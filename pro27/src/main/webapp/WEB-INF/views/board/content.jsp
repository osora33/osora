<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src = "https://code.jquery.com/jquery-3.5.1.js"></script>
<title>Insert title here</title>
</head>
<script>
	function wripple(){
		var ripple = $("#ripple").val();
		if(ripple == "" || ripple == null){
			alert("내용을 입력해 주십시오");
			$("#ripple").focus();
			return;
		}else{
			document.rfrm.submit();
		}
	}

	function rippleToggle(i){
		$("#uripple"+i).css("display", "");
		$("#ripple"+i).css("display", "none");
	}
	
	function return_r(i){
		$("#uripple"+i).css("display", "none");
		$("#ripple"+i).css("display", "");
	}
	
	function rupdate(i){
		var ripple = $("#rupdate"+i).val();
		if(ripple == "" || ripple == null){
			alert("내용을 입력해 주십시오");
			$("#rupdate"+i).focus();
			return;
		}else{
			$("#rufrm"+i).submit();
		}
	}
	
	function deleter(rno, articleno){
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href="${contextPath}/board/deleter.do?rno="+rno+"&num="+articleno;
		}else{
			return;
		}
	}
</script>
<body>
	<table align="center" width="80%" height="500px" style="margin-left: 150px;">
		<tr height="30px">
			<th>글번호</th>
			<td>${vo.articleno }</td>
			<th>작성시간</th>
			<td>${vo.writedate }</td>
			<th>조회수</th>
			<td></td>
		</tr>
		<tr height="30px">
			<th>제목</th>
			<td colspan="3">${vo.title }</td>
			<th>작성자</th>
			<td>${vo.id }</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="5" align="left">${vo.content }</td>
		</tr>
	</table>
	<div align="right" style="margin-right: 75px;">
		<input type="button" value="목록" onclick="location.href='${contextPath }/board/listArticles.do'"/>
		<c:if test="${sid == vo.id }">
			<input type="button" value="수정" onclick="location.href='${contextPath}/board/update.do?num=${vo.articleno }'"/>
			<input type="button" value="삭제" onclick="location.href='${contextPath}/board/delete.do?num=${vo.articleno }'"/>
		</c:if>
	</div>
	
	<div style="margin-top: 50px;">
		<c:if test="${sid != null }">
			<form action="${contextPath }/board/ripple.do" method="post" name="rfrm">
				<textarea name="ripple" id="ripple" style="width: 65%; height: 80px; margin-left: 180px;"></textarea>
				<input type="hidden" name="id" value="${sid}">
				<input type="hidden" name="articleno" value="${vo.articleno }">
				<input type="button" onclick="wripple()" value="저장" style="width: 7%; height: 85px; float: right; margin-right: 80px;">
			</form>
		</c:if>
		<table width="80%" style="text-align: left; margin: 30px 0 50px 170px;">
			<c:choose>
				<c:when test="${rvo != '0' }">
					<c:forEach var="ripple" items="${rvo }" varStatus="i">
						<tr>
							<th>${i.count} : ${ripple.id }</th>
						</tr>
						<tr id="ripple${i.count }">
							<td style="padding-left: 20px; border: 1px solid; border-radius: 20px; padding: 5px 20px;">
								${fn:replace(ripple.ripple, replaceChar, "<br/>") }
								<div style="float: right">
									<c:if test="${sid == ripple.id }">
										<input type="button" value="수정" onclick="rippleToggle(${i.count});">
										<input type="button" value="삭제" onclick="deleter(${ripple.rno}, ${ripple.articleno })">
									</c:if>
								</div>
							</td>
						</tr>
						<tr style="display: none;" id="uripple${i.count }">
							<td>
								<form id="rufrm${i.count }" action="${contextPath }/board/rupdate.do" method="post">
									<textarea name="ripple" id="rupdate${i.count }" style="padding:5px 15px; border: 1px solid; border-radius: 20px;" cols="97" rows="5">${ripple.ripple }</textarea>
									<input type="button" onclick="return_r(${i.count})" value="취소" style="width: 7%; height: 85px; float: right;">
									<input type="button" value="수정" style="width: 7%; height: 85px; float: right;" onclick="rupdate(${i.count})">
									<input type="hidden" value="${i.count }" name="i">
									<input type="hidden" value="${ripple.rno }" name="rno">
									<input type="hidden" value="${vo.articleno }" name="articleno">
								</form>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<th>아직 작성된 덧글이 없습니다</th>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>