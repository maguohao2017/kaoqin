package com.stylefeng.guns.modular.checkTime.service;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 打卡
 * @author maguohao
 * @Date 2018年8月10日 下午1:11:57
 */
public interface ICheckTimeService{

    /**
     * 获取员工历史打卡信息列表
     */
    List<Map<String, Object>> queryStaffCheckTimeList(@Param("userid") Integer userid,@Param("flag") String flag);

    /**
     * 新增员工打卡记录
     */
    Integer insertInfo(@Param("userid") Integer userid,@Param("status") Integer status);

    /**
     * 获取经理打卡信息列表（获取所有员打卡记录）
     */
    List<Map<String, Object>> queryBossCheckTimeList(@Param("userid") Integer userid, @Param("flag") String flag);

    /**
     * 经理审批打卡记录
     */
    Integer update(@Param("id") Integer id,@Param("status") Integer status);
}