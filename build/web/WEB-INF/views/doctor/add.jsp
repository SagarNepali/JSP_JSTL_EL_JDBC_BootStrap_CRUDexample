<%@include file="../header.jsp" %>
<h1>Add Doctor Information!</h1>


<div class="container-fluid">
    <form action="${SITE_URL}/doctor/save" method="post" >
        <div class="form-group">
            <label >First Name</label>
            <input name="firstName" type="text" class="form-control" id="firstName" placeholder="First Name">
        </div>
        <div class="form-group">
            <label >Last Name</label>
            <input name="lastName" type="text" class="form-control" required="true" id="lastName" placeholder="Last Name">
        </div>
        <div class="form-group">
            <label >Address</label>
            <input name="address" type="text" class="form-control" required="true" id="address" placeholder="Address">
        </div>
        <div class="form-group">
            <label >Contact</label>
            <input name="contact" type="text" class="form-control" required="true" id="contact" placeholder="Contact">
        </div>
        <div class="form-group">
            <label >Specialization</label>
            <input name="specialization" type="text" class="form-control" required="true" id="specialization" placeholder="Specialization">
        </div>
        <div class="form-group">
            <label >Workplace</label>
            <input name="workplace" type="text" class="form-control" required="true" id="workplace" placeholder="Workplace">
        </div>
        
        <a href="${SITE_URL}/doctor/index.jsp" class="btn btn-default btn-danger">Back</a>
        <button type="submit" class="btn btn-default btn-success">Save</button>
                

        
    </form>


</div>

</body>
</html>
