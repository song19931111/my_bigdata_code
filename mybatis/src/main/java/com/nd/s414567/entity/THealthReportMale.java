package com.nd.s414567.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_health_report_male
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class THealthReportMale {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_male.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_male.check_project
     *
     * @mbg.generated
     */
    private String checkProject;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_male.detail
     *
     * @mbg.generated
     */
    private String detail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_health_report_male.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_male.id
     *
     * @return the value of t_health_report_male.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_male.id
     *
     * @param id the value for t_health_report_male.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_male.check_project
     *
     * @return the value of t_health_report_male.check_project
     *
     * @mbg.generated
     */
    public String getCheckProject() {
        return checkProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_male.check_project
     *
     * @param checkProject the value for t_health_report_male.check_project
     *
     * @mbg.generated
     */
    public void setCheckProject(String checkProject) {
        this.checkProject = checkProject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_male.detail
     *
     * @return the value of t_health_report_male.detail
     *
     * @mbg.generated
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_male.detail
     *
     * @param detail the value for t_health_report_male.detail
     *
     * @mbg.generated
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_health_report_male.user_id
     *
     * @return the value of t_health_report_male.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_health_report_male.user_id
     *
     * @param userId the value for t_health_report_male.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}