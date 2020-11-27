package com.hh.userservice.model;

import java.io.Serializable;

public class UserBean implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.id
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.username
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.password
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.mobilephone
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    private String mobilephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.id
     *
     * @return the value of u_user.id
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.id
     *
     * @param id the value for u_user.id
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.username
     *
     * @return the value of u_user.username
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.username
     *
     * @param username the value for u_user.username
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.password
     *
     * @return the value of u_user.password
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.password
     *
     * @param password the value for u_user.password
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.mobilephone
     *
     * @return the value of u_user.mobilephone
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.mobilephone
     *
     * @param mobilephone the value for u_user.mobilephone
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }
}