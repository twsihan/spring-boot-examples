package com.twsihan.examples.controllers;

import com.github.pagehelper.PageInfo;

import com.twsihan.examples.entities.City;
import com.twsihan.examples.services.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController
{
    @Autowired
    private CityService cityService;


    @RequestMapping
    public PageInfo<City> getAll(City city)
    {
        List<City> countryList = cityService.getAll(city);
        return new PageInfo<>(countryList);
    }

    @RequestMapping(value = "/add")
    public City add()
    {
        return new City();
    }

    @RequestMapping(value = "/view/{id}")
    public City view(@PathVariable Integer id)
    {
        return cityService.getById(id);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelMap delete(@PathVariable Integer id)
    {
        ModelMap result = new ModelMap();
        cityService.deleteById(id);
        result.put("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelMap save(City city)
    {
        ModelMap result = new ModelMap();
        String msg = city.getId() == null ? "新增成功!" : "更新成功!";
        cityService.save(city);
        result.put("city", city);
        result.put("msg", msg);
        return result;
    }
}
