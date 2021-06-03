<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <p style="color: red;">${emsg}</p>
        <form method="POST" >
            <fieldset class="form-group">
                <label for="">Name</label>
                <input type="text" name="name" class="form-control">
            </fieldset>
            <fieldset class="form-group">
                <label for="">Password</label>
                <input type="password" name="password" class="form-control">
            </fieldset>
            <input type="submit" class="btn btn-primary">
        </form>
</div>
<%@ include file="common/footer.jspf" %>
 