package com.stylefeng.guns.modular.vacation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.vacation.service.IVacationservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 休假
 *
 * @author maguohao
 * @Date 2018年5月17日20:27:22
 */
@Controller
@RequestMapping("/vacation")
public class VacationController {

    private String PREFIX = "/vacation/";

    @Resource
    IVacationservice iVacationservice;

    /**
     * 跳转员工休假申请页面
     */
    @RequestMapping("/vacation_staff")
    public String vacation_staff() {
        return PREFIX + "vacation_staff.html";
    }

    /**
     * 员工新增休假申请页面
     */
    @RequestMapping("/vacation_add_staff")
    public String vacation_add_staff() {
        return PREFIX + "vacation_add_staff.html";
    }

    /**
     * 跳转到员工编辑页面
     */
    @RequestMapping("/vacation_edit_staff/{id}")
    public String vacation_edit_staff(@PathVariable Integer id, Model model) {

        Map map = this.iVacationservice.queryStaffEdit(id);
        model.addAttribute(id);
        model.addAttribute("remark",map.get("remark"));
        model.addAttribute("starttime",map.get("starttime"));
        model.addAttribute("endtime",map.get("endtime"));
        return PREFIX + "vacation_edit_staff.html";
    }

    /**
     * 跳转经理休假管理页面
     */
    @RequestMapping("/vacation_boss")
    public String vacation_boss() {
        return PREFIX + "vacation_boss.html";
    }

    /**
     * 跳转经理新增休假管理页面
     */
    @RequestMapping("/vacation_add_boss")
    public String vacation_add_boss() {
        return PREFIX + "vacation_add_boss.html";
    }

    /**
     * 跳转到经理编辑页面
     */
    @RequestMapping("/vacation_edit_boss/{id}")
    public String vacation_edit_boss(@PathVariable Integer id, Model model) {

        String remark = this.iVacationservice.queryBossEdit(id);
        model.addAttribute(id);
        model.addAttribute("remark",remark);
        return PREFIX + "vacation_edit_boss.html";
    }

    /**
     * 员工获取休假列表
     */
    @RequestMapping(value = "/list_staff")
    @ResponseBody
    public Object list_staff() {
        Integer userid = ShiroKit.getUser().getId();
        List<Map<String, Object>> list = this.iVacationservice.staffVacationList(userid);
        return list;
    }

    /**
     * 员工添加休假申请
     */
    @RequestMapping(value = "/add_staff/{params}")
    @ResponseBody
    public Integer add_staff(@PathVariable String params) {

        Integer userid = ShiroKit.getUser().getId();
        int status = 1;
        JSONObject json = JSON.parseObject(params);
        String remark = json.get("remark").toString();
        String starttime = json.get("starttime").toString();
        String endtime = json.get("endtime").toString();
        Integer list = this.iVacationservice.staffaAddVacation(userid,remark,status,starttime,endtime);
        return list;
    }

    /**
     * 员工修改休假申请
     */
    @RequestMapping(value = "/edit_staff/{params}")
    @ResponseBody
    public Integer edit_staff(@PathVariable String params) {

        JSONObject json = JSON.parseObject(params);
        Integer id = Integer.parseInt(json.getString("id"));
        String remark = json.get("remark").toString();
        String starttime = json.get("starttime").toString();
        String endtime = json.get("endtime").toString();
        Integer list = this.iVacationservice.staffEditVacation(id,remark,starttime,endtime);
        return list;
    }

    /**
     * 员工删除休假申请
     */
    @RequestMapping(value = "/delete_staff/{id}")
    @ResponseBody
    public Integer delete_staff(@PathVariable int id) {

        Integer list = this.iVacationservice.staffDeleteVacation(id);
        return list;
    }

    /**
     * 经理获取列表
     */
    @RequestMapping(value = "/list_boss")
    @ResponseBody
    public Object list_boss() {
        List<Map<String, Object>> list = this.iVacationservice.vacationBossList();
        return list;
    }

    /**
     * 经理添加
     */
    @RequestMapping(value = "/add/{remark}")
    @ResponseBody
    public Integer add(@PathVariable String remark) {

        Integer userid = ShiroKit.getUser().getId();
        int status = 1;
        Integer list = this.iVacationservice.bossAddVacation(userid,remark,status);
        return list;
    }

    /**
     * 经理修改
     */
    @RequestMapping(value = "/edit/{id}")
    @ResponseBody
    public Integer edit(@PathVariable Integer id) {

        Integer status = 2;
        Integer list = this.iVacationservice.bossEditVacation(id,status);
        return list;
    }

    /**
     * 经理删除
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public Integer delete(@PathVariable int id) {

        Integer list = this.iVacationservice.bossDeleteVacation(id);
        return list;
    }
}
