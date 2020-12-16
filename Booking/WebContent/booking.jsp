<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Login.Student" %>    
<%@ page import="Groups.groups" %> 
<%@ page import="Groups.group2" %> 
<%@ page import="Groups.group3" %>
<%@ page import="Groups.group4" %>
<%@ page import="Blocks.Booked" %>
<%@ page import="Blocks.History" %>
<%@ page import ="java.util.ArrayList" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Accomodation</title>

    <!-- Bootstrap -->
    <link href="bootstrap-3/css/bootstrap.min.css" rel="stylesheet">

    <script type="text/javascript">
    window.history.forward();
    function noBack()
    {
        window.history.forward();
    }
</script> 
   

    <style>
    body{
    position:relative;
    }
     .dropdown-menu li{
    cursor: pointer;
    }
   .DivStyle{
    padding-top:40px;
    

    }
    .DivStyle2{
    margin-top:10px;
    min-height:600px;
    } 
    .toggle-btn{
    height:30px;
    width:64px;
    background:gray;
    border-radius:30px;
    padding:2px;
    margin-top:3px;
    margin-right:10px;
    color:white;
    }
    .toggle-btn > .inner-circle{
    width:26px;
    height:26px;
    background:#fff;
    border-radius:50%;
    ;
    
    }
    .toggle-btn.active{
    background:#00acee;
    }
    .toggle-btn.active > .inner-circle{
    margin-left:32px;
    }
    
   
    
    }
    

    @media only screen and(max-width:768px){
     .main{
     margin-top:1000px;
     }
    }
      /* The Modal (background) */
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
.modal2 {
  display: block;
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

.closee {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.closeb {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.closeg {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}


.closee:hover,
.closee:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
.closeb:hover,
.closeb:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
.closeg:hover,
.closeg:focus {
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
<body data-spy="scroll" data-target="#MainNavbar" data-offset="100" onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<%
if(session.getAttribute("regno")== null){
	response.sendRedirect("student.jsp");
}
ArrayList<Student> b = new ArrayList<Student>();
String f = "";
String s = "";
String groupname = "";
String regno = (String)session.getAttribute("regno");




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
      <li ><a href="#History" >History</a></li>
      <li ><a href="#groups" >Groups</a></li>
      <li ><a href="#booking" > Booking</a></li>
     
       </ul>
       <ul class="nav navbar-nav navbar-right">
       <li ><a href="logout.jsp">logout</a></li>
       
       </ul>
       </div>
       </div>
      </nav>

  



<div class="container">

        <div class="row" style="min-height=200px;"></div>

      <div id="History" class="DivStyle">
   <h2>History</h2>

  
   <% if(session.getAttribute("incomplete") != null){
	 s = (String)session.getAttribute("incomplete");
	 session.removeAttribute("incomplete");
	 %>
	 
 <div id = "incomplete" class="alert alert-warning alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= s %> 
</div>  

<%} %>
 
 
  <% if(session.getAttribute("successgrps") != null){
	 s = (String)session.getAttribute("successgrps");
	 session.removeAttribute("successgrps");
	 %>
	 
 <div id = "success" class="alert alert-success alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= s %> 
</div>  

<%} %>
  <% if(session.getAttribute("successbooking") != null){
	 s = (String)session.getAttribute("successbooking");
	 session.removeAttribute("successbooking");
	 %>
	 
 <div id = "successbooking" class="alert alert-success alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= s %> 
</div>  

<%} %>

  <% if(request.getAttribute("failuregrps") != null){
	 s = (String)request.getAttribute("failuregrps");
	 request.removeAttribute("failuregrps");
	 %>
	 
 <div id = "failure" class="alert alert-warning alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= s %> 
</div>  

<%} %>
<% if(session.getAttribute("failurebooking") != null){
	 s = (String)session.getAttribute("failurebooking");
	 session.removeAttribute("failurebooking");
	 %>
	 
 <div id = "failurebooking" class="alert alert-warning alert-dismissible">
  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  <%= s %> 
</div>  

<%} %>
  
  
  
   
        <div class="DivStyle2">
        
        
     <h3>Booked rooms</h3>
                 <% if(session.getAttribute("history") != null){
      ArrayList<History> history= (ArrayList<History>)session.getAttribute("history");
	      
	     %>
	     
		    <div  class="col-xs-12">
            <div class="table-responsive">
                <table class="table table-bordered ">
                    <thead>
                     <tr>
                         <td>
                             Hostelname
                         </td>
                         <td>
                             Roomnumber
                         </td>
                         <td>
                             Year
                         </td>
                         <td>
                             Status
                         </td>

                     </tr>
                    </thead>
                    <tbody>
                         <%for(int i=0;i<history.size();i++){ %>
                        <%History c = history.get(i); %>
                        
                        <%  String status = "";
                        
                       if(c.getStatus().equals("CLOSED")){
                       	status = "Cleared";
                       }else{
                       	status = "Booked";
                       	%>
                       <% } %>
                        <tr class="active">
                            <td>
                                <%=c.getHostelname() %>
                            </td>
                            <td>
                                <%=c.getRoomno() %> 
                            </td>
                            <td>
                                <%=c.getYear() %> 
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
   </div >
  
      <div id="groups" class="DivStyle">
    <h2>Groups</h2>
    


     <div  class="DivStyle2">
    
     <div id="offg" class="col-xs-12"> <h4>Grouping is unavailable </h4></div>
     <div id="ong" class="col-xs-12 "> <h4>Grouping is available</h4></div>
    
     
      <div id="st2" class="col-xs-2 dropdown ">
        <a id="bsg" class="dropdown-toggle btn btn-success sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="create">Create</a></li>
           
           
        </ul>
    </div>
          <div id="st2s" class="col-xs-2 dropdown ">
        <a id="bsgs" class="dropdown-toggle btn btn-success sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            
            <li  id="exitlink"><a id="exit" >Exit</a></li>
           
        </ul>
    </div>
     
    
    
   
     
     <div id="St-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
   
      
     <div id="exg" class="col-xs-12"><h3>Expiry:${gto}</h3></div>
     
     
          <% if(session.getAttribute("grpnotification") != null){
      String notice = (String)session.getAttribute("grpnotification");
	   
	     %>
	     
	        <!-- Create Modal -->
<div id="memberModal" class="modal2">

  <!-- Modal content -->
  <div class="modal-content">
   
    <form  action="DeclineGroup" method="Post">
     
	   <p><%=notice %></p>  
	   <input id="accept" type="submit" name="submit" class="btn btn-success float left"  value="accept">
	   <input id="decline" type="submit" name="submit" class="btn btn-danger float right"  value="decline" >
	   </form>
  </div>

</div> 



	     
         <%} %>
         
        
                  <% if(session.getAttribute("grpstatus") != null){
      String notice1 = (String)session.getAttribute("grpstatus");
	      
	     %>
	     
	        <!-- Create Modal -->
<div id="studentdecline" class="modal2">

  <!-- Modal content -->
  <div class="modal-content">
   
    <form  action="DeclineGroup" method="Post">
     
	   <p><%=notice1 %></p>  
	   <input id="ad" type="submit" name="submit" class="btn btn-success float centre"  value="OK">
	   
	   </form>
  </div>

</div> 
	     
         <%} %>
         
         
                           <% if(session.getAttribute("grpdeclined") != null){
      String notice2 = (String)session.getAttribute("grpdeclined");
	      
	     %>
	     
	        <!-- Create Modal -->
<div id="admindecline" class="modal2">

  <!-- Modal content -->
  <div class="modal-content">
   
    <form  action="DeclineGroup" method="Post">
     
	   <p><%=notice2 %></p>  
	   <input id="ad" type="submit" name="submit" class="btn btn-success float centre"  value="OK">
	   
	   </form>
  </div>

</div> 
	     
         <%} %>
         
         

         
          
     

     <% if((session.getAttribute("grpn") != null) || (request.getAttribute("grpn") != null)){
    	 
    	 if(request.getAttribute("grpn") == null){
    		 groupname = (String)session.getAttribute("grpn");
    	 }else{
    		 groupname = (String)request.getAttribute("grpn");
    	 }
       
	   
	 %>
	 
		 <div id = "grpname" class="col-xs-12">
		     <h3>Group name:<%=groupname %></h3> 
		</div>  
		
		<%if((session.getAttribute("members") != null) || (request.getAttribute("members") != null)){
			
			if(request.getAttribute("members") == null){
				 b = (ArrayList)session.getAttribute("members");
			}else{
				 b = (ArrayList)request.getAttribute("members");
			}
			
			%>
		
			
			
			
			
		
		    <div id = "members" class="col-xs-12">
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

     <%} %>

  
 
   <!-- Create Modal -->
<div id="creategroup" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="closeg">&times;</span>
    <form name="setDate" action="userstatus" method="Post">
     
	   <p>Do you want to create a new  group?</p>  
	   <input type="submit" name="submit" class="btn btn-success"  value="confirm">
	   
	   </form>
  </div>

</div> 
  
  <!-- The Modal -->
<div id="exitgroup" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="closee">&times;</span>
    <form name="setDate" action="DeclineGroup" method="Post">
     
	   <p>Do you want to exit group?</p>  
	   <input type="submit" name="submit" class="btn btn-success"  value="Confirm">
	   
	 </form>
  </div>

</div>
        
       
     </div>
     
          <div  class="DivStyle2">
     <h3>View</h3>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Debitis sunt pariatur saepe aliquid numquam,
    cum laborum consectetur ex nisi in hic quo sint veniam deleniti.
    Quisquam iste, iure obcaecati sint esse at dignissimos molestias aspernatur,
     numquam aliquam assumenda deleniti facilis.
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Debitis sunt pariatur saepe aliquid numquam,
    cum laborum consectetur ex nisi in hic quo sint veniam deleniti.
    Quisquam iste, iure obcaecati sint esse at dignissimos molestias aspernatur,
     numquam aliquam assumenda deleniti facilis.
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Debitis sunt pariatur saepe aliquid numquam,
    cum laborum consectetur ex nisi in hic quo sint veniam deleniti.
    Quisquam iste, iure obcaecati sint esse at dignissimos molestias aspernatur,
     numquam aliquam assumenda deleniti facilis.
     </div>
   
   </div >
 
   <div id="booking" class="DivStyle">
    <h2>Booking</h2>
    
     <div  class="DivStyle2">
   
     <div id="offb" class="col-xs-12"> <h4>Booking is unavailable </h4></div>
     <div id="onb" class="col-xs-12 "> <h4>Booking is available</h4></div>
     
      <div id="st" class="col-xs-2 dropdown">
        <a id="bst" class="dropdown-toggle btn btn-success sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
  
    </div>

    
   
     
     <div id="b-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
   
      <div id="exb" class="col-xs-12"><h3>Expiry:${bto}</h3></div> 
      <div id="exbb" class="col-xs-12">
           <form name="bookstu" action="StudentBook" method="Post">
             <div class="form-group">
             <input type="hidden" name="regno" class="form-control" value="<%= regno %>" />
             </div>
             
             <input type="submit" name="submit" class="btn btn-success col-xs-2"  value="BOOK">
             
           </form>
    </div>
  

  
  
  <!-- The Modal -->
<div id="bModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="closeb">&times;</span>
    <form name="setDate" action="" method="Post">
     
	   <p>Do you want to unbook?</p>  
	   <input type="submit" name="submit" class="btn btn-success"  value="Confirm">
	   
	   </form>
  </div>

</div>
     </div>


   </div >

  




   </div >
   
 

        




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery-3.4.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3/js/bootstrap.min.js"></script>
   
  
    <script type="text/javascript">
   
  
   
    		
        	setTimeout(function(){
        		$('#success').hide('fade')
        	},4500);
        	setTimeout(function(){
    		$('#successbooking').hide('fade')
	        },4500);
        	setTimeout(function(){
        		$('#failure').hide('fade')
        	},4500);
        	setTimeout(function(){
        		$('#failurebooking').hide('fade')
        	},4500);
        	setTimeout(function(){
        		$('#incomplete').hide('fade')
        	},4500);
    
    	
  

    
    	

    		
    		
    
     
    	
    	
    	
    	var status = '${gstatus}';
    	var bstatus = '${bstatus}';
    	var gstatus = '${ustatus}';
if(status == 'YES'){
	$('#St-btn').addClass('active');	
	$('#offg').addClass('hide');
	$('#ong').removeClass('hide');
	$('#exg').removeClass('hide');
	$('#groupname').removeClass('hide');
	$('#members').removeClass('hide');
	$('#bsg').removeClass('disabled');
	$('#bsgs').removeClass('disabled');
    	}
else{
	$('#St-btn').removeClass('active');	
	$('#ong').addClass('hide');
	$('#exg').addClass('hide');
	$('#offg').removeClass('hide');
	$('#bsg').addClass('disabled');
	$('#bsgs').addClass('disabled');
	
}
if(bstatus == 'YES'){
	$('#b-btn').addClass('active');
	$('#offb').addClass('hide');
	$('#onb').removeClass('hide');
	$('#bst').removeClass('disabled');
	$('#exb').removeClass('hide');
	$('#exbb').removeClass('hide');
}
else{
	$('#b-btn').removeClass('active');	
	$('#onb').addClass('hide');
	$('#offb').removeClass('hide');
	$('#bst').addClass('disabled');
	$('#exb').addClass('hide');
	$('#exbb').addClass('hide');
}
if(gstatus == "S" || gstatus=="D"){
	$('#st2s').addClass('hide');
}else{
	$('#st2').addClass('hide');
}
	
    	var alterClass= function(){
        var ww= document.body.clientWidth;
        if(ww<450){
        	$('#st').removeClass('col-xs-2').addClass('col-xs-5');
        	$('#st2').removeClass('col-xs-2').addClass('col-xs-5');
        	$('#st2s').removeClass('col-xs-2').addClass('col-xs-5');
        }else {
        	
        	$('#st').addClass('col-xs-2').removeClass('col-xs-5');
        	$('#st2').addClass('col-xs-2').removeClass('col-xs-5');
        	$('#st2s').addClass('col-xs-2').removeClass('col-xs-5');
        };
    	};
        $(window).resize(function(){
        	alterClass();
        });
    	
    	
    	
    	
    	
    	
    	
    	
    	
   
    function validate(){
    	var from = document.setDate.from.value;
    	var to = document.setDate.to.value;
    	var today = new Date();
    	from = new Date(from);
    	to  = new Date(to);

    	if((from<today) || (to<today)){
    		document.write("please select a date greater than today");
    	    return false;
    	}
    	else if(to<from){
    		document.write("please select a date greater than start date");
    		return false;
    		}
    	
    	

    }
    
    function validate2(){
    	var from = document.bsetDate.from.value;
    	var to = document.bsetDate.to.value;
    	var today = new Date();
    	from = new Date(from);
    	to  = new Date(to);

    	
    	if((from<today) || (to<today)){
    		document.write("please select a date greater than today");
    	    return false;
    	}
    	else if(to<from){
    		document.write("please select a date greater than start date");
    		return false;
    		}
    }
    	
 // Get the modal
    var creategroup = document.getElementById("creategroup");
    var exitgroup = document.getElementById("exitgroup");
    
    
    // Get the button that opens the modal
    var create = document.getElementById("create");
    var exit = document.getElementById("exit");
    
    // Get the <span> element that closes the modal
    var closeg = document.getElementsByClassName("closeg")[0];
    var closee = document.getElementsByClassName("closee")[0];

    // When the user clicks on the button, open the modal

    create.onclick = function() {
    	creategroup.style.display = "block";
      }
    exit.onclick = function() {
    	exitgroup.style.display = "block";
      }



    // When the user clicks on <span> (x), close the modal

    closeg.onclick = function() {
    	creategroup.style.display = "none";
      }
    closee.onclick = function() {
    	exitgroup.style.display = "none";
      }


   // When the user clicks anywhere outside of the modal, close it
   window.onclick = function(event) {

      if (event.target == creategroup) {
    	  creategroup.style.display = "none";
        } 
      if (event.target == exitgroup) {
    	  exitgroup.style.display = "none";
        } 
      
    }
   

   
   
   
   
    
    </script>
</body>
</html>