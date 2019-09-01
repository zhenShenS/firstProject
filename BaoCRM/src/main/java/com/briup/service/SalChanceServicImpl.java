package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.SalChance;
import com.briup.bean.SalChanceExample;
import com.briup.bean.SalPlan;
import com.briup.bean.SalPlanExample;
import com.briup.bean.SalPlanExample.Criteria;
import com.briup.common.exception.CrmCommonException;
import com.briup.dao.interfaces.SalChanceMapper;
import com.briup.dao.interfaces.SalPlanMapper;
import com.briup.service.interfaces.ISalChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class SalChanceServicImpl implements ISalChanceService {

	@Autowired 
	private SalChanceMapper salChangeMapper;
	@Autowired 
	private SalPlanMapper salPlanMapper;
	
	
	@Override
	public void saveChance(SalChance sc) throws CrmCommonException {
		int insertSelective = salChangeMapper.insertSelective(sc);
		System.out.println(insertSelective);
	}

	/**
	 * 查找所有的销售机会带分页的
	 * */
	
	@Override
	public PageInfo<SalChance> findSalChanceByPage(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		//获取第 curpage 页， row 条内容，默认查询总数 count
		PageHelper.startPage(curpage, row);
		SalChanceExample chanceExample = new SalChanceExample();
		List<SalChance> list = salChangeMapper.selectByExample(chanceExample);
		//使用pageInfo对结果进行包装  分页
		PageInfo<SalChance> pageInfo = new PageInfo<>(list);
		
		return pageInfo;
	}

	@Override
	public List<SalPlan> findAllSalPlan() throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalPlan> findSalPlans(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<SalPlan> findSalPlanByPage(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		//为分页插件设置参数   
		PageHelper.startPage(curpage,row);
		SalPlanExample salPlanExample = new SalPlanExample();
        List<SalPlan> selectByExample = salPlanMapper.selectByExample(salPlanExample);
        PageInfo<SalPlan> pageInfo = new PageInfo<>(selectByExample);
		return pageInfo;
	}

	@Override
	public void updateChance(SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		int i = salChangeMapper.updateByPrimaryKeySelective(sc);
		System.out.println(i);
		
	}

	@Override
	public SalChance findOneSalChance(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return salChangeMapper.selectByPrimaryKey(chcId);
	}

	@Override
	public SalPlan findSalPlan(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalPlanExample example = new SalPlanExample();
		example.createCriteria().andPlaChcIdEqualTo(chcId);
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public void deleteSalChance(long chcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = salChangeMapper.deleteByPrimaryKey(chcId);
		System.out.println(deleteByPrimaryKey);
	}

	@Override
	public void savePlan(SalPlan sp) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSalPlan(long plaId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSalPlan(SalPlan sp) throws CrmCommonException {
		// TODO Auto-generated method stub
		int i = salPlanMapper.updateByPrimaryKeySelective(sp);
		System.out.println(i);
		
	}
	
	public Long findSalPlanIdByPlaChcId(Long plaChcId) throws CrmCommonException {
		// TODO Auto-generated method stub
		SalPlanExample example = new SalPlanExample();
		Criteria criteria = example.createCriteria();
		criteria.andPlaChcIdEqualTo(plaChcId);
		List<SalPlan> list = salPlanMapper.selectByExample(example);
		list.get(0);
		return list.get(0).getPlaId();
	}

	@Override
	public PageInfo<SalChance> findSalPageByCon(int curpage, int row, SalChance sc) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

}
