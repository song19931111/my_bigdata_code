package com.nd.s414567.mapper;

import com.nd.s414567.entity.TJobHistory;

public interface TJobHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job_history
     *
     * @mbg.generated
     */
    int insert(TJobHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job_history
     *
     * @mbg.generated
     */
    int insertSelective(TJobHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job_history
     *
     * @mbg.generated
     */
    TJobHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TJobHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_job_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TJobHistory record);
}