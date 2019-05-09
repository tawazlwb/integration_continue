<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ingetis.ikhairy.util.ListUtils"%>
<%@page import="com.ingetis.ikhairy.entities.Employe"%>
<h1>List Employés</h1>
<br>
<table>
	<col width="100">
	<col width="150">
	<col width="150">
	<tr>
		<td>N° Employe</td>
		<td>Nom</td>
		<td>Prenom</td>
	</tr>
	<c:set var="employes" value="<%= ListUtils.castList(request.getAttribute(\"employes\"), Employe.class)%>"/>
	<c:forEach items="${employes}" var="employe" varStatus="status">
		<tr>
			<td>
				<c:out value="${employe.employeID}"/>
			</td>
			<td>
				<c:out value="${employe.lastName}"/>
			</td>
			<td>
				<c:out value="${employe.firstName}"/>
			</td>
		</tr>
	</c:forEach>	
</table>
<br>
<% int count = (int) request.getAttribute("count"); %>
<c:set var="pagesCount" value="<%= (int) Math.ceil((double) (count) / 10)%>"/>
<c:set var="currentPage" value="<%= (int) request.getAttribute(\"currentPage\")%>"/>
<c:choose>
	<c:when test="${pagesCount != 0}">
		<div class="pagination">
			<c:forEach var="i" begin="0" end="${pagesCount - 1}" step="1">
				<c:choose>
				  <c:when test="${i == currentPage}">
				    <a
						href="gestion?submit=chercher&currentPage=<c:out value="${i}"/>&page=<c:out value="${i+1}"/>&employeID=${employe.employeID}"
						class="active disabled">
						<c:out value="${i+1}"/>
					</a>
				  </c:when>
				  <c:otherwise>
				    <a
						href="gestion?submit=chercher&currentPage=<c:out value="${i}"/>&page=<c:out value="${i+1}"/>&employeID=${employe.employeID}">
						<c:out value="${i+1}"/>
					</a>
				  </c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</c:when>
</c:choose>
