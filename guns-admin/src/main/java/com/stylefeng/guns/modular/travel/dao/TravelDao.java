package com.stylefeng.guns.modular.travel.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * <p>
 * 出差
 * </p>
 *
 * @author maguohao
 * @since 2018-08-19
 */
public interface TravelDao {

    /**
     * 员工获取出差列表
     */
    List<Map<String, Object>> staffTravelList();

    /**
     * 弹出到员工编辑页面
     */
    Map queryEditStaff(@Param("id") Integer id);

    /**
     * 员工添加出差记录
     */
    Integer addStaff(@Param("userid") Integer userid, @Param("remark") String remark, @Param("status") int status, @Param("starttime") String starttime, @Param("endtime") String endtime);

    /**
     * 员工修改出差记录
     */
    Integer editStaff(@Param("id") int id, @Param("remark") String remark, @Param("starttime") String starttime, @Param("endtime") String endtime);

    /**
     * 员工删除出差记录
     */
    Integer deleteStaff(@Param("id") int id);

    /**
     * 经理获取所有列表
     */
    List<Map<String, Object>> bossTravelList();

    /**
     * 跳转到经理编辑页面
     */
    Map queryEditBoss(@Param("id") Integer id);

    /**
     * 经理添加
     */
    Integer addBoss(@Param("userid") Integer userid, @Param("remark") String remark, @Param("status") int status,@Param("starttime") String starttime,@Param("endtime") String endtime);

    /**
     * 经理修改
     */
    Integer editBoss(@Param("id") int id, @Param("status") Integer status);

    /**
     * 经理删除
     */
    Integer deleteBoss(@Param("id") int id);
}
