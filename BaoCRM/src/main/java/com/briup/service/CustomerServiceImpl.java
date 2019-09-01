 package com.briup.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CstActivity;
import com.briup.bean.CstActivityExample;
import com.briup.bean.CstCustomer;
import com.briup.bean.CstCustomerExample;
import com.briup.bean.CstCustomerExample.Criteria;
import com.briup.bean.CstLinkman;
import com.briup.bean.CstLinkmanExample;
import com.briup.common.exception.CrmCommonException;
import com.briup.dao.interfaces.CstActivityMapper;
import com.briup.dao.interfaces.CstCustomerMapper;
import com.briup.dao.interfaces.CstLinkmanMapper;
import com.briup.service.interfaces.ICustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CstCustomerMapper customerMapper;
    
    @Autowired
    private CstLinkmanMapper linkManMapper;
    
    @Autowired
    private CstActivityMapper activityMapper;
	
	@Override
	public List<CstCustomer> findAllCustomer() throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CstCustomer findCustomerById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomer customer = customerMapper.selectByPrimaryKey(id);
		return customer;
	}

	@Override
	public CstCustomer findCustomerByCstName(String cstName) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustNameEqualTo(cstName);
		List<CstCustomer> selectByExample = customerMapper.selectByExample(example);
		System.out.println("findCustomerByCstName:"+selectByExample);
		return selectByExample.get(0);
	}

	@Override
	public Set<String> findAllCustomerLevelLable() throws CrmCommonException {
	CstCustomerExample example = new CstCustomerExample();
	List<CstCustomer> list = customerMapper.selectByExample(example);
	Set<String> set = new HashSet<>();
	for (CstCustomer cstCustomer : list) {
           set.add(cstCustomer.getCustLevelLabel());		
	}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerByLevelLable(String levelLable) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustLevelLabelEqualTo(levelLable);
		return customerMapper.selectByExample(example);
	}

	@Override
	public Set<Integer> findAllCustomerCredit() throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> list = customerMapper.selectByExample(example);
		Set<Integer> set = new HashSet<>();
		for (CstCustomer cstCustomer : list) {
		 	set.add(cstCustomer.getCustCredit());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerByCredit(int credit) throws CrmCommonException {
		// TODO Auto-generated method stub
		 CstCustomerExample example = new CstCustomerExample();
		 example.createCriteria().andCustCreditEqualTo(credit);
		return customerMapper.selectByExample(example);
	}

	@Override
	public Set<Integer> findAllCustomerSatisfy() throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> list = customerMapper.selectByExample(example);
		Set<Integer> set = new HashSet<>();
		for (CstCustomer cstCustomer : list) {
			set.add(cstCustomer.getCustSatisfy());
		}
		return set;
	}

	@Override
	public List<CstCustomer> findCstCustomerBySatisfy(int satisfy) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
        example.createCriteria().andCustSatisfyEqualTo(satisfy);
		return customerMapper.selectByExample(example);
	}

	@Override
	public CstCustomer findCustomerByCstNo(String cstNo) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(CstCustomer cstCustomer) throws CrmCommonException {
		// TODO Auto-generated method stub
		System.out.println(cstCustomer);
		int i = customerMapper.updateByPrimaryKeySelective(cstCustomer);
		System.out.println(i);
	}

	@Override
	public void saveLinkMan(CstLinkman cstLinkman) throws CrmCommonException {
		// TODO Auto-generated method stub
		int insert = linkManMapper.insert(cstLinkman);
		System.out.println(insert);
		
	}

	@Override
	public void deleteLinkMan(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = linkManMapper.deleteByPrimaryKey(id);
		System.out.println("删除了："+deleteByPrimaryKey+"行");
	}

	@Override
	public PageInfo<CstCustomer> findAllCstCustomer(int curpage, int row) throws CrmCommonException {
		// TODO Auto-generated method stub
		PageHelper.startPage(curpage, row);
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> cstCustomerList = customerMapper.selectByExample(example);
		PageInfo<CstCustomer> pageInfo = new PageInfo<>(cstCustomerList);
		return pageInfo;
	}

	@Override
	public PageInfo<CstCustomer> findCustomerPageByCon(int curpage, int row, CstCustomer cstCustomer)
			throws CrmCommonException {
		//设置起始页面
		PageHelper.startPage(curpage, row);
		CstCustomerExample example = new CstCustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustNoLike("%"+cstCustomer.getCustNo()+"%")
		.andCustNameLike("%"+cstCustomer.getCustName()+"%")
		.andCustManagerNameLike("%"+cstCustomer.getCustManagerName()+"%")
		.andCustRegionLike("%"+cstCustomer.getCustRegion()+"%")
		.andCustLevelLabelLike("%"+cstCustomer.getCustLevelLabel()+"%");
		List<CstCustomer> list = customerMapper.selectByExample(example);
		PageInfo<CstCustomer> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public List<CstLinkman> findAllLinkManByCstId(long cstId) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstLinkmanExample example = new CstLinkmanExample();
		com.briup.bean.CstLinkmanExample.Criteria criteria = example.createCriteria();
		criteria.andLkmCustIdEqualTo(cstId);
		List<CstLinkman> list = linkManMapper.selectByExample(example);
		return list;
	}

	@Override
	public CstLinkman findLinkManById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstLinkman linkman = linkManMapper.selectByPrimaryKey(id);
		return linkman;
	}

	@Override
	public void updateLinkman(CstLinkman lkm) throws CrmCommonException {
		// TODO Auto-generated method stub
		int insert = linkManMapper.updateByPrimaryKey(lkm);
		System.out.println("修改了"+insert);
		
	}

	@Override
	public void deleteCustomerById(long id) throws CrmCommonException {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = customerMapper.deleteByPrimaryKey(id);
		System.out.println("删除上帝："+deleteByPrimaryKey);
	}

	@Override
	public void saveCstActivity(CstActivity cstActivity) throws CrmCommonException {
		// TODO Auto-generated method stub
		int insert = activityMapper.insert(cstActivity);
		System.out.println(insert);
		
	}

	@Override
	public List<CstActivity> findAllCstActivityByCstNo(String cstNo) throws CrmCommonException {
		// TODO Auto-generated method stub
		CstActivityExample example = new CstActivityExample();
		example.createCriteria().andAtvCustNoEqualTo(cstNo);
		return activityMapper.selectByExample(example);
	}

	@Override
	public CstActivity findCstActivityById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAtv(CstActivity cstActivity) throws CrmCommonException {
		// TODO Auto-generated method stub
		int updateByPrimaryKeySelective = activityMapper.updateByPrimaryKeySelective(cstActivity);
		System.out.println(updateByPrimaryKeySelective);
	}

	@Override
	public void deleteAtvById(long atvId) throws CrmCommonException {
		// TODO Auto-generated method stub
		int deleteByPrimaryKey = activityMapper.deleteByPrimaryKey(atvId);
		System.out.println("删除交往记录："+deleteByPrimaryKey);
		
	}

	@Override
	public void saveCustomer(CstCustomer cst) throws CrmCommonException {
		// TODO Auto-generated method stub
		int insert = customerMapper.insert(cst);
	}

}
