package com.briup.dao.interfaces;

import com.briup.bean.CstLinkman;
import com.briup.bean.CstLinkmanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CstLinkmanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    long countByExample(CstLinkmanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int deleteByExample(CstLinkmanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int deleteByPrimaryKey(Long lkmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int insert(CstLinkman record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int insertSelective(CstLinkman record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    List<CstLinkman> selectByExample(CstLinkmanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    CstLinkman selectByPrimaryKey(Long lkmId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") CstLinkman record, @Param("example") CstLinkmanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByExample(@Param("record") CstLinkman record, @Param("example") CstLinkmanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByPrimaryKeySelective(CstLinkman record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cst_linkman
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByPrimaryKey(CstLinkman record);
}