package com.stylefeng.guns.modular.quit.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.shiro.ShiroKit;
import com.stylefeng.guns.modular.quit.service.IQuitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 离职模块
 *
 * @author maguohao
 * @Date 2018年5月17日20:27:22
 */
@Controller
@RequestMapping("/quit")
public class QuitController extends BaseController {

    private String PREFIX = "/quit/";
    @Resource
    IQuitService iQuitService;

    /**
     * 跳转员工离职页面
     */
    @RequestMapping("/quit_staff")
    public String quit_staff() {
        return PREFIX + "quit_staff.html";
    }

    /**
     * 弹出员工离职新增页面
     */
    @RequestMapping("/quit_add_staff")
    public String quit_add_staff() {
        return PREFIX + "quit_add_staff.html";
    }

    /**
     * 跳转经理离职审批页面
     */
    @RequestMapping("/quit_boss")
    public String quit_boss() {
        return PREFIX + "quit_boss.html";
    }

    /**
     * 跳转经理添加页面
     */
    @RequestMapping("/quit_add_boss")
    public String quit_add_boss() {
        return PREFIX + "quit_add_boss.html";
    }

    /**
     * 跳转到员工编辑页面
     */
    @RequestMapping("/quit_edit_staff/{id}")
    public String quit_edit_staff(@PathVariable Integer id, Model model) {

        String remark = this.iQuitService.queryeditStaff(id);
        model.addAttribute(id);
        model.addAttribute("remark",remark);
        return PREFIX + "quit_edit_staff.html";
    }


    /**
     * 获取员工离职列表
     */
    @RequestMapping(value = "/list_staff")
    @ResponseBody
    public Object list_staff() {
        Integer userid = ShiroKit.getUser().getId();
        List<Map<String, Object>> list = this.iQuitService.quitListStaff(userid);
        return list;
    }

    /**
     * 员工添加离职申请
     */
    @RequestMapping(value = "/add_staff/{remark}")
    @ResponseBody
    public Integer add_staff(@PathVariable String remark) {

        Integer userid = ShiroKit.getUser().getId();
        int status = 1;
        Integer list = this.iQuitService.addStaffQuit(userid,remark,status);
        return list;
    }

    /**
     * 员工修改离职申请
     */
    @RequestMapping(value = "/edit_staff/{params}")
    @ResponseBody
    public Integer edit_staff(@PathVariable String params) {

        JSONObject json = JSON.parseObject(params);
        Integer id = Integer.parseInt(json.getString("id"));
        String remark = json.get("remark").toString();
        Integer list = this.iQuitService.editStaffQuit(id,remark);
        return list;
    }

    /**
     * 员工删除离职申请
     */
    @RequestMapping(value = "/delete_staff/{id}")
    @ResponseBody
    public Integer delete_staff(@PathVariable int id) {

        Integer list = this.iQuitService.deleteStaffQuit(id);
        return list;
    }

    /**
     * 跳转到经理编辑页面
     */
    @RequestMapping("/quit_edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        String remark = this.iQuitService.queryBossedit(id);
        model.addAttribute(id);
        model.addAttribute("remark",remark);
        return PREFIX + "quit_edit.html";
    }

    /**
     * 经理获取离职列表
     */
    @RequestMapping(value = "/list_boss")
    @ResponseBody
    public Object list_boss() {
        Integer deptId = ShiroKit.getUser().deptId;
        List<Map<String, Object>> list = this.iQuitService.quitBossList(deptId);
        return list;
    }

    /**
     * 经理审批
     */
    @RequestMapping(value = "/edit_boss/{id}")
    @ResponseBody
    public Integer edit_boss(@PathVariable Integer id) {

        Integer status = 2;
        Integer list = this.iQuitService.editBossQuit(id,status);
        return list;
    }

    /**
     * 经理删除
     */
    @RequestMapping(value = "/delete_boss/{id}")
    @ResponseBody
    public Integer delete(@PathVariable int id) {

        Integer list = this.iQuitService.deleteBossQuit(id);
        return list;
    }
}
