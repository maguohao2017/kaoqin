package com.stylefeng.guns.modular.travel.service.impl;

import com.stylefeng.guns.modular.travel.dao.TravelDao;
import com.stylefeng.guns.modular.travel.service.ITravelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.ibatis.annotations.Param;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TravelServiceImpl implements ITravelService{

    @Resource
    TravelDao travelDao;

    @Override
    public List<Map<String, Object>> staffTravelList(){
        return this.travelDao.staffTravelList();
    }

    @Override
    public Map queryEditStaff(@Param("id") Integer id){
        return this.travelDao.queryEditStaff(id);
    }

    @Override
    public Integer addStaff(@Param("userid") Integer userid, @Param("remark") String remark,
                            @Param("status") int status, @Param("starttime") String starttime,
                            @Param("endtime") String endtime){
        return this.travelDao.addStaff(userid,remark,status,starttime,endtime);
    }

    @Override
    public Integer editStaff(@Param("id") int id, @Param("remark") String remark,
                             @Param("starttime") String starttime, @Param("endtime") String endtime){
        return this.travelDao.editStaff(id,remark,starttime,endtime);
    }

    @Override
    public Integer deleteStaff(@Param("id") int id){
        return this.travelDao.deleteStaff(id);
    }

    @Override
    public List<Map<String, Object>> bossTravelList(){
        return this.travelDao.bossTravelList();
    }

    @Override
    public Map queryEditBoss(@Param("id") Integer id){
        return this.travelDao.queryEditBoss(id);
    }

    @Override
    public Integer addBoss(@Param("userid") Integer userid, @Param("remark") String remark,
                           @Param("status") int status,@Param("starttime") String starttime,
                           @Param("endtime") String endtime){
        return this.travelDao.addBoss(userid,remark,status,starttime,endtime);
    }

    @Override
    public Integer editBoss(@Param("id") int id, @Param("status") Integer status){
        return this.travelDao.editBoss(id,status);
    }

    @Override
    public Integer deleteBoss(@Param("id") int id){
        return this.travelDao.deleteBoss(id);
    }



}