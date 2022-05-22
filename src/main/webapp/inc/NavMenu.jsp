<%@ page import="util.Const" %>
<%@ page import="util.Utils" %>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <%
    Utils.control(request);
    Object obj = request.getSession().getAttribute("user");
    if( obj == null ){
    %>
<script>
        window.location.href="<%=Const.base%>"
</script>
    <%}
    User user = new User();
    if ( obj != null ) {
        user = (User) obj;
    }
    %>


<div class="row">
    <div class="col col-md-10">
        <ul class="nav nav-tabs" id="myTab">
            <li class="nav-item">
                <a  class="nav-link active" href="item">Active Items</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Deleted Items</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="archivedItems">Archived Items</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" ><%=user.getName()%></a>
            </li>
        </ul>
    </div>
    <div class="col-md-2">
        <a href="<%=Const.base%>userLogout" class="btn btn-danger">Log Out</a>
    </div>
</div>
<script>
    $('#myTab a').on('click', function (e) {
        e.preventDefault()
        $(this).tab('show')
    })
    $('#myTab li:first-child a').tab('show')
    $('#myTab li:nth-child(2) a').tab('show')
    $('#myTab li:nth-child(3) a').tab('show')
</script>



