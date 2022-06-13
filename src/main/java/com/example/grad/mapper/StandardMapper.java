package com.example.grad.mapper;

import com.example.grad.bean.StandardBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zxf
 */
public interface StandardMapper {

    /**
     * 根据id查询standard的detail信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM standard_1 WHERE id=#{id}")
    StandardBean selectDetail(@Param("id") int id);

    /**
     * 删除standard数据
     * @param id
     * @return
     */
    @Delete("DELETE FROM standard_1 WHERE id=#{id}")
    int deleteStandardM(@Param("id") int id);

    /**
     * 查询需要添加的id
     * @return
     */
    @Select("SELECT MAX(id) FROM standard_1")
    int selectMaxID();

    /**
     * update操作standard的detail
     * @param standard_class
     * @param standard_state
     * @param standard_adopt
     * @param release_date
     * @param impl_date
     * @param css
     * @param iss
     * @param competent_department
     * @param technical_comm
     * @param standard_feature
     * @param id
     * @return
     */
    @Update("UPDATE standard_1 SET STANDARD_CLASS=#{standard_class}, STANDARD_STATE=#{standard_state}, STANDARD_ADOPT=#{standard_adopt}, RELEASE_DATE=#{release_date}, IMPL_DATE=#{impl_date}, CSS=#{css}, ISS=#{iss}, COMPETENT_DEPARTMENT=#{competent_department}, TECHNICAL_COMM=#{technical_comm}, STANDARD_FEATURE=#{standard_feature} WHERE id=#{id}")
    int updateDetail(@Param("standard_class") String standard_class, @Param("standard_state") String standard_state, @Param("standard_adopt") String standard_adopt, @Param("release_date") String release_date, @Param("impl_date") String impl_date, @Param("css") String css,
              @Param("iss") String iss, @Param("competent_department") String competent_department, @Param("technical_comm") String technical_comm, @Param("standard_feature") String standard_feature, @Param("id") int id);

    /**
     * 返回通过所属领域查找到的标准数据
     * @param standard_feature
     * @return
     */
    @Select("SELECT * FROM standard_1 WHERE STANDARD_FEATURE=#{standard_feature}")
    List<StandardBean> selectStandardByFeature(@Param("standard_feature") String standard_feature);

    /**
     * 返回通过主管部门查找到的标准数据
     * @param competent_department
     * @return
     */
    @Select("SELECT * FROM standard_1 WHERE COMPETENT_DEPARTMENT=#{competent_department}")
    List<StandardBean> selectStandardByComp(@Param("competent_department") String competent_department);

    /**
     * 查找前10条标准数据
     * @return
     */
    @Select("SELECT * FROM standard_1 limit 10")
    List<StandardBean> selectStandard10();

    /**
     * 进入其他界面,返回之后保留查看界面
     * @param lastID
     * @return
     */
    @Select("SELECT * FROM standard_1 limit #{lastID}, 10")
    List<StandardBean> selectStandardChange(@Param("lastID") int lastID);

    /**
     * 查询标准数据的最新条数
     * @return
     */
    @Select("SELECT COUNT(*) FROM standard_1")
    int selectCount();

    /**
     * 插入标准数据
     * @param id
     * @param standard_id
     * @param standard_name_cn
     * @param standard_name_en
     * @param standard_calss
     * @param standard_state
     * @param standard_adopt
     * @param release_date
     * @param impl_date
     * @param css
     * @param iss
     * @param competent_department
     * @param technical_comm
     * @param standard_feature
     * @return
     */
    @Insert("INSERT INTO standard values(#{id}, #{STANDARD_ID}, #{STANDARD_NAME_CN}, #{STANDARD_NAME_EN}, #{STANDARD_CLASS}, #{STANDARD_STATE}, #{STANDARD_ADOPT}, #{RELEASE_DATE}, #{IMPL_DATE}, #{CSS}, #{ISS}, #{COMPETENT_DEPARTMENT}, #{TECHNICAL_COMM}, #{STANDARD_FEATURE})")
    int insert(@Param("id") int id, @Param("STANDARD_ID") String standard_id, @Param("STANDARD_NAME_CN") String standard_name_cn, @Param("STANDARD_NAME_EN") String standard_name_en, @Param("STANDARD_CLASS") String standard_calss, @Param("STANDARD_STATE") String standard_state, @Param("STANDARD_ADOPT") String standard_adopt, @Param("RELEASE_DATE") String release_date,
               @Param("IMPL_DATE") String impl_date, @Param("CSS") String css, @Param("ISS") String iss, @Param("COMPETENT_DEPARTMENT") String competent_department, @Param("TECHNICAL_COMM") String technical_comm, @Param("STANDARD_FEATURE") String standard_feature);

    /**
     * 查询所有的所属领域(standard_feature)
     * @return
     */
    @Select("SELECT DISTINCT STANDARD_FEATURE FROM standard_1")
    List<String> selectDistinctFeature();

    /**
     * 查询所有的主管部门(competent——department)
     * @return
     */
    @Select("SELECT DISTINCT COMPETENT_DEPARTMENT FROM standard_1 GROUP BY COMPETENT_DEPARTMENT DESC")
    List<String> selectDistinctComp();

    @Select("SELECT * FROM standard_1")
    List<StandardBean> selectAllStandards();

}
