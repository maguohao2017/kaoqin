package com.stylefeng.guns.modular.checkTime.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 打卡
 * </p>
 *
 * @author maguohao
 * @since 2018-08-19
 */
public interface CheckTimeDao {


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