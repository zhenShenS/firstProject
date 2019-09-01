package com.briup.service;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.CstCustomer;
import com.briup.bean.CstCustomerExample;
import com.briup.bean.Orders;
import com.briup.bean.OrdersExample;
import com.briup.bean.OrdersLine;
import com.briup.bean.OrdersLineExample;
import com.briup.common.exception.CrmCommonException;
import com.briup.dao.interfaces.CstCustomerMapper;
import com.briup.dao.interfaces.OrdersLineMapper;
import com.briup.dao.interfaces.OrdersMapper;
import com.briup.service.interfaces.ICustomerService;
import com.briup.service.interfaces.IReportFormsService;

@Service
public class ReportServiceImpl implements IReportFormsService{

	@Autowired
	private CstCustomerMapper customerMapper;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private OrdersLineMapper orderLineMapper;
	
	@Override
	public CategoryDataset findCstcontribute(String cust_name) throws Exception {
		double sum=0.0;
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// TODO Auto-generated method stub
        if(StringUtils.isBlank(cust_name)){
        	CstCustomerExample example = new CstCustomerExample();
//    		example.createCriteria().andCustNameEqualTo(cust_name);
    		List<CstCustomer> list = customerMapper.selectByExample(example);
    		System.out.println(cust_name);
    		System.out.println("ReportService������Ϊ�յ������"+list);
    		for (CstCustomer cstCustomer : list) {
    			sum=0.0;
    			String custName = cstCustomer.getCustName();
    			sum = getSum(sum, custName);
    			System.out.println(custName+"�Ĺ���ֵ��"+sum);
    			dataset.addValue(sum, "�ͻ����׷���", custName);
    		}
    		return dataset;
        }		
        dataset.addValue(getSum(sum, cust_name), "�ͻ����׷���", cust_name);
		return dataset;
	}



	private double getSum(double sum, String custName) throws CrmCommonException {
		OrdersExample ordersExample = new OrdersExample();
//		CustomerServiceImpl customerService = new CustomerServiceImpl();
		CstCustomer customer = customerService.findCustomerByCstName(custName);
		ordersExample.createCriteria()
		.andOdrCustIdEqualTo(customer.getCustId());
		List<Orders> list2 = ordersMapper.selectByExample(ordersExample);
		for (Orders orders : list2) {
			OrdersLineExample ordersLineExample = new OrdersLineExample();
			ordersLineExample.createCriteria()
			.andOddOrderIdEqualTo(orders.getOdrId());
			List<OrdersLine> list3 = orderLineMapper.selectByExample(ordersLineExample);
			for (OrdersLine ordersLine : list3) {
				sum+=ordersLine.getOddPrice();
			}
		}
		return sum;
	}



	@Override
	public CategoryDataset findCstMakeup(int condit) throws CrmCommonException {
		// TODO Auto-generated method stub
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		if(condit==0){
			int sumSize = getSumSize();
			Set<String> set = customerService.findAllCustomerLevelLable();
			for (String string : set) {
				List<CstCustomer> list2 = customerService.findCstCustomerByLevelLable(string);
				double ratio=(double)list2.size()/sumSize;
				System.out.println(ratio);
				dataset.addValue(ratio, "�ͻ����ɷ���", string);
			}
			return dataset;
		}
		if(condit==1){
			Set<Integer> customerCredit = customerService.findAllCustomerCredit();
			for (Integer integer : customerCredit) {
				List<CstCustomer> customerByCredit = customerService.findCstCustomerByCredit(integer);
				double ratio=(double)customerByCredit.size()/getSumSize();
				System.out.println(ratio);
				dataset.addValue(ratio, "�ͻ����ɷ���(ͨ���ͻ�������)", integer+"��");
			}
			return dataset;
		}
			Set<Integer> customerSatisfy = customerService.findAllCustomerSatisfy();
			for (Integer integer : customerSatisfy) {
				List<CstCustomer> customerBySatisfy = customerService.findCstCustomerBySatisfy(integer);
				double ratio=(double)customerBySatisfy.size()/getSumSize();
				System.out.println(ratio);
				dataset.addValue(ratio, "�ͻ����ɷ���(ͨ���ͻ������)", integer+"��");
			}
			return dataset;
	}

	private int getSumSize() {
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> list = customerMapper.selectByExample(example);
		int sumSize = list.size();
		return sumSize;
	}

}
