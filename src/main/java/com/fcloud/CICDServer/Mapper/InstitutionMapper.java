package com.fcloud.CICDServer.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fcloud.CICDServer.dataBean.InstitutionInfo;
import com.fcloud.CICDServer.dataBean.UserEntity;

@Mapper
public interface  InstitutionMapper {
	@Select("SELECT * FROM T_INSTITUTION")
	@Results({
		@Result(property = "institutionId",  column = "INSTITUTION_ID"),
		@Result(property = "institutionName", column = "INSTITUTION_NAME"),
		@Result(property = "institutionAbbr", column = "INSTITUTION_ABBR"),
		@Result(property = "institutionType", column = "INSTITUTION_TYPE")
	})
	List<InstitutionInfo> getAll(); 
	
	@Select("SELECT * FROM T_INSTITUTION WHERE INSTITUTION_ID = #{institutionId}")
	@Results({
		@Result(property = "institutionId",  column = "INSTITUTION_ID"),
		@Result(property = "institutionName", column = "INSTITUTION_NAME"),
		@Result(property = "institutionAbbr", column = "INSTITUTION_ABBR"),
		@Result(property = "institutionType", column = "INSTITUTION_TYPE")
	})
	InstitutionInfo getOne(String institutionId);
	
	@Insert("INSERT INTO T_INSTITUTION(INSTITUTION_ID,INSTITUTION_NAME,INSTITUTION_ABBR,INSTITUTION_TYPE) VALUES(#{institutionId}, #{institutionName}, #{institutionAbbr}, #{institutionType})")
	void insert(InstitutionInfo institutionInfo);

	@Update("UPDATE T_INSTITUTION SET INSTITUTION_NAME=#{institutionName},INSTITUTION_TYPE =#{institutionType},INSTITUTION_ABBR =#{institutionAbbr} WHERE INSTITUTION_ID = #{institutionId}")
	void update(InstitutionInfo institutionInfo);

	@Delete("DELETE FROM T_INSTITUTION WHERE INSTITUTION_ID=#{institutionId}")
	void delete(String institutionId);
}
