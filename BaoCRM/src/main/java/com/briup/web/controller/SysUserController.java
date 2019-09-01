package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.bean.SysRole;
import com.briup.bean.SysUser;
import com.briup.common.exception.CrmCommonException;
import com.briup.service.interfaces.ISysUserService;

@Controller
public class SysUserController {
	
	@Autowired
	/**
	 * @Qualifier("实现类类名首字母小写")用于解决一个借口多个实现类
	 * */
	private ISysUserService sysUserService;
	

	@RequestMapping("/")
	public String index(){
		System.out.println("测试注入的是接口还是实现类"+sysUserService);
		return "index";
		
	}
	
	@RequestMapping("/23")
	public String main(@RequestParam String username,@RequestParam String password,HttpSession session){
		try {
        	//SysUserServiceImpl sysUserService = new SysUserServiceImpl();
			SysUser sysUser = 
					sysUserService.login(username, password);
			Long usrRoleId = sysUser.getUsrRoleId();
			SysRole sysRole = sysUserService.findRoleBySysRoleId(usrRoleId);
			if(sysRole.getRoleFlag()==1&sysUser.getUsrFlag()==1){
				session.setAttribute("user",sysUser);
				return "main";
			}else {
				return "Error";
			}
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}		
		
	}
	

	@RequestMapping("/sysUser/LoginOut")
	public String loginOut(HttpSession session){
		session.invalidate();
		//System.out.println(session.getAttribute("user"));
		return "index";
	}
}

