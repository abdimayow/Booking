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
    <link href="customStyle.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
    
    @media only screen and (max-width:1030px){
    .toggle-btn{
     display:none;
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

 
  <nav id="MainNavbar" class="navbar navbar-inverse navbar-fixed-top">
  <div class="container ">
       <div class="navbar-header">
       <button type="button" class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
       <span class="icon-bar"></span>
       <span class="icon-bar"></span>
        <span class="icon-bar"></span>
       </button>
       </div>
     
       <ul class="nav navbar-collapse">
       <li ><a class="active" href="#search">Search</a></li>
       <li ><a href="#booking" > Booking</a></li>
      <li ><a href="#groups" >Groups</a></li>
       </ul>
       <ul class="nav navbar-collapse navbar-right">
       <li ><a href="#">logout</a></li>
       
       </ul>
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
      <div class="col-xs-1 dropdown">
        <a  class="dropdown-toggle btn btn-info sav" data-toggle="dropdown">
            Status<span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            <li><a id="enable" >Enable</a></li>
            <li><a id="disable">Disable</a></li>
            <li><a >View</a></li>
           
        </ul>
    </div>
   
     
     <div id="St-btn" class="col-xs-2  toggle-btn"><div class="inner-circle"></div></div>
     
      
      
     
     
        
       
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3/js/bootstrap.min.js"></script>
    <script>
    $(document).ready(function(){
    	$('#enable').click(function(){
    		$('#St-btn').addClass('active');
    	});
    	$('#disable').click(function(){
    		$('#St-btn').removeClass('active');
    	});
    });
    </script>
</body>
</html>