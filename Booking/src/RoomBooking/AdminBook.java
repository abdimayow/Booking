package RoomBooking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Blocks.Bed;
import Blocks.Blocks;
import Blocks.Hostel;
import Blocks.InsertDaoImp;
import Blocks.Room;
import Blocks.insertDao;
import Groups.GroupDao;
import Groups.GroupDaoImp;
import Groups.group2;
import Groups.group3;
import Groups.group4;
import Login.Student;

/**
 * Servlet implementation class AdminBook
 */
@WebServlet("/AdminBook")
public class AdminBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String submitype = request.getParameter("submit");
		String regno="";
		
		insertDao in = new InsertDaoImp();
		GroupDao gd = new GroupDaoImp();
		switch (submitype) {
		case "bookstudent":
			
		regno = request.getParameter("regno");
		
		Student stu = gd.getRegno(regno);
		session.setAttribute("student", stu);
		if(stu.getRegno()!=null) {
			switch(stu.getStatus()) {
	
			case "C":
				session.setAttribute("failurebooking", "Student is in a group!");
				System.out.println("Failure1");
				response.sendRedirect("home.jsp");
				break;	
			default:
				int bid = in.checkbookedbed(regno);
				if(bid ==0) {
					
					ArrayList<Blocks> bl = in.getVacantBlocks(stu);
				    session.setAttribute("blocks", bl);
					response.sendRedirect("BookBlocks.jsp");
				}else {
					session.setAttribute("failurebooking", "Student has already booked!");
					System.out.println("Failure2");
					response.sendRedirect("home.jsp");
				}

				break;
			}
			

		}else {
			session.setAttribute("failurebooking", "Registration number does not exist!");
			System.out.println("Failure3");
			response.sendRedirect("home.jsp");
		}
		

			break;
		case "book hostels":
			String blockids = request.getParameter("blockid");
			Student stud = (Student)session.getAttribute("student");
			int blockid = Integer.parseInt(blockids);
			
			ArrayList<Hostel> hs = in.getVacantHostels(blockid,stud);
			if(hs != null) {
				session.setAttribute("hostels", hs);
				response.sendRedirect("BookHostels.jsp");
			}else {
				session.setAttribute("failurebooking", "No vacant hostels found!");
				System.out.println("Failure");
				response.sendRedirect("BookBlocks.jsp");
			}
			

			break;
		case "book rooms":
			String hostelids = request.getParameter("hostelid");
			Student stude = (Student)session.getAttribute("student");
			int hostelid = Integer.parseInt(hostelids);
			ArrayList<Room> rm = in.getVacantRooms(hostelid,stude);
			if(rm != null) {
				session.setAttribute("status", stude.getStatus());
				session.setAttribute("rooms", rm);
				response.sendRedirect("BookRooms.jsp");
			}else {
				session.setAttribute("failurebooking", "No vacant rooms found!");
				System.out.println("Failure");
				response.sendRedirect("BookHostels.jsp");
			}

			break;
		case "book beds":
			String roomids = request.getParameter("roomid");
			Student studen = (Student)session.getAttribute("student");
			int roomid = Integer.parseInt(roomids);
			ArrayList<Bed> bd = in.getVacantBeds(roomid,studen);
			if(bd != null) {
				session.setAttribute("beds", bd);
				response.sendRedirect("BookBeds.jsp");
			}else {
				session.setAttribute("failurebooking", "No vacant beds found!");
				System.out.println("Failure");
				response.sendRedirect("BookRooms.jsp");
			}

			break;
		case "book room":
			String roomids2 = request.getParameter("roomid");
			int id = Integer.parseInt(roomids2);
			Student student = (Student)session.getAttribute("student");
			int bookedroom = in.bookroom(student,id);
			System.out.println(bookedroom);
			switch(bookedroom) {
			case 0:
				session.setAttribute("failurebooking", "Booking was unsuccessful!");
				System.out.println("Failure");
				response.sendRedirect("home.jsp");
				break;
			default:
				if(student.getStatus().equals("L")) {

					
					if(student.getGrp().equals("2")) {


				     group2 g2 = gd.getgroup2(student.getRegno());
				     
			    	 Student leader = gd.getRegno(g2.getLeader());
				     Student snd = gd.getRegno(g2.getRegno2());
				   					     
				     int one = gd.deletestatus(leader.getRegno());
				     int two = 0;
				     
				     if(snd.getStatus().equals("P")) {
				    	 two = gd.deletestatus(g2.getRegno2());
				     }
				     if(snd.getStatus().equals("C")) {
				    	two = gd.declineStudent(g2.getRegno2()); 
				     }
				     
				     int three = gd.deletereg(g2.getLeader());
				     int four = gd.deletereg(g2.getRegno2());
				     
				     int five = gd.deletegrp(g2.getLeader());
				     int six = gd.deletegrp(g2.getRegno2());
				     
	                 int sev = gd.removegroup(student.getRegno()); 					     
				     
				     
				     int eight = gd.deletegroup2(g2.getLeader());
				     
	                 System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" ");
		
				     
					}
					if(student.getGrp().equals("3")) {

						
						group3 g3 = gd.getgroup3(student.getRegno());
					    
						

					    
					    if(g3.getLeader() != null) {
					    	
					    	 Student leader = gd.getRegno(g3.getLeader());
						     Student snd = gd.getRegno(g3.getRegno2());
						     Student trd = gd.getRegno(g3.getRegno3());
						    
						     int one = gd.deletestatus(leader.getRegno());
						     int two = 0;
						     int three = 0;
						     if(snd.getStatus().equals("P")) {
						    	 two = gd.deletestatus(g3.getRegno2());
						     }
						     if(snd.getStatus().equals("C")) {
						    	two = gd.declineStudent(g3.getRegno2()); 
						     }
						     if(trd.getStatus().equals("P")) {
						    	 three = gd.deletestatus(g3.getRegno3());
						     }
						     if(trd.getStatus().equals("C")) {
						    	 three = gd.declineStudent(g3.getRegno3()); 
						     }
						     
						      
						     
						     
						     int four = gd.deletereg(g3.getLeader());
						     int five = gd.deletereg(g3.getRegno2());
						     int six = gd.deletereg(g3.getRegno3());
						     
						     int sev = gd.deletegrp(g3.getLeader());
						     int eight = gd.deletegrp(g3.getRegno2());
						     int nine = gd.deletegrp(g3.getRegno3());
						     
	                         int ten = gd.removegroup(student.getRegno()); 					     
						     
						     
						     int ele = gd.deletegroup3(g3.getLeader());
						     
	                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" ");
							
							
						     
						     
						     
						     
					    }

	   
						
					}
					if(student.getGrp().equals("4")) {

						
						group4 g4 = gd.getgroup4(student.getRegno());
					    

					    
					    if(g4.getLeader() != null) {
					    	
						     Student leader = gd.getRegno(g4.getLeader());
						     Student snd = gd.getRegno(g4.getRegno2());
						     Student trd = gd.getRegno(g4.getRegno3());
						     Student frt = gd.getRegno(g4.getRegno4());
						     
						    
						     int one = gd.deletestatus(leader.getRegno());
						     int two = 0;
						     int three = 0;
						     int four = 0;
						     if(snd.getStatus().equals("P")) {
						    	 two = gd.deletestatus(g4.getRegno2());
						     }
						     if(snd.getStatus().equals("C")) {
						    	two = gd.declineStudent(g4.getRegno2()); 
						     }
						     if(trd.getStatus().equals("P")) {
						    	 three = gd.deletestatus(g4.getRegno3());
						     }
						     if(trd.getStatus().equals("C")) {
						    	 three = gd.declineStudent(g4.getRegno3()); 
						     }
						     if(frt.getStatus().equals("P")) {
						    	 four = gd.deletestatus(g4.getRegno4());
						     }
						     if(frt.getStatus().equals("C")) {
						    	 four = gd.declineStudent(g4.getRegno4()); 
						     }
						     
						     int five = gd.deletereg(g4.getLeader());
						     int six = gd.deletereg(g4.getRegno2());
						     int sev = gd.deletereg(g4.getRegno3());
						     int eight = gd.deletereg(g4.getRegno4());
						     
						     int nine = gd.deletegrp(g4.getLeader());
						     int ten = gd.deletegrp(g4.getRegno2());
						     int ele = gd.deletegrp(g4.getRegno3());
						     int twel = gd.deletegrp(g4.getRegno4());
						     
	                         int thir = gd.removegroup(student.getRegno()); 					     
						     
						     
						     int fort = gd.deletegroup4(g4.getLeader());
						     
	                         System.out.println(one +" "+two +" "+three +" "+four +" " +five +" "+six +" "+sev +" "+eight +" "+nine +" "+ten +" "+ele +" "+twel +" "+thir +" "+fort +" ");
						    
						     
					    }					

						
					}
					
				}
				session.setAttribute("successbooking", "Booking was successful!");
				System.out.println("success");
				response.sendRedirect("home.jsp");
			   break;
			}
			
			
		    break;
		case "book bed":
			String bedids = request.getParameter("bedid");
			int bedid = Integer.parseInt(bedids);
			System.out.println(bedid);
			Student student2 = (Student)session.getAttribute("student");
			int bookedroom2 = in.bookbed(student2,bedid);
			System.out.println(bookedroom2);
			switch(bookedroom2) {
			case 0:
				session.setAttribute("failurebooking", "Booking was unsuccessful!");
				System.out.println("Failure");
				response.sendRedirect("home.jsp");
				break;
			default:
				session.setAttribute("successbooking", "Booking was successful!");
				System.out.println("success");
				response.sendRedirect("home.jsp");
				break;
			
			}
			
			break;
		case "confirm":
		
		int bedidnumber = (Integer)session.getAttribute("bedid");
		String regnumber= in.checkbookedstudent(bedidnumber);
		int unbook = in.unbook(bedidnumber, regnumber);
		if(unbook==1) {
			session.setAttribute("successunbooking", "UnBooking was successful!");
			System.out.println("success");
			response.sendRedirect("RoomView.jsp");
		}else {
			session.setAttribute("failureunbooking", "UnBooking was unsuccessful!");
			System.out.println("Failure");
			response.sendRedirect("BedView.jsp");
		}
			break;
		default:
			response.sendRedirect("home.jsp");
			break;
		}
		

		
		
		
		
	}

}
