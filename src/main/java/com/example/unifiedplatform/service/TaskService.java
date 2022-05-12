package com.example.unifiedplatform.service;

import com.example.unifiedplatform.controller.form.TaskForm;
import com.example.unifiedplatform.entity.Task;
import com.example.unifiedplatform.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    /**
     * 获取任务列表
     * @param pageable
     * @return
     */
    public List<Task> getTask(Pageable pageable){
        Page<Task> page = taskRepository.findByOrderByIdDesc(pageable);
        System.out.println(page.getContent().size());
        return page.toList();
    }

    /**
     * 发布任务
     * @param taskForm
     * @return
     */
    public boolean publishTask(TaskForm taskForm){
        Task task = new Task();
        task.setTitle(taskForm.getTitle());task.setContent(taskForm.getContent());task.setFiles(taskForm.getFiles());
        task.setDeadline(taskForm.getDeadline());
        task.setPublishDate(new Date().toString());
        task.setState("未完成");
        Task save = taskRepository.save(task);
        if(save==null)return false;
        return true;
    }
}
