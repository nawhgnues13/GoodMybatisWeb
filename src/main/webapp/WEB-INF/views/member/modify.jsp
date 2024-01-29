<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>정보 수정</title>
	</head>
	<body>
		<form action="/member/modify.do" method="post">
			<fieldset>
				<legend>정보수정</legend>
				<ul>
					<li>
						<label for="member-id">아이디</label>
						<input type="text" name="member-id" id="member-id" value="${member.memberId }">
					</li>
					<li>
						<label for="member-pw">비밀번호</label>
						<input type="password" name="member-pw" id="member-pw" value="${member.memberPw }">
					</li>
					<li>
						<label for="member-name">이름</label>
						<input type="text" name="member-name" id="member-name" value="${member.memberName }">
					</li>
					<li>
						<label for="gender">성별</label>
						남<input type="radio" name="member-gender" id="gender" value='M' <c:if test="${member.memberGender eq 77 }">checked</c:if>>
						여<input type="radio" name="member-gender" id="gender" value='F' <c:if test="${member.memberGender eq 70 }">checked</c:if>>
					</li>
					<li>
						<label for="age">나이</label>
						<input type="text" name="member-age" id="age" value="${member.memberAge }">
					</li>
					<li>
						<label for="email">이메일</label>
						<input type="text" name="member-email" id="email" value="${member.memberEmail }">
					</li>
					<li>
						<label for="phone">전화번호</label>
						<input type="text" name="member-phone" id="phone" value="${member.memberPhone }">
					</li>
					<li>
						<label for="address">주소</label>
						<input type="text" name="member-address" id="address" value="${member.memberAddress }">
					</li>
					<li>
						<label for="hobby">취미</label>
						<input type="text" name="member-hobby" id="hobby" value="${member.memberHobby }">
					</li>
				</ul>
			</fieldset>
			<input type="submit" value="수정하기">
			<input type="reset" value="초기화">
		</form>
	</body>
</html>