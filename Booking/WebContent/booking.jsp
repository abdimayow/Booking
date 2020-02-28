<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

   
   

    <style>
    body{
    position:relative;
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
      <li ><a href="#uBook" >UnBook</a></li>
       </ul>
       <ul class="nav navbar-nav navbar-right">
       <li ><a href="#">logout</a></li>
       
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
     <h3>Status</h3>
     <div id="off" class="col-xs-12"> <h4>Booking is unavailable until grouping is closed</h4></div>
     <div id="on" class="col-xs-12 "> <h4>Booking is available</h4></div>
     <div class="col-xs-12"> <h4>Click on the Button to Change status</h4></div>
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
  
     <div  class="DivStyle2">
     <h3>Status</h3>
     
     <h4>Click on the Button to Change status</h4>
      <div id="st2" class="col-xs-2 dropdown">
        <a  class="dropdown-toggle btn btn-info sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="enable" >Enable</a></li>
            <li><a id="myBtn">Disable</a></li>
            <li><a id="view">View</a></li>
           
        </ul>
    </div>
    
    
   
     
     <div id="St-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
   
      

  
    <!-- The Modal to set dates for groups -->
<div id="gModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close4">&times;</span>
			<form name="setDate" action="setgroup" method="Post">
			 <div class="form-group">
			<label>from:</label> <input name="from" type="date" class="form-control" id="from">
			</div>
			<div class="form-group">
			<label>to:</label> <input   name="to" type="date" class="form-control" id="to">
			</div>
			<input type="submit" name="submit" class="btn btn-primary" onClick="return validate();" value="confirmDate">
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


<div id="uBook" class="DivStyle">
    <h2>Unbook</h2>
  
     <div  class="DivStyle2">
     <h3>Status</h3>
     
     <h4>Click on the Button to Change status</h4>
      <div id="st2" class="col-xs-2 dropdown">
        <a  class="dropdown-toggle btn btn-info sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="enable" >Enable</a></li>
            <li><a id="myBtn">Disable</a></li>
            <li><a id="view">View</a></li>
           
        </ul>
    </div>
    
    
   
     
     <div id="St-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
   
      

  
    <!-- The Modal to set dates for groups -->
<div id="gModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close4">&times;</span>
			<form name="setDate" action="setgroup" method="Post">
			 <div class="form-group">
			<label>from:</label> <input name="from" type="date" class="form-control" id="from">
			</div>
			<div class="form-group">
			<label>to:</label> <input   name="to" type="date" class="form-control" id="to">
			</div>
			<input type="submit" name="submit" class="btn btn-primary" onClick="return validate();" value="confirmDate">
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
	$('#on').addClass('hide');
	$('#off').removeClass('hide');
	$('#bst').addClass('disabled');
    	}
else{
	$('#St-btn').removeClass('active');	
	$('#on').removeClass('hide');
	$('#off').addClass('hide');
	$('#bst').removeClass('disabled');
	
}
if(bstatus == 'YES'){
	$('#b-btn').addClass('active');
}
else{
	$('#b-btn').removeClass('active');	
}
	
    	var alterClass= function(){
        var ww= document.body.clientWidth;
        if(ww<450){
        	$('#st').removeClass('col-xs-2').addClass('col-xs-5');
        	$('#st2').removeClass('col-xs-2').addClass('col-xs-5');
        }else {
        	
        	$('#st').addClass('col-xs-2').removeClass('col-xs-5');
        	$('#st2').addClass('col-xs-2').removeClass('col-xs-5');
        };
    	};
        $(window).resize(function(){
        	alterClass();
        });
    	
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
    var modal = document.getElementById("myModal");
    var modal2 = document.getElementById("bModal");
    var modal3 = document.getElementById("bsetdate");
    var modal4 = document.getElementById("gModal");
    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");
    var btn2 = document.getElementById("bmyBtn");
    var btn3 = document.getElementById("benable");
    var btn4 = document.getElementById("enable");
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