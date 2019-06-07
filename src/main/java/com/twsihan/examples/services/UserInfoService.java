package com.twsihan.examples.services;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twsihan.examples.entities.UserInfo;
import com.twsihan.examples.mappers.UserInfoMapper;

import java.util.List;

@Service
public class UserInfoService
{
    @Autowired
    private UserInfoMapper userInfoMapper;


    public List<UserInfo> getAll(UserInfo userInfo)
    {
        if (userInfo.getPage() != null && userInfo.getRows() != null) {
            PageHelper.startPage(userInfo.getPage(), userInfo.getRows());
        }
        return userInfoMapper.selectAll();
    }

    public UserInfo getById(Integer id)
    {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id)
    {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(UserInfo country)
    {
        if (country.getId() != null) {
            userInfoMapper.updateByPrimaryKey(country);
        } else {
            userInfoMapper.insert(country);
        }
    }
}
