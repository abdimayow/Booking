<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Groups.groups" %> 
<%@ page import="Login.Student" %>   
<%@ page import = "java.util.ArrayList" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Admin Dashboard</title>

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
	width: 800px;
	margin-top: 40px ;
	margin-bottom: 20px;
	margin-left: auto;
	margin-right: auto;
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

.links ul li:hover,
.links ul li.active{
	color: #4abd3e;
}

.view_main{
	background: #fff;
	border-radius: 3px;
	padding: 15px;
}

.list-view .view_item {
	background: #fff;
	border: 1px solid #e2efe1;
	margin: 10px;
	padding: 10px 20px;
	display: flex;
	align-items: center;
}

.list-view .view_item:last-child{
	margin-bottom: 0;
}

.list-view .view_item .vi_left{
	margin-right: 25px;
}

.view_item .title{
	font-weight: 600;
}

.view_item .content{
	margin: 5px 0;
	font-size: 14px;
	line-height: 22px;
	font-weight: 500;
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



.modal {
  /* This way it could be display flex or grid or whatever also. */
  display: block;
  
  /* Probably need media queries here */
  width: 600px;
  max-width: 100%;
  
  height: 400px;
  max-height: 100%;
  
  position: fixed;
  
  z-index: 100;
  
  left: 50%;
  top: 50%;
  
  /* Use this for centering if unknown width/height */
  transform: translate(-50%, -50%);
  
  /* If known, negative margins are probably better (less chance of blurry text). */
  /* margin: -200px 0 0 -200px; */
  
  background: white;
  box-shadow: 0 0 60px 10px rgba(0, 0, 0, 0.9);
}
.closed {
  display: none;
}
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 50;
  
  background: rgba(0, 0, 0, 0.6);
}
.modal-guts {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  padding: 20px 50px 20px 20px;
}



* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
.modal .close-button {
  position: absolute;
  
  /* don't need to go crazy with z-index here, just sits over .modal-guts */
  z-index: 1;
  
  top: 10px;
  
  /* needs to look OK with or without scrollbar */
  right: 20px;
  
  border: 0;
  background: black;
  color: white;
  padding: 5px 10px;
  font-size: 1.3rem;
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
<%



ArrayList<groups> s = (ArrayList<groups>)session.getAttribute("viewgroups");

ArrayList <Student> b = new ArrayList<Student>();

   
%>
 
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
      
       <li ><a href="home.jsp" > Home</a></li>
 
       </ul>
       <ul class="nav navbar-nav navbar-right">
       <li ><a href="logout.jsp">logout</a></li>
       
       </ul>
       </div>
       </div>
      </nav>
      


<div class="container main">


   


     <% if((session.getAttribute("grpn") != null) ){
    	 
    	     
    		String groupname = (String)session.getAttribute("grpn");

       session.removeAttribute("grpn");
	   
	 %>
	 
	<div class="modal-overlay" id="modal-overlay"></div>

  <div class="modal" id="modal">
  <button class="close-button" id="close-button">Close Button</button>
  		<%if((session.getAttribute("members") != null) ){
			
			
				 b = (ArrayList)session.getAttribute("members");
		
			
			%>
  <div class="modal-guts">
    <h1>Group name:<%=groupname %></h1>
                <div class="table-responsive">
                <table class="table table-bordered ">
                    <thead>
                     <tr>
                         <td>
                             Regno
                         </td>
                         <td>
                             Name
                         </td>
                         <td>
                             Status
                         </td>

                     </tr>
                    </thead>
                    <tbody>
                         <%for(int i=0;i<b.size();i++){ %>
                        <%Student c = b.get(i); %>
                        
                        <%  String status = "";
                        
                       if(c.getStatus().equals("P")){
                       	status = "Pending";
                       }else{
                       	status = "Confirmed";
                       	%>
                       <% } %>
                        <tr class="active">
                            <td>
                                <%=c.getRegno() %>
                            </td>
                            <td>
                                <%=c.getName() %> 
                            </td>
                            <td>
                                <%=status %>
                            </td>
  
                        </tr>
                        <%} %> 
                      
                    </tbody>
                </table>
            </div>
  </div>
  <%} %>
</div>

     <%} %>
  
 <div class="wrapper">
	<div class="links">
		<ul>
			<li data-view="list-view" class="li-list active">
			<i class="fas fa-th-list"></i>
			Groups List View</li>

		</ul>
	</div>
	<div class="view_main">
		<div class="view_wrap list-view" style="display: block;">

			<%if(s != null){ %>
			
			    <%for(int i=0;i<s.size();i++){ %>
    <%groups g = s.get(i); %>
			
			<div class="view_item">
				<div class="vi_left">
					<img src="img/people.png" alt="group">
				</div>
				<div class="vi_right">
					<p class="title"><h4><%= g.getGroupname() %></h4></p>
					<p class="content">Group leader:<%= g.getLeader() %><br>
					Number of members:<%= g.getNoOfMembers() %>
					</p>
					<form action="ViewGroups" method="Post">
					<input type="hidden" name="leader" value="<%= g.getLeader() %>" />
					<input type="submit" name="submit"   class="btn btn-success"  value="View Members">
					</form>
					
				</div>
				
			</div>
			  <%} %>
			  <%} %>

		</div>

	</div>
</div>


  




   </div >
   
 

        




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery-3.4.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3/js/bootstrap.min.js"></script>
   
  
    <script type="text/javascript">
    var modal = document.querySelector("#modal");
    var modalOverlay = document.querySelector("#modal-overlay");
    var closeButton = document.querySelector("#close-button");
    
    closeButton.addEventListener("click", function() {
    	  modal.classList.toggle("closed");
    	  modalOverlay.classList.toggle("closed");
    	});

    	
    
    var li_links = document.querySelectorAll(".links ul li");
    var view_wraps = document.querySelectorAll(".view_wrap");
    var list_view = document.querySelector(".list-view");
  

    li_links.forEach(function(link){
    	link.addEventListener("click", function(){
    		li_links.forEach(function(link){
    			link.classList.remove("active");
    		})

    		link.classList.add("active");

    		var li_view = link.getAttribute("data-view");

    		view_wraps.forEach(function(view){
    			view.style.display = "none";
    		})

    		if(li_view == "list-view"){
    			list_view.style.display = "block";
    		}

    	})
    })
    
    
    
    
    
    </script>
</body>
</html>