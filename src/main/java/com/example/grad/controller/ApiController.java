package com.example.grad.controller;

import com.example.grad.bean.ApiBean;
import com.example.grad.mapper.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zxf
 */
@Controller
@RequestMapping(value = "/API")
public class ApiController {

    @Autowired(required = false)
    ApiMapper apiMapper;

    /**
     * 进入API管理页
     * @param model
     * @return
     */
    @RequestMapping(value = "/APIManage")
    public String APIManage(Model model){
        List<ApiBean> APIList = apiMapper.selectAllAPI();
        model.addAttribute("APIList", APIList);
        return "api_manage1";
    }

    /**
     * API删除/修改操作
     * @param id
     * @param api_url
     * @param remark_detail
     * @param submit
     * @param model
     * @return
     */
    @RequestMapping(value = "/API")
    public String API(@RequestParam("id") String id, @RequestParam("api_url") String api_url, @RequestParam("remark_detail") String remark_detail, @RequestParam("submit") String submit, Model model){
        if(submit.equals("修改")){
            int updateCount = apiMapper.updateAPIM(api_url, remark_detail, id);
        }else if(submit.equals("删除")){
            int deleteCount = apiMapper.deleteAPIM(id);
        }
        List<ApiBean> APIList = apiMapper.selectAllAPI();
        model.addAttribute("APIList", APIList);
        return "api_manage1";
    }

    /**
     * 插入API数据
     * @param api_url
     * @param remark_detail
     * @param model
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insert(@RequestParam("api_url") String api_url, @RequestParam("remark_detail") String remark_detail, Model model){
        int insertCount = apiMapper.insert(api_url, remark_detail);
        List<ApiBean> APIList = apiMapper.selectAllAPI();
        model.addAttribute("APIList", APIList);
        return "api_manage1";
    }

}
