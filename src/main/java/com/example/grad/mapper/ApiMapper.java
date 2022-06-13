package com.example.grad.mapper;

import com.example.grad.bean.ApiBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zxf
 */
public interface ApiMapper {

    /**
     * 查询所有API数据
     * @return
     */
    @Select("SELECT * FROM api")
    List<ApiBean> selectAllAPI();

    /**
     * API数据修改
     * @param api_url
     * @param remark_detail
     * @param id
     * @return
     */
    @Update("UPDATE api SET api_url=#{api_url}, remark_detail=#{remark_detail} WHERE id=#{id}")
    int updateAPIM(@Param("api_url") String api_url, @Param("remark_detail") String remark_detail, @Param("id") String id);

    /**
     * 插入新的API数据
     * @param api_url
     * @param remark_detail
     * @return
     */
    @Insert("INSERT INTO api(api_url, remark_detail) VALUES(#{api_url}, #{remark_detail})")
    int insert(@Param("api_url") String api_url, @Param("remark_detail") String remark_detail);

    /**
     * API数据删除
     * @param id
     * @return
     */
    @Delete("DELETE FROM api WHERE id=#{id}")
    int deleteAPIM(@Param("id") String id);

}
