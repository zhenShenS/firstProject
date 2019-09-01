package com.briup.service.interfaces;

import java.util.List;

import com.briup.bean.CstService;
import com.briup.bean.SysUser;
import com.briup.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

/**
 * 
 * 服务管理服务�?
 * 
 * @author briup
 *
 */
public interface ICstService {
	/**
	 * 保存服务
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void save(CstService cstService) throws CrmCommonException;

	/**
	 * 查找�?有的经理
	 * @param cstService
	 * @throws CrmCommonException
	 */
	List<SysUser> findAllManagerName() throws CrmCommonException;

	/**
	 * 根据条件查找服务 带分�?
	 * @param con
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findCstServiceByCondition(CstService con, int curPage, int row) throws CrmCommonException;

	/**
	 * 根据条件查找已处理的服务 带分�?
	 * @param con
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findServiceOnDealed(CstService con, int curPage, int row) throws CrmCommonException;


	/**
	 * 查询�?有状态为新创建的服务 带分�?
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findAllService(int curPage, int row) throws CrmCommonException;

	/**
	 * 查询�?有状态为已分配的服务 带分�?
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findByfp(int curPage, int row) throws CrmCommonException;


	/**
	 * 查询�?有状态为已处理的服务 带分�?
	 * @param curPage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstService> findBycl(int curPage, int row) throws CrmCommonException;


	
	/**
	 * 根据服务id删除服务
	 * @param svrId
	 * @throws CrmCommonException
	 */
	void delete(long svrId) throws CrmCommonException;

	/**
	 * 更新服务
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void updateCstService(CstService cstService) throws CrmCommonException;

	/**
	 * 根据服务id查找服务
	 * @param svrId
	 * @return
	 * @throws CrmCommonException
	 */
	CstService queryOneByid(long svrId) throws CrmCommonException;

	/**
	 * 更新处理服务
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void updateinfo(CstService cstService) throws CrmCommonException;
	
	/**
	 * 处理结果
	 * @param cstService
	 * @throws CrmCommonException
	 */
	void Dealresult(CstService cstService) throws CrmCommonException;

}
