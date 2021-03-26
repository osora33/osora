package com.myspring.pro27.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.board.vo.BoardVO;

public interface BoardDAO {

	List selectAllArticleList() throws DataAccessException;
	BoardVO viewContent(String articleno) throws DataAccessException;
	void updateArticle(BoardVO vo) throws DataAccessException;
	int maxArticleno() throws DataAccessException;
	void insertArticle(BoardVO vo) throws DataAccessException;
	void deleteArticle(String articleno) throws DataAccessException;
	List searchArticles(String search) throws DataAccessException;
}
