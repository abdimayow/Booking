package Blocks;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertRooms
 */
@WebServlet("/insertrooms")
public class InsertRooms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		insertDao in = new InsertDaoImp();
		
		String submitype = request.getParameter("submit");
		
		
		if(submitype.equals("ViewHostels")){
			
			   ArrayList<Hostel> h = in.getHostels();
			   request.setAttribute("hostelrooms", h);
			   
			   for(int i=0 ; i<h.size();i++) {
				   Hostel j = h.get(i);
				   
				   System.out.println(j.getHostelname()+" "+j.getNoOfRooms());
			   }
			  
			   
				RequestDispatcher dis = request.getRequestDispatcher("Addrooms.jsp");
				dis.forward(request, response);	
			
		}else if(submitype.equals("AddRooms")) {
			
			int rooms = Integer.parseInt(request.getParameter("r")); 
			int one = Integer.parseInt(request.getParameter("1")); 
			int two = Integer.parseInt(request.getParameter("2")); 
			int three = Integer.parseInt(request.getParameter("3")); 
		int four = Integer.parseInt(request.getParameter("4")); 
//			int six = Integer.parseInt(request.getParameter("6"));
			int hid = Integer.parseInt(request.getParameter("hid")); 
			
			int count = rooms;
			

				if(one>0) {
					Room single = new Room();
					
					single.setHostelid(hid);
					single.setRoomno(1);
					single.setType("S");
					
					int insert = in.insertRoom(single);
					if(insert>0) {
						System.out.println(1);
					}else {
						System.out.println(insert);	
					}
					
				}
				if(two>0) {
					Room single = new Room();
					
					single.setHostelid(hid);
					single.setRoomno(2);
					single.setType("D");
					
					int insert = in.insertRoom(single);
					if(insert>0) {
						System.out.println(2);
					}else {
						System.out.println(insert);	
					}
					
				}				
				if(three>0) {
					Room single = new Room();
					
					single.setHostelid(hid);
					single.setRoomno(3);
					single.setType("T");
					
					int insert = in.insertRoom(single);
					if(insert>0) {
						System.out.println(3);
					}else {
						System.out.println(insert);	
					}
					
				}
				
				if(four>0) {
					Room single = new Room();
					
					single.setHostelid(hid);
					single.setRoomno(4);
					single.setType("Q");
					
					int insert = in.insertRoom(single);
					if(insert>0) {
						System.out.println(4);
					}else {
						System.out.println(insert);	
					}
					
				}

				
				
				
				request.setAttribute("success", "Rooms have been added");
				response.sendRedirect("View.jsp");
			
			
			
			
			
		}else if(submitype.equals("rooms")){
			   ArrayList<Room> h = in.getRooms();
			 
			for(int i =7;i<h.size();i++) {
				Room r = h.get(i);
				String type = r.getType();
				int rid = r.getRoomid();
				
				if(type.equals("D")) {
					for(int j=0;j<2;j++) {
						Bed b = new Bed();
						b.setBedno(j+1);
						b.setRoomid(rid);
						
						int one = in.insertBed(b);
				}
				}else if(type.equals("T")) {
					for(int j=0;j<3;j++) {
						Bed b = new Bed();
						b.setBedno(j+1);
						b.setRoomid(rid);
						int one = in.insertBed(b);
				}
					
					
				}else if(type.equals("Q")) {
					for(int j=0;j<4;j++) {
						Bed b = new Bed();
						b.setBedno(j+1);
						b.setRoomid(rid);
						int one = in.insertBed(b);
				}
					
					
				}else if(type.equals("SE")) {
					for(int j=0;j<6;j++) {
						Bed b = new Bed();
						b.setBedno(j+1);
						b.setRoomid(rid);
						int one = in.insertBed(b);
				}
					
					
				}else if(type.equals("S")) {
					
						Bed b = new Bed();
						b.setBedno(1);
						b.setRoomid(rid);
						int one = in.insertBed(b);
				
					
					
				}else if(type.equals("D")) {
					for(int j=0;j<2;j++) {
						Bed b = new Bed();
						b.setBedno(j+1);
						b.setRoomid(rid);
						int one = in.insertBed(b);
				}
					
					
				}
				
				
				
				
			}

			  
			request.setAttribute("success", "Rooms have been added");
			response.sendRedirect("View.jsp");
	
		}
		
		
		
	}

}
