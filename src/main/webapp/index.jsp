<%@ page import="com.example.demo1.Assure" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.Employeur" %>
<%@ page import="com.example.demo1.Declaration" %>
<%@ page import="com.example.demo1.Cotisation" %>
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
    <thead><tr><th>ID</th><th>Raison Sociale</th><th>Secteur</th><th>Status</th></tr></thead>
    <tbody>
   <%
       List<Employeur> employeurList = (List<Employeur>)request.getAttribute("employeurs");
       if (employeurList != null){
       for (Employeur em :employeurList){
   %>
        <tr>
            <td><%=em.getId()%></td>
            <td><%=em.getRaisonSocial()%></td>
            <td><%=em.getSecteurActive()%></td>
            <td>
                <a href="employeur?action=edit&id=${a.id}">Edit</a>
                <a href="employeur?action=delete&id=${a.id}" style="background-color: red" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
   <%}
   }else {
   %>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    <% }%>
    </tbody>
</table>

<!-- Assurés -->
<h2>Assurés</h2>
<a href="Ajouter_assure.jsp">Ajouter Assuré</a>
<table>
    <thead><tr><th>ID</th><th>Nom</th><th>Salaire Mensuel</th><th>Employeur</th><th>Status</th></tr></thead>
    <tbody>
    <%
        List<Assure> list = (List<Assure>) request.getAttribute("assures");
        if (list != null){
        for(Assure ass : list){
    %>
        <tr>
            <td><%=ass.getId()%></td>
            <td><%=ass.getNom()%></td>
            <td><%=ass.getSalaireMensuel()%></td>
            <td><%=ass.getEmployeur().getId()%></td>
            <td>
                <a href="assure?action=edit&id=">Edit</a>
                <a href="assure?action=delete&id=${a.id}" style="background-color: red" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
        <%} }else {%>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    <%}%>
    </tbody>
</table>

<!-- Déclarations -->
<h2>Déclarations</h2>
<a href="Ajouter_Declaration.jsp">Ajouter Déclaration</a>
<table>
    <thead><tr><th>ID</th><th>Employeur</th><th>Mois</th><th>Année</th><th>Date Déclaration</th><th>Status</th></tr></thead>
    <tbody>
<%
  List<Declaration> declarationList =(List<Declaration>) request.getAttribute("declaration");
  if(declarationList != null){
      for (Declaration dr :declarationList){

%>
        <tr>
            <td><%=dr.getId()%></td>
            <td><%=dr.getEmployeur().getRaisonSocial()%></td>
            <td><%=dr.getMois()%></td>
            <td><%=dr.getAnnee()%></td>
            <td><%=dr.getDate()%></td>
            <td>
                <a href="assure?action=edit&id=${a.id}">Edit</a>
                <a href="assure?action=delete&id=${a.id}" style="background-color: red" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    <% }
    }else{%>
    <tr>

    </tr>
    <%}%>
    </tbody>
</table>

<!-- Cotisations -->
<h2>Cotisations</h2>
<a href="Ajouter_cotisation.jsp">Ajouter Cotisation</a>
<table>
    <thead><tr><th>ID</th><th>Assuré</th><th>Déclaration</th><th>Salaire Déclaré</th><th>Cotisation Salariale</th><th>Cotisation Patronale</th><th>Status</th></tr></thead>
    <tbody>
<%
 List<Cotisation> cotisationList =(List<Cotisation>) request.getAttribute("cotisation");
 if(cotisationList!= null){
     for(Cotisation ct:cotisationList){

%>
        <tr>
            <td><%=ct.getId()%></td>
            <td><%=ct.getAssure().getNom()%></td>
            <td><%=ct.getDeclaration().getId()%></td>
            <td><%=ct.getSalaire_declare()%></td>
            <td><%=ct.getCotisation_salaire()%></td>
            <td><%=ct.getCoisation_patronale()%></td>
            <td>
                <a href="assure?action=edit&id=${a.id}">Edit</a>
                <a href="assure?action=delete&id=${a.id}" style="background-color: red" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
<%   }
}else {%>
    <tr>
    </tr>
    <%}%>
    </tbody>
</table>


</body>
</html>