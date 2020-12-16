package Blocks;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Groups.Group;
import Groups.GroupDao;
import Groups.GroupDaoImp;
import Groups.groups;
import RoomBooking.RoomBookingDao;
import RoomBooking.RoomBookingDaoImp;

/**
 * Servlet implementation class ViewBooked
 */
@WebServlet("/ViewBooked")
public class ViewBooked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   RoomBookingDao rm = new RoomBookingDaoImp();
		   GroupDao gd = new GroupDaoImp();
		   HttpSession session = request.getSession();
		   String submit = request.getParameter("submit");
		   
		   
		   String from = request.getParameter("from");
			LocalDate  sfrom = LocalDate.parse(from);

			
			Group ps = gd.getGroup("YES");
			String fdate = ps.getFrom();
			LocalDate  fromdate = LocalDate.parse(fdate);
			
			LocalDate current = LocalDate.now();
			
			String test="ba";
			

			if(fromdate.compareTo(sfrom) > 0) {
				test = test+"ba";
			}
			if(current.compareTo(fromdate) > 0) {
				test = test+"ba";
			}

			switch(test) {
			case "ba":
				from = from+" 00:00:00:00";
				
				String to = current+" 23:59:59:59";
				System.out.println(from +" "+to);
				response.sendRedirect("home.jsp");
//				ArrayList<groups> gs = gd.getroups(from,  to);
//				
//				   if(gs !=null) {
//					   session.setAttribute("viewgroups", gs);
//					   
//					   response.sendRedirect("ListFile.jsp");
//				   }
//				   else {
//					   session.setAttribute("failuregrps", "student groups are not available at the moment");
//					   response.sendRedirect("home.jsp");
//				   }
			//groups g = 	(groups)session.getAttribute("groups");
				break;
			default:
				System.out.println("failure");
				session.setAttribute("searchfailure", "Date should be from the beginning of  grouping date to todays date ");
				response.sendRedirect("home.jsp");
				break;
			}
		   
		   
	}




}
