package Blocks;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		
		
		String submitype = request.getParameter("submit");

		
		insertDao in = new InsertDaoImp();
	if(submitype.equals("Add Hostels"))	{
		String hostelname = request.getParameter("hostelname");
		String NoOfRooms = request.getParameter("NoOfRooms");
		String NoOfSingleRooms = request.getParameter("NoOfSingleRooms");
		String NoOfDoubleRooms = request.getParameter("NoOfDoubleRooms");
		String NoOfTripleRooms = request.getParameter("NoOfTripleRooms");
		String NoOfQuadRooms = request.getParameter("NoOfQuadRooms");
		String NoOfSextupleRooms = request.getParameter("NoOfSextupleRooms");
	
	     Hostel  h = new Hostel();
	       
	       h.setHostelname(hostelname);
	       h.setNoOfRooms(NoOfRooms);
	       h.setNoOfSingleRooms(NoOfSingleRooms);
	       h.setNoOfDoubleRooms(NoOfDoubleRooms);
	       h.setNoOfTripleRooms(NoOfTripleRooms);
	       h.setNoOfQuadRooms(NoOfQuadRooms);       
	       h.setNoOfSextupleRooms(NoOfSextupleRooms);
	       
	       int one  = in.insertHostel(h);
	       System.out.println(one);
	       
	       response.sendRedirect("insertroom.jsp");
	}

	else if(submitype.equals("Add Blocks")) {
		String Blockname = request.getParameter("Blockname"); 
		
		Blocks b = new Blocks();
		b.setBlockname(Blockname);
		
		
		int one  = in.insertBlocks(b);
		
		System.out.println(one);
		
		response.sendRedirect("insertBlocks.jsp");
	}

	else if(submitype.equals("Blocks")) {
		
		

		ArrayList<Blocks> b = in.getBlocks();
		
		request.setAttribute("blocks", b);
		
		RequestDispatcher dis = request.getRequestDispatcher("Blocks.jsp");
		dis.forward(request, response);
	
		
	}	else  if(submitype.equals("ViewHostels")) {
		
	   String blockid = request.getParameter("blockid");

       System.out.println(blockid);
		
		response.sendRedirect("Blocks.jsp");
		
	}else if(submitype.equals("AddHostels")) {
		
	   String blockid = request.getParameter("id");

	   
	   ArrayList<Hostel> h = in.getHostels();
	   request.setAttribute("hostels", h);
	   request.setAttribute("blockid", blockid);
	   
		RequestDispatcher dis = request.getRequestDispatcher("Addhostels.jsp");
		dis.forward(request, response);
		
	}else if(submitype.equals("RemoveHostel")) {
		
	   String blockid3 = request.getParameter("blockid");

       System.out.println(blockid3);
		
		response.sendRedirect("Blocks.jsp");
	}
	else if(submitype.equals("AddHostel")){
		int hostelid = Integer.parseInt(request.getParameter("hid"));
		int blockid = Integer.parseInt(request.getParameter("bid"));
		 

		
		
		 
		 
		 System.out.println("hid "+hostelid);
		 System.out.println("bid "+blockid);
		 
		 int check = in.checkBlock(hostelid);
		 
	
		 
	    System.out.println("Value of check is "+check);
		 if(check == 0) {
			 Block b = new Block();
		 b.setBlockid(blockid);
		 b.setHostelid(hostelid);
			    
		int	 one = in.insertBlock(b);
		
		session.setAttribute("success", "Hostel has been added");
		
		System.out.println(" One Block has been inserted with status "+one);
		

		
		 }else {
		 
			 String hostelname = in.getHostelname(check);
			 session.setAttribute("failure", "Hostel already belongs to a block "+hostelname);
	
	 }
		 
			response.sendRedirect("View.jsp");	

	}

   
		
		
		
		

		
		
		
		
		
		
		
		
	}

}
