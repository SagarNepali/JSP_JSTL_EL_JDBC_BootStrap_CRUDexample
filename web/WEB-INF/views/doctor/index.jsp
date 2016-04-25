<%-- 
    Document   : index
    Created on : Apr 19, 2016, 11:44:48 AM
    Author     : user
--%>

<%@include file="../header.jsp" %>
<h1>Doctor page</h1>



<div class ="container">
    <div class="pull right">
        <p>
            <a href="${SITE_URL}/doctor/add.jsp" class="btn btn-primary " ><span class="glyphicon glyphicon-plus"/> Add </a>
        </p>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered table-hover ">
                <tr>
                    <th width="5">Id</th>
                    <th width="15">First Name</th>
                    <th width="15">Last Name</th>
                    <th width="15">Address</th>
                    <th width="15">Contact</th>
                    <th width="10">Specialization</th>
                    <th width="30">Workplace</th>
                    <th width="5">Action</th>

                </tr>

                <c:forEach var="doc" items="${requestScope.docList}">
                    <tr>
                        <td width="5">${doc.id}</td>
                        <td width="15">${doc.firstName}</td>
                        <td width="15">${doc.lastName}</td>
                        <td width="15">${doc.address}</td>
                        <td width="15">${doc.contact}</td>
                        <td width="10">${doc.specialization}</td>
                        <td width="30">${doc.workplace}</td>
                        <td>
                            <a href="${SITE_URL}/doctor/edit?id=${doc.id}" class="btn btn-success btn-sm"> <span class="glyphicon glyphicon-pencil"> </a>

                            <a href="${SITE_URL}/doctor/delete?id=${doc.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure to delete this entry?')" ><span class="glyphicon glyphicon-trash" > </a>
                        </td>
                    </tr> 
                </c:forEach>


            </table>
        </div>
    </div>
</div>
<%@include file="../footer.jsp" %>
