package RoomBooking;

import java.io.IOException;
import java.time.LocalDate;

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
		   String now = rm.checkBookStatus();
		  BookStatus g = new BookStatus();
		  if(submitype.equals("confirmDate")) {
			  
			  LocalDate  today  = LocalDate.now();
			  LocalDate  tomorrow  = LocalDate.now().plusYears(1);
			  int stoday = today.getYear();
			  int stomorrow = tomorrow.getYear();
              String year = stoday+"/"+stomorrow;

			  
			  g.setFrom(from);
			  g.setTo(to);
			  g.setStatus(status);
			  g.setYear(year);
			  
			  
			  
			if( now.equals("NO")) {
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
			
			  
			if( now.equals("YES")) {
				
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


