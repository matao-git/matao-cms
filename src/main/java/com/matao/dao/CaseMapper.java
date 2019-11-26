package com.matao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.matao.entity.Case;

public interface CaseMapper {
	
	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Insert("INSERT INTO cms_collect (userId,url,name,created) "
			+ " VALUES(#{userId},#{url},#{name},now())")
	int add(Case collect);
	
	/**
	 * 
	 * @return
	 */
	@Select("SELECT * FROM cms_collect "
			+ " WHERE userId=#{userId} "
			+ " ORDER BY created DESC")
	List<Case> list(int userId);

	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Update("UPDATE cms_collect set url=#{url},name=#{name} "
			+ "	WHERE id=#{id}")
	int  update(Case collect);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM cms_collect WHERE id=#{value} ")
	Case get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE  FROM cms_collect WHERE id=#{value} ")
	int delete(int id);

}
