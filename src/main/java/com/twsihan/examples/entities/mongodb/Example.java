package com.twsihan.examples.entities.mongodb;

import com.twsihan.examples.components.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper=true)
@Document(collection = "example")
public class Example extends BaseEntity
{
    @Field(value = "name")
    private String name;
}
