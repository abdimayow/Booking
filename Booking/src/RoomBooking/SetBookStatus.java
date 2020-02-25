package RoomBooking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/setBookStatus")
public class SetBookStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		RoomBookingDao rm = new RoomBookingDaoImp();
		
		   HttpSession session = request.getSession();
		  
			
		   String from = request.getParameter("from");
		   String to = request.getParameter("to");
		   String submitype = request.getParameter("submit");
		   String status = "YES";
		  BookStatus g = new BookStatus();
		  if(submitype.equals("confirmDate")) {
			  
			  
			  g.setFrom(from);
			  g.setTo(to);
			  
			  g.setStatus(status);
			  
			if( rm.checkBookStatus("YES")== false) {
				int one = rm.insertBookingStatus(g);
				session.setAttribute("bstatus","YES");
				System.out.println(one);
				
				
			}
			else {
				rm.closeBookStatus();
				int one = rm.insertBookingStatus(g);
				System.out.println(one);
				session.setAttribute("bstatus","YES");
			}
			 
			
			 response.sendRedirect("home.jsp");
		  }
		  if(submitype.equals("Confirm")) {
			
			  
			if( rm.checkBookStatus("YES")== true) {
				
				rm.closeBookStatus();
				session.setAttribute("bstatus","NO");
			}
			else {
				session.setAttribute("disabled","Book is already disabled");
			}
			 response.sendRedirect("home.jsp");
		  } 
		  
		  
		}
		
	}


