<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

<%--    <h3>단일 메뉴 상세 조회</h3>--%>
<%--    <form action="menu/select" method="get">--%>
<%--        <label>메뉴 이름 : </label>--%>
<%--        <input type="text" name="menu_name" id="menu_name"/>--%>
<%--        <button type="submit">조회하기 </button>--%>
<%--    </form>--%>
<%--    <hr/>--%>
    <nav>
        <ul>
            <li>
            <button onclick="location.href='${pageContext.servletContext.contextPath}/menu/list'">메뉴 전체 조회하기 </button>
            </li>
            <hr/>
        </ul>
    </nav>

<%--    <form action="${pageContext.sevletContext.contextPath}/menu/list" method="post">--%>
<%--        메뉴이름 : <input type="text" name="menu_name">--%>
<%--        가격 : <input type="text" name="menu_price">--%>
<%--        --%>
    </form>
</body>
</html>
