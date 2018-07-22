package com.aouty.area.controller;

import com.aouty.area.entity.Area;
import com.aouty.area.mapper.AreaMapper;
import com.aouty.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aouty
 * @date 2018-04-15 11:06
 * @description area：controller
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/area")//指定根路由，这是规范的做法,路由都是小写
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private Map<String, Object> geteAreaList() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @RequestMapping(value = "/{areaId}", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(@PathVariable Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area) {
//        @RequestBody Area area 表示要接受的值是除了x-www-form-urlencoded之外格式的数据
        //比如：Json、xml等
        Map<String, Object> modelMap = new HashMap<>();
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = {"/modify"}, method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = {"/{areaId}"}, method = RequestMethod.DELETE)
    private Map<String, Object> removeArea(@PathVariable Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }

    @RequestMapping(value = {"/condition"}, method = RequestMethod.POST)
    private Map<String, Object> getAreaListByCondition(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.getAreaListByCondition(area));
        return modelMap;
    }

}
