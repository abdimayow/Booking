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
				String fname = request.getParameter("firstname");
				String sname = request.getParameter("secondname");
				String faculty = request.getParameter("faculty");
				String department = request.getParameter("department");
				String password = request.getParameter("password");
				
				Student c = new Student();
				
				c.setRegno(regno);
				c.setFirstname(fname);
				c.setSecondname(sname);
				c.setFaculty(faculty );
				c.setDepartment	(department);
				c.setPassword(password);
				
				
				
				 int n = cd.insertStudent(c);
				 
				 System.out.println(n);
                
				 HttpSession session = request.getSession();
				session.setAttribute("success","Student has been successfully registered");
				
			    response.sendRedirect("StudentReg.jsp");	
			
					
				}
			else if(submitype.equals("Register Admin")) {
					String fname = request.getParameter("firstname");
					String sname = request.getParameter("secondname");
					String position = request.getParameter("position");
					String department = request.getParameter("department");
					String password = request.getParameter("password");
				    
					Admin c = new Admin();
					
					
					c.setFirstname(fname);
					c.setSecondname(sname);
					c.setPosition(position);
					c.setDepartment	(department);
					c.setPassword(password);
					
					System.out.println(c.getFirstname());
					System.out.println(c.getSecondname());
					System.out.println(c.getDepartment());
					System.out.println(c.getPosition());
					System.out.println(c.getPassword());
					
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


