package Login;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Login.Student;

import Login.LoginDao;
import Login.LoginDaoImp;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        LoginDao cd = new LoginDaoImp();
   
        
		
    	String regno = request.getParameter("regno");
		String password1 = request.getParameter("StudentPassword");
	    String submitype = request.getParameter("submit");
		String name = request.getParameter("username");
		String password2 = request.getParameter("AdminPassword");
	
		Student c=cd.getStudent(regno, password1); 
	   
		
		
		Admin a= cd.getAdmin(name, password2);
	
		

		

	     
				
		
		if(submitype.equals("Login Student") && (c.getRegno() != null)) {
			
		
			System.out.println(c.getName());
			
			HttpSession session = request.getSession();
			session.setAttribute("name", c.getName());
			session.setAttribute("regno",c.getRegno());
			
			System.out.println(c.getRegno());
			session.setAttribute("user","isStudent");
		
		    response.sendRedirect("checkstatus");	
		    
				
			}
		
		
		
		else if(submitype.equals("Login Admin") && (a.getName()!=null)) {
			
			

				
				
				
			    System.out.println(a.getName());
				HttpSession session = request.getSession();
				session.setAttribute("firstname", a.getName());
				session.setAttribute("id",a.getId());
	            session.setAttribute("user","isAdmin");
			    response.sendRedirect("checkstatus");
				}
				else if(submitype.equals("Login Admin") && (a.getName()==null)) {
					HttpSession session = request.getSession();
					session.setAttribute("failure","Signin not successful");
					response.sendRedirect("admin.jsp");
					
			}
				else {
					HttpSession session = request.getSession();
					session.setAttribute("failure","Signin not successful");
					response.sendRedirect("student.jsp");
				}
		
		
	}

}
