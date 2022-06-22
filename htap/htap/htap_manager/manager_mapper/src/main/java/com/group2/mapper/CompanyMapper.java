package com.group2.mapper;
import com.group2.pojo.Company;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 2z
 *
 */
public interface CompanyMapper {

    @Update("update t_company set cpwd=#{cpwd}, cname=#{cname}, ceo=#{ceo}, cphone=#{cphone}, cmail=#{cmail} where cid=#{cid}")
    int updateCompany(Company company);

    @Insert("insert into t_company values(null,#{cpwd},#{cname},#{ceo},#{cphone},#{cmail},#{starttime},#{status},#{cnum})")
    int addCompany(Company company);

    //至于说用还是不用注解，你就看本次查询的内容 1。是关联查询、动态条件查询  就用mapper映射  其他的用注解
    List<Company> getCompanyByCondition(@Param("cname") String cname, @Param("status") String status, @Param("cnumOrder") String cnumOrder);
}
