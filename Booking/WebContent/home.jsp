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
      <div id="st" class="col-xs-2 dropdown">
        <a  class="dropdown-toggle btn btn-info sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="enable" >Enable</a></li>
            <li><a id="disable">Disable</a></li>
            <li><a id="view">View</a></li>
           
        </ul>
    </div>
    
    
   
     
     <div id="St-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
   
      
  
   <div class="col-xs-2 hide" id="setDate">
    
       <form name="setDate" action="setgroup" method="Post">
        <div class="form-group">
	   <label>from:</label> <input name="from" type="date" class="form-control" id="from">
	   </div>
	   <div class="form-group">
	   <label>to:</label> <input   name="to" type="date" class="form-control" id="to">
	   </div>
	   <button type="submit" class="btn btn-default" onClick="return validate();">confirm</button>
	   </form>
	   
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
    	$('#enable').click(function(){
    		$('#St-btn').addClass('active');
    		$('#setDate').removeClass('hide');
    	});
    	$('#disable').click(function(){
    		$('#St-btn').removeClass('active');
    		$('#setDate').addClass('hide');
    	});
    	var alterClass= function(){
        var ww= document.body.clientWidth;
        if(ww<450){
        	$('#st').removeClass('col-xs-2').addClass('col-xs-5');
        }else {
        	
        	$('#st').addClass('col-xs-2').removeClass('col-xs-5');
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
        dif = from-today;
      console.log(from);
      console.log(today);
      console.log(dif);
    	
    	if((from<today) || (to<today)){
    		document.write("please select a date greater than today");
    	    return false;
    	}
    	else if(to<from){
    		document.write("please select a date greater than start date");
    		return false;
    		}
    	
    	

    }
    	
  
    </script>
</body>
</html>