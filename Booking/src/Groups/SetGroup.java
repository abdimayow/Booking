package Groups;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Blocks.InsertDaoImp;
import Blocks.insertDao;
import RoomBooking.RoomBookingDao;
import RoomBooking.RoomBookingDaoImp;

/**
 * Servlet implementation class SetGroup
 */
@WebServlet("/setgroup")
public class SetGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   GroupDao gd = new GroupDaoImp();
	   RoomBookingDao rm = new RoomBookingDaoImp();
		
	   HttpSession session = request.getSession();
	  
	   insertDao in = new InsertDaoImp();
		
	   String from = request.getParameter("from");
	   String to = request.getParameter("to");
	   String submitype = request.getParameter("submit");
	   String status = "YES";
	   String now = gd.checkGroupstates();
	   String then = rm.checkBookStatus();
	   
	
	   
	  Group g = new Group();
	  if(submitype.equals("confirmDate")) {
       
		  int close = in.unbookall();
		  System.out.println("Unbook all returned: "+close);
		  
		  if(then.equals("YES")) {
			  rm.closeBookStatus();
		  }
		  
		  LocalDate  today  = LocalDate.now();
		  LocalDate  tomorrow  = LocalDate.now().plusYears(1);
		  int stoday = today.getYear();
		  int stomorrow = tomorrow.getYear();
          String year = stoday+"/"+stomorrow;
		  System.out.println(year);
		  g.setFrom(from);
		  g.setTo(to); 
		  g.setStatus(status);
		  g.setYear(year);
		  
		if( now.equals("NO")) {
			int one = gd.insertGroup(g);
			Group ps = gd.getGroup("YES");
			session.setAttribute("group", ps);
			session.setAttribute("gstatus","YES");
			session.setAttribute("gto",g.getTo());
			System.out.println(one);
			
			
		}
		else {
			gd.closeGroup();
			int one = gd.insertGroup(g);
			Group ps = gd.getGroup("YES");
			session.setAttribute("group", ps);
			System.out.println(one);
			session.setAttribute("gstatus","YES");
			session.setAttribute("gto",g.getTo());
		}
		 
		
		 response.sendRedirect("home.jsp");
	  }
	  if(submitype.equals("Confirm")) {
		
		  
		if( now.equals("YES")) {
			
			gd.closeGroup();
			session.setAttribute("gstatus","NO");
			session.removeAttribute("groups");
		}
		else {
			session.setAttribute("disabled","Group is already disabled");
		}
		 response.sendRedirect("home.jsp");
	  } 
	  
	  if(submitype.equals("creategroup")) {
		  response.sendRedirect("booking.jsp");
	  }
	  
	  
	}

}
