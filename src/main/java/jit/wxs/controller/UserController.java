package jit.wxs.controller;

import jit.wxs.entity.SysUser;
import jit.wxs.service.SysRoleService;
import jit.wxs.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.normalizer.NormalizerBase;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;


    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登陆用户：" + name);

        return "home";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("login")
    public String showLogin() {
        return "login";
    }

    /**
     * 跳转注册
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }
    /**
     * 注册
     * @return
     */
    @RequestMapping("/register")
    public String register(SysUser sysUser, String role, HttpServletRequest request) {
        SysUser user=userService.selectByName(sysUser.getName());
        if (user==null){
            userService.saveSysUser(sysUser);
            roleService.saveSysRole(role);
            request.setAttribute("login","注册成功，请登录！");
            return "login";
        }
//        return "<script>alert(\"账号已存在，请重新注册！\");window.location.href=\"/toRegister\";</script>";
        request.setAttribute("login","账号已存在，请重新注册！");
        return "register";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "<h2>段位：白银</h2></br><h4>欢迎来到白银试炼场</h2>";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "<h2>段位：青铜</h2></br><h4>欢迎来到青铜试炼场</h2>";
    }

    @RequestMapping("/toSayHello")
    public String toSayHello(){
        return "sayHello";
    }
}