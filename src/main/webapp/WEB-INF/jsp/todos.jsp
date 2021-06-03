<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <form:form method="POST" modelAttribute="todo">
        <form:hidden path="id" />
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <input type="text" path="desc" name="desc" class="form-control" required>
            <form:errors path="desc" cssClass="text-warning" />
        </fieldset>
        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <input type="text" path="targetDate" id="targetDate" name="targetDate" class="form-control" required>
            <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>
        
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>
      