package com.briup.web.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.bean.CstActivity;
import com.briup.bean.CstCustomer;
import com.briup.bean.CstLinkman;
import com.briup.bean.CstLog;
import com.briup.bean.SysUser;
import com.briup.common.exception.CrmCommonException;
import com.briup.service.interfaces.ICustomerService;
import com.briup.service.interfaces.ILogService;
import com.github.pagehelper.PageInfo;
/**
 * ���û���صĲ���
 * @author 11870
 *
 */
@Controller
public class CustomerController {
	
	@Autowired
	private ICustomerService ICustomerService;
	
	@Autowired
	private ILogService logService;
	
	@RequestMapping(value="/cust/{curPage}/findAllCust")
	public String findAllCustomers(@PathVariable int curPage,HttpSession session){
		try {
			//��ǰҳ�� �� 10�����ݴ��ݸ�service��
			PageInfo<CstCustomer> pageInfo = ICustomerService.findAllCstCustomer(curPage,4);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_info/list";
	} 
	
	@RequestMapping(value="add_customer")
	public String add_customer(){
		return "cust_info/add_customer";
		
	}
	
	
	
	@RequestMapping(value="selectCustomer")
	public String selectCustomer(@RequestParam String cust_no,
			@RequestParam String cust_name,@RequestParam String cust_addr,
			@RequestParam String cust_manager_name,
			@RequestParam String cust_level_label){
		
		return "redirect:/cust/1/findAllCust";
		
	}
	
	@RequestMapping(value="add_customer_behind")
	public String add_customer_behind(CstCustomer cst ,HttpSession session){
		System.out.println("controller��ת");
		try {
			ICustomerService.saveCustomer(cst);
			String thing="������"+cst.getCustId()+"�Ź˿͵���Ϣ";
			addLog(session, thing);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/1/findAllCust";
		
	}

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
	 * listҳ��Ĳ�ѯ
	 * @param curPage
	 * @param session
	 * @return
	 */
	@RequestMapping(value="cust/{curPage}/selectCustomer")
	public String selectCustomer(@PathVariable int curPage,HttpSession session,CstCustomer cst){
		try {
			//��ǰҳ�� �� 10�����ݴ��ݸ�service��
			PageInfo<CstCustomer> pageInfo = ICustomerService.findCustomerPageByCon(curPage, 8, cst);
			System.out.println("++++++++++++selectCustomer+++++++++++++++++++++++++");
			session.setAttribute("pageInfo", pageInfo);
			PageInfo<CstCustomer> attribute = (PageInfo<CstCustomer>) session.getAttribute("pageInfo");
			List<CstCustomer> list = attribute.getList();
			Iterator<CstCustomer> it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			System.out.println("________________________________");
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_info/list";
	}
	
	
	
	@RequestMapping(value="list/{custId}/update")
	public String UpdateCustomer_before(@PathVariable long custId, HttpSession session){
		try {
			CstCustomer customerById = ICustomerService.findCustomerById(custId);
			String thing="�޸���"+customerById.getCustId()+"�Ź˿͵���Ϣ";
			addLog(session, thing);
			session.setAttribute("customerById", customerById);
			System.out.println("+++++++++++++++++++++++++++++++");
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/customer_edit1";
		
	}
	
	@RequestMapping(value="update/customer_edit")
	public String UpdateCustomer__behind(CstCustomer cst, HttpSession session){
		try {
			 ICustomerService.updateCustomer(cst);
			 System.out.println("�޸�����");
			//session.setAttribute("customerById", customerById);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/1/findAllCust";
		
	}
	
	@RequestMapping(value="controller/{custId}/linkMan")
	public String linkMan(@PathVariable long custId, HttpSession session){
		try {
			List<CstLinkman> linkManByCstId = ICustomerService.findAllLinkManByCstId(custId);
			session.setAttribute("linkManById", linkManByCstId);
			session.setAttribute("custId", custId);
			System.out.println(linkManByCstId);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "cust_info/linkman";
		
	}

	
	
	@RequestMapping(value="controller/linkMan_add")
	public String createLinkMan_before(){
		
		return "cust_info/linkman_add";
		
	}
	
	@RequestMapping(value="controller/linkMan_add_behind")
	public String createLinkMan_behind(CstLinkman linkMan,HttpSession session){
		try {
			Long custId = (Long) session.getAttribute("custId");
			CstCustomer customer = ICustomerService.findCustomerById(custId);
			linkMan.setLkmCustId(custId);
			linkMan.setLkmCustName(customer.getCustName());
			ICustomerService.saveLinkMan(linkMan);
			String thing="�����"+linkMan.getLkmCustId()+"�Ź˿͵���ϵ��"+linkMan.getLkmName();
			addLog(session, thing);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/1/findAllCust";
		
	}
	
	
	
	@RequestMapping(value="controller/{lkmCustId}/linkMan_update")
	public String updateLinkMan_before(@PathVariable long lkmCustId, HttpSession session){
		try {
			CstLinkman updateLinkManById = ICustomerService.findLinkManById(lkmCustId);
			System.out.println(updateLinkManById);
			session.setAttribute("updateLinkManById", updateLinkManById);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/linkman_edit";
		
	}
	
	@RequestMapping(value="controller/linkMan_update_behind")
	public String updateLinkMan_behind(CstLinkman linkMan, HttpSession session){
		try {
			ICustomerService.updateLinkman(linkMan);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/1/findAllCust";
		
	}
	
	@RequestMapping(value="controller/{lkmCustId}/linkMan_Delete")
	public String deleteLinkMan(@PathVariable long lkmCustId , HttpSession session){
		try {
			ICustomerService.deleteLinkMan(lkmCustId);
			System.out.println(lkmCustId);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/1/findAllCust";
		
	}
	
	
	/**
	 * ������¼
	 */
	@RequestMapping(value="controller/{custNo}/Communication")
	public String Communication(@PathVariable String custNo,HttpSession session){
		try {
			List<CstActivity> activityByCstNo = 
					ICustomerService.findAllCstActivityByCstNo(custNo);
			System.out.println(activityByCstNo);
			session.setAttribute("activityByCstNo",activityByCstNo);
			List<CstActivity> activity = (List<CstActivity>) session.getAttribute("activityByCstNo");
			System.out.println("session�У�"+activity);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "cust_info/activities";
		
	}
	
	/**
	 * �½�������¼ ��ǰ��
	 */
	@RequestMapping(value="controller/Communication_add_before")
	public String Communication_add_before(){
		return "cust_info/activities_add";
	}
	
	/**
	 * �½�������¼ ����
	 */
	@RequestMapping(value="controller/Communication_add_behind")
	public String Communication_add_behind(CstActivity activity){
		try {
			ICustomerService.saveCstActivity(activity);
		} catch (CrmCommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cust/1/findAllCust";
	}
	
	/**
	 * �༭������¼(ǰ)
	 */
@RequestMapping(value="controller/{atvId}/Communication_edit_before")
public String Communication_edit_before(
		@PathVariable long atvId,HttpSession session){
	try {
		CstActivity findCstActivityById = 
				ICustomerService.findCstActivityById(atvId);
		session.setAttribute("CstActivityById",findCstActivityById);
	} catch (CrmCommonException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "cust_info/activities_edit";
}
	
/**
 * �༭������¼(ǰ)
 */
@RequestMapping(value="controller/Communication_edit_behind")
public String Communication_edit_behind(
		CstActivity activity){
	try {
		ICustomerService.updateAtv(activity);
	} catch (CrmCommonException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "redirect:/cust/1/findAllCust";
}


/**
 * ɾ����ϵ��
 * */
@RequestMapping(value="controller/{atvId}/Communication_delete")
public String Communication_delete(@PathVariable long atvId){
	try {
		ICustomerService.deleteAtvById(atvId);
	} catch (CrmCommonException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "redirect:/cust/1/findAllCust";
	
}



/**
 * ɾ���ϵۣ������ؿ��ǣ�
 */

@RequestMapping(value="cust/{custId}/deleteCustomr")
public String deleteCustomer(@PathVariable long custId){
	try {
		ICustomerService.deleteCustomerById(custId);
	} catch (CrmCommonException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "redirect:/cust/1/findAllCust";
	
}






































}
