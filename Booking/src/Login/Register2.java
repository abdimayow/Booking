package Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register2")
public class Register2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 LoginDao cd = new LoginDaoImp();
			
			
			
			
		 String submitype = request.getParameter("submit");
			
			
		
					
					
			
			if(submitype.equals("Register Student")) {
				String regno = request.getParameter("regno"); 
				String name = request.getParameter("name");	
				String faculty = request.getParameter("faculty");
				String department = request.getParameter("department");
				String year = request.getParameter("year");
				String email = request.getParameter("email");
				String recoveryemail = request.getParameter("recoveryemail");
				String password = request.getParameter("password");
				
				Student c = new Student();
				
				c.setRegno(regno);
				c.setName(name);
				c.setFaculty(faculty );
				c.setDepartment	(department);
				c.setYear(year);
				c.setEmail(email);
				c.setRecoveryemail(recoveryemail);
				c.setPassword(password);
				
				
				
				 int n = cd.insertStudent(c);
				 
				 System.out.println(n);
                
				 HttpSession session = request.getSession();
				session.setAttribute("success","Student has been successfully registered");
				
			    response.sendRedirect("StudentReg.jsp");	
			
					
				}
			else if(submitype.equals("Register Admin")) {
					String name = request.getParameter("name");
					String department = request.getParameter("department");
					String position = request.getParameter("position");
					String email = request.getParameter("email");
					String recoveryemail = request.getParameter("recoveryemail");
					String password = request.getParameter("password");
				    
					Admin c = new Admin();
					
					
					c.setName(name);
					c.setDepartment	(department);
					c.setPosition(position);
					c.setEmail(email);
					c.setRecoveryemail(recoveryemail);
					c.setPassword(password);

					
					 int n = cd.insertAdmin(c);
					 
					 System.out.println(n);
					
					HttpSession session = request.getSession();
					session.setAttribute("success", "Admin has been successfully registered");
				

					
				    response.sendRedirect("adminreg.jsp");
					}
			else {
						 response.sendRedirect("register.jsp");
				}
			
			
		}

	}


