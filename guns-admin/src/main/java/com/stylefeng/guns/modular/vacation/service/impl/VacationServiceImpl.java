package com.stylefeng.guns.modular.vacation.service.impl;

import com.stylefeng.guns.modular.vacation.dao.VacationDao;
import com.stylefeng.guns.modular.vacation.service.IVacationservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VacationServiceImpl implements IVacationservice {

    @Resource
    VacationDao vacationDao;

    @Override
    public List<Map<String, Object>> staffVacationList(@Param("userid") Integer userid){
        return this.vacationDao.staffVacationList(userid);
    }

    @Override
    public Map queryStaffEdit(@Param("id") Integer id){
        return this.vacationDao.queryStaffEdit(id);
    }

    @Override
    public Integer staffaAddVacation(@Param("userid") Integer userid, @Param("remark") String remark,
                                     @Param("status") int status,@Param("starttime") String starttime,
                                     @Param("endtime") String endtime){
        return this.vacationDao.staffaAddVacation(userid,remark,status,starttime,endtime);
    }

    @Override
    public Integer staffEditVacation(@Param("id") int id, @Param("remark") String remark,
                                     @Param("starttime") String starttime,@Param("endtime") String endtime){
        return this.vacationDao.staffEditVacation(id,remark,starttime,endtime);
    }

    @Override
    public Integer staffDeleteVacation(@Param("id") int id){
        return this.vacationDao.staffDeleteVacation(id);
    }

    @Override
    public List<Map<String, Object>> vacationBossList(){
        return this.vacationDao.vacationBossList();
    }

    @Override
    public String queryBossEdit(@Param("id") Integer id){
        return this.vacationDao.queryBossEdit(id);
    }

    @Override
    public Integer bossAddVacation(@Param("userid") Integer userid, @Param("remark") String remark, @Param("status") int status){
        return this.vacationDao.bossAddVacation(userid,remark,status);
    }

    @Override
    public Integer bossEditVacation(@Param("id") int id, @Param("status") Integer status){
        return this.vacationDao.bossEditVacation(id,status);
    }

    @Override
    public Integer bossDeleteVacation(@Param("id") int id){
        return this.vacationDao.bossDeleteVacation(id);
    }

}
