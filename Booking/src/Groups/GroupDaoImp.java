package Groups;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Login.ConnectionProvider;


public class GroupDaoImp implements GroupDao {
	static Connection conn1;
	static PreparedStatement ps;

	@Override
	public int insertGroup(Group g) {
     int status = 0;
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into groupstatus (fromdate, todate, status)values(?,?,?)");
		ps.setString(1, g.getFrom());	
		ps.setString(2, g.getTo());
		ps.setString(3, g.getStatus());
		
		status = ps.executeUpdate();
		
		conn1.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into group table");
		}
		
		return status;
	}

	@Override
	public boolean checkGroup(String status) {
		try {
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("SELECT * from groupstatus WHERE status=?");
			ps.setString(1, status);
		  
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			return true;	
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in checking group status");
				}
		return false ;
	}

	@Override
	public Group getGroup(String status) {
		Group g = new Group();
		
		
		
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
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting Group data");
				}
				
				return g;
	}

	@Override
	public boolean closeGroup() {
		boolean flag = false; 
		String close = "NO";
		String open ="YES";
        try{  
        	conn1 = ConnectionProvider.getconn();  
            PreparedStatement ps=conn1.prepareStatement("update groupstatus set status=? where status=?");  
            
            ps.setString(1,close); 
            ps.setString(2,open);
           
            
              
            ps.executeUpdate(); 
          

            flag = true;
              
            
        }catch(Exception e){
        	System.out.println(e);
            System.out.println("there is an exception in closing group");
        	
        	}  
          
        return flag; 
	}

	@Override
	public boolean checkGroup(String from, String to) {
		try {
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("SELECT * from groupstatus WHERE fromdate=? and todate=?");
			ps.setString(1, from);
			ps.setString(2, to); 
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			return true;	
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in checking group dates");
				}
		return false ;
	}

	@Override
	public String getToDate(String status) {
		
		String to ="";
		
        Group g = new Group();
		
		
		
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
					System.out.println("there is an exception in getting deadline date");
				}
				
		return to;
	}

}
