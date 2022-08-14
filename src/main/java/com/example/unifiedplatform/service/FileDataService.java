package com.example.unifiedplatform.service;

import com.example.unifiedplatform.controller.form.FileDataForm;
import com.example.unifiedplatform.entity.FileData;
import com.example.unifiedplatform.entity.User;
import com.example.unifiedplatform.exception.PlatformException;
import com.example.unifiedplatform.exception.ResultEnum;
import com.example.unifiedplatform.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FileDataService {
    @Autowired
    FileDataRepository fileDataRepository;

    @Autowired
    UserService userService;

    /**
     * 获取用户云空间数据
     *
     * @return
     */
    public List<FileData> getMyCloudSpace(FileDataForm fileDataForm) {
        PageRequest pageRequest = PageRequest.of(fileDataForm.getPage() - 1, fileDataForm.getSize());
        User user = userService.findByEmailOrTelephone(fileDataForm.getAccount());
        if (user == null) {
            throw new PlatformException(ResultEnum.USER_NOT_EXIST);
        }
        Page<FileData> page = fileDataRepository.
                findByUserIdAndParentPath(user.getId(), fileDataForm.getParentPath(), pageRequest);
        return page.toList();
    }

    /**
     * 创建文件夹
     *
     * @param fileDataForm
     * @return
     */
    public FileData createFolder(FileDataForm fileDataForm) {
        User user = userService.findByEmailOrTelephone(fileDataForm.getAccount());
        if (user == null) {
            throw new PlatformException(ResultEnum.USER_NOT_EXIST);
        }
        FileData queryResult = fileDataRepository.findByFileNameAndParentPath(fileDataForm.getFolderName(), fileDataForm.getParentPath());
        if(queryResult!=null){
            throw new PlatformException(ResultEnum.FOLDER_EXIST);
        }
        FileData fileData = new FileData();
        fileData.setFileType("文件夹");
        fileData.setFileName(fileDataForm.getFolderName());
        fileData.setIsShared("NO");
        Date date = new Date();
        fileData.setPublishDate(date.getYear() + "-" + date.getMonth() + "-" + date.getDay());
        fileData.setUserId(user.getId());
        fileData.setUserName(user.getUserName());
        fileData.setParentPath(fileDataForm.getParentPath());
        return fileDataRepository.save(fileData);
    }

    /**
     * 保存/上传 文件至云空间指定目录
     * @param fileDataForm
     * @return
     */
    public FileData saveFile(FileDataForm fileDataForm){
        User user = userService.findByEmailOrTelephone(fileDataForm.getAccount());
        if (user == null) {
            throw new PlatformException(ResultEnum.USER_NOT_EXIST);
        }
        FileData fileData = new FileData();
        fileData.setFileType("文件");
        fileData.setFileName(fileDataForm.getFolderName().substring(37));
        fileData.setIsShared("NO");
        Date date = new Date();
        fileData.setPublishDate((date.getYear()+1900) + "-" + (date.getMonth()+1) + "-" + date.getDate());
        fileData.setUserId(user.getId());
        fileData.setUserName(user.getUserName());
        fileData.setParentPath(fileDataForm.getParentPath());
        fileData.setHref(fileDataForm.getFolderName());
        return fileDataRepository.save(fileData);
    }

    /**
     * 删除文件
     * @param fileDataForm
     */
    public void deleteFile(FileDataForm fileDataForm){
        User user = userService.findByEmailOrTelephone(fileDataForm.getAccount());
        if (user == null) {
            throw new PlatformException(ResultEnum.USER_NOT_EXIST);
        }
        FileData fileData = fileDataRepository.getById(fileDataForm.getId());
        fileDataRepository.delete(fileData);
    }
}
