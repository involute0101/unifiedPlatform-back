package com.example.unifiedplatform.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "filedata")
public class FileData {

    @Id
    @GeneratedValue
    private Integer id;

    private String fileName;

    private String publishDate;

    private String fileType;

    private String isShared;

    private Integer userId;

    private String userName;

    private String parentPath;

    private String href;

}
