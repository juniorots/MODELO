<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Livros</title>
</head>
<body>    
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>LISTA</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Ano</th>                
            </tr>
            <c:forEach var="livro" items="${listaLivro}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.nome}" /></td>
                    <td><c:out value="${book.ano}" /></td>
                    <!-- 
                    <td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                     -->
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>