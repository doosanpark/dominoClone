<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml" 
      xmlns:sec="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <hr>
        <div>
            <a sec:authorize="isAnonymous()" th:href="@{/login}">로그인</a>
            <a sec:authorize="isAuthenticated()" th:href="@{/logout}">로그아웃</a>
            <a sec:authorize="isAnonymous()" th:href="@{/signup}">회원가입</a>
        </div>
        <div>
            <a th:href="@{/member/info}">내 정보</a>
            <a th:href="@{/admin}">관리자</a>
        </div>
    </body>
</html>