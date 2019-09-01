package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CstService;
import com.briup.bean.CstServiceExample;
import com.briup.bean.SysUser;
import com.briup.common.exception.CrmCommonException;
import com.briup.dao.interfaces.CstServiceMapper;
import com.briup.service.interfaces.ICstService;
import com.briup.service.interfaces.IReportFormsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 服务管理模块
 * @author 11870
 *
 */
@Service
public class ICstServiceImpl implements ICstService {

	@Autowired
	private CstServiceMapper cstServiceMapper; 
	
/*	@Autowired
	private IReportFormsService reportFormsService ;*/
	
	@Override
	public void save(CstService cstService) throws CrmCommonException {
		int insert = cstServiceMapper.insert(cstService);
		System.out.println("saveService:"+insert);
	}

	@Override
	public List<SysUser> findAllManagerName() throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CstService> findCstServiceByCondition(CstService con, int curPage, int row)
			throws CrmCommonException {
		//设置起始页面
		PageHelper.startPage(curPage, row);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrCustNameLike("%"+con.getSvrCustName()+"%")
		.andSvrTitleLike("%"+con.getSvrTitle()+"%")
		.andSvrTypeLike("%"+con.getSvrType()+"%")
		.andSvrStatusLike("%"+con.getSvrStatus()+"%");
		List<CstService> list = cstServiceMapper.selectByExample(example);
		PageInfo<CstService> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<CstService> findServiceOnDealed(CstService con, int curPage, int row) throws CrmCommonException {
		//设置起始页面
		System.out.println("con:"+con);
		PageHelper.startPage(curPage, row);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria()
		.andSvrCustNameLike("%"+con.getSvrCustName()+"%")
		.andSvrTitleLike("%"+con.getSvrTitle()+"%")
		.andSvrTypeLike("%"+con.getSvrType()+"%")
		.andSvrStatusLike("已处理");
		List<CstService> list = cstServiceMapper.selectByExample(example);
		System.out.println(list);
		PageInfo<CstService> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	/**
	 * 服务分配
	 * 查找所有客户及对应服务
	 * @author 11870
	 *
	 */
	@Override
	public PageInfo<CstService> findAllService(int curPage, int row) throws CrmCommonException {
		//设置起始页面
		PageHelper.startPage(curPage, row);
		//查询所有用户
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrStatusEqualTo("新创建");
		List<CstService> list = cstServiceMapper.selectByExample(example);
		//list传入
		System.out.println("service"+list);
		PageInfo<CstService> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<CstService> findByfp(int curPage, int row) throws CrmCommonException {
		//设置起始页面
		PageHelper.startPage(curPage, row);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrStatusEqualTo("已分配");
		List<CstService> list = cstServiceMapper.selectByExample(example);
		PageInfo<CstService> pageInfo = new PageInfo<CstService>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<CstService> findBycl(int curPage, int row) throws CrmCommonException {
		//设置起始页面
		PageHelper.startPage(curPage, row);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrStatusEqualTo("已处理");
		List<CstService> list = cstServiceMapper.selectByExample(example);
		PageInfo<CstService> pageInfo = new PageInfo<CstService>(list);
		return pageInfo;
	}

	@Override
	public void delete(long svrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCstService(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CstService queryOneByid(long svrId) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrIdEqualTo(svrId);
		List<CstService> list = cstServiceMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public void updateinfo(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub
		int i = cstServiceMapper.updateByPrimaryKeySelective(cstService);
		System.out.println(i);
	}

	@Override
	public void Dealresult(CstService cstService) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

}
