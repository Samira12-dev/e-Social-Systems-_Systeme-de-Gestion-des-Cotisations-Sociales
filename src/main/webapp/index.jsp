<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestion e_Social CNSS</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<h1>System e-Social</h1>

<!-- Employeurs -->
<h2>Employeurs</h2>
<a href="Ajouter_Employeur.jsp">Ajouter Employeur</a>
<table>
    <thead><tr><th>ID</th><th>Raison Sociale</th><th>Secteur</th></tr></thead>
    <tbody>
    <c:forEach var="emp" items="${employeurs}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.raisonSocial}</td>
            <td>${emp.secteurActivite}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Assurés -->
<h2>Assurés</h2>
<a href="Ajouter_assure.jsp">Ajouter Assuré</a>
<table>
    <thead><tr><th>ID</th><th>Nom</th><th>Salaire Mensuel</th><th>Employeur</th></tr></thead>
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

<!-- Déclarations -->
<h2>Déclarations</h2>
<a href="Ajouter_Declaration.jsp">Ajouter Déclaration</a>
<table>
    <thead><tr><th>ID</th><th>Employeur</th><th>Mois</th><th>Année</th><th>Date Déclaration</th></tr></thead>
    <tbody>
    <c:forEach var="dec" items="${declarations}">
        <tr>
            <td>${dec.id}</td>
            <td>${dec.employeur.raisonSocial}</td>
            <td>${dec.mois}</td>
            <td>${dec.annee}</td>
            <td>${dec.dateDeclaration}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Cotisations -->
<h2>Cotisations</h2>
<a href="Ajouter_cotisation.jsp">Ajouter Cotisation</a>
<table>
    <thead><tr><th>ID</th><th>Assuré</th><th>Déclaration</th><th>Salaire Déclaré</th><th>Cotisation Salariale</th><th>Cotisation Patronale</th></tr></thead>
    <tbody>
    <c:forEach var="cot" items="${cotisations}">
        <tr>
            <td>${cot.id}</td>
            <td>${cot.assure.nom}</td>
            <td>${cot.declaration.id}</td>
            <td>${cot.salaireDeclare}</td>
            <td>${cot.cotisationSalariale}</td>
            <td>${cot.cotisationPatronale}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>