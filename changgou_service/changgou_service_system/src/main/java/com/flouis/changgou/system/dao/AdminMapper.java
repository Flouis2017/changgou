package com.flouis.changgou.system.dao;

import com.flouis.changgou.system.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    List<Admin> findAll();

	Admin findOneByLoginName(@Param("loginName") String loginName);
}