package com.twsihan.examples.components.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    @javax.persistence.Transient
    @org.springframework.data.annotation.Transient
    private Integer page = 0;

    @Setter
    @Getter
    @javax.persistence.Transient
    @org.springframework.data.annotation.Transient
    private Integer rows = 10;
}
