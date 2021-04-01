<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.tbl{
		height: 300px;
	}

	.pagingBox{
		margin-top: 20px;
	}

	.page{
		text-align: center;
		display: inline-block;
		cursor: pointer;
	}
	
	.prev{
		float: left;
		margin-left: 20%;
		cursor: pointer;
	}
	
	.next{
		float: right;
		margin-right: 30%;
		cursor: pointer;
	}
	
</style>
<script>
	//이전 버튼 이벤트
	function fn_prev(page, range, rangeSize){
		var page = parseInt(page) - 1;
		var range = Math.ceil(page/5);
		
		var url = "${contextPath}/board/listArticles.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	//페이지 번호 클릭
	function fn_paging(page, range, rangeSize, searchType, keyword){
		var url = "${contextPath}/board/listArticles.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
	
	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize){
		var page = parseInt(page) + 1;
		if(page % 5 == 1){
			range = parseInt(range) +1;
		}
		
		var url = "${contextPath}/board/listArticles.do";
		url = url + "?page=" + page;
		url = url + "&range=" + range;
		
		location.href = url;
	}
</script>
</head>
	<div class="tbl">
		<table width="80%" style="margin: 0 auto">
			<c:choose>
				<c:when test="${boardList != '0'}">
					<tr>
						<th width="10%">글번호</th>
						<th width="55%">제목</th>
						<th width="10%">작성자</th>
						<th width="25%">작성시간</th>
					</tr>
					<c:forEach var="board" items="${boardList}">
						<tr onclick="location.href='${contextPath }/board/content.do?num=${board.articleno}'">
							<td>${board.articleno }</td>
							<c:choose>
								<c:when test="${board.parentno != 0}">
									<td>ㄴ>${board.title }</td>
								</c:when>
								<c:otherwise>
									<td>${board.title }</td>
								</c:otherwise>
							</c:choose>
							<td>${board.id }</td>
							<td>${board.writedate }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr><th>글이 존재하지 않습니다</th></tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<!-- paging -->
	<div class = "pagingBox">
		<div class = "prev">
			<c:choose>
				<c:when test="${paging.prev }">
					<a onclick = "fn_prev('${paging.page }', '${paging.range }', '${paging.rangeSize }')">이전</a>
				</c:when>
				<c:otherwise>
					<a href="#" style="text-decoration: none; cursor: default">　　</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="page">
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="idx">
				<a onclick="fn_paging('${idx}', '${paging.range}', '${paging.rangeSize}')"> ${idx} </a>
			</c:forEach>
		</div>
		
		<div class="next">
			<c:choose>
				<c:when test="${paging.next }">
					<a onclick="fn_next('${paging.page}', '${paging.range }', '${paging.rangeSize }')">다음</a>
				</c:when>
				<c:otherwise>
					<a href="#" style="text-decoration: none; cursor: default">　　</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- paging -->
	
	<form action="${contextPath }/board/search.do" method="get">
		<div style="float: right; margin: 30px 180px 0 0">
			<input type="text" name="search">
			<input type="submit" value="검색">
			<c:if test="${sid != null}">
				<input type="button" value="글쓰기" onclick="location.href='${contextPath }/board/write.do'">
			</c:if>
		</div>
	</form>
</body>
</html>