<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<title>Index page</title>
</head>

<spring: from method="get" modelAttribute="lessons" action="get-all-lessons">

</spring>
</html>