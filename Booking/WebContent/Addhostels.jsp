<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Blocks.Hostel" %>    
<%@ page import = "java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>insert room</title>

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
<% ArrayList<Hostel> h = (ArrayList<Hostel>)request.getAttribute("hostels");
   String id = (String)request.getAttribute("blockid");
   
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


       
       
        
  
  
 <div class="texts">
  <h2></h2>



 

 <div class="list-group">
 
   
 
      
      <table>
    <%for(int i=0;i<h.size();i++){ %>
    <%Hostel j = h.get(i); %>
   
       
         <tr>
       <td><%= j.getHostelname() %></td>
       <td>
    		<form class="list-group-text" action="insert" method="Post">
		    <input type="hidden" name="hid"  value='<%= j.getHostelid() %>'>
		    <input type="hidden" name="bid"  value='<%= id %>'>
		    <input type="submit" name="submit" class="btn btn-primary" value="AddHostel">
		    </form>  
        </td>
       
       </tr>

   <%} %>
      
      
      </table>
</div> 
</div>
</div>
        




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3/js/bootstrap.min.js"></script>
     <script>


     
    </script>
</body>
</html>