<%--
  Created by IntelliJ IDEA.
  User: enaa
  Date: 3/3/2026
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assure list</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Liste des Assurés</h2>
<a href="ajouter_assure.jsp">Ajouter un Assuré</a>
<table>
    <thead>
    <tr><th>ID</th><th>Nom</th><th>Salaire Mensuel</th><th>Employeur</th></tr>
    </thead>
    <tbody>
    <c:forEach var="ass" items="${assures}">
        <tr>
            <td>${ass.id}</td>
            <td>${ass.nom}</td>
            <td>${ass.salaireMensuel}</td>
            <td>${ass.employeur.raisonSocial}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
