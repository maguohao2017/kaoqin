package com.stylefeng.guns.modular.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.travel.service.ITravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 出差管理
 *
 * @author maguohao
 * @Date 2018年5月17日20:27:22
 */
@Controller
@RequestMapping("/travel")
public class TravelController extends BaseController {

    private String PREFIX = "/travel/";

    @Resource
    ITravelService iTravelService;

    /**
     * 跳转员工出差管理页面
     */
    @RequestMapping("/travel_staff")
    public String travel_staff() {
        return PREFIX + "travel_staff.html";
    }

    /**
     * 弹出员工新增页面
     */
    @RequestMapping("/travel_add_staff")
    public String travel_add_staff() {
        return PREFIX + "travel_add_staff.html";
    }

    /**
     * 跳转经理出差管理页面
     */
    @RequestMapping("/travel_boss")
    public String travel_boss() {
        return PREFIX + "travel_boss.html";
    }

    /**
     * 跳转经理新增页面
     */
    @RequestMapping("/travel_add_boss")
    public String travel_add_boss() {
        return PREFIX + "travel_add_boss.html";
    }

    /**
     * 弹出到员工编辑页面
     */
    @RequestMapping("/travel_edit_staff/{id}")
    public String travel_edit_staff(@PathVariable Integer id, Model model) {

        Map map = this.iTravelService.queryEditStaff(id);
        model.addAttribute(id);
        model.addAttribute("remark",map.get("remark"));
        model.addAttribute("starttime",map.get("starttime"));
        model.addAttribute("endtime",map.get("endtime"));
        return PREFIX + "travel_edit_staff.html";
    }

    /**
     * 跳转到经理编辑页面
     */
    @RequestMapping("/travel_edit_boss/{id}")
    public String travel_edit_boss(@PathVariable Integer id, Model model) {

        Map map = this.iTravelService.queryEditBoss(id);
        model.addAttribute(id);
        model.addAttribute("remark",map.get("remark"));
        model.addAttribute("starttime",map.get("starttime"));
        model.addAttribute("endtime",map.get("endtime"));
        return PREFIX + "travel_edit.html";
    }

    /**
     * 员工获取出差列表
     */
    @RequestMapping(value = "/list_staff")
    @ResponseBody
    public Object list_staff() {
        Integer userid = ShiroKit.getUser().getId();
        List<Map<String, Object>> list = this.iTravelService.staffTravelList();
        return list;
    }

    /**
     * 员工添加出差记录
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
        Integer list = this.iTravelService.addStaff(userid,remark,status,starttime,endtime);
        return list;
    }

    /**
     * 员工修改出差记录
     */
    @RequestMapping(value = "/edit_staff/{params}")
    @ResponseBody
    public Integer edit_staff(@PathVariable String params) {

        JSONObject json = JSON.parseObject(params);
        Integer id = Integer.parseInt(json.getString("id"));
        String remark = json.get("remark").toString();
        String starttime = json.get("starttime").toString();
        String endtime = json.get("endtime").toString();
        Integer list = this.iTravelService.editStaff(id,remark,starttime,endtime);
        return list;
    }

    /**
     * 员工删除出差记录
     */
    @RequestMapping(value = "/delete_staff/{id}")
    @ResponseBody
    public Integer delete_staff(@PathVariable int id) {

        Integer list = this.iTravelService.deleteStaff(id);
        return list;
    }

    /**
     * 经理获取列表
     */
    @RequestMapping(value = "/list_boss")
    @ResponseBody
    public Object list_boss() {
        List<Map<String, Object>> list = this.iTravelService.bossTravelList();
        return list;
    }

    /**
     * 经理添加
     */
    @RequestMapping(value = "/add/{params}")
    @ResponseBody
    public Integer add(@PathVariable String params) {

        Integer userid = ShiroKit.getUser().getId();
        int status = 1;
        JSONObject json = JSON.parseObject(params);
        String remark = json.get("remark").toString();
        String starttime = json.get("starttime").toString();
        String endtime = json.get("endtime").toString();
        Integer list = this.iTravelService.addBoss(userid,remark,status,starttime,endtime);
        return list;
    }

    /**
     * 经理修改
     */
    @RequestMapping(value = "/edit/{id}")
    @ResponseBody
    public Integer edit(@PathVariable Integer id) {

        Integer status = 2;
        Integer list = this.iTravelService.editBoss(id,status);
        return list;
    }

    /**
     * 经理删除
     */
    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public Integer delete(@PathVariable int id) {

        Integer list = this.iTravelService.deleteBoss(id);
        return list;
    }

}
