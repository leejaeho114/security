<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Please Login</title>
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
							<input type="text" placeholder="아이디" name="id"  id="id" class="form-control" onkeypress="if (event.keyCode==13) ajaxLogin();" value="leejaeho114">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
						</div>
					</div>
				</div>
				<label for="password" class="control-label sr-only">Password</label>
				<div class="form-group">
					<div class="col-sm-12">
						<div class="input-group">
							<input type="password" placeholder="비밀번호" name="password" id="password" title="비밀번호 입력" class="form-control" onkeypress="if (event.keyCode==13) login();" value="1234">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						</div>
					</div>
				</div>

				<c:if test="${4 < sessionScope.loginFailCnt}">
					비밀번호 오류 횟수 : ${sessionScope.loginFailCnt}<br />
					<img src="<c:url value="stickyCaptcha.png" />"><br />
					<input name="answer" placeholder="캡차코드" />
				</c:if>

				<%--<a href="javascript://" onclick="login();">
					<div class="btn btn-custom-primary btn-lg btn-block btn-auth"><i class="fa fa-arrow-circle-o-right"></i> Login</div>
				</a>--%>

				<a href="javascript://" onclick="ajaxLogin();">
					<div class="btn btn-custom-primary btn-lg btn-block btn-auth"><i class="fa fa-arrow-circle-o-right"></i>ajax Login</div>
				</a>
				<a href="/logout">
					<div class="btn btn-custom-primary btn-lg btn-block btn-auth"><i class="fa fa-arrow-circle-o-right"></i>logout</div>
				</a>

				<input type="hidden"  name="remember-me" value="true" />
				<%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
			</form>

		</div>
	</div>
</div>

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	<c:if test="${null != SPRING_SECURITY_LAST_EXCEPTION && '' != SPRING_SECURITY_LAST_EXCEPTION}">
	alert('${SPRING_SECURITY_LAST_EXCEPTION}');
	</c:if>
	<c:remove var = "SPRING_SECURITY_LAST_EXCEPTION" scope="session" />

	function login() {
		if(validate()) {
			$('#loginfrm').submit();
		}
	}

	function ajaxLogin(){
		if(validate()) {
			$.ajax({
				type: "POST",
				url: "/login/authenticate",
				dataType: "json",
				data: $("#loginfrm").serialize(),
				success: function (result) {
					console.log(result);
					alert(result.message);
					if(result.returnUrl != undefined){
						location.href = result.returnUrl;
					}

				}, error: function (xhr, textStatus) {
					alert(xhr.status + " 오류가 발생했습니다.");
				}
			});
		}
	}

	function validate(){
		var id = $("#id").val();
		if(0 == id.length){
			alert('아이디를 입력해주세요.');
			return false;
		}

		var password = $("#password").val();
		if(0 == password.length){
			alert('비밀번호를 입력해주세요.');
			return false;
		}
		return true;
	}

	$("#id").focus();

</script>
</body>
</html>
