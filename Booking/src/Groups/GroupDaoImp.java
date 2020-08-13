package Groups;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Login.ConnectionProvider;
import Login.Student;


public class GroupDaoImp implements GroupDao {
	static Connection conn1;
	static PreparedStatement ps;

	@Override
	public int insertGroup(Group g) {
     int status = 0;
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into groupstatus (fromdate, todate, status, year)values(?,?,?,?)");
		ps.setString(1, g.getFrom());	
		ps.setString(2, g.getTo());
		ps.setString(3, g.getStatus());
		ps.setString(4, g.getYear());
		
		status = ps.executeUpdate();
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into group table");
		}
		
		return status;
	}

	@Override
	public String  checkGroupstates() {
		

	

			String status = "";
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select status from groupstatus ORDER BY id DESC LIMIT 1");
		
				
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
	
				 status = rs.getString("status");
				 
				 System.out.println("checkgroupstates has returned " +status);
					
				 conn1.close();
				 ps.close();
				 
				  }
					
				
					
			
				
				

				
				
					}catch(Exception e){
					
						System.out.println(e);
						System.out.println("there is an exception in checking for an open group");
					}
			
			
					
			return status;
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
				g.setId(rs.getInt(1));
				g.setFrom(rs.getString(2));
				g.setTo(rs.getString(3));
				g.setStatus(rs.getString(4));
				g.setYear(rs.getString(5));
					
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
	public boolean checkGroupdates(String from, String to) {
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
	public String getToDate() {
		
		String to ="";
			
		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select todate from groupstatus ORDER BY id DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {

			 to = rs.getString("todate");
			 
			 System.out.println("gettodate in groupstatus has returned " +to);
				
			 conn1.close();
			 ps.close();
			 
			  }
			
			
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting deadline date");
				}
				
		return to;
	}

	@Override
	public int insertgroups(groups g) {
    int status = 0;
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into groups (groupname, NoOfMembers, leader)values(?,?,?)");
		ps.setString(1, g.getGroupname());	
		ps.setString(2, g.getNoOfMembers());
		ps.setString(3, g.getLeader());

		
		status = ps.executeUpdate();
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into groups table");
		}
		
		return status;
	}

	@Override
	public String getLeader(String leader) {
      String regno=null;
      
		
		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select groupname from groups where leader=?");
			ps.setString(1, leader);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			regno = rs.getString("groupname");		
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting leader from groups table");
				}
				
				return regno;
	}

	@Override
	public Student getRegno(String leader) {
	    Student s = new Student();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from students where regno=?");
				ps.setString(1, leader);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				s.setName(rs.getString(1)); 
				s.setRegno(rs.getString(2));
				s.setFaculty(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setDepartment(rs.getString(5));
				s.setYear(rs.getString(6));
				s.setEmail(rs.getString(7));
				s.setRecoveryemail(rs.getString(8));
				s.setStatus(rs.getString(10));
				s.setGrp(rs.getString(11));
				s.setReg(rs.getString(12));
				
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in checking for student from students table");
					}
					
					return s;
	}

	@Override
	public int pendingStudent(String regno) {
		int c=0; 
		String status = "P";
		 
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students  set status=? where regno=?");
			ps.setString(1, status);	
			ps.setString(2,regno);

			
			c = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in pending student status in students table");
			}
			
			return c;
	}

	@Override
	public int confirmedStudent(String regno) {
		int c=0; 
		String status = "C";
		 
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students  set status=? where regno=?");
			ps.setString(1, status);	
			ps.setString(2,regno);

			
			c = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in confirming student status as confirmed in students table");
			}
			
			return c;
	}

	@Override
	public int checkgroups(String leader) {
		int c=0; 
		String checked = "YES";
		 
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update groups  set checked=? where leader=?");
			ps.setString(1, checked);	
			ps.setString(2,leader);

			
			c = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in checking groups table");
			}
			
			return c;
	}

	@Override
	public groups getgroup(String leader) {
       groups g = new groups();
		
		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from groups where leader=?");
			ps.setString(1, leader);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				g.setGroupid(rs.getInt(1));
				g.setGroupname(rs.getString(2));
				g.setNoOfMembers(rs.getString(3));
				g.setLeader(rs.getString(4));
				g.setMessage(rs.getString(5));
				g.setChecked(rs.getString(6));
					
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting group from groups table");
				}
				
				return g;
	}

	@Override
	public int insertgroup2(group2 g) {
     int status = 0;
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into group2 (groupid, leader, regno2)values(?,?,?)");
		ps.setInt(1, g.getGroupid());	
		ps.setString(2, g.getLeader());
		ps.setString(3, g.getRegno2());

		
		status = ps.executeUpdate();
		System.out.println("successfully inserted into group2");
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into group2 table");
		}
		
		return status;
	}

	@Override
	public int confirmedLeader(String regno) {
		int c=0; 
		String status = "L";
		 
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students  set status=? where regno=?");
			ps.setString(1, status);	
			ps.setString(2,regno);

			
			c = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in confirming student status as leader in students table");
			}
			
			return c;
	}

	@Override
	public String getstudentstatus(String regno) {
    String status=null;
      
		
		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select status from students where regno=?");
			ps.setString(1, regno);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
			status = rs.getString("status");		
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting student status from students table");
				}
				
				return status;
	}

	@Override
	public group2 getgroup2(String leader) {
      group2 g = new group2();
		
		
		
		try {
			
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from group2 where leader=?");
			ps.setString(1, leader);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				g.setId(rs.getInt(1));
				g.setGroupid(rs.getInt(2));
				g.setLeader(rs.getString(3));
				g.setRegno2(rs.getString(4));				
			}
			
			
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting group using leader from group2 table");
				}
				
				return g;
	}

	@Override
	public group2 student2(String regno2) {
	      group2 g = new group2();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group2 where regno2=?");
				ps.setString(1, regno2);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));				
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using regno2 from group2 table");
					}
					
					return g;
	}

	@Override
	public int insertgroup3(group3 g) {
	     int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into group3 (groupid, leader, regno2, regno3)values(?,?,?,?)");
			ps.setInt(1, g.getGroupid());	
			ps.setString(2, g.getLeader());
			ps.setString(3, g.getRegno2());
			ps.setString(4,g.getRegno3());

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into group3 table");
			}
			
			return status;
	}

	@Override
	public int insertgroup4(group4 g) {
	     int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into group4 (groupid, leader, regno2, regno3, regno4)values(?,?,?,?,?)");
			ps.setInt(1, g.getGroupid());	
			ps.setString(2, g.getLeader());
			ps.setString(3, g.getRegno2());
			ps.setString(4, g.getRegno3());
			ps.setString(5, g.getRegno4());

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into group4 table");
			}
			
			return status;
	}

	@Override
	public group3 getgroup3(String leader) {
	      group3 g = new group3();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group3 where leader=?");
				ps.setString(1, leader);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));
					g.setRegno3(rs.getString(5));
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using leader from group3 table");
					}
					
					return g;
	}

	@Override
	public group3 group3student2(String regno2) {
	      group3 g = new group3();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group3 where regno2=?");
				ps.setString(1, regno2);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));
					g.setRegno3(rs.getString(5));
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using regno2 from group3 table");
					}
					
					return g;
	}

	@Override
	public group3 group3student3(String regno3) {
	      group3 g = new group3();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group3 where regno3=?");
				ps.setString(1, regno3);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));
					g.setRegno3(rs.getString(5));
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using regno3 from group3 table");
					}
					
					return g;
	}

	@Override
	public group4 getgroup4(String leader) {
	      group4 g = new group4();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group4 where leader=?");
				ps.setString(1, leader);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));
					g.setRegno3(rs.getString(5));
					g.setRegno4(rs.getString(6));
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using leader from group4 table");
					}
					
					return g;
	}

	@Override
	public group4 group4student2(String regno2) {
	      group4 g = new group4();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group4 where regno2=?");
				ps.setString(1, regno2);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));
					g.setRegno3(rs.getString(5));
					g.setRegno4(rs.getString(6));
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using reno2 from group4 table");
					}
					
					return g;
	}

	@Override
	public group4 group4student3(String regno3) {
	      group4 g = new group4();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group4 where regno3=?");
				ps.setString(1, regno3);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));
					g.setRegno3(rs.getString(5));
					g.setRegno4(rs.getString(6));
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using regno3 from group4 table");
					}
					
					return g;
	}

	@Override
	public group4 group4student4(String regno4) {
	      group4 g = new group4();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from group4 where regno4=?");
				ps.setString(1, regno4);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setId(rs.getInt(1));
					g.setGroupid(rs.getInt(2));
					g.setLeader(rs.getString(3));
					g.setRegno2(rs.getString(4));
					g.setRegno3(rs.getString(5));
					g.setRegno4(rs.getString(6));
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group using regno4 from group4 table");
					}
					
					return g;
	}

	@Override
	public int removegroup(String leader) {
	     int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("delete from groups where leader=?");
			ps.setString(1, leader);	


			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in deleleting data into groups table");
			}
			
			return status;
	}

	@Override
	public String getgrpname(String regno,String grp,String reg) {
		String name = null;
      if(grp.equals("2")) {
    	  if(reg.equals("0")) {
        	  group2 g = getgroup2(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }else if(reg.equals("1")) {
        	  group2 g = student2(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }

      }else if(grp.equals("3")) {
    	  if(reg.equals("0")) {
        	  group3 g = getgroup3(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }else if(reg.equals("1")) {
        	  group3 g = group3student2(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }else if(reg.equals("2")) {
        	  group3 g = group3student3(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }

      }else if(grp.equals("4")) {
    	  if(reg.equals("0")) {
        	  group4 g = getgroup4(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }else if(reg.equals("1")) {
        	  group4 g = group4student2(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }else if(reg.equals("2")) {
        	  group4 g = group4student3(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }else if(reg.equals("3")) {
        	  group4 g = group4student4(regno);
        	  String leader = g.getLeader();
        	  groups h = getgroup(leader);
        	  name = h.getGroupname();
    	  }

      }
      
      
      
      return name;
	}

	@Override
	public int editmessage(String leader, String message) {
		int c=0; 
	
		 
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update groups  set Message=? where leader=?");
			ps.setString(1, message);	
			ps.setString(2,leader);

			
			c = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in Editing message in groups table");
			}
			
			return c;
	}

	@Override
	public int deletegroup2(String leader) {
	     int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("delete from group2 where leader=?");
			ps.setString(1, leader);	


			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in deleleting data from group2 table");
			}
			
			return status;
	}

	@Override
	public int deletegroup3(String leader) {
	     int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("delete from group3 where leader=?");
			ps.setString(1, leader);	


			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in deleleting data from group3 table");
			}
			
			return status;
	}

	@Override
	public int deletegroup4(String leader) {
	     int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("delete from group4 where leader=?");
			ps.setString(1, leader);	


			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in deleleting data from group4 table");
			}
			
			return status;
	}

	@Override
	public int deletestatus(String regno) {
	     int status = 0;
			String n ="S";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set status=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in deleleting data status column in students table");
			}
			
			return status;
	}
	@Override
	public int reg1(String regno) {
	     int status = 0;
			String n ="0";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set reg=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting reg1 into reg column");
			}
			
			return status;
	}
	@Override
	public int reg2(String regno) {
	     int status = 0;
			String n ="1";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set reg=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting reg2 into reg column");
			}
			
			return status;
	}
	

	@Override
	public int reg3(String regno) {
	     int status = 0;
			String n ="2";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set reg=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting reg3 into reg column");
			}
			
			return status;
	}

	@Override
	public int reg4(String regno) {
	     int status = 0;
			String n ="3";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set reg=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting reg4 into reg column");
			}
			
			return status;
	}

	@Override
	public int deletereg(String regno) {
	
		     int status = 0;
				String n ="NULL";
				try {
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("update students set reg=? where regno=?");
				ps.setString(1, n);	
				ps.setString(2, regno);

				
				status = ps.executeUpdate();
				
				conn1.close();
				ps.close();
					
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in deleting data from reg table");
				}
				
				return status;
		}


	@Override
	public int grp2(String regno) {
	     int status = 0;
			String n ="2";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set grp=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting grp2 into grp column");
			}
			
			return status;
	}

	@Override
	public int grp3(String regno) {
	     int status = 0;
			String n ="3";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set grp=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting grp3 into grp column");
			}
			
			return status;
	}

	@Override
	public int grp4(String regno) {
	     int status = 0;
			String n ="4";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set grp=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting grp4 into grp column");
			}
			
			return status;
	}

	@Override
	public int deletegrp(String regno) {
	     int status = 0;
			String n ="NULL";
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students set grp=? where regno=?");
			ps.setString(1, n);	
			ps.setString(2, regno);

			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in deleting  grp column");
			}
			
			return status;
	}

	@Override
	public String checkgrpname(String name) {
	      String grpname=null;
	      
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select groupname from groups where groupname=?");
				ps.setString(1, name);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
				grpname = rs.getString("groupname");		
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting groupname from groups table");
					}
					
					return grpname;
	}

	@Override
	public groups group(int gid) {
	       groups g = new groups();
			
			
			
			try {
				
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from groups where groupid=?");
				ps.setInt(1, gid);
				
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					g.setGroupid(rs.getInt(1));
					g.setGroupname(rs.getString(2));
					g.setNoOfMembers(rs.getString(3));
					g.setLeader(rs.getString(4));
					g.setMessage(rs.getString(5));
					g.setChecked(rs.getString(6));
						
				}
				
				
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting group from groups table");
					}
					
					return g;
	}

	@Override
	public int declineStudent(String regno) {
		int c=0; 
		String status = "D";
		 
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students  set status=? where regno=?");
			ps.setString(1, status);	
			ps.setString(2,regno);

			
			c = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception inserting decline status in students table");
			}
			
			return c;
	}

	@Override
	public int declineLeader(String regno) {
		int c=0; 
		String status = "U";
		 
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("update students  set status=? where regno=?");
			ps.setString(1, status);	
			ps.setString(2,regno);

			
			c = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception inserting unsuccessful status in students table");
			}
			
			return c;
	}



}
