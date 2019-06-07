package com.twsihan.examples.entities;

import com.twsihan.examples.components.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "country")
public class Country extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    private String countryname;

    private String countrycode;
}
