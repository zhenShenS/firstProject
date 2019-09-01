package com.briup.service.interfaces;

import java.util.List;

import com.briup.bean.CstLog;
import com.briup.common.exception.CrmCommonException;
import com.github.pagehelper.PageInfo;

public interface ILogService {
	/**
	 * 保存日志
	 * @param log
	 * @throws CrmCommonException
	 */
	void saveLog(CstLog log) throws CrmCommonException;

	/**
	 * 查找�?有的日志  带分�?
	 * @param curpage
	 * @param row
	 * @return
	 * @throws CrmCommonException
	 */
	PageInfo<CstLog> findAllLog(int curpage, int row) throws CrmCommonException;

	/**
	 * 查找�?有的日志  不带分页
	 * @return
	 * @throws CrmCommonException
	 */
	List<CstLog> findAllLog() throws CrmCommonException;
}
