package com.briup.dao.interfaces;

import com.briup.bean.Storage;
import com.briup.bean.StorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    long countByExample(StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int deleteByExample(StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int deleteByPrimaryKey(Long stkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int insert(Storage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int insertSelective(Storage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    List<Storage> selectByExample(StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    Storage selectByPrimaryKey(Long stkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByPrimaryKeySelective(Storage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table storage
     *
     * @mbg.generated Mon Mar 04 14:12:14 CST 2019
     */
    int updateByPrimaryKey(Storage record);
}