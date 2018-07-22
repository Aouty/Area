package com.aouty.area.mapper;

import com.aouty.area.entity.Area;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aouty
 * @date 2018-07-21 22:31
 * @description AreaMapper接口：数据库的增删查改
 */
@Component
public interface AreaMapper {

    //查询所有的area
    List<Area> queryArea();

    //根据id查询area
    Area queryAreaById(int areaId);

    //添加area
    int insertArea(Area area);

    //修改area
    int updateArea(Area area);

    //根据id删除area
    int deleteArea(int areaId);

    //根据条件查询区域列表
    List<Area> queryAreaListByCondition(Area area);
}
