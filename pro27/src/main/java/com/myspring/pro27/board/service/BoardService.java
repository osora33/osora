package com.myspring.pro27.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.board.vo.BoardVO;

public interface BoardService {
	public List listArticles() throws DataAccessException;
	public BoardVO viewContent(String articleno) throws DataAccessException;
	public void updateArticle(BoardVO vo) throws DataAccessException;
	public void write(BoardVO vo) throws DataAccessException;
	public void deleteArticle(String articleno) throws DataAccessException;
	public List searchArticles(String search) throws DataAccessException;
}
