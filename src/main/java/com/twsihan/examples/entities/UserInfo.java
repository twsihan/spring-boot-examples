package com.twsihan.examples.entities;

import com.twsihan.examples.components.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "user_info")
public class UserInfo extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String username;

    private String password;

    private String usertype;

    private Integer enabled;

    private String qq;

    private String email;

    private String tel;
}
