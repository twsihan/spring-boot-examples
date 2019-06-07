package com.twsihan.examples.mappers;

import com.twsihan.examples.components.base.BaseMapper;
import com.twsihan.examples.entities.Country;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CountryMapper extends BaseMapper<Country> {}
