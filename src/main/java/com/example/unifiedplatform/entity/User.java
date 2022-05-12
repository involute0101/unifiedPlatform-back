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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String userName;

    private String email;

    private String telephone;

    private String password;
}
