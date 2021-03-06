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
		ps = conn1.prepareStatement("insert into bookstatus (fromdate, todate, status, year)values(?,?,?,?)");
		ps.setString(1, b.getFrom());	
		ps.setString(2, b.getTo());
		ps.setString(3, b.getStatus());
		ps.setString(4, b.getYear());
		
		status = ps.executeUpdate();
		
		conn1.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into bookstatus table");
		}
		
		return status;
	}

	@Override
	public String checkBookStatus() {
		
		String status = "";
		
		try {
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select status from bookstatus ORDER BY id DESC LIMIT 1");

		  
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 status = rs.getString("status");
				 
				 System.out.println("checkbookstatus has returned "+status);
					
	
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in checking book status");
				}
		return status ;
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
				b.setId(rs.getInt(1));
				b.setFrom(rs.getString(2));
				b.setTo(rs.getString(3));
				b.setStatus(rs.getString(4));
				b.setYear(rs.getString(5));
					
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
	public String getToDate() {
        String to ="";

		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select todate from bookstatus ORDER BY id DESC LIMIT 1");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				 to= rs.getString("todate");
				 
				 System.out.println("gettodate in bookstatus has returned "+to);
					
	
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting deadline date from bookstatus");
				}
				
		return to;
	}

}
