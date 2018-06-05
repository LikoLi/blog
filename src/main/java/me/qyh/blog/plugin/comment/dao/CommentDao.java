/*
 * Copyright 2016 qyh.me
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.qyh.blog.plugin.comment.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.qyh.blog.core.vo.PageQueryParam;
import me.qyh.blog.plugin.comment.entity.Comment;
import me.qyh.blog.plugin.comment.entity.CommentModule;
import me.qyh.blog.plugin.comment.vo.CommentQueryParam;
import me.qyh.blog.plugin.comment.vo.ModuleCommentCount;
import me.qyh.blog.plugin.comment.vo.PeriodCommentQueryParam;

/**
 * 
 * @author Administrator
 *
 */
public interface CommentDao {

	/**
	 * 查询评论数(tree形式)
	 * 
	 * @param param
	 *            查询参数
	 * @return 评论数
	 */
	int selectCountWithTree(CommentQueryParam param);

	/**
	 * 查询评论数(list形式)
	 * 
	 * @param param
	 *            查询参数
	 * @return 评论数
	 */
	int selectCountWithList(CommentQueryParam param);

	/**
	 * 查询评论(tree形式)
	 * 
	 * @param param
	 *            查询参数
	 * @return tree形式的结果集
	 */
	List<Comment> selectPageWithTree(CommentQueryParam param);

	/**
	 * 查询评论(list形式)
	 * 
	 * @param param
	 *            查询参数
	 * @return 结果集
	 */
	List<Comment> selectPageWithList(CommentQueryParam param);

	/**
	 * 根据模块删除评论
	 * 
	 * @param module
	 */
	void deleteByModule(CommentModule module);

	/**
	 * 根据id查询评论
	 * 
	 * @param id
	 *            评论id
	 * @return 如果不存在返回null，否则返回存在的评论
	 */
	Comment selectById(Integer id);

	/**
	 * 插入评论
	 * 
	 * @param comment
	 *            待插入的评论
	 */
	void insert(Comment comment);

	/**
	 * 根据路径和状态删除对应的评论
	 * 
	 * @param path
	 *            路径
	 */
	void deleteByPath(String path);

	/**
	 * 根据id删除评论
	 * 
	 * @param id
	 *            评论id
	 * @return 受影响的数目
	 */
	void deleteById(Integer id);

	/**
	 * 查询某个ip在某个模块指定时间内评论的总数
	 * 
	 * @param module
	 *            评论模块
	 * @param begin
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @param ip
	 *            ip
	 * @return
	 */
	int selectCountByIpAndDatePeriod(@Param("module") CommentModule module, @Param("begin") Timestamp begin,
			@Param("end") Timestamp end, @Param("ip") String ip);

	/**
	 * 查询当前评论的最后一条回复记录
	 * 
	 * @param current
	 *            评论
	 * @return 如果不存在返回null，否在返回最后一条记录
	 */
	Comment selectLast(Comment current);

	/**
	 * 将评论状态由审核变为普通
	 * 
	 * @param comment
	 *            评论
	 */
	void updateStatusToNormal(Comment comment);

	/**
	 * 查询模块评论数
	 * 
	 * @param modules
	 * @return
	 */
	List<ModuleCommentCount> selectCommentCounts(List<CommentModule> modules);

	/**
	 * 查询文章评论数
	 * 
	 * @param module
	 *            文章id
	 * @return 评论数
	 */
	ModuleCommentCount selectCommentCount(CommentModule module);

	/**
	 * 查询没有被审核的评论数目
	 * 
	 * @return
	 */
	int queryUncheckCommentsCount();

	/**
	 * 分页查询未审核的评论
	 * 
	 * @param param
	 * @return
	 */
	List<Comment> queryUncheckComments(PageQueryParam param);

	/**
	 * @param gravatar
	 * @return
	 */
	boolean checkExistsByGravatar(String gravatar);

	/**
	 * 
	 * @param param
	 * @return
	 */
	int selectCountByPeriod(PeriodCommentQueryParam param);

	/**
	 * 
	 * @param param
	 * @return
	 */
	List<Comment> selectPageByPeriod(PeriodCommentQueryParam param);

}
