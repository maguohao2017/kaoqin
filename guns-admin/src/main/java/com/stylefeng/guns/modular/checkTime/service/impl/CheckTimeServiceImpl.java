package com.stylefeng.guns.modular.checkTime.service.impl;

import com.stylefeng.guns.modular.checkTime.dao.CheckTimeDao;
import com.stylefeng.guns.modular.checkTime.service.ICheckTimeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CheckTimeServiceImpl implements ICheckTimeService{
    @Resource
    CheckTimeDao checkTimeDao;

    @Override
    public List<Map<String, Object>> queryStaffCheckTimeList(@Param("userid") Integer userid, @Param("flag") String flag){
        return checkTimeDao.queryStaffCheckTimeList(userid,flag);
    }

    @Override
    public Integer insertInfo(@Param("userid") Integer userid,@Param("status") Integer status){
        return checkTimeDao.insertInfo(userid,status);
    }

    @Override
    public List<Map<String, Object>> queryBossCheckTimeList(@Param("userid") Integer userid, @Param("flag") String flag){
        return checkTimeDao.queryBossCheckTimeList(userid,flag);
    }

    @Override
    public Integer update(@Param("id") Integer id,@Param("status") Integer status){
        return checkTimeDao.update(id,status);
    }
}