<%@ page import="java.util.List" %>
<%@ page import="models.Item" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
    <div class = "container">
        <c:import url="inc/NavMenu.jsp"></c:import>

            <div class="row">
                <div class="col-sm-6">
                    <h2>My Archived Items</h2>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Iid</th>
                            <th scope="col">Title</th>
                            <th scope="col">Info</th>
                            <th scope="col">Status</th>
                            <th scope="col">Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%  List<Item> items = (List<Item>) request.getAttribute("archivedItems");

                            for ( Item item : items){%>
                        <tr >
                            <th scope="row"><%=item.getIid()%></th>
                            <td><%=item.getTitle()%></td>
                            <td><%=item.getInfo()%></td>
                            <td><%=item.getStatus()%></td>
                            <td><a href="?iid=<%=item.getIid()%>" class="btn btn-danger btn-sm">Delete</a></td>
                            </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
            </div>

    </div>
</body>
</html>
