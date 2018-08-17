package com.stylefeng.guns.modular.vacation.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VacationDao {

    /**
     * 员工获取休假列表
     */
    List<Map<String, Object>> staffVacationList(@Param("userid") Integer userid);

    /**
     * 跳转到员工编辑页面
     */
    Map queryStaffEdit(@Param("id") Integer id);

    /**
     * 员工添加休假申请
     */
    Integer staffaAddVacation(@Param("userid") Integer userid, @Param("remark") String remark, @Param("status") int status,@Param("starttime") String starttime,@Param("endtime") String endtime);

    /**
     * 员工修改休假申请
     */
    Integer staffEditVacation(@Param("id") int id, @Param("remark") String remark,@Param("starttime") String starttime,@Param("endtime") String endtime);

    /**
     * 员工删除休假申请
     */
    Integer staffDeleteVacation(@Param("id") int id);

    /**
     * 经理获取所有列表
     */
    List<Map<String, Object>> vacationBossList();

    /**
     * 跳转到经理编辑页面
     */
    String queryBossEdit(@Param("id") Integer id);

    /**
     * 经理添加
     */
    Integer bossAddVacation(@Param("userid") Integer userid, @Param("remark") String remark, @Param("status") int status);

    /**
     * 经理修改
     */
    Integer bossEditVacation(@Param("id") int id, @Param("status") Integer status);

    /**
     * 经理删除
     */
    Integer bossDeleteVacation(@Param("id") int id);
}
