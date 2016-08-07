<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Portal Template</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
		
		<link href="<c:url value="/resources/mytheme/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
    <script src="<c:url value="/resources/js/main.js" />"></script>
		
		
		
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="/resources/mytheme/css/styles.css" rel="stylesheet">
	</head>
	<body>
	
 
 
<div class="container">
<h1>Spring MVC - How to include JS or CSS files in a JSP page</h1>
  <h2>Form control: input</h2>
  <hr>
  <p>The form below contains two input elements; one of type text and one of type password:</p>
  <form role="form"  method="POST" action="/form/addStudent" >
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name">
    </div>
    
        <div class="form-group">
      <label for="age">Age:</label>
      <input type="text" class="form-control" id="age" name="age">
    </div>
    
            <div class="form-group">
      <label for="id">Id:</label>
      <input type="text" class="form-control" id="id" name="id">
    </div>
    
     <div class="form-actions">
      <button type="submit" class="btn btn-success">Submit</button>
      <button type="button" class="btn">Cancel</button>
     </div>
  </form>
</div>



		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="/resources/mytheme/js/bootstrap.min.js"></script>
	</body>
</html>
