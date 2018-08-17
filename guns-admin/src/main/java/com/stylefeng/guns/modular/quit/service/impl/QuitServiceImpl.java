package com.stylefeng.guns.modular.quit.service.impl;

import com.stylefeng.guns.modular.quit.service.IQuitService;
import com.stylefeng.guns.modular.quit.dao.QuitDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class QuitServiceImpl implements IQuitService{

    @Resource
    QuitDao quitDao;

    @Override
    public List<Map<String, Object>> quitListStaff(@Param("userid") Integer userid){
        return this.quitDao.quitListStaff(userid);
    }

    @Override
    public String queryeditStaff(@Param("id") Integer id){
        return this.quitDao.queryeditStaff(id);
    }

    @Override
    public Integer addStaffQuit(@Param("userid") Integer userid,@Param("remark") String remark,@Param("status") int status){
        return this.quitDao.addStaffQuit(userid,remark,status);
    }

    @Override
    public Integer editStaffQuit(@Param("id") int id,@Param("remark") String remark){
        return this.quitDao.editStaffQuit(id,remark);
    }

    @Override
    public Integer deleteStaffQuit(@Param("id") int id){
        return this.quitDao.deleteStaffQuit(id);
    }

    @Override
    public List<Map<String, Object>> quitBossList(@Param("deptId") Integer deptId){
        return this.quitDao.quitBossList(deptId);
    }

    @Override
    public String queryBossedit(@Param("id") Integer id){
        return this.quitDao.queryBossedit(id);
    }

    @Override
    public Integer editBossQuit(@Param("id") int id, @Param("status") Integer status){
        return this.quitDao.editBossQuit(id,status);
    }

    @Override
    public Integer deleteBossQuit(@Param("id") int id){
        return this.quitDao.deleteBossQuit(id);
    }
}