package com.myspring.pro27.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro27.board.Paging;
import com.myspring.pro27.board.dao.BoardDAO;
import com.myspring.pro27.board.vo.BoardVO;
import com.myspring.pro27.board.vo.RippleVO;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List listArticles(Paging paging) throws DataAccessException {
		List articlesList = null;
		articlesList = boardDAO.selectAllArticleList(paging);
		return articlesList;
	}
	
	@Override
	public int listArticlesCnt() throws DataAccessException {
		int cnt = boardDAO.selectAllArticleListCnt();
		return cnt;
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
	public List searchArticles(Paging paging) throws DataAccessException {
		List searchList = boardDAO.searchArticles(paging);
		return searchList;
	}
	
	@Override
	public int searchArticlesCnt(String search) throws DataAccessException {
		int cnt = boardDAO.searchArticlesCnt(search);
		return cnt;
	}
	
	@Override
	public void ripple(RippleVO vo) throws DataAccessException {
		boardDAO.ripple(vo);
	}
	
	@Override
	public List viewRipple(String articleno) throws DataAccessException {
		List rippleList = boardDAO.viewRipple(articleno);
		return rippleList;
	}
	
	@Override
	public void rupdate(RippleVO vo) throws DataAccessException {
		boardDAO.rupdate(vo);
	}
	
	@Override
	public void deleter(int rno) throws DataAccessException {
		boardDAO.deleter(rno);
	}
}
