package com.briup.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.briup.bean.Product;
import com.briup.bean.Storage;
import com.briup.common.exception.CrmCommonException;
import com.briup.service.interfaces.IBasicDataService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IBasicDataService basicDataService;
	
	@RequestMapping(value="/{curPage}/toproduct")
	public String toproduct(@PathVariable int curPage,HttpSession session) {
		try {
			PageInfo<Product> pageInfo = basicDataService.findProductAll(curPage, 10);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "basic/product";
	}
	
	@RequestMapping(value="/{curPage}/findProductByCon",method=RequestMethod.POST)
	public String findProductByCon(@PathVariable int curPage,HttpSession session,Product product) {
		try {
			PageInfo<Product> pageInfo = basicDataService.findProduct(product, curPage,5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
		}
		return "basic/product";
	}
	
	@RequestMapping(value="/{curpage}/storage")
	public String toShowStorage(@PathVariable int curpage,HttpSession session) {
		try {
			PageInfo<Storage> pageInfo = basicDataService.findStorageAll(curpage,5);
			session.setAttribute("pageInfo", pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg",e.getMessage());
		}
		return "basic/storage";
	}
	
	@RequestMapping(value="/{curpage}/findStorageByCon")
	public String findStorageByCon(@PathVariable int curpage,Storage storage,HttpSession session) {
		try {
			PageInfo<Storage> pageInfo = basicDataService.findStorage(storage, curpage, 5);
			session.setAttribute("pageInfo",pageInfo);
		} catch (CrmCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
		}
		
		return "basic/storage";
	}
}
