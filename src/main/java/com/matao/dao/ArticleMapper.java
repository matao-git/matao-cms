package com.matao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.matao.entity.Article;
import com.matao.entity.Comment;

public interface ArticleMapper {
	/**
	 * 
	    * @Title: getById
	    * @Description: 根据id获取文章的内容
	    * @param @param id
	    * @param @return    参数
	    * @return Article    返回类型
	    * @throws
	 */
	Article getById(Integer id);

	/**
	 * 根据频道获取文章
	 * @param chnId
	 * @param categoryId
	 * @return
	 */
	List<Article> listByCat(@Param("chnId") int chnId,@Param("categoryId") int categoryId);
	/**
	 * 获取热门文章
	 * @return
	 */
	List<Article> hostList();
	/**
	 * 获取最新文章
	 * @param i 获取的个数
	 * @return
	 */
	List<Article> newList(int i);

	@Update(" UPDATE cms_article SET  deleted=1 WHERE id=#{value} ")
	int delete(int id);

	/** 
	 * @Title: checkExist 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: Article
	 */
	@Select("SELECT id, title,user_id AS userId FROM cms_article WHERE id = #{value}")
	@ResultType(Article.class)
	Article checkExist(int id);

	/** 
	 * 管理员根据状态查询文章
	 * @Title: listByStatus 
	 * @Description: TODO
	 * @param status
	 * @return
	 * @return: List<Article>
	 */
	List<Article> listByStatus(int status);
	
	/**
	 * 获取文章详情，不考虑状态
	 * @param id
	 * @return
	 */
	Article getDetailById(int id);

	/**
	 *  审核文章 
	 * @param id
	 * @param status
	 * @return
	 */
	@Update(" UPDATE cms_article SET  status=#{status} "
			+ " WHERE id=#{id} ")
	int apply(@Param("id") int id,@Param("status") int status);

	/**
	 * 设置热门
	 * @param id
	 * @param status
	 * @return
	 */
	@Update(" UPDATE cms_article SET  hot=#{status} "
			+ " WHERE id=#{id} ")
	int setHot(@Param("id") int id,@Param("status") int status);

	/**
	 * 
	 * #{articleType,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler,"
			+ "jdbcType=INTEGER,javaType=com.zhukaige.entity.TypeEnum}
	 * 添加文章
	 * @param article
	 * @return
	 */
	@Insert("INSERT INTO cms_article("
			+ " title,content,picture,channel_id,category_id,"
			+ " user_id,hits,hot,status,deleted,"
			+ " created,updated,commentCnt,articleType) "
			+ " values("
			+ " #{title},#{content},#{picture},#{channelId},#{categoryId},"
			+ "#{userId},#{hits},#{hot},#{status},#{deleted},"
			+ "now(),now(),#{commentCnt},"
			+ "#{articleType,typeHandler=org.apache.ibatis.type.EnumOrdinalTypeHandler,"
			+ "jdbcType=INTEGER,javaType=com.matao.entity.TypeEnum})")
	int add(Article article);

	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	@Update("UPDATE cms_article SET title=#{title},content=#{content},"
			+ "picture=#{picture},channel_id=#{channelId},"
			+ "category_id=#{categoryId},status=0,updated=now() WHERE id=#{id}")
	int update(Article article);
	
	List<Article> listByUser(Integer userId);
	
	@Insert(" REPLACE cms_favorite(user_id,article_id,created) "
			+ "VALUES(#{userId},#{articleId},now())")
	int favorite(@Param("userId") Integer userId,@Param("articleId") int articleId);

	/**
	 * 获取10篇图片文章
	 * @param num
	 * @return
	 */
	List<Article> getImgArticles(int num);

	/**
	 * 添加评论
	 * @param userId
	 * @param articleId
	 * @param content
	 * @return
	 */
	@Insert("INSERT INTO cms_comment (articleId,userId,content,created)"
			+ " VALUES(#{articleId},#{userId},#{content},now())")
	int addComment(@Param("userId") Integer userId,
			@Param("articleId") int articleId,
			@Param("content")  String content);

	/**
	 * 评论数目自增一
	 * @param articleId
	 */
	@Update("UPDATE cms_article set commentCnt=commentCnt+1 WHERE id=#{value} ")
	void increaseCommentCnt(int articleId);

	@Select("SELECT * FROM cms_comment WHERE articleId=#{value}")
	List<Comment> commentlist(int articleId);

}
