package com.briup.service.interfaces;

import java.util.List;

import com.briup.bean.SalChance;
import com.briup.bean.SalPlan;
import com.briup.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface ISalChanceService {
	/**
	 * 保存�?售机�?
	 * @param sc
	 * @throws CrmCommonException
	 */
	void saveChance(SalChance sc) throws CrmCommonException;

	/**
	 * 查找�?有的�?售机会，带分�?
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SalChance> findSalChanceByPage(int curpage, int row) throws CrmCommonException;

	/**
	 * 查找�?有的�?发计�? 不带分页
	 * @return
	 * @throws CrmCommonException
	 */
	List<SalPlan> findAllSalPlan() throws CrmCommonException;

	/**
	 * 根据�?发计划编号查找开发机�?
	 * @param chcId
	 * @return
	 * @throws CrmCommonException
	 */
	List<SalPlan> findSalPlans(long chcId) throws CrmCommonException;

	/**
	 *	查找�?有的�?发计�?
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SalPlan> findSalPlanByPage(int curpage, int row) throws CrmCommonException;

	/**
	 * 更新�?发计划信�?
	 * @param sc
	 * @throws CrmCommonException
	 */
	void updateChance(SalChance sc) throws CrmCommonException;

	/**
	 * 根据�?售机会id查找�?售机�?
	 * @param chcId
	 * @return
	 * @throws CrmCommonException
	 */
	SalChance findOneSalChance(long chcId) throws CrmCommonException;

	/**
	 * 更具�?售机会id查找�?发计�?
	 * @param chcId
	 * @return
	 * @throws CrmCommonException
	 */
	SalPlan findSalPlan(long chcId) throws CrmCommonException;

	/**
	 * 根据�?售机会id删除�?售机�?
	 * @param chcId
	 * @throws CrmCommonException
	 */
	void deleteSalChance(long chcId) throws CrmCommonException;

	/**
	 * 保存�?发计�?
	 * @param sp
	 * @throws CrmCommonException
	 */
	void savePlan(SalPlan sp) throws CrmCommonException;
	
	/**
	 * 根据�?发计划id删除�?发计�? 
	 * @param plaId
	 * @throws CrmCommonException
	 */
	void deleteSalPlan(long plaId) throws CrmCommonException;
	
	/**
	 * 更新�?发计划信�?
	 * @param sp
	 * @throws CrmCommonException
	 */
	void updateSalPlan(SalPlan sp) throws CrmCommonException;


	/**
	 * 根据条件查找�?有的�?售机�?
	 * @param curpage
	 * @param row
	 * @param sc
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<SalChance> findSalPageByCon(int curpage, int row, SalChance sc) throws CrmCommonException;
}
