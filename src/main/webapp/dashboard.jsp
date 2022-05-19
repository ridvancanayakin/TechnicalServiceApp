<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
    <div class = "container">
        <c:import url="inc/NavMenu.jsp"></c:import>

            <div class="col-md-6">
                <h2>Product List</h2>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Pid</th>
                        <th scope="col">Product</th>
                        <th scope="col">Info</th>
                        <th scope="col">Status</th>
                        <th scope="col">Delete</th>
                        <th scope="col">Archive</th>
                    </tr>
                    </thead>
                    <tbody>
                        <% for ( int i = 0; i<5; i++){%>
                        <tr>
                            <th scope="row"><%=i%></th>
                            <td>Product<%=i%></td>
                            <td>Info<%=i%></td>
                            <td>Status<%=i%></td>
                            <td>Delete<%=i%></td>
                            <td>Archive<%=i%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
    </div>


</body>
</html>
