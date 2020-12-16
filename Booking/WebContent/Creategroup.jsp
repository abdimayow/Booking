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
<%
String f2 = "";
String f1 = "";

%>
 <nav class="navbar navbar-inverse" >
       <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
        <span class="icon-bar"></span>
       </button>
       </div>
       <div class="navbar-collapse collapse">
       <ul class="nav navbar-nav navbar-left " >
       <li ><a href="booking.jsp"  >Back</a></li>
       </ul>
              <ul class="nav navbar-nav navbar-centre " >
       <li ><a href="booking.jsp"  >Home</a></li>
       </ul>
       <ul class="nav navbar-nav navbar-right " >
       <li ><a href="logout.jsp"  >Logout</a></li>
       </ul>
       </div>
      </nav>
<div class="container">
  <div class="row" style="min-height=200px;"></div>
  
  <% if(request.getAttribute("failuregrps") != null){
	 f1 = (String)request.getAttribute("failuregrps");
	 request.removeAttribute("failuregrps");
	 %>
	 
 <div id = "failure1" class="alert alert-danger alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= f1 %> 
</div>  

<%} %>

  <% if(request.getAttribute("grpfailure2") != null){
	 f2 = (String)request.getAttribute("grpfailure2");
	 request.removeAttribute("grpfailure2");
	 %>
	 
 <div id = "failure2" class="alert alert-danger alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= f2 %> 
</div>  

<%} %>  
 
 

      <div class="row">
      
     
    
       <div class="col-xs-12 customDiv1"></div>     

        
                    
                 <div class="col-xs-8 col-xs-offset-2 ">
                
		             
		                
		            
               
                  
                 <div class="col-xs-10 col-xs-offset-2 customDiv2"><h4 >Enter New Group Details</h4></div>
                    
             
                <form class="form-horizontal"  action="Creategroup" method="Post">
                    
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="groupname">groupname</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="groupname" name="groupname"  placeholder="groupname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="NoOfMembers">Number of members </label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="NoOfMembers" name="NoOfMembers"  placeholder="Enter number of members either 2,3 or 4)">
                        </div>
                    </div>

                    <div class="form-group">
                  
                     <div class="col-xs-12 col-xs-offset-2">
                       <input type="submit" name="submit" class="btn btn-success" value="creategroup">
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
    		$('#failure1').hide('fade')
    	},4500);
    	
    	setTimeout(function(){
    		$('#failure2').hide('fade')
    	},4500);	

     });
    </script>
</body>
</html>