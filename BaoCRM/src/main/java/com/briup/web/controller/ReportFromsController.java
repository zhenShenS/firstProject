package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.jfree.data.category.CategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.common.util.JFreeChartUtil;
import com.briup.service.interfaces.IReportFormsService;

@Controller
public class ReportFromsController {

	@Autowired
	public IReportFormsService reportFromService;

	/*@Autowired
	public ReportServiceImpl reportFromServiceImpl ;*/
	@RequestMapping(value = "chart/cstContribute")
	public String showCstContribute(String cstname, HttpServletRequest request) {
		try {
			CategoryDataset findCstcontribute = reportFromService.findCstcontribute(cstname);
			String fileName = JFreeChartUtil.createBarChart("衣食父母贡献分析图", "客户", "总金额", findCstcontribute, request);
			String chartURL = request.getContextPath() + "/jfreeChart?filename=" + fileName;
			System.out.println(chartURL);
			request.getSession().setAttribute("chartURL", chartURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jfreechart/contr";

	}

	@RequestMapping(value = "chart/constitute")
	public String showCstconstitute(Integer condit, HttpServletRequest request) {
		if(condit==null){
			condit=0;
		}
		try {
			CategoryDataset findCstMakeup = reportFromService.findCstMakeup(condit);
			String fileName = JFreeChartUtil.createBarChart(
					"客户构成分析(看看哪种客户是大哥)", "上帝", 
					"上帝的恩宠程度", findCstMakeup, request);
			String chartURLCons = request.getContextPath() + "/jfreeChart?filename=" + fileName;
			System.out.println(chartURLCons);
			request.getSession().setAttribute("chartURLCons", chartURLCons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "jfreechart/cons";
	}

}
