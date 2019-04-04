<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<c:if test="${empty requestScope.orgPage.dataList}">
	<jsp:forward page="Org_showAll"></jsp:forward>
</c:if>
<body>
	<table border="1" style="margin: auto;">
		<tr>
			<td>编号</td>
			<td>社团名称</td>
			<td>简介</td>
		</tr>
		<c:forEach items="${requestScope.orgPage.dataList}" var="org">
		<tr> 
			<td>${org.oid}</td>
			<td>${org.oname}</td>
			<td>${org.introduction}</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td>
				每页${requestScope.orgPage.pageSize}条记录 总共${requestScope.orgPage.totalPage}页
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td>
				当前：第${requestScope.orgPage.currentPage} / ${requestScope.orgPage.totalPage}页
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td>
				请选择：第
				<c:forEach begin="1" end="${requestScope.orgPage.totalPage}" step="1" var="i">
					<c:if test="${i==requestScope.orgPage.currentPage}">
						【${i}】
					</c:if>
					<c:if test="${i!=requestScope.orgPage.currentPage}">
						<a href="Org_showAll?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				页
			</td>
		</tr>
	</table>
</body>
</html>