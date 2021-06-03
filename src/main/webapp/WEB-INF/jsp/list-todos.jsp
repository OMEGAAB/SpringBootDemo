<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1>Your Todos</h1>
        <table class="table table-striped">
            <caption>Your Todo's are</caption>
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is it Done?</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.desc}</td>
                        <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy" /></td>
                        <td>${todo.done}</td>
                        <td><a href="/update-todos?id=${todo.id}" class="btn btn-success">Update</a></td>
                        <td><a href="/delete-todos?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <a class="btn btn-primary" href="/add-todos">Add Todos</a>
        </div>
        </div>
        <%@ include file="common/footer.jspf" %>