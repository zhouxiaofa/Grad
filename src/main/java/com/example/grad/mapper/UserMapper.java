package com.example.grad.mapper;

import com.example.grad.bean.UserBean;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zxf
 */
public interface UserMapper {

    /**
     * 根据name查询得到user实体并返回
     * @param name
     * @return
     */
    @Select("SELECT * FROM user WHERE name=#{name}")
    UserBean login(@Param("name") String name);

    /**
     * 查询所有user实体,返回一个list集合
     * @return
     */
    @Select("SELECT * FROM user")
    List<UserBean> selectAllUser();

    /**
     * 修改user的password和flag,返回int值
     * @param password
     * @param s_flag
     * @param id
     * @return
     */
    @Update("UPDATE user SET password=#{password}, s_flag=#{s_flag} WHERE id=#{id}")
    int updateUserM(@Param("password") String password, @Param("s_flag") int s_flag, @Param("id") String id);

    /**
     * 假删除user,flag=0
     * @param id
     * @return
     */
    @Update("UPDATE user SET s_flag=0 WHERE id=#{id}")
    int deleteUser(@Param("id") String id);

    /**
     * admin操作insert新的user
     * @param name
     * @param password
     * @return
     */
    @Insert("INSERT INTO user(name, password, flag, s_flag) values(#{name}, #{password}, 0, 1)")
    int insertUserByAdmin(@Param("name") String name, @Param(("password")) String password);

    /**
     * 通过name和password查询用户数据
     * @param name
     * @param password
     * @return
     */
    @Select("SELECT * FROM user WHERE name = #{name} AND password = #{password}")
    UserBean loginM(@Param("name") String name, @Param("password") String password);

    /**
     * 插入新的用户数据
     * @param name
     * @param password
     * @return
     */
    @Insert("INSERT INTO user(name, password) values(#{name}, #{password})")
    int insertInfoM(@Param("name") String name,@Param("password") String password);

}
