package com.briup.web.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.bean.SalChance;
import com.briup.bean.SalPlan;
import com.briup.bean.SysUser;
import com.briup.common.exception.CrmCommonException;
import com.briup.service.interfaces.ISalChanceService;
import com.briup.service.interfaces.ISysUserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sale")
public class SalesManagementController {

	@Autowired
	private ISalChanceService salChangeService;
	
	@Autowired
	private ISysUserService sysUserService;
	/**
	 * 销售计划
	 * */
	@RequestMapping("{curPage}/showAllSaleChance")
	public String salesOpportunities(@PathVariable int curPage,HttpSession session){
		
		try {
			PageInfo<SalChance> findSalChanceByPage = salChangeService.findSalChanceByPage(curPage,4);
			session.setAttribute("findSalChance", findSalChanceByPage);

		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		
		return "sale/list";
		
	}
	
	
	/**
	 * 客户开发计划
	 * */
	@RequestMapping("{curPage}/dev")
	public String customerDevelopment(@PathVariable int curPage,HttpSession session){
		try {
			PageInfo<SalChance> findSalChanceByPage = salChangeService.findSalChanceByPage(curPage,8);
			session.setAttribute("findSalChance", findSalChanceByPage);
			PageInfo<SalChance> findSalChance = (PageInfo<SalChance>) session.getAttribute("findSalChance");
			List<SalChance> list = findSalChance.getList();
			Iterator<SalChance> it = list.iterator();
			while (it.hasNext()) {
				
				System.out.println("session:"+it.next());
			}
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sale/dev";
		
	}
	
	/**
	 * 指定客户开发计划（还未被开发的客户）
	 */
	@RequestMapping(value="{chcId}/dev_plan_before")
	public String dev_plan_before(@PathVariable long chcId,HttpSession session){
		try {
			SalChance findOneSalChance = salChangeService.findOneSalChance(chcId);
			session.setAttribute("OneSalChance", findOneSalChance);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sale/dev_plan";
	}
	/**
	 * 执行客户开发计划（什么叫执行客户开发计划）
	 */
	@RequestMapping(value="{chcId}/dev_execute_before")
	public String dev_execute_before(@PathVariable long chcId,HttpSession session){
		try {
			SalChance findOneSalChance = salChangeService.findOneSalChance(chcId);
			session.setAttribute("OneSalChance", findOneSalChance);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sale/dev_execute";
	}
	@RequestMapping(value="dev_execute_develop")
	public String dev_execute_develop(SalChance salChance,HttpSession session){
		try {
			System.out.println(salChance);
			salChance.setChcStatus("develop");
			salChangeService.updateChance(salChance);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:1/dev";
	}
	@RequestMapping(value="dev_execute_success")
	public String dev_execute_success(SalChance salChance,HttpSession session){
		try {
			salChance.setChcStatus("success");
			salChangeService.updateChance(salChance);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:1/dev";
	}
	
	@RequestMapping(value="saveplan.action")
	public String dev_saveplan(SalPlan salPlan,@RequestParam Long plaChcId){
		try {
			salPlan.setPlaChcId(plaChcId);
			SalPlan plan = salChangeService.findSalPlan(salPlan.getPlaChcId());
			salPlan.setPlaId(plan.getPlaId());
			System.out.println("set后:"+salPlan);
			salChangeService.updateSalPlan(salPlan);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:1/dev";
	}
	/**
	 * 查看客户开发计划
	 * @return
	 */
	@RequestMapping(value="{chcId}/dev_plan_controller")
	public String dev_dev_detail_controller(@PathVariable Long chcId,HttpSession session){
		try {
			SalChance findOneSalChance = salChangeService.findOneSalChance(chcId);
			session.setAttribute("findOneSalChance", findOneSalChance);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sale/dev_detail";
	}
	
	
	
	
	
	
	
	
	/**
	 * 新建销售机会管理
	 */
	
	@RequestMapping(value="add_salchance_controller")
	public String add_salchance_controller(){
		
		return "sale/add_salchance";
	}
	@RequestMapping(value="save_salchance_controller")
	public String save_salchance_controller(SalChance sc){
		try {
			salChangeService.saveChance(sc);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:1/dev";
		
	}
	
	/**
	 * 分派销售机会
	 */
	@RequestMapping(value="{chcId}/dispatch_controller")
	public String dispatch_controller(@PathVariable Long chcId,HttpSession session){
		try {
			SalChance oneSalChance = salChangeService.findOneSalChance(chcId);
			List<SysUser> findAllMgr = sysUserService.findAllMgr();
			session.setAttribute("oneSalChance", oneSalChance);
			session.setAttribute("findAllMgr", findAllMgr);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sale/dispatch";
	}
	@RequestMapping(value="dispatch_behind_controller")
	public String dispatch_behind_controller(SalChance sc){
		try {
			System.out.println(sc.getChcId());
			salChangeService.updateChance(sc);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:1/dev";
		
	}
	
	/**
	 * 修改销售计划
	 */
	@RequestMapping(value="{chcId}/Update_controller")
	public String Update_controller(@PathVariable Long chcId,HttpSession session){
		try {
			SalChance findOneSalChance = salChangeService.findOneSalChance(chcId);
			session.setAttribute("findOneSalChance", findOneSalChance);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "sale/edit";
		
	}
	
	@RequestMapping("update_behind")
	public String update_behind(SalChance salChance){
		try {
			salChangeService.updateChance(salChance);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/sale/1/showAllSaleChance";
	}
	/**
	 * 删除销售机会
	 * @param salChance
	 * @return
	 */
	@RequestMapping("{chcId}/delete_controller")
	public String delete(@PathVariable Long chcId){
		try {
			salChangeService.deleteSalChance(chcId);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/sale/1/showAllSaleChance";
	}
}
