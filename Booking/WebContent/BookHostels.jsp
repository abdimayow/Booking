<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Blocks.Hostel" %>   
<%@ page import = "java.util.ArrayList" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hostels</title>
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

</style>

</head>
<body data-spy="scroll" data-target="#MainNavbar" data-offset="200">
<%
if(session.getAttribute("id")== null){
	response.sendRedirect("admin.jsp");
}



%>
<%if(session.getAttribute("hostels")== null){
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
       <li ><a href="BookBlocks.jsp" > Back</a></li>
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
  			ArrayList<Hostel> b = (ArrayList<Hostel>)session.getAttribute("hostels");
	
			%> 
<div class="wrapper">
	<div class="links">
		<ul>
			<li data-view="grid-view" class="li-grid active">
			<i class="fas fa-th-large"></i>
			 Hostel Grid View</li>
		</ul>
	</div>
	<div class="view_main">

		<div class="view_wrap grid-view" style="display: block;">
		
					<%if(b != null){ %>
			
			    <%for(int i=0;i<b.size();i++){ %>
    <%Hostel c = b.get(i); %>
		
						<div class="view_item">
				<div class="vi_left">
					<img src="img/apartment.png" alt="group">
				</div>
				<div class="vi_right">
					<p class="title"><h4>Hostel Name:<%= c.getHostelname() %></h4></p>
                     
					<form action="AdminBook" method="Post" >
					<input type="hidden" name="hostelid" value="<%= c.getHostelid() %>" />
					
					<input   class="btn" type="submit" name="submit"  value="book rooms">

					</form>
				</div>
				
			</div>
			  <%} %>
			  <%} %>


		</div>
	</div>
</div>
</div>	
<script>


</script>


</body>
</html>