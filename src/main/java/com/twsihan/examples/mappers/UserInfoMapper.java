package com.twsihan.examples.mappers;

import com.twsihan.examples.components.base.BaseMapper;
import com.twsihan.examples.entities.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {}
