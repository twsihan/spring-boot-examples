package com.twsihan.examples.mappers;

import com.twsihan.examples.components.base.BaseMapper;
import com.twsihan.examples.entities.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CityMapper extends BaseMapper<City> {}
