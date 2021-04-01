package com.myspring.pro27.board.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro27.board.Paging;
import com.myspring.pro27.board.vo.BoardVO;
import com.myspring.pro27.board.vo.RippleVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired SqlSession sqlSession;
	
	@Override
	public List selectAllArticleList(Paging paging) throws DataAccessException {
		List<BoardVO> articlesList = null;
		System.out.println("paging : " + paging.toString());
		articlesList = sqlSession.selectList("mapper.board.selectAllArticleList", paging);
		
		return articlesList;
	}
	
	@Override
	public int selectAllArticleListCnt() throws DataAccessException {
		int cnt = sqlSession.selectOne("mapper.board.selectAllArticleListCnt");
		return cnt;
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
	public List searchArticles(Paging paging) throws DataAccessException {
		List searchList = sqlSession.selectList("mapper.board.searchArticles", paging);
		return searchList;
	}
	
	@Override
	public int searchArticlesCnt(String search) throws DataAccessException {
		int cnt = sqlSession.selectOne("mapper.board.searchArticlesCnt", search);
		return cnt;
	}
	
	@Override
	public void ripple(RippleVO vo) throws DataAccessException {
		int rno = (int)sqlSession.selectOne("mapper.board.maxRno") + 1;
		vo.setRno(rno);
		
		Timestamp date = new Timestamp(System.currentTimeMillis());
		vo.setWritedate(date);
		
		System.out.println("vo : " + vo.getArticleno()+ " / " + vo.getRno() + " / " + vo.getId() + " / " + vo.getRipple() + " / " + vo.getWritedate() );
		
		sqlSession.insert("mapper.board.ripple", vo);
	}
	
	@Override
	public List viewRipple(String articleno) throws DataAccessException {
		List rippleList = sqlSession.selectList("mapper.board.viewRipple", articleno);
		return rippleList;
	}
	
	@Override
	public void rupdate(RippleVO vo) throws DataAccessException {
		sqlSession.update("mapper.board.rupdate", vo);
	}
	
	@Override
	public void deleter(int rno) throws DataAccessException {
		sqlSession.delete("mapper.board.deleter", rno);
	}
}
