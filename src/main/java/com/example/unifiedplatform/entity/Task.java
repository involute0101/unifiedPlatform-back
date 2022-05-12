package com.example.unifiedplatform.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String content;

    private String publishDate;

    private String deadline;

    /**
     * 表示本次任务的文件，以“，”形式分割，传入传出均修改为数组
     */
    private String files;

    private String state;
}
