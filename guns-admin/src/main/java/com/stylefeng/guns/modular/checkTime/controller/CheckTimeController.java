package com.stylefeng.guns.modular.checkTime.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.checkTime.service.ICheckTimeService;
import com.stylefeng.guns.core.shiro.ShiroKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 打卡控制器
 *
 * @author maguohao
 * @Date 2018年5月17日20:27:22
 */
@Controller
@RequestMapping("/checkTime")
public class CheckTimeController extends BaseController {

    private String PREFIX = "/checkTime/";

    @Resource
    private ICheckTimeService iCheckTimeService;
    /**
     * 跳转员工打卡页面
     */
    @RequestMapping("/check_time_staff")
    public String check_time_staff() {
        return PREFIX + "check_time_staff.html";
    }
    /**
     * 跳转员工历史打卡信息页面
     */
    @RequestMapping("/check_history_staff")
    public String check_history_staff() {
        return PREFIX + "check_history_staff.html";
    }

    /**
     * 跳转经理打卡页面
     */
    @RequestMapping("/check_time_boss")
    public String check_time_boss() {
        return PREFIX + "check_time_boss.html";
    }

    /**
     * 获取员工打卡信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list() {

        Integer userid = ShiroKit.getUser().getId();

        String flag = "0";

        List<Map<String, Object>> list = this.iCheckTimeService.queryStaffCheckTimeList(userid,flag);

        return list;
    }

    /**
     * 获取员工历史打卡信息列表
     */
    @RequestMapping(value = "/history_list")
    @ResponseBody
    public Object historyList() {

        Integer userid = ShiroKit.getUser().getId();
        String flag = "";

        List<Map<String, Object>> list = this.iCheckTimeService.queryStaffCheckTimeList(userid,flag);

        return list;
    }

    /**
     * 新增员工打卡记录
     */
    @RequestMapping(value = "/insertInfo")
    @ResponseBody
    public Integer insertInfo() {

        Integer userid = ShiroKit.getUser().getId();
        Integer status = 1;
        Integer no = 0;
        try {
            no = this.iCheckTimeService.insertInfo(userid,status);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }

    /**
     * 经理获取打卡信息列表（获取所有员打卡记录）
     */
    @RequestMapping(value = "/boss_list")
    @ResponseBody
    public Object historyListBoss() {

        Integer userid = ShiroKit.getUser().getId();
        String flag = "";

        List<Map<String, Object>> list = this.iCheckTimeService.queryBossCheckTimeList(userid,flag);

        return list;
    }

    /**
     * 经理审批打卡记录
     */
    @RequestMapping(value = "/update_boss/{id}")
    @ResponseBody
    public Integer update(Integer id) {

        Integer status = 10;
        Integer no = 0;
        try {
            no = this.iCheckTimeService.update(id,status);
        }catch (Exception e){
            e.printStackTrace();
        }

        return no;
    }
}
