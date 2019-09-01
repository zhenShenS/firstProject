package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CstLog;
import com.briup.bean.CstLogExample;
import com.briup.common.exception.CrmCommonException;
import com.briup.dao.interfaces.CstLogMapper;
import com.briup.service.interfaces.ILogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class LogServiceImpl  implements ILogService{

	@Autowired 
	private CstLogMapper cstLogMapper;

	@Override
	public void saveLog(CstLog log) throws CrmCommonException {
		// TODO Auto-generated method stub
		int i = cstLogMapper.insertSelective(log);
		System.out.println(i);
		
	}

	@Override
	public PageInfo<CstLog> findAllLog(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		CstLogExample cstLogExample = new CstLogExample();
		List<CstLog> selectByExample = cstLogMapper.selectByExample(cstLogExample);
		PageInfo<CstLog> pageInfo = new PageInfo<>(selectByExample);
		
		return pageInfo;
	}

	@Override
	public List<CstLog> findAllLog() throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
