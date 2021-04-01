<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>    
    
<%
	request.setCharacterEncoding("EUC-KR");
%>    
    
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />    
     
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>헤더</title>
</head>
<body>
	<table border=0  width="100%">
		<tr>
			<td>
				<a href="${contextPath}/member/listMembers.do">
					<img src="${contextPath}/resources/image/duke_swing.gif"/>
				</a>
			</td>
			<td>
				<h1><font size=30>
					<a href="${contextPath }/member/listMembers.do" style="text-decoration: none; color: black">
						스프링 실습 홈페이지
					</a>
				</font></h1>
			</td>
			<td>
				<c:choose>
					<c:when test="${sid != null && member != null}">
						<h3>환영합니다. ${member.name}님!</h3>
						<a href="${contextPath}/member/logout.do" ><h3>로그아웃</h3></a>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/member/loginForm.do" ><h3>로그인</h3></a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>






