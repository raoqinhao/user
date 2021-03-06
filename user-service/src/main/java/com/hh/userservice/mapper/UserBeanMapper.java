package com.hh.userservice.mapper;

import com.hh.userservice.model.UserBean;
import com.hh.userservice.model.UserBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserBeanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    long countByExample(UserBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int deleteByExample(UserBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int insert(UserBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int insertSelective(UserBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    List<UserBean> selectByExample(UserBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    UserBean selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int updateByExampleSelective(@Param("record") UserBean record, @Param("example") UserBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int updateByExample(@Param("record") UserBean record, @Param("example") UserBeanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int updateByPrimaryKeySelective(UserBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table u_user
     *
     * @mbg.generated Fri Nov 27 14:47:59 CST 2020
     */
    int updateByPrimaryKey(UserBean record);
}