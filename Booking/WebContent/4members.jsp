<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Create Group</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3/css/bootstrap.min.css" rel="stylesheet">
    <link href="customStyle.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%
if(session.getAttribute("regno")==null){
	response.sendRedirect("student.jsp");
}
String leader = (String)session.getAttribute("regno");

String f = "";

%>
 <nav class="navbar navbar-default">
       <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
        <span class="icon-bar"></span>
       </button>
       </div>
       <div class="navbar-collapse collapse">
       <ul class="nav navbar-nav navbar-right">
       <li ><a href="student.jsp">Student</a></li>
       </ul>
       </div>
      </nav>
<div class="container">
  <div class="row" style="min-height=200px;"></div>
 <% if(request.getAttribute("failuregrps") != null){
	 f = (String)request.getAttribute("failuregrps");
	 request.removeAttribute("failuregrps");
	 %>
	 
 <div id = "failure2" class="alert alert-danger alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= f %> 
</div>  

<%} %>  
     
      <div class="row">
      
     
    
       <div class="col-xs-12 customDiv1"></div>     

        
                    
                 <div class="col-xs-8 col-xs-offset-2 ">
                
		             
		                
		            
               
                  
                 <div class="col-xs-10 col-xs-offset-2 customDiv2"><h4 >Enter Registration number of members</h4></div>
                    
             
                <form class="form-horizontal"  action="userstatus" method="Post">
                    
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="Regno1">Regno1</label>
                        <div class="col-xs-10">
                        <input class="form-control " type="text" id="Regno1" name="Regno1"  value='<%= leader %>' disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="Regno2">Regno2</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="Regno2" name="Regno2"  placeholder="Enter Registration number">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-xs-2  control-label" for="Regno3">Regno3</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="Regno3" name="Regno3"  placeholder="Enter Registration number">
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="col-xs-2  control-label" for="Regno4">Regno4</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="Regno4" name="Regno4"  placeholder="Enter Registration number">
                        </div>
                    </div>
                    <div class="form-group">
                       
                     <div class="col-xs-10 col-xs-offset-2">
                       <input type="hidden" name="members" class="btn btn-primary" value="4members">
                       <input type="submit" name="submit" class="btn btn-primary" value="confirm members">
                    </div>
                    </div>
                  
                </form>
                 
      </div>
  </div>
             
</div>
        




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3/js/bootstrap.min.js"></script>
     <script>
     $(document).ready(function(){
    	setTimeout(function(){
    		$('#failure2').hide('fade')
    	},3500);
     });
    </script>
</body>
</html>