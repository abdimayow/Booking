package Blocks;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BlockView
 */
@WebServlet("/BlockView")
public class BlockView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		insertDao in = new InsertDaoImp();
				
		String submitype = request.getParameter("submit");
		
		
		switch (submitype) {
		case "view blocks":
			ArrayList<Blocks> b = in.getBlocks();
			
			session.setAttribute("blocks", b);
			System.out.println("Hello");
			
			if(b !=null) {
				response.sendRedirect("BlockVew.jsp");	
			}
			break;
		case "view hostels":
			String id = request.getParameter("blockid");
			

			int blockid = Integer.parseInt(id);
		
			ArrayList<Hostel> h= in.getBlockHostels(blockid);
            session.setAttribute("hostels", h);
			response.sendRedirect("HostelView.jsp");
			break;
		case "view rooms":
			String hid = request.getParameter("hostelid");
			int hostelid = Integer.parseInt(hid);
			ArrayList<Room> r= in.getHostelRooms(hostelid);
            session.setAttribute("rooms", r);
			response.sendRedirect("RoomView.jsp");
			break;
		case "view beds":
			
			String rid = request.getParameter("roomid");
			int roomid = Integer.parseInt(rid);
			System.out.println(roomid);
			ArrayList<Bed> j = in.getRoomBeds(roomid);
			session.setAttribute("beds", j);
			response.sendRedirect("BedView.jsp");
			break;
		case "BOOK":
			
			String bid = request.getParameter("bedid");
			int bedid = Integer.parseInt(bid);
			
			System.out.println(bedid);
			response.sendRedirect("BedView.jsp");
			break;	
		case "UNBOOK":
			
			String bid2 = request.getParameter("bedid");
			int bedid2 = Integer.parseInt(bid2);
			String reg= in.checkbookedstudent(bedid2);
			if(reg!=null) {
				session.setAttribute("reg", reg);
				session.setAttribute("bedid", bedid2);
				response.sendRedirect("BedView.jsp");
			}else {
				session.setAttribute("failurebooking", "Room is not booked!");
				response.sendRedirect("BedView.jsp");	
			}
			
			System.out.println(bedid2);
			
			break;
			
		default:
			response.sendRedirect("BedView.jsp");
			break;
		}


				
		
	}
	
	

}
