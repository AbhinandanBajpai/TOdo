 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">

<p>${name}'s Todos Are</p>


<table class="table table-striped">
<tr>
<th>Description</th>
<th>Target Date</th>
<th>IsItDone</th>
<th>Update</th>
<th>Delete</th>

</tr>

<c:forEach items="${todos}" var="item">
<tr>
<td>${item.desc}</td>
<td>${item.targetDate}</td>
<td> 	</td>
<td><a type="button" class="btn btn-success" href="update-todos?id=${item.id }">UPDATE ${item.id}</a></td>
<td><a type="button" class="btn btn-warning" href="delete-todos?id=${item.id }">DELETE ${item.id}</a></td>

</tr>
</c:forEach>
</table>

<div>
<a class="button" href="add-todos">Add ToDo</a>
</div>
</div>

<%@ include file="common/footer.jspf" %>