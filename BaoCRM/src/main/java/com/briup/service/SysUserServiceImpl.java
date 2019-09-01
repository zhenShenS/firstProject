package com.briup.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.SysRole;
import com.briup.bean.SysRoleExample;
import com.briup.bean.SysUser;
import com.briup.bean.SysUserExample;
import com.briup.bean.SysUserExample.Criteria;
import com.briup.common.exception.CrmCommonException;
import com.briup.dao.interfaces.SysRoleMapper;
import com.briup.dao.interfaces.SysUserMapper;
import com.briup.service.interfaces.ISysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysUserServiceImpl implements ISysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public SysUser login(String username, String password) throws CrmCommonException {
		// TODO Auto-generated method stub
		if(StringUtils.isBlank(username)&StringUtils.isBlank(password)){
			throw CrmCommonException.getException(401);
		}
		SysUserExample sysUserExample = new SysUserExample();
		Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsrNameEqualTo(username).
		         andUsrPasswordEqualTo(password);
		System.out.println(sysUserMapper);
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		if(list.size()==0|list==null){
			throw CrmCommonException.getException(402);
		}
		return list.get(0);
	}

	@Override
	public List<SysUser> findAllMgr() throws CrmCommonException {
		SysUserExample example = new SysUserExample();
		List<SysUser> list = sysUserMapper.selectByExample(example);
		System.out.println("*******"+list);
		return list;
	}

	@Override
	public List<SysRole> findAllRole() throws CrmCommonException {
		SysRoleExample example = new SysRoleExample();
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		return list;
	}

	@Override
	public SysRole findRoleBySysRoleId(long roleId) throws CrmCommonException {
		// TODO Auto-generated method stub
		
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
		return sysRole;
	}

	@Override
	public void updateRole(SysRole role) throws CrmCommonException {
		int updateByPrimaryKey = sysRoleMapper.updateByPrimaryKeySelective(role);
		System.out.println(updateByPrimaryKey);
	}

	@Override
	public PageInfo<SysUser> findAllSysUser(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		SysUserExample sysUserExample = new SysUserExample();
		List<SysUser> selectByExample = sysUserMapper.selectByExample(sysUserExample);
		PageInfo<SysUser> pageInfo = new PageInfo<>(selectByExample);
		return pageInfo;
	}

	@Override
	public int getAllRows() throws CrmCommonException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUser findOneUser(long usrId) throws CrmCommonException {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(usrId);
		return sysUser;
	}

	@Override
	public void updateUser(SysUser user) throws CrmCommonException {
		int updateByPrimaryKey = sysUserMapper.updateByPrimaryKey(user);
		System.out.println(updateByPrimaryKey);
	}

	@Override
	public void addUser(SysUser user) throws CrmCommonException {
		int insert = sysUserMapper.insert(user);
		System.out.println(insert);
	}

	@Override
	public void deleteUser(long usrId) throws CrmCommonException {
		int deleteByPrimaryKey = sysUserMapper.deleteByPrimaryKey(usrId);
		System.out.println(deleteByPrimaryKey);
	}

	@Override
	public void addRole(SysRole role) throws CrmCommonException {
		int insert = sysRoleMapper.insert(role);
		System.out.println(insert);
	}

	@Override
	public void deleteRole(long roleId) throws CrmCommonException {
		int deleteByPrimaryKey = sysRoleMapper.deleteByPrimaryKey(roleId);
		System.out.println(deleteByPrimaryKey);
	}

}
