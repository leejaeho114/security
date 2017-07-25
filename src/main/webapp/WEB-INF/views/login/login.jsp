<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Please Login</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<body >
<div class="wrapper full-page-wrapper page-auth page-login text-center">
	<div class="inner-page">
		<div class="login-box center-block">
			<form class="form-horizontal" role="form" name="loginfrm" id="loginfrm"  method="post" action="/login/authenticate">
				<p class="title">LOGIN</p>
				<div class="form-group">
					<label for="id" class="control-label sr-only">id</label>
					<div class="col-sm-12">
						<div class="input-group">
							<input type="text" placeholder="아이디" name="id"  id="id" class="form-control" onkeypress="if (event.keyCode==13) login();">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
						</div>
					</div>
				</div>
				<label for="password" class="control-label sr-only">Password</label>
				<div class="form-group">
					<div class="col-sm-12">
						<div class="input-group">
							<input type="password" placeholder="비밀번호" name="password" id="password" title="비밀번호 입력" class="form-control" onkeypress="if (event.keyCode==13) login();">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						</div>
					</div>
				</div>


				<img src="<c:url value="simpleCaptcha.png" />"><br />
				Answer: <input name="answer" /><input type="submit" />

				<div class="btn btn-custom-primary btn-lg btn-block btn-auth"  onclick="login();"><i class="fa fa-arrow-circle-o-right"></i> Login</div>

				<input type="hidden"  name="remember-me" value="true" />
				<%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
			</form>

		</div>
	</div>
</div>

<script type="text/javascript">
	<c:if test="${null != SPRING_SECURITY_LAST_EXCEPTION && '' != SPRING_SECURITY_LAST_EXCEPTION}">
	alert('${SPRING_SECURITY_LAST_EXCEPTION}');
	</c:if>
	<c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope="session" />

	function login() {
		$('#loginfrm').submit();
	}

</script>
</body>
</html>
