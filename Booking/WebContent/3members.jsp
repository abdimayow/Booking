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
    .modal {
  display: none; /* Hidden by default */
  position: relative; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */

}


/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
  
}


/* The Close Button */

.closec,.closeh {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}




.closec:hover,.closeh:hover
.closec:focus,.closeh:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

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
if(session.getAttribute("regno")==null){
	response.sendRedirect("student.jsp");
}
String leader = (String)session.getAttribute("regno");

String f = "";



%>
 <nav class="navbar navbar-inverse">
       <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
        <span class="icon-bar"></span>
       </button>
       </div>
       <div class="navbar-collapse collapse">
       <ul class="nav navbar-nav navbar-left " >
       <li><a id="back">Back</a></li>
       </ul>
       <ul class="nav navbar-nav navbar-centre " >
       <li><a id="home">Home</a></li>
       </ul>
       <ul class="nav navbar-nav navbar-right " >
       <li ><a href="logout.jsp"  >Logout</a></li>
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

    <!-- Backtrack Modal -->
<div id="backtrack" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="closec">&times;</span>
    <form name="backtrack" action="backtrackgroup" method="Get">
     
	   <p>Do you want to restart the grouping process?</p>  
	   <input type="submit" name="submit" class="btn btn-success"  value="ok">
	   
	   </form>
  </div>

</div> 
    <!-- Cancel Modal -->
<div id="cancel" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="closeh">&times;</span>
    <form name="backtrack" action="backtrackgroup" method="Get">
     
	   <p>Do you want to cancel the grouping process?</p>  
	   <input type="submit" name="submit" class="btn btn-success"  value="confirm">
	   
	   </form>
  </div>

</div>    
     
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
                       
                     <div class="col-xs-10 col-xs-offset-2">
                       <input type="hidden" name="members" class="btn btn-primary" value="3members">
                       <input type="submit" name="submit" class="btn btn-success" value="confirm members">
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
    	 window.open ("http://localhost:8080/Booking/Creategroup","mywindow","status=1,toolbar=0");
    	 
    	setTimeout(function(){
    		$('#failure2').hide('fade')
    	},3500);
     });
     
     
     // Get the modal
     var restartgroup = document.getElementById("backtrack");
     var cancelgroup = document.getElementById("cancel");
     
     
     // Get the button that opens the modal
     var back = document.getElementById("back");
     var home = document.getElementById("home");
     
     
     // Get the <span> element that closes the modal
     var closec = document.getElementsByClassName("closec")[0];
     var closeh = document.getElementsByClassName("closeh")[0];
     
     
     // When the user clicks on the button, open the modal

     back.onclick = function() {
     	restartgroup.style.display = "block";
       }
     home.onclick = function() {
     	cancelgroup.style.display = "block";
       }
     
     
     
     // When the user clicks on <span> (x), close the modal

     closec.onclick = function() {
    	 restartgroup.style.display = "none";
       }
     closeh.onclick = function() {
    	 cancelgroup.style.display = "none";
       }
     
     
     // When the user clicks anywhere outside of the modal, close it
     window.onclick = function(event) {

        if (event.target == restartgroup) {
      	  restartgroup.style.display = "none";
          } 
        if (event.target == cancelgroup) {
      	  cancelgroup.style.display = "none";
          } 
        
      }
    </script>
</body>
</html>