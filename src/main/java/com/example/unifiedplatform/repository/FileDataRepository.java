package com.example.unifiedplatform.repository;

import com.example.unifiedplatform.entity.FileData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Integer> {
    Page<FileData> findByUserIdAndParentPath(Integer userId, String parentPath, Pageable pageable);

    FileData findByFileNameAndParentPath(String fileName,String parentPath);
}
