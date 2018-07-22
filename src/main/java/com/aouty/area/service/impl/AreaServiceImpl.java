package com.aouty.area.service.impl;

import com.aouty.area.entity.Area;
import com.aouty.area.mapper.AreaMapper;
import com.aouty.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Aouty
 * @date 2018-04-15 10:43
 * @description AreaService的实现类
 */
@Service//告诉Spring容器，这是一个Bean
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAreaList() {
        return areaMapper.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaMapper.queryAreaById(areaId);
    }

    //@Transactional默认接受RuntimeException，并且回滚
//    @Transactional(rollbackFor = Exception.class)//此时抛出异常时，改为Exception即可
    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());//java.util.Date
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaMapper.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());//java.util.Date
            try {
                //更新区域信息
                int effectedNum = areaMapper.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional(rollbackFor = Exception.class)//此时在抛出异常时可以使用Exception
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaMapper.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new Exception("删除区域信息失败！");
                }
            } catch (Exception e) {
                try {
                    throw new Exception("删除区域信息失败：" + e.getMessage());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            try {
                throw new Exception("区域Id不能为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public List<Area> getAreaListByCondition(Area area) {
        return areaMapper.queryAreaListByCondition(area);
    }
}
