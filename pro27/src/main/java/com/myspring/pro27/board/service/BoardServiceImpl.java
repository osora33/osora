package com.myspring.pro27.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro27.board.dao.BoardDAO;
import com.myspring.pro27.board.vo.BoardVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List listArticles() throws DataAccessException {
		List articlesList = null;
		articlesList = boardDAO.selectAllArticleList();
		return articlesList;
	}
	
	@Override
	public BoardVO viewContent(String articleno) throws DataAccessException {
		BoardVO vo = new BoardVO();
		vo = boardDAO.viewContent(articleno);
		return vo;
	}
	
	@Override
	public void updateArticle(BoardVO vo) throws DataAccessException {
		boardDAO.updateArticle(vo);
	}
	
	@Override
	public void write(BoardVO vo) throws DataAccessException {
		boardDAO.insertArticle(vo);
	}
	
	@Override
	public void deleteArticle(String articleno) throws DataAccessException {
		boardDAO.deleteArticle(articleno);
	}
	
	@Override
	public List searchArticles(String search) throws DataAccessException {
		List searchList = boardDAO.searchArticles(search);
		return searchList;
	}
}
