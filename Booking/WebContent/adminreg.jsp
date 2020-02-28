<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

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
  <div class="row" style="min-height=200px;"></div>
      <div class="row">
      
     
    
       <div class="col-xs-12 customDiv1"></div>     

        
                    
                 <div class="col-xs-8 col-xs-offset-2 ">
                 <div class="col-xs-10 col-xs-offset-2 customDiv2"><h4 >${success}</h4></div>
                 <div class="col-xs-10 col-xs-offset-2 customDiv2"><h4 >Admin Registration Form</h4></div>
                    
             
                <form class="form-horizontal"  action="Register2" method="Post">
                    
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="name">name</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="inputUname" name="name"  placeholder="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="department">department</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="department" name="department"  placeholder="department">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="position">position</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="text" id="position" name="position"  placeholder="position">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="email">secondname</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="email" id="secondname" name="email"  placeholder="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="secondname">recoveryemail</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="email" id="secondname" name="recoveryemail"  placeholder="recoveryemail">
                        </div>
                    </div>
                   
                    <div class="form-group">
                        <label class="col-xs-2  control-label" for="password">password</label>
                        <div class="col-xs-10">
                        <input class="form-control" type="password" id="password" name="password" placeholder="password">
                        
                    </div>
                    </div>
                     <div class="form-group">
                       
                        <div class="col-xs-10 col-xs-offset-2">
                        <input type="submit" name="submit" class="btn btn-primary" value="Register Admin">
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
</body>
</html>