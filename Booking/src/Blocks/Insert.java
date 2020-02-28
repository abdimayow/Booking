package Blocks;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		insertDao in = new InsertDaoImp();
		

		for(int i =1;i<65;i++) {
			Room m = new Room();
			m.setHostelid(1);
			m.setHostelname("Amboseli");
			m.setRoomnumber(i);
			int one  = in.insertRoom(m);	
		}



		
		
		
		

		
		response.sendRedirect("insertroom.jsp");
		
		
		
		
		
		
	}

}
