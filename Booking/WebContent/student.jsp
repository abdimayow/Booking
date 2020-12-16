<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Student Login</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3/css/bootstrap.min.css" rel="stylesheet">
    <link href="customStyle.css" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <script type="text/javascript">
    window.history.forward();
    function noBack()
    {
        window.history.forward();
    }
</script> 
<style>
.navbar-inverse {
    background-color: #035e06;
    border-color: #E7E7E7;
}
.navbar-default .navbar-nav > li > a {
    color: #777777;
}
.navbar-default .navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:hover, .navbar-default .navbar-nav > .active > a:focus {
    background-color: #E7E7E7;
    color: #555555;
}
.btn-success{
background-color: #035e06;
}

</style>
</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
 <nav class="navbar navbar-inverse ">
       <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
       </button>
       </div>
       <div class="navbar-collapse collapse">
       <ul class="nav navbar-nav navbar-right">
       <li ><a href="admin.jsp">Admin</a></li>
       </ul>
       </div>
      </nav>
<div class="container">
  <div class="row" style="min-height=200px;"></div>
<% if(session.getAttribute("failure") != null){
	String s = (String)session.getAttribute("failure");
	 session.removeAttribute("failure");
	 %>
	 
       <div id="div1" class="alert alert-warning customDiv2" role="alert">
          <a id="clo" href="#" class="close" data-dismiss="alert">&times;</a>
          <%= s%> 
       </div>

<%} %>
      <div class="row">
      
     
    
       <div class="col-xs-12 customDiv1"></div>     

        
                    
                 <div class="col-xs-8 col-xs-offset-2 ">
             
                 
                 <div class="col-xs-10 col-xs-offset-2 customDiv2"><h4 >Student Login Form</h4></div>
                    
             
                <form class="form-horizontal"  action="Login" method="Post">
                    
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="regno">regno</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="inputUname" name="regno" placeholder="regno">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="inputPassword">password</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="password" id="inputPassword" name="StudentPassword" placeholder="Password">
                       
                    </div>
                    </div>
                     <div class="form-group">
                       
                        <div class="col-xs-10 col-xs-offset-2">
                      <input type="submit" name="submit" class="btn btn-success" value="Login Student">
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
    		$('#div1').hide('fade')
    	},1500);
     });
    </script>
  

</body>
</html>