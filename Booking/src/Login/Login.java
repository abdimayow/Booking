package Login;

import java.io.IOException;

import java.time.LocalDate;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Groups.GroupDao;
import Groups.GroupDaoImp;
import Login.Student;
import RoomBooking.RoomBookingDao;
import RoomBooking.RoomBookingDaoImp;
import Login.LoginDao;
import Login.LoginDaoImp;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 GroupDao gd = new GroupDaoImp();
        LoginDao cd = new LoginDaoImp();
        RoomBookingDao rm = new RoomBookingDaoImp(); 
        
		
    	String name1 = request.getParameter("StudentUname");
		String password1 = request.getParameter("StudentPassword");
	    String submitype = request.getParameter("submit");
		String name2 = request.getParameter("AdminUname");
		String password2 = request.getParameter("AdminPassword");
	
		Student c=cd.getStudent(name1, password1); 
	
		
		Admin a= cd.getAdmin(name2, password2);
	
		String gstatus = "";
		String bstatus = "";
				
		
		if(submitype.equals("Login Student") && (c.getFirstname() != null)) {
		
			
			System.out.println(c.getFirstname());
			
			HttpSession session = request.getSession();
			session.setAttribute("firstname", c.getFirstname());
			session.setAttribute("regno",c.getRegno());
			
            if(gd.checkGroup("YES") == true) {
            	gstatus = "YES";  
            }
            else {
            	gstatus = "NO";
            }
			 if(rm.checkBookStatus("YES") == true) {
				 
				 String to = rm.getToDate("YES");
				 

					LocalDate todate = LocalDate.parse(to);
					LocalDate  today  = LocalDate.now();
					
				 if(today.compareTo(todate) == 0 || today.compareTo(todate)<0) {
					 rm.closeBookStatus();
					 bstatus = "NO";
				 }
				 else {
					 bstatus = "YES";  
				 }
				 
				
				 
	            	
	            }
	            else {
	            	bstatus = "NO";
	            }
			System.out.println(gstatus);
			session.setAttribute("gstatus",gstatus);
			session.setAttribute("bstatus",bstatus);
		    response.sendRedirect("booking.jsp");	
		    
				
			}
		else if(submitype.equals("Login Admin") && (a.getFirstname()!=null)) {
				
				
				
				
			    System.out.println(a.getFirstname());
				HttpSession session = request.getSession();
				session.setAttribute("firstname", a.getFirstname());
				session.setAttribute("id",a.getId());

				 if(gd.checkGroup("YES") == true) {
					 
					 String to = gd.getToDate("YES");
					 
	
						LocalDate todate = LocalDate.parse(to);
						LocalDate  today  = LocalDate.now();
						
					 if(today.compareTo(todate) == 0 || today.compareTo(todate)<0) {
						 gd.closeGroup();
						 gstatus = "NO";
					 }
					 else {
						 gstatus = "YES";  
					 }
					 
					
					 
		            	
		            }
		            else {
		            	gstatus = "NO";
		            }
				 
				System.out.println(gstatus);
				session.setAttribute("gstatus",gstatus);
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
