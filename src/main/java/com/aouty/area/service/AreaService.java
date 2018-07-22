package com.aouty.area.service;

import com.aouty.area.entity.Area;

import java.util.List;

/**
 * @author Aouty
 * @date 2018-04-15 10:35
 * @description AreaService:service层接口
 */
public interface AreaService {

    /**
     * 获取区域列表
     *
     * @return 区域列表
     */
    List<Area> getAreaList();

    /**
     * 通过区域Id来获取区域信息
     *
     * @param areaId 区域
     * @return
     */
    Area getAreaById(int areaId);


    /**
     * 增加区域信息
     *
     * @param area 区域对象{@link Area}
     * @return 增加区域结果，成功返回<code>true</code>
     * 增加失败，返回<code>false</code>
     */
    boolean addArea(Area area);

    /**
     * 修改区域信息
     *
     * @param area 区域对象{@link Area}
     * @return 修改结果，成功返回<code>true</code>
     * 修改失败，返回<code>false</code>
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域
     *
     * @param areaId 区域id
     * @return 删除区域，成功返回<code>true</code>
     * 删除失败，返回<code>false</code>
     */
    boolean deleteArea(int areaId);

    /**
     * 根据条件获取区域列表
     *
     * @param area 条件
     * @return 区域列表
     */
    List<Area> getAreaListByCondition(Area area);

}
