<%--
  Created by IntelliJ IDEA.
  User: enaa
  Date: 3/3/2026
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter</title>
    <style>

        /* STYLE GENERAL L KOLA FORM */
        .form-style {
            width: 400px;
            margin: 60px auto;
            background: #e8f8f5;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .form-style h2 {
            text-align: center;
            color: #16a085;
            margin-bottom: 20px;
        }

        .form-style input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-style input[type="submit"] {
            background: #16a085;
            color: white;
            border: none;
            font-weight: bold;
            cursor: pointer;
            transition: 0.3s;
        }

        .form-style input[type="submit"]:hover {
            background: #138d75;
        }
    </style>
</head>
<body>
<div class="form-style">
    <h2>Ajouter Employeur</h2>
    <form action="AjouterEmployeurServlet" method="post">
        Nom: <input type="text" name="raisonSocial" required>
        Secteur: <input type="text" name="secteurActivite" required>
        <input type="submit" value="Ajouter">
    </form>
</div>
</body>
</html>
