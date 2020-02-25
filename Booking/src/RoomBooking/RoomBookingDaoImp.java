package RoomBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Login.ConnectionProvider;

public class RoomBookingDaoImp implements RoomBookingDao {

	static Connection conn1;
	static PreparedStatement ps;
	
	@Override
	public int insertBookingStatus(BookStatus b) {
int status = 0;
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into bookstatus (fromdate, todate, status)values(?,?,?)");
		ps.setString(1, b.getFrom());	
		ps.setString(2, b.getTo());
		ps.setString(3, b.getStatus());
		
		status = ps.executeUpdate();
		
		conn1.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into bookstatus table");
		}
		
		return status;
	}

	@Override
	public boolean checkBookStatus(String status) {
		try {
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("SELECT * from bookstatus WHERE status=?");
			ps.setString(1, status);
		  
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			return true;	
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in checking book status");
				}
		return false ;
	}

	@Override
	public boolean checkBookStatus(String from, String to) {
		try {
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("SELECT * from bookstatus WHERE fromdate=? and todate=?");
			ps.setString(1, from);
			ps.setString(2, to); 
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			return true;	
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in checking book dates");
				}
		return false ;
	}

	@Override
	public BookStatus getBookStatus(String status) {
       BookStatus b = new BookStatus();
		
		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from bookstatus where status=?");
			ps.setString(1, status);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				b.setFrom(rs.getString(1));
				b.setTo(rs.getString(2));
				b.setStatus(rs.getString(3));
					
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting bookstatus data");
				}
				
				return b;
	}

	@Override
	public boolean closeBookStatus() {
		boolean flag = false; 
		String close = "NO";
		String open ="YES";
        try{  
        	conn1 = ConnectionProvider.getconn();  
            PreparedStatement ps=conn1.prepareStatement("update bookstatus set status=? where status=?");  
            
            ps.setString(1,close); 
            ps.setString(2,open);
           
            
              
            ps.executeUpdate(); 
          

            flag = true;
              
            
        }catch(Exception e){
        	System.out.println(e);
            System.out.println("there is an exception in closing bookstatus");
        	
        	}  
          
        return flag; 
	}

	@Override
	public String getToDate(String status) {
        String to ="";
		
        BookStatus g = new BookStatus();
		
		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from groupstatus where status=?");
			ps.setString(1, status);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				g.setFrom(rs.getString(1));
				g.setTo(rs.getString(2));
				g.setStatus(rs.getString(3));
					
			}
			
			to = g.getTo();
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting deadline date from bookstatus");
				}
				
		return to;
	}

}
