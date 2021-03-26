<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- 자바의 import처럼 타일즈 태그들을 사용하기 위해 반드시 추가 해야 한다.  -->   
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>   

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"  %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

		<!-- tiles_member.xml의 definition태그의 하위 태그인 <put-attribute>태그의 name이 title인  값(value)를 불러와 표시  -->
<title> <tiles:insertAttribute name="title"/>   </title>


    <style>
      #container {
        width: 100%;
        margin: 0px auto;
          text-align:center;
        border: 0px solid #bcbcbc;
      }
      #header {
        padding: 5px;
        margin-bottom: 5px;
        border: 0px solid #bcbcbc;
        background-color: lightgreen;
      }
      #sidebar-left {
        width: 15%;
        height:700px;
        padding: 5px;
        margin-right: 5px;
        margin-bottom: 5px;
        float: left;
         background-color: yellow;
        border: 0px solid #bcbcbc;
        font-size:10px;
      }
      #content {
        width: 75%;
        padding: 5px;
        margin-right: 5px;
        float: left;
        border: 0px solid #bcbcbc;
      }
      #footer {
        clear: both;
        padding: 5px;
        border: 0px solid #bcbcbc;
         background-color: lightblue;
      }
      
    </style>

</head>
<body>
		<!-- tiles_member.xml의  <definition>태그의  하위 태그인 <put-attribute>태그의 name이 header인  JSP를 불러와 표시 -->

		<div id="container">
			<div id="header">
				<tiles:insertAttribute name="header" /> 
			</div>
			<div id="sidebar-left">
				<tiles:insertAttribute name="side"/>
			</div>
			<div id="content">
				<tiles:insertAttribute name="body"/>
			</div>
			<div id="footer">
				<tiles:insertAttribute name="footer"/>
			</div>
		</div>
</body>
</html>







