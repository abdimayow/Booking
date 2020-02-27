package Login;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Groups.GroupDao;
import Groups.GroupDaoImp;
import RoomBooking.RoomBookingDao;
import RoomBooking.RoomBookingDaoImp;


/**
 * Servlet implementation class Checkstatus
 */
@WebServlet("/checkstatus")
public class Checkstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    GroupDao gd = new GroupDaoImp();

    RoomBookingDao rm = new RoomBookingDaoImp();
  
		
		
	String bstatus = rm.checkBookStatus();	
	String gstatus=gd.checkGroupstates();
	System.out.println(gstatus);

	
	if(gstatus.equals("YES")) {
		

	
		LocalDate current = LocalDate.now();
		
		String to  = gd.getToDate("YES");
		
		LocalDate  todate = LocalDate.parse(to);
		
		if(current.compareTo(todate) > 0) {
			gstatus = "YES";

		}
		else {
			gd.closeGroup();
			gstatus = "NO";	
		}
		
	}
	else {
      gstatus = "NO";

	}
	
	if(bstatus.equals("YES")) {
		
		LocalDate current = LocalDate.now();
		
		String to  = rm.getToDate("YES");
		
		LocalDate  todate = LocalDate.parse(to);
		
		if(current.compareTo(todate) > 0) {
			bstatus = "YES";

		}
		else {
			rm.closeBookStatus();
			bstatus = "NO";	
		}
		
	}
	else {
		bstatus = "NO";	
	}
	

		
		 response.sendRedirect("home.jsp");
	}

}
