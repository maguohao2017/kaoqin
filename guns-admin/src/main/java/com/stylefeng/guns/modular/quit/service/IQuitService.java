package com.stylefeng.guns.modular.quit.service;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 离职
 * @author maguohao
 * @Date 2018年8月10日 下午1:11:57
 */
public interface IQuitService{

    /**
     * 获取员工离职列表
     */
    List<Map<String, Object>> quitListStaff(@Param("userid") Integer userid);

    /**
     * 跳转到员工编辑页面
     */
    String queryeditStaff(@Param("id") Integer id);

    /**
     * 员工添加离职申请
     */
    Integer addStaffQuit(@Param("userid") Integer userid,@Param("remark") String remark,@Param("status") int status);

    /**
     * 员工修改离职申请
     */
    Integer editStaffQuit(@Param("id") int id,@Param("remark") String remark);

    /**
     * 员工删除离职申请
     */
    Integer deleteStaffQuit(@Param("id") int id);

    /**
     * 获取经理列表
     */
    List<Map<String, Object>> quitBossList(@Param("deptId") Integer deptId);

    /**
     * 跳转到经理编辑页面
     */
    String queryBossedit(@Param("id") Integer id);

    /**
     * 经理修改
     */
    Integer editBossQuit(@Param("id") int id, @Param("status") Integer status);

    /**
     * 经理删除
     */
    Integer deleteBossQuit(@Param("id") int id);
}