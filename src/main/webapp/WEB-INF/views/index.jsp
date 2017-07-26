<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8" ?>
<html lang="ko">
  <head>
    <title>메인 페이지</title>
	  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	  <sec:authentication var="userInfo" property="principal.userVo" />
	  <sec:authentication var="userInfo2" property="principal" />

  </head>

  <body>
  <div class="container">
	대쉬보드
	<br /><br /><br />
	  <a href="/logout">로그아웃</a>
	  <br /><br /><br />
	  [${userInfo}]<br />
	  [${userInfo2}]<br />
  </div>
  </body>

</html>
