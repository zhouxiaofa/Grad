package com.example.grad.controller;

import com.example.grad.bean.StandardBean;
import com.example.grad.bean.UserBean;
import com.example.grad.mapper.StandardMapper;
import com.example.grad.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zxf
 */

@Controller
public class UserController {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    StandardMapper standardMapper;

    /**
     * 返回登录界面
     * @return
     */
    @RequestMapping(value = "/index")
    public String show() {
        return "index1";
    }

    /**
     * 新用户注册
     * @return
     */
    @RequestMapping(value = "/register")
    public String register(){
        return "register1";
    }

    /**
     * 返回admin界面
     * @return
     */
    @RequestMapping(value = "/admin")
    public String admin(){
        return "admin1";
    }

    /**
     * 获得list<user>,进入userManage界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/userManage")
    public String returnAdminPage(Model model){
        List<UserBean> userList = userMapper.selectAllUser();
        model.addAttribute("userList", userList);
        return "user_manage1";
    }

    /**
     * user实体类的修改/删除
     * @param id
     * @param name
     * @param password
     * @param s_flag
     * @param submit
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/update")
    public String updateUser(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("password") String password,
                             @RequestParam("s_flag") int s_flag, @RequestParam("submit") String submit, Model model){
        // 修改,数据库update
        if(submit.equals("修改")){
            int updateCount = userMapper.updateUserM(password, s_flag, id);
        // 假删除,数据库update,flag字段置0
        }else if(submit.equals("删除")){
            int deleteCount = userMapper.deleteUser(id);
        }
        List<UserBean> userList = userMapper.selectAllUser();
        model.addAttribute("userList", userList);
        return "user_manage1";
    }

    /**
     * admin操作insert新的user
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/insert")
    public String insert(@RequestParam("name") String name, @RequestParam("password") String password, Model model){
        UserBean userBean = userMapper.login(name);
        // 存在相同账号,直接返回
        if(userBean != null){
            List<UserBean> userList = userMapper.selectAllUser();
            model.addAttribute("userList", userList);
        }else {
            int insertCount = userMapper.insertUserByAdmin(name, password);
            List<UserBean> userList = userMapper.selectAllUser();
            model.addAttribute("userList", userList);
        }
        return "user_manage1";
    }

    /**
     * 登录验证,用户/管理员分别进入前/后台
     * @param name
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        // 判断账号是否存在
        UserBean userBean1 = userMapper.login(name);
        // 账号不存在,返回登录界面
        if(userBean1 == null){
            return "index1";
        // 账号存在,判断密码是否正确
        }else {
            // 密码错误,返回登录界面
            if(!userBean1.getPassword().equals(password)){
                return "index1";
            }else {
                //账号禁用,不允许登录,返回登录界面
                if(userBean1.getS_flag()==0){
                    return "index1";
                }else {
                    // 管理员账号(flag=1),进入后台
                    if(userBean1.getFlag()==1){
                        List<UserBean> userList = userMapper.selectAllUser();
                        model.addAttribute("userList", userList);
                        return "admin1";
                        // 用户账号(flag=0),进入前台
                    }else {
                        List<String> featureList = standardMapper.selectDistinctFeature();
                        model.addAttribute("featureList", featureList);
                        List<String> compList = standardMapper.selectDistinctComp();
                        model.addAttribute("compList", compList);
                        List<StandardBean> standardList = standardMapper.selectStandard10();
                        model.addAttribute("standardList", standardList);
                        return "home1";
                    }
                }
            }
        }
    }

    /**
     * 新用户注册
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insertUser(@RequestParam("name") String name, @RequestParam("password") String password) {
        UserBean userBean = userMapper.login(name);
        if (userBean == null) {
            int count = userMapper.insertInfoM(name, password);
            return "index1";
        } else {
            return "register1";
        }
    }

    /**
     * 进入图谱查看
     * @param model
     * @return
     */
    @RequestMapping(value = "/neo4j")
    public String intoNeo4j(Model model){
        List<String> compList = standardMapper.selectDistinctComp();
        model.addAttribute("compList", compList);
        return "neo4j1";
    }

    /**
     * 查询所有用户数据信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectAllUser")
    public String selectAllUser(Model model){
        // 查询到所有的用户数据
        List<UserBean> userList = userMapper.selectAllUser();
        model.addAttribute("userList", userList);
        return "user_manage1";
    }

}
