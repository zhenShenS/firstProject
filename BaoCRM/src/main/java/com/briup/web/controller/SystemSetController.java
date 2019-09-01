package com.briup.web.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.bean.CstLog;
import com.briup.bean.SysRole;
import com.briup.bean.SysUser;
import com.briup.common.exception.CrmCommonException;
import com.briup.service.interfaces.ILogService;
import com.briup.service.interfaces.ISysUserService;
import com.github.pagehelper.PageInfo;
/**
 * ϵͳ����ģ��
 * @author 11870
 *
 */
@Controller
public class SystemSetController {
	
	@Autowired
	private ISysUserService sysUserService; 
	@Autowired
	private ILogService logService;
	
	/**
	 * ��ɫ����
	 * @param curpage
	 * @param session
	 * @return
	 */
	@RequestMapping("/role/{curpage}/toShowAllRole")
	public String roleManagement(@PathVariable int curpage,HttpSession session){
		try {
			List<SysRole> sysRole = sysUserService.findAllRole();
			session.setAttribute("sysRole", sysRole);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "systemset/role_manage";
	}
	/**
	 * ��ɫ����
	 * ��������
	 * @param curpage
	 * @param session
	 * @return
	 */
	@RequestMapping("/systemset/addRole")
	public String addRole(){
		return "systemset/addRole";
	}
	
	@RequestMapping("/systemset/saveRole")
	public String saveRole(SysRole sysRole,HttpSession session){
		try {
			sysUserService.addRole(sysRole);
			String thing="�����"+sysRole.getRoleName()+"ְλ";
			addLog(session, thing);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/role/1/toShowAllRole";
	}
	
/*	@RequestMapping("/systemset/rolemanage")
	public String addRoleToRoleManage(SysRole sysRole){
		
		return "redirect:/role/1/toShowAllRole";
	}*/
	
	private void addLog(HttpSession session, String thing) throws CrmCommonException {
		SysUser user = (SysUser) session.getAttribute("user");
		CstLog cstLog = new CstLog();
		cstLog.setLogOp(user.getUsrName());
		Date date = new Date();
		cstLog.setLogDate(date);
		cstLog.setLogEvent(thing);
		logService.saveLog(cstLog);
	}
	
	/**
	 * ��ɫ����
	 * �༭����
	 * @param curpage
	 * @param session
	 * @return
	 */
	
	@RequestMapping("/systemset/{roleId}/role_update")
	public String updateRoleManagement(@PathVariable long roleId,HttpSession session){
		try {
			SysRole oneRole = sysUserService.findRoleBySysRoleId(roleId);
			session.setAttribute("oneRole", oneRole);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "systemset/role_update";
	}
	
	
	@RequestMapping("/role/roleupdate")
	public String saveRoleManagement(SysRole sysRole,HttpSession session){
		try {
			sysUserService.updateRole(sysRole);
			String thing="�޸���"+sysRole.getRoleName()+"ְλ����Ϣ";
			addLog(session, thing);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/role/1/toShowAllRole";
	}
	/**
	 * ��ɫ����
	 * ɾ������
	 * @param curpage
	 * @param session
	 * @return
	 */
	@RequestMapping("/systemset/{roleId}/role_delete")
	public String deleteRoleManagement(@PathVariable long roleId,HttpSession session){
		try {
			sysUserService.deleteRole(roleId);
			String thing="ɾ����"+roleId+"��ְλ����Ϣ";
			addLog(session, thing);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/role/1/toShowAllRole";
	}
	/**
	 * �û�����
	 * @param curpage
	 * @param session
	 * @return
	 */
	@RequestMapping(value="sysUser/{curPage}/showAllUser",method=RequestMethod.GET)
	public String findAllCustomers(@PathVariable int curPage,HttpSession session){
		try {
			//��ǰҳ�� �� 10�����ݴ��ݸ�service��
			PageInfo<SysUser> pageInfo = sysUserService.findAllSysUser(curPage, 4);
			//���浽session��
			System.out.println(pageInfo.getSize());
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "systemset/user_manage";
	}
	
	@RequestMapping("/systemset/adduser")
	public String addUser(){
		return "systemset/add";
	}
	
	@RequestMapping("/systemset/saveUser")
	public String saveUser(SysUser sysUser,HttpSession session){
		try {
			sysUserService.addUser(sysUser);
			String thing="������û�"+sysUser.getUsrName()+"����Ϣ";
			addLog(session, thing);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/sysUser/1/showAllUser";
	}
	
	@RequestMapping("/systemset/usermanage")
	public String addToUserManage(){
		
		return "redirect:/sysUser/1/showAllUser";
	}
	
	
	/**
	 * �û�����
	 * �༭����
	 * @param curpage
	 * @param session
	 * @return
	 */
	@RequestMapping("/systemset/{usrId}/user_update")
	public String updateUserManagement(@PathVariable long usrId,HttpSession session){
		try {
			SysUser oneUser = sysUserService.findOneUser(usrId);
			session.setAttribute("oneUser", oneUser);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "systemset/user_update";
	}

	@RequestMapping("/systemset/updateUser")
	public String saveUserManagement(SysUser sysUser,HttpSession session){
		try {
			sysUserService.updateUser(sysUser);
			String thing="�޸����û�"+sysUser.getUsrName()+"����Ϣ";
			addLog(session, thing);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/sysUser/1/showAllUser";
	}
	/**
	 * �û�����
	 * ɾ������
	 * @param curpage
	 * @param session
	 * @return
	 */
	@RequestMapping("/systemset/{usrId}/user_delete")
	public String deleteUserManagement(@PathVariable long usrId,HttpSession session){
		try {
			sysUserService.deleteUser(usrId);
			String thing="ɾ�����û����Ϊ"+usrId+"����Ϣ";
			addLog(session, thing);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/sysUser/1/showAllUser";
	}
	
	/**
	 * ��־�鿴
	 * @param curpage
	 * @param session
	 * @return
	 */
	@RequestMapping("log/{curpage}/reviewLog")
	public String logViewer(@PathVariable int curpage,HttpSession session){
		System.out.println("��־�鿴");
		try {
			PageInfo<CstLog> findAllLog = logService.findAllLog(curpage, 4);
			List<CstLog> list = findAllLog.getList();
			for (CstLog cstLog : list) {
				System.out.println(cstLog);
			}
			session.setAttribute("findAllLog", findAllLog);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "systemset/log_review";
	}
}
