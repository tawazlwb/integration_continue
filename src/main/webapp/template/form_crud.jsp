<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>Fiche Employé</h1>
<form action="./gestion" method="GET">
	<table>
		<col width="100">
		<col width="150">
		<tr>
			<td>N° Employe</td>
			<td><input type="text" name="employeID" value="${employe.employeID == 0 ? '' : employe.employeID}"></td>
		</tr>
		<tr>
			<td>Nom</td>
			<td><input type="text" name="lastName" value="${employe.lastName}"></td>
		</tr>
		<tr>
			<td>Prenom</td>
			<td><input type="text" name="firstName" value="${employe.firstName}"></td>
		</tr>
	</table>
	<input type="hidden" name="currentPage" value="${currentPage}">
	<br>
	<input type="submit" name="submit" value="chercher">
	<input type="submit" name="submit" value="modifier">
	<input type="submit" name="submit" value="ajouter">
	<input type="submit" name="submit" value="supprimer">
</form>
