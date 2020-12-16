package Blocks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			
		   HttpSession session = request.getSession();
		   String submit = request.getParameter("submit");
	}




}
