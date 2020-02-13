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
		
    	String name1 = request.getParameter("StudentUname");
		String password1 = request.getParameter("StudentPassword");
	    String submitype = request.getParameter("submit");
		String name2 = request.getParameter("AdminUname");
		String password2 = request.getParameter("AdminPassword");
	
		Student c=cd.getStudent(name1, password1); 
	
		
		Admin a= cd.getAdmin(name2, password2);
	
				
				
		
		if(submitype.equals("Login Student") && (c.getFirstname() != null)) {
		
			
			System.out.println(c.getFirstname());
			
			HttpSession session = request.getSession();
			session.setAttribute("firstname", c.getFirstname());
			session.setAttribute("regno",c.getRegno());

			
		    response.sendRedirect("booking.jsp");	
		
				
			}
		else if(submitype.equals("Login Admin") && (a.getFirstname()!=null)) {
				
				
				
				
			    System.out.println(a.getFirstname());
				HttpSession session = request.getSession();
				session.setAttribute("firstname", a.getFirstname());
				session.setAttribute("id",a.getId());

				
			    response.sendRedirect("home.jsp");
				}
				else if(submitype.equals("Login Admin") && (a.getFirstname()==null)) {
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
