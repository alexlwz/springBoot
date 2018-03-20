package com.fcloud.CICDServer.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fcloud.CICDServer.dataBean.UserEntity;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM T_USER")
	@Results({
		@Result(property = "userName",  column = "USER_NAME"),
		@Result(property = "passWord", column = "PASSWORD"),
		@Result(property = "userRight", column = "USER_RIGHT")
	})
	List<UserEntity> getAll();
	
	@Select("SELECT * FROM T_USER WHERE USER_NAME = #{userName}")
	@Results({
		@Result(property = "userName",  column = "USER_NAME"),
		@Result(property = "passWord", column = "PASSWORD"),
		@Result(property = "userRight", column = "USER_RIGHT")
	})
	UserEntity getOne(Long id);

	@Insert("INSERT INTO T_USER(USER_NAME,PASSWORD,USER_RIGHT) VALUES(#{userName}, #{passWord}, #{userRight})")
	void insert(UserEntity user);

	@Update("UPDATE T_USER SET PASSWORD=#{passWord},USER_RIGHT =#{userRigth} WHERE USER_NAME=#{userName}")
	void update(UserEntity user);

	@Delete("DELETE FROM T_USER WHERE USER_NAME=#{userName}")
	void delete(Long id);

}
