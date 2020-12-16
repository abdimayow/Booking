<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Blocks.Bed" %>   
<%@ page import = "java.util.ArrayList" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>beds</title>
    <!-- Bootstrap -->
    <link href="bootstrap-3/css/bootstrap.min.css" rel="stylesheet">

<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@200;400;600&display=swap');
@import 'https://fonts.googleapis.com/css?family=Prompt:400,700';

*{
	list-style: none;
	font-family: 'Montserrat', sans-serif;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body{
	background: #ebecf1;
	color: #000000;
}

.view_item img{
	width: 75px;
}

.wrapper{
    padding-top:50px;
	width: 800px;
	margin: 20px auto;
}

.links{
	margin-bottom: 25px;
	background: #fff;
	padding: 15px;
	border-radius: 3px;
}

.links ul{
	display: flex;
	justify-content: center;
}

.links ul li{
	margin: 0 15px;
	font-weight: 600;
	text-transform: uppercase;
	letter-spacing: 3px;
	font-size: 20px;
	cursor: pointer;
}


.links ul li.active{
	color: #4abd3e;
}

.view_main{
	background: #fff;
	border-radius: 3px;
	padding: 15px;
}



.view_item .title{
	font-weight: 600;
}

.view_item .content{
	margin: 5px 0;
	font-size: 14px;
	line-height: 22px;
	font-weight: 200;
}

.view_item .btn{
	width: 125px;
	background: #4abd3e;
	padding: 8px 5px;
	border-radius: 3px;
	color: #fff;
	text-align: center;
	font-weight: 200;
	cursor: pointer;
}

.view_item .btn:hover{
	background: #3bd62b;
}

.grid-view{
	width: 100%;
}

.grid-view .view_item {
	display: inline-block;
    border: 1px solid #e2efe1;
    width: 345px;
    padding: 25px;
    text-align: center;
    margin: 10px;
}

.grid-view .view_item .vi_left{
	margin-bottom: 10px;
}

.grid-view .view_item .btn{
	margin: 0 auto;
}
.modal {
  display: block; /* not Hidden by default */
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

.closeb {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.closeb:hover,
.closeb:focus {
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
<body data-spy="scroll" data-target="#MainNavbar" data-offset="200">
<%
if(session.getAttribute("id")== null){
	response.sendRedirect("admin.jsp");
}


%>
<%if(session.getAttribute("beds")== null){
	response.sendRedirect("home.jsp");
} %>

 
  <nav id="MainNavbar" class="nav navbar-inverse navbar-fixed-top">
  <div class="container ">
       <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
        <span class="icon-bar"></span>
       </button>
       </div>
     <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
       <li ><a href="RoomView.jsp" > Back</a></li>
       <li ><a href="home.jsp" > Home</a></li>
 
       </ul>
       <ul class="nav navbar-nav navbar-right">
       <li ><a href="logout.jsp">logout</a></li>
       
       </ul>
       </div>
       </div>
      </nav>

<div class="container main">  

  		<%		
  			ArrayList<Bed> b = (ArrayList<Bed>)session.getAttribute("beds");
	
			%> 
<div class="wrapper">
     <% if(session.getAttribute("failureunbooking") != null){
	String s = (String)session.getAttribute("failureunbooking");
	 session.removeAttribute("failureunbooking");
	 %>
	 
 <div id = "failureunbooking" class="alert alert-danger alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= s %> 
</div>  

<%} %>
	<div class="links">
		<ul>
			<li data-view="grid-view" class="li-grid active">
			<i class="fas fa-th-large"></i>
			 Beds Grid View</li>
		</ul>
	</div>
	<% if(session.getAttribute("reg") != null){
	 
		String reg=(String)session.getAttribute("reg");
	    session.removeAttribute("reg");
	 
	 %>
 <div id="unbook" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="closeb"  >&times;</span>
    <form  action="AdminBook" method="Post">
     
	   <p>Do you want to unbook <%= reg%>?</p>  
	   <input type="submit" name="submit" class="btn btn-primary"  value="confirm">
	   
	   </form>
  </div>

</div>
	 <%} %>
	  
 
	
	<div class="view_main">

		<div class="view_wrap grid-view" style="display: block;">
		
					<%if(b != null){ %>
			
			    <%for(int i=0;i<b.size();i++){ %>
    <%Bed c = b.get(i); String action = "";%>
		<%
		switch (c.getStatus()) {
		case "VACANT":
             action="VACANT";
			break;
		case "BOOKED":
            action="UNBOOK";
			break;
	
		default:
			break;
		}
	%>
						<div class="view_item">
				<div class="vi_left">
					<img src="img/bed.png" alt="group">
				</div>
				<div class="vi_right">
					<p class="title"><h4>Bed Number:<%= c.getBedno() %></h4></p>
                    <p class="content">Status:<%= c.getStatus() %></p> 
					<form action="BlockView" method="Get">
					<input type="hidden" name="bedid" value="<%= c.getBedid() %>" />
					
					<input   class="btn" type="submit" name="submit"  value="<%= action %>">
					</form>
					
				</div>
				
			</div>
			  <%} %>
			  <%} %>


		</div>
	</div>
</div>
</div>	

    <script type="text/javascript">
    

    
        // Get the modal
        var creategroup = document.getElementById("unbook");
       
        
        
        // Get the button that opens the modal
        
        
        // Get the <span> element that closes the modal
        
        var close = document.getElementsByClassName("closeb")[0];

        // When the user clicks on the button, open the modal





        // When the user clicks on <span> (x), close the modal


        close.onclick = function() {
        	creategroup.style.display = "none";
          }


       // When the user clicks anywhere outside of the modal, close it
       window.onclick = function(event) {

          if (event.target == creategroup) {
        	  creategroup.style.display = "none";
            } 
      
        }
       
       $(document).ready(function(){
       	
       	setTimeout(function(){
       		$('#failureunbooking').hide('fade')
       	},4500);
       
   });
    	
    	
    	
  
    

    
    
    </script>

</body>
</html>