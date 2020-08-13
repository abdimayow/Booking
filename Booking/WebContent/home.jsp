<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

   
   <script type="text/javascript">
   
   function checkForm()
   {
   	var from = document.getElementById('from').value;
   	var to = document.getElementById('to').value;
   	today = new Date();
   	var td = today.getDate();
   	var tm = today.getMonth()+1; //As January is 0.
   	var ty = today.getFullYear();
   	

 //use split()    to conc str into 	YY MM DD 
 const splitfromdate = from.split("-");
 const splittodate = to.split("-");
// use parseInt() to convert str to int

var fromyear =  parseInt(splitfromdate[0]);
var frommonth =  parseInt(splitfromdate[1]);
var fromdate =  parseInt(splitfromdate[2]);

var toyear =  parseInt(splittodate[0]);
var tomonth =  parseInt(splittodate[1]);
var todate =  parseInt(splittodate[2]);
alert(todate);

//check for the year
if(fromyear != ty){
	alert("From year should be this year");
	document.getElementById('from').focus();
	return false;
}
if(toyear != ty){
	alert("To year should be this year");
	document.getElementById('to').focus();
	return false;
}
//check for the month
if(frommonth != tm){
	alert("From month should be this month");
	document.getElementById('from').focus();
	return false;
}
if(tomonth != tm){
	alert("To month should be this month");
	document.getElementById('to').focus();
	return false;
}

//check for the days
if(fromdate < td){
	alert("From date should be from today upto the end of this month");
	document.getElementById('from').focus();
	return false;
}

//Compare to and from days
if(todate < fromdate){
	alert("To date should be after from date");
	document.getElementById('to').focus();
	return false;
	
}



 
   }
   
   </script>

    <style>
    body{
    position:relative;
    }
   
   .DivStyle{
    padding-top:40px;
    

    }
    .dropdown-menu li{
    cursor: pointer;
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

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
  
}

/* The Close Button */
.close {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.close2 {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.close3 {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.close4 {
  color: #bbb;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
.close2:hover,
.close2:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
.close3:hover,
.close3:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
.close4:hover,
.close4:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
 
    </style>

</head>
<body data-spy="scroll" data-target="#MainNavbar" data-offset="100">
<%
if(session.getAttribute("id")== null){
	response.sendRedirect("admin.jsp");
}






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
       <li ><a class="active" href="#search">Search</a></li>
       <li ><a href="#booking" > Booking</a></li>
      <li ><a href="#groups" >Groups</a></li>
      <li ><a href="#bRooms" >Booked-Rooms</a></li>
      <li ><a href="#vRooms" >Vacant-Rooms</a></li>
      <li ><a href="#book" >Book</a></li>
      <li ><a href="#unBook" >UnBook</a></li>
       </ul>
       <ul class="nav navbar-nav navbar-right">
       <li ><a href="logout.jsp">logout</a></li>
       
       </ul>
       </div>
       </div>
      </nav>
      


<div class="container main">

      <div id="search" class="DivStyle">
   <h2>Search</h2>
           <form class="form-inline" action="" role="search">
             <div class="form-group">
             <input type="text" class="form-control" placeholder="registration number" />
             </div>
             <button type="button" class="btn btn-primary">Submit</button>
             
           </form>
   </div >
  
 
   <div id="booking" class="DivStyle">
    <h2>Booking</h2>
    
     <div  class="DivStyle2">
     <h3>Status: ${bstatus}</h3>
     <div id="off" class="col-xs-12"> <h4>Booking is unavailable until grouping is closed</h4></div>
     <div id="on" class="col-xs-12 "> <h4>Booking is available</h4></div>
     <div id="on1" class="col-xs-12"> <h4>Click on the Button to Change status</h4></div>
      <div id="st" class="col-xs-2 dropdown">
        <a id="bst" class="dropdown-toggle btn btn-info sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="benable" >Enable</a></li>
            <li><a id="bmyBtn">Disable</a></li>
            <li><a id="bview">View</a></li>
           
        </ul>
    </div>
    
    
   
     
     <div id="b-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
   
      
  
 
  
        <div id="bsetdate" class="modal">

	    <!-- Modal content -->
		    <div class="modal-content">
				 <span class="close3">&times;</span>
				     <form name="bsetDate" action="setBookStatus" method="Post">
                              <div class="form-group">
							     <label>from:</label> <input name="from" type="date" class="form-control" id="bfrom">
							   </div>
							   <div class="form-group">
							      <label>to:</label> <input   name="to" type="date" class="form-control" id="bto">
							   </div>
							      <input type="submit" name="submit"  onClick="return validate2();" class="btn btn-primary"  value="confirmDate">
					  </form>
		    </div>

     </div>
  
  
  <!-- The Modal -->
<div id="bModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close2">&times;</span>
    <form name="setDate" action="setBookStatus" method="Post">
     
	   <p>Do you want to disable Booking?</p>  
	   <input type="submit" name="submit" class="btn btn-primary"  value="Confirm">
	   
	   </form>
  </div>

</div>
     </div>
        <div class="DivStyle2">
     <h3>Booked rooms</h3>
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
        <div id="Vrooms" class="DivStyle2">
     <h3>Vacant rooms</h3>
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

  
   <div id="groups" class="DivStyle">
    <h2>Groups</h2>
  
  
        <h3 id="offg">Grouping is unavailable </h3>
        <h3 id="ong">Grouping is available</h3>
  
     <div  class="DivStyle2">
     
     <h3>Status: ${gstatus}</h3>

     <h4>Click on the Button to Change status</h4>
      <div id="st2" class="col-xs-2 dropdown">
        <a id="bsg" class="dropdown-toggle btn btn-info sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="enable" >Enable</a></li>
            
            
           
        </ul>
    </div>
    <div id="st2s" class="col-xs-2 dropdown">
        <a id="bsgs" class="dropdown-toggle btn btn-info sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="edit" >Edit</a></li>
            <li><a id="myBtn">Disable</a></li>
            
           
        </ul>
    </div>
    
   
     
     <div id="St-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
   
      
     <div id="exg" class="col-xs-12"><h3>Expiry:${gto}</h3></div>
  
    <!-- The Modal to set dates for groups -->
<div id="gModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close4">&times;</span>
			<form name="setDate" action="setgroup" method="Post">
			 <div class="form-group">
			<label>from:</label> <input name="from" type="date" class="form-control" id="from" required>
			</div>
			<div class="form-group">
			<label>to:</label> <input   name="to" type="date" class="form-control" id="to" required>
			</div>
			<input type="submit" name="submit" class="btn btn-primary" onClick="return checkForm();" value="confirmDate">
			</form>
  </div>

</div>
  
  
  
  <!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <form name="setDate" action="setgroup" method="Post">
     
	   <p>Do you want to disable group?</p>  
	   <input type="submit" name="submit" class="btn btn-primary"  value="Confirm">
	   
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
   
       <div id="bRooms" class="DivStyle">
   <h2>Booked Rooms</h2>
           <form class="form-inline" action="" role="search">
             <div class="form-group">
             <input type="text" class="form-control" placeholder="registration number" />
             </div>
             <button type="button" class="btn btn-primary">Submit</button>
             
           </form>
   </div >
       <div id="vRooms" class="DivStyle">
   <h2>Vacant Rooms</h2>
           <form class="form-inline" action="" role="search">
             <div class="form-group">
             <input type="text" class="form-control" placeholder="registration number" />
             </div>
             <button type="button" class="btn btn-primary">Submit</button>
             
           </form>
   </div >
       <div id="book" class="DivStyle">
   <h2>Book</h2>
           <form class="form-inline" action="" role="search">
             <div class="form-group">
             <input type="text" class="form-control" placeholder="registration number" />
             </div>
             <button type="button" class="btn btn-primary">Submit</button>
             
           </form>
   </div >
       <div id="uBook" class="DivStyle">
   <h2>Unbook</h2>
           <form class="form-inline" action="" role="search">
             <div class="form-group">
             <input type="text" class="form-control" placeholder="registration number" />
             </div>
             <button type="button" class="btn btn-primary">Submit</button>
             
           </form>
   </div >
   </div >
   
 

        




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="jquery-3.4.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3/js/bootstrap.min.js"></script>
   
  
    <script type="text/javascript">
    $(document).ready(function(){
    	var status = '${gstatus}';
    	var bstatus = '${bstatus}';
if(status == 'YES'){
	$('#St-btn').addClass('active');	

	$('#offg').addClass('hide');
	$('#ong').removeClass('hide');
	$('#exg').removeClass('hide');
	$('#off').removeClass('hide');
	$('#on').addClass('hide');
	$('#on1').addClass('hide');
	$('#bst').addClass('disabled');
	$('#st2').addClass('hide');
	$('#st2s').removeClass('hide');
    	}
else{
	$('#St-btn').removeClass('active');	

	$('#offg').removeClass('hide');
	$('#ong').addClass('hide');
	$('#exg').addClass('hide');
	$('#off').addClass('hide');
    $('#on').removeClass('hide');
    $('#on1').removeClass('hide');
	$('#bst').removeClass('disabled');
	$('#st2s').addClass('hide');
	$('#st2').removeClass('hide');
	
}
if(bstatus == 'YES'){
 $('#b-btn').addClass('active');
 $('#bst').removeClass('disabled');
 $('#on').removeClass('hide');
 $('#on1').removeClass('hide');
 $('#off').addClass('hide');
 $('#bsg').addClass('disabled');
 $('#bsgs').addClass('disabled');
}
else{
	$('#b-btn').removeClass('active');
	
	$('#on').addClass('hide');
	$('#on1').addClass('hide');
	$('#off').removeClass('hide');
	$('#bsg').removeClass('disabled');
	$('#bsgs').removeClass('disabled');
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
    	
    	alterClass();
    	
    	
    	
    	
    	
    	
    });
   

    	
	

    
    
	
 // Get the modal
    var modal = document.getElementById("myModal");
    var modal2 = document.getElementById("bModal");
    var modal3 = document.getElementById("bsetdate");
    var modal4 = document.getElementById("gModal");
    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");
    var btn2 = document.getElementById("bmyBtn");
    var btn3 = document.getElementById("benable");
    var btn4 = document.getElementById("enable");
    var btn5 = document.getElementById("edit");
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];
    var span2 = document.getElementsByClassName("close2")[0];
    var span3 = document.getElementsByClassName("close3")[0];
    var span4 = document.getElementsByClassName("close4")[0];
    // When the user clicks on the button, open the modal
    btn.onclick = function() {
      modal.style.display = "block";
    }
    btn2.onclick = function() {
        modal2.style.display = "block";
      }
    btn3.onclick = function() {
        modal3.style.display = "block";
      }
    btn4.onclick = function() {
        modal4.style.display = "block";
      }
    btn5.onclick = function() {
        modal4.style.display = "block";
      }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
      modal.style.display = "none";
    }
    span2.onclick = function() {
        modal2.style.display = "none";
      }
    span3.onclick = function() {
        modal3.style.display = "none";
      }
    span4.onclick = function() {
        modal4.style.display = "none";
      }

   // When the user clicks anywhere outside of the modal, close it
   window.onclick = function(event) {
	   if (event.target == modal) {
	        modal.style.display = "none";
	      }
      if (event.target == modal2) {
        modal2.style.display = "none";
      }
      if (event.target == modal3) {
          modal3.style.display = "none";
        }
      if (event.target == modal4) {
          modal4.style.display = "none";
        } 
    }
    
    </script>
</body>
</html>