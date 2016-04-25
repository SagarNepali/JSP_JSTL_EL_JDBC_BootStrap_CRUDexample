<%@include file="../header.jsp" %>
<h1>Edit Doctor Information!</h1>


<div class="container-fluid">
    <form action="${SITE_URL}/doctor/edited" method="post" >
        <div class="form-group">
            <label >First Name</label>
            <input name="firstName" type="text" class="form-control" id="firstName" value="${selectedDoc.firstName}">
        </div>
        <div class="form-group">
            <label >Last Name</label>
            <input name="lastName" type="text" class="form-control" required="true" id="lastName" value="${selectedDoc.lastName}">
        </div>
        <div class="form-group">
            <label >Address</label>
            <input name="address" type="text" class="form-control" required="true" id="address" value="${selectedDoc.address}">
        </div>
        <div class="form-group">
            <label >Contact</label>
            <input name="contact" type="text" class="form-control" required="true" id="contact" value="${selectedDoc.contact}">
        </div>
        <div class="form-group">
            <label >Specialization</label>
            <input name="specialization" type="text" class="form-control" required="true" id="specialization" value="${selectedDoc.specialization}">
        </div>
        <div class="form-group">
            <label >Workplace</label>
            <input name="workplace" type="text" class="form-control" required="true" id="workplace" value="${selectedDoc.workplace}">
        </div>
        
        <input type="hidden" name="id" value="${selectedDoc.id}"/>
        <a href="${SITE_URL}/doctor/index/edit" class="btn btn-default btn-danger">Back</a>
        <button type="submit" class="btn btn-default btn-success">Save</button>
                

        
    </form>


</div>

</body>
</html>
