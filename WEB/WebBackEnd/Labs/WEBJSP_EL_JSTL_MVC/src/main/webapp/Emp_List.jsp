<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>EMP 목록</title>
  <style>
    table { border-collapse: collapse; width: 100%; }
    th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
    th { background-color: #f0f0f0; }
  </style>
</head>
<body>
	<%-- ${requestScope.empList} --%>
  <h2>사원 목록</h2>
  <table>
    <tr>
      <th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th>
      <th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPTNO</th>
    </tr>
	<!-- 사원목록   -->
   <c:forEach var="emp" items="${empList}">
      <tr>
        <td>${emp.empno}</td>
        <td>${emp.ename}</td>
        <td>${emp.job}</td>
        <td>${emp.mgr}</td>
        <td>${emp.hiredate}</td>
        <td>${emp.sal}</td>
        <td>${emp.comm}</td>
        <td>${emp.deptno}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>