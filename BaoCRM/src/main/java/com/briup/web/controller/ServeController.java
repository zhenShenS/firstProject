package com.briup.web.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.bean.CstCustomer;
import com.briup.bean.CstService;
import com.briup.bean.SysUser;
import com.briup.common.exception.CrmCommonException;
import com.briup.service.interfaces.ICstService;
import com.briup.service.interfaces.ICustomerService;
import com.briup.service.interfaces.ISysUserService;
import com.github.pagehelper.PageInfo;

/**
 * 服务管理模块
 * @author 11870
 *
 */
@Controller
public class ServeController {
	@Autowired
	private ICstService cstService;
	@Autowired
	private ICustomerService customerService; 
	@Autowired
	private ISysUserService SysuserService;
	/**
	 * 服务创建
	 * @param curPage
	 * @param session
	 * @return
	 */
	@RequestMapping("/service/toShowAddService")
	public String toShowAddService(HttpSession session){
		try {
			List<CstCustomer> allCustomer = customerService.findAllCustomer();
			session.setAttribute("allCustomer", allCustomer);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_service/add";
	}
	
	@RequestMapping("/addService")
	public String AddService(CstService Service){
		try {
			cstService.save(Service);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_service/add";
	}
	/**
	 * 服务分配
	 * @param curPage
	 * @param session
	 * @return
	 */
	@RequestMapping(value="service/{curPage}/findAllService",method=RequestMethod.GET)
	public String findAllService(@PathVariable int curPage,HttpSession session){
		try {
			//当前页面 与 10条数据传递给service层
			List<SysUser> allMgr = SysuserService.findAllMgr();
			PageInfo<CstService> findAllService = cstService.findAllService(curPage, 4);
			//保存到session中
			System.out.println("所有人员："+allMgr);
			session.setAttribute("pageInfo", findAllService);
			session.setAttribute("allMgr", allMgr);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_service/dispatch";
	} 
	
	
	
	@RequestMapping(value="service/allot")
	public String findAllService_2(CstService service){
		try {
		          cstService.updateinfo(service);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "redirect:/service/1/findAllService";
	} 
	/**
	 * service/findByCon
	 * @param curPage
	 * @param session
	 * @return
	 */
	@RequestMapping(value="service/findByCon")
	public String findServiceBycondition (CstService con,int curPage,HttpSession session){
		try {
			PageInfo<CstService> pageInfoByCon = 
					cstService.findCstServiceByCondition(con, curPage, 4);
		    session.setAttribute("pageInfo", pageInfoByCon);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_service/dispatch";
	} 
	/**
	 * 服务处理
	 * @param curPage
	 * @param session
	 * @return
	 */
	@RequestMapping(value="service/{curPage}/findAllFp",method=RequestMethod.GET)
	public String findAllFp(@PathVariable int curPage,HttpSession session){
		try {
			//当前页面 与 10条数据传递给service层
			PageInfo<CstService> findByfp = cstService.findByfp(curPage,5);
			//保存到session中
			session.setAttribute("pageInfo", findByfp);
			
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_service/deal";
	} 
	
	@RequestMapping(value="service/{curPage}/selectFp",method=RequestMethod.POST)
	public String selectFp(@PathVariable int curPage,HttpSession session,CstService service){
		try {
			//当前页面 与 10条数据传递给service层
			PageInfo<CstService> findCstServiceByCondition = cstService.findCstServiceByCondition(service, curPage, 4);
			//保存到session中
			session.setAttribute("pageInfo", findCstServiceByCondition);
			
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_service/deal";
	} 
	@RequestMapping(value="service/{svrId}/deal_detail",method=RequestMethod.GET)
	public String selectFp(@PathVariable Long svrId,HttpSession session){
		
		return "cust_service/deal_detail";
	} 
	
	/**
	 * 服务反馈
	 * @param curPage
	 * @param session
	 * @return
	 */
	@RequestMapping(value="service/{curPage}/findFeedback",method=RequestMethod.GET)
	public String findFeedback(@PathVariable int curPage,HttpSession session){
		try {
			PageInfo<CstService> pageInfo = cstService.findBycl(curPage, 6);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_service/feedback";
	} 
	
	@RequestMapping(value="service/{curPage}/selectFB",method=RequestMethod.POST)
	public String selectFB(@PathVariable int curPage,HttpSession session,CstService service){
		try {
			//当前页面 与 10条数据传递给service层
			PageInfo<CstService> pageInfo = cstService.findServiceOnDealed(service, curPage, 6);
			System.out.println("*********++"+pageInfo.getList().toString());
			//保存到session中
			session.setAttribute("pageInfo", pageInfo);
			
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_service/feedback";
	}
	
	@RequestMapping(value="service/{svrId}/feedback_detail_controller")
	public String feedback_detail(@PathVariable Long svrId,HttpSession session){
		System.out.println("asdfgh+++++++++++++++++++++++++++++++++++++");
		try {
			CstService queryOneByid = cstService.queryOneByid(svrId);
			session.setAttribute("queryOneByid", queryOneByid);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_service/feedback_detail";
	}
	
	@RequestMapping(value="service/update")
	public String service_update_controller(CstService service,HttpSession session){
		System.out.println("asdfgh+++++++++++++++++++++++++++++++++++++");
		try {
		cstService.updateinfo(service);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cust_service/feedback";
	}
	
}
