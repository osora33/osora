package com.myspring.pro27.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.board.Paging;
import com.myspring.pro27.board.vo.BoardVO;
import com.myspring.pro27.board.vo.RippleVO;

public interface BoardDAO {

	List selectAllArticleList(Paging paging) throws DataAccessException;
	BoardVO viewContent(String articleno) throws DataAccessException;
	void updateArticle(BoardVO vo) throws DataAccessException;
	int maxArticleno() throws DataAccessException;
	void insertArticle(BoardVO vo) throws DataAccessException;
	void deleteArticle(String articleno) throws DataAccessException;
	List searchArticles(Paging paging) throws DataAccessException;
	public int selectAllArticleListCnt() throws DataAccessException;
	int searchArticlesCnt(String search) throws DataAccessException;
	void ripple(RippleVO vo) throws DataAccessException;
	List viewRipple(String articleno) throws DataAccessException;
	void rupdate(RippleVO vo) throws DataAccessException;
	void deleter(int rno) throws DataAccessException;
}
