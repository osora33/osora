package com.myspring.pro27.board.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro27.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired SqlSession sqlSession;
	
	@Override
	public List selectAllArticleList() throws DataAccessException {
		List<BoardVO> articlesList = null;
		articlesList = sqlSession.selectList("mapper.board.selectAllArticleList");
		
		return articlesList;
	}
	
	@Override
	public BoardVO viewContent(String articleno) throws DataAccessException {
		BoardVO vo = new BoardVO();
		vo = sqlSession.selectOne("mapper.board.viewContent", articleno);
		
		return vo;
	}
	
	@Override
	public void updateArticle(BoardVO vo) throws DataAccessException {
		sqlSession.update("mapper.board.updateArticle", vo);
	}
	
	@Override
	public int maxArticleno() throws DataAccessException {
		int maxArticleno = sqlSession.selectOne("mapper.board.maxArticleno");
		return maxArticleno;
	}
	
	@Override
	public void insertArticle(BoardVO vo) throws DataAccessException {
		
		int maxArticleno = maxArticleno() +1;
		vo.setArticleno(maxArticleno);
		
		Timestamp date = new Timestamp(System.currentTimeMillis());
		vo.setWritedate(date);

		System.out.println("vo : " + vo.getId());
		
		sqlSession.insert("mapper.board.insertArticle", vo);
	}
	
	@Override
	public void deleteArticle(String articleno) throws DataAccessException {
		sqlSession.delete("mapper.board.deleteArticle", articleno);
	}
	
	@Override
	public List searchArticles(String search) throws DataAccessException {
		List searchList = sqlSession.selectList("mapper.board.searchArticles", search);
		return searchList;
	}
}
