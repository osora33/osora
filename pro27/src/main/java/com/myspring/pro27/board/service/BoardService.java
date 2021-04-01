package com.myspring.pro27.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.board.Paging;
import com.myspring.pro27.board.vo.BoardVO;
import com.myspring.pro27.board.vo.RippleVO;

public interface BoardService {
	public List listArticles(Paging paging) throws DataAccessException;
	public BoardVO viewContent(String articleno) throws DataAccessException;
	public void updateArticle(BoardVO vo) throws DataAccessException;
	public void write(BoardVO vo) throws DataAccessException;
	public void deleteArticle(String articleno) throws DataAccessException;
	public List searchArticles(Paging paging) throws DataAccessException;
	public int listArticlesCnt() throws DataAccessException;
	public int searchArticlesCnt(String search) throws DataAccessException;
	public void ripple(RippleVO vo) throws DataAccessException;
	public List viewRipple(String articleno) throws DataAccessException;
	public void rupdate(RippleVO vo) throws DataAccessException;
	public void deleter(int rno) throws DataAccessException;
}
