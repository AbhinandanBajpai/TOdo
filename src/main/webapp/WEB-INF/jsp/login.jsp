<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<font color="red">${error}</font>
<form method="Post">
Name : <input type="text" name="name" class="form-control"> <br>
Password :<input type="password" name="password" class="form-control">
<button type="submit" class="btn btn-success"> Submit </button>
</form>

</div>

<%@ include file="common/footer.jspf" %>