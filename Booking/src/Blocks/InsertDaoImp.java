package Blocks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;

import Groups.GroupDao;
import Groups.GroupDaoImp;
import Groups.group2;
import Groups.group3;
import Groups.group4;
import Login.ConnectionProvider;
import Login.Student;


public class InsertDaoImp implements insertDao {

	static Connection conn1;
	static PreparedStatement ps;
	
	
	@Override
	public int insertRoom(Room n) {
		 int status = 0;

		 System.out.println(n.getHostelid());
		 System.out.println(n.getRoomno());
		 System.out.println(n.getType());
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into rooms (hostelid, roomno, type) values(?,?,?)");
			
			ps.setInt(1, n.getHostelid());
			ps.setInt(2, n.getRoomno());
			ps.setString(3, n.getType());
			
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into rooms table");
			}
			
			return status;
	}

	@Override
	public int insertHostel(Hostel n) {
		 int status = 0;
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into hostels (hostelname, NoOfRooms, NoOfSingleRooms, NoOfDoubleRooms, NoOfTripleRooms, NoOfQuadRooms, NoOfSextupleRooms)values(?,?,?,?,?,?,?)");
			ps.setString(1, n.getHostelname());
			ps.setString(2, n.getNoOfRooms());
			ps.setString(3, n.getNoOfSingleRooms());
			ps.setString(4, n.getNoOfDoubleRooms());
			ps.setString(5, n.getNoOfTripleRooms());
			ps.setString(6, n.getNoOfQuadRooms());
			ps.setString(7, n.getNoOfSextupleRooms());
			
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into hostels table");
			}
			
			return status;
	}

	@Override
	public Hostel getHostel(int hostelid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRoom(int roomid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRooms(int roomnumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRooms2(String hostelnumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels(String Single) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels2(String Double) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels3(String Triple) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hostel getHostels4(String Quad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBlocks(Blocks b) {
		 int status = 0;

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into blocks (blockname)values(?)");
			ps.setString(1, b.getBlockname());	

			
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into blocks table");
			}
			
			return status;
	}

	@Override
	public ArrayList<Blocks> getBlocks() {
		ArrayList <Blocks> b = new ArrayList<Blocks>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from blocks");
		

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Blocks c = new Blocks();
			c.setBlockid(rs.getInt(1));
			c.setBlockname(rs.getString(2));
	
			
			b.add(c);
		}
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting blocks from blocks table");
		}
		
	
		return b;
	}

	@Override
	public ArrayList<Hostel> getHostels() {
     ArrayList<Hostel> h = new ArrayList<Hostel>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from hostels");
		

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Hostel i = new Hostel();
			i.setHostelid(rs.getInt(1));
			i.setHostelname(rs.getString(2));
			i.setNoOfRooms(rs.getString(3));
			i.setNoOfSingleRooms(rs.getString(4));
			i.setNoOfDoubleRooms(rs.getString(5));
			i.setNoOfTripleRooms(rs.getString(6));
			i.setNoOfQuadRooms(rs.getString(7));
			i.setNoOfSextupleRooms(rs.getString(8));
	
			
			h.add(i);
		}
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting hostels from hostels table");
		}
		
	
		return h;
	}

	@Override
	public int insertBlock(Block b) {
		int status = 0;

		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("insert into block (blockid, hostelid)values(?,?)");
		ps.setInt(1, b.getBlockid());	
		ps.setInt(2, b.getHostelid());

		

		status = ps.executeUpdate();
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in inserting data into block table");
		}
		
		return status;
	}

	@Override
	public int checkBlock(int hostelid) {
		 int status = 0;

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select blockid from block where hostelid=?");
			ps.setInt(1, hostelid);	

			
	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
	    			
	       status = rs.getInt("blockid");
			}else {
				status = 0;
			}
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in checking  blocks table");
			}
			
			return status;
	}

	@Override
	public String getHostelname(int hostelid) {
		 String status = "";

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select hostelname from hostels where hostelid=?");
			ps.setInt(1, hostelid);	

			
	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
	    			
	       status = rs.getString("hostelname");
			}else {
				status = "No Hostel found";
			}
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in getting hostelname from hostels table");
			}
			
			return status;
	}

	@Override
	public ArrayList<Room> getRooms() {
ArrayList<Room> h = new ArrayList<Room>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from rooms");
		

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			
			Room i = new Room();
			i.setRoomid(rs.getInt(1));
			i.setHostelid(rs.getInt(2));
			i.setRoomno(rs.getInt(3));
			i.setType(rs.getString(4));
	
	
			
			h.add(i);
		}
		
		conn1.close();
		ps.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting Rooms from Room table");
		}
		
	
		return h;
	}

	@Override
	public int insertBed(Bed b) {
		 int status = 0;

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("insert into bed (roomid, bedno) values(?,?)");
			
			ps.setInt(1, b.getRoomid());
			ps.setInt(2, b.getBedno());
			
			
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in inserting data into bed table");
			}
			
			return status;
	}

	@Override
	public int deleteBed() {
		 int status = 0;

			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("delete from bed");
			

			
			
	
			status = ps.executeUpdate();
			
			conn1.close();
			ps.close();
				
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in deleting all data from bed table");
			}
			
			return status;
	}

	@Override
	public ArrayList<Hostel> getBlockHostels(int blockid) {
		ArrayList <Block> b = new ArrayList<Block>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from block where blockid=?");
		ps.setInt(1, blockid);	

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Block c = new Block();
		 c.setBlockid(rs.getInt(1)); 
		 c.setHostelid(rs.getInt(2));
           
	
			
			b.add(c);
		}
		
		conn1.close();
		ps.close();
		
        
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting hostels from hostels table");
				}
		ArrayList<Hostel> h = new ArrayList<Hostel>();
		
		
		for(int j=0;j<b.size();j++) {
			
			Block c = b.get(j); 
			try {
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from hostels where hostelid=?");
				ps.setInt(1,c.getHostelid() );

				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Hostel i = new Hostel();
					i.setHostelid(rs.getInt(1));
					i.setHostelname(rs.getString(2));
					i.setNoOfRooms(rs.getString(3));
					i.setNoOfSingleRooms(rs.getString(4));
					i.setNoOfDoubleRooms(rs.getString(5));
					i.setNoOfTripleRooms(rs.getString(6));
					i.setNoOfQuadRooms(rs.getString(7));
					i.setNoOfSextupleRooms(rs.getString(8));
			
					
					h.add(i);
				}
				
				conn1.close();
				ps.close();
					
		
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting hostelid from block table");
		}
		
	
		
		
		
		     
				}


				
				
			
				return h;
		
	}

	@Override
	public ArrayList<Room> getHostelRooms(int hostelid) {
		ArrayList <Room> b = new ArrayList<Room>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from rooms where hostelid=?");
		ps.setInt(1, hostelid);	

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Room c = new Room();
		 c.setRoomid(rs.getInt(1)); 
		 c.setHostelid(rs.getInt(2));
		 c.setRoomno(rs.getInt(3));
		 c.setType(rs.getString(4));
           
	
			
			b.add(c);
		}
		
		conn1.close();
		ps.close();
		
        
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting room from rooms table");
				}
		
	
		
		
		
		     
		


				
				
			
				return b;
	}

	@Override
	public ArrayList<Bed> getRoomBeds(int roomid) {
		ArrayList <Bed> b = new ArrayList<Bed>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from bed where roomid=?");
		ps.setInt(1, roomid);	

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Bed c = new Bed();
		 c.setBedid(rs.getInt(1)); 
		 c.setRoomid(rs.getInt(2));
		 c.setBedno(rs.getInt(3));
		 c.setStatus(rs.getString(4));
           
	
			
			b.add(c);
		}
		
		conn1.close();
		ps.close();
		
        
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting Bed from bed table");
				}
		
	
		
		
		
		     
		


				
				
			
				return b;
	}

	@Override
	public ArrayList<Blocks> getVacantBlocks(Student stu) {
		ArrayList <Blocks> vacantblocks = new ArrayList<Blocks>();
		
		
		
		
		ArrayList <Bed> vacantbeds = new ArrayList<Bed>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from bed where status=?");
		ps.setString(1, "VACANT");	

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Bed d = new Bed();
		 d.setBedid(rs.getInt(1)); 
		 d.setRoomid(rs.getInt(2));
		 d.setBedno(rs.getInt(3));
		 d.setStatus(rs.getString(4));
           
	
			
			vacantbeds.add(d);
		}
		
		conn1.close();
		ps.close();
		
        
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting Bed from bed table");
				}

	

		Set<Integer> roomset = new HashSet<Integer>();
		
	    for(int i=0;i<vacantbeds.size();i++) {
	    	Bed vacantbed = vacantbeds.get(i);
            roomset.add(vacantbed.getRoomid());
	    }
	    
	    
	    
		ArrayList <Room> vacantrooms = new ArrayList<Room>();
		
        for(Integer Roomid: roomset) {
        	int roomid = Roomid;
        	 
        	
        	
        	switch(stu.getStatus()) {
        	case "L":
        		switch(stu.getGrp()) {
        		case "2":
        			try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=? and type!=?");
        				ps.setInt(1, roomid);
        				ps.setString(2, "S");

        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
        			break;
        		case "3":
try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=? and (type!=? and type!=?)");
        				ps.setInt(1, roomid);
        				ps.setString(2, "S");
        				ps.setString(3, "D");
        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
        			break;
        		case "4":
try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=? and (type=? or type=?)");
        				ps.setInt(1, roomid);
        				ps.setString(2, "Q");
        				ps.setString(3, "SE");
        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
        			break;
        		default:
        		  break;
        		
        		}

    			break;
    			default:
    	   			try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=?");
        				ps.setInt(1, roomid);	

        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
    			break;	
        	}

        	
        }
	
	    	
	    	

	  
	    

		Set<Integer> hostelset = new HashSet<Integer>();
		
	    for(int i=0;i<vacantrooms.size();i++) {
	    	Room vacantroom = vacantrooms.get(i);
            hostelset.add(vacantroom.getHostelid());
	    }
	    
	
		
		ArrayList<Hostel> vacanthostels = new ArrayList<Hostel>();
		
		
		for(Integer hs : hostelset) {
			int hostelid = hs;
			switch(stu.getGender()) {
			case "MALE":
				try {
					
					conn1 = ConnectionProvider.getconn();
					ps = conn1.prepareStatement("select * from hostels where hostelid=? and category=?");
					ps.setInt(1,hostelid );
					ps.setString(2,"MALE" );
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						Hostel i = new Hostel();
						i.setHostelid(rs.getInt(1));
						i.setHostelname(rs.getString(2));
						i.setNoOfRooms(rs.getString(3));
						i.setNoOfSingleRooms(rs.getString(4));
						i.setNoOfDoubleRooms(rs.getString(5));
						i.setNoOfTripleRooms(rs.getString(6));
						i.setNoOfQuadRooms(rs.getString(7));
						i.setNoOfSextupleRooms(rs.getString(8));
				
						
						vacanthostels.add(i);
					}
					
					conn1.close();
					ps.close();
						
			
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in getting hostels from hostel table");
			}
				break;

			default:
				try {
					
					conn1 = ConnectionProvider.getconn();
					ps = conn1.prepareStatement("select * from hostels where hostelid=? and category=?");
					ps.setInt(1,hostelid );
					ps.setString(2,"FEMALE" );
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						Hostel i = new Hostel();
						i.setHostelid(rs.getInt(1));
						i.setHostelname(rs.getString(2));
						i.setNoOfRooms(rs.getString(3));
						i.setNoOfSingleRooms(rs.getString(4));
						i.setNoOfDoubleRooms(rs.getString(5));
						i.setNoOfTripleRooms(rs.getString(6));
						i.setNoOfQuadRooms(rs.getString(7));
						i.setNoOfSextupleRooms(rs.getString(8));
				
						
						vacanthostels.add(i);
					}
					
					conn1.close();
					ps.close();
						
			
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in getting hostels from hostel table");
			}
				break;
			}
			 

		
	
			}
		ArrayList<Block> vacantblock = new ArrayList<Block>();
		
		
		
		Set<Integer> hostelset2 = new HashSet<Integer>();
		
	    for(int i=0;i<vacanthostels.size();i++) {
	    	Hostel vacanthostel = vacanthostels.get(i);
            hostelset2.add(vacanthostel.getHostelid());
	    }
	    

		
		for(Integer ht : hostelset2) {
			
			int hostelid = ht; 
			

			try {
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from block where hostelid=?");
				ps.setInt(1,hostelid);	

				

				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
				Block c = new Block();
				 c.setBlockid(rs.getInt(1)); 
				 c.setHostelid(rs.getInt(2));
		           
			
					
					vacantblock.add(c);
				}
				
				conn1.close();
				ps.close();
				
		        
						}catch(Exception e){
							System.out.println(e);
							System.out.println("there is an exception in getting vacant block  from block table");
						}
		}
		

	    
		Set<Integer> blockset = new HashSet<Integer>();
		
	    for(int i=0;i<vacantblock.size();i++) {
	    	Block vacntblock = vacantblock.get(i);
            blockset.add(vacntblock.getBlockid());
	    }
	    

	
	    for(Integer bl: blockset) {
	    	int blockid = bl;
	  
			switch(stu.getFaculty()) {
			
			case "ENGINEERING":
				try {
					
					conn1 = ConnectionProvider.getconn();
					ps = conn1.prepareStatement("select * from blocks where blockid=? and category=?");
					ps.setInt(1, blockid);	
					ps.setString(2, "ENGINEERING");
					

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Blocks c = new Blocks();
					 c.setBlockid(rs.getInt(1)); 
					 c.setBlockname(rs.getString(2));
					 c.setCategory(rs.getString(3));
			           
				
						
						vacantblocks.add(c);
					}
					
					conn1.close();
					ps.close();
					
			        
							}catch(Exception e){
								System.out.println(e);
								System.out.println("there is an exception in getting vacantblocks from blocks table");
							}
				break;
			case "HEALTH SCIENCE":
				try {
					
					conn1 = ConnectionProvider.getconn();
					ps = conn1.prepareStatement("select * from blocks where blockid=? and category=?");
					ps.setInt(1, blockid);	
					ps.setString(2, "HEALTHSCIENCE");
					

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Blocks c = new Blocks();
					 c.setBlockid(rs.getInt(1)); 
					 c.setBlockname(rs.getString(2));
					 c.setCategory(rs.getString(3));
			           
				
						
						vacantblocks.add(c);
					}
					
					conn1.close();
					ps.close();
					
			        
							}catch(Exception e){
								System.out.println(e);
								System.out.println("there is an exception in getting vacantblocks from blocks table");
							}
				break;
			default:
				try {
					
					conn1 = ConnectionProvider.getconn();
					ps = conn1.prepareStatement("select * from blocks where blockid=? and category=?");
					ps.setInt(1, blockid);	
					ps.setString(2, "NORMAL");
					

					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Blocks c = new Blocks();
					 c.setBlockid(rs.getInt(1)); 
					 c.setBlockname(rs.getString(2));
					 c.setCategory(rs.getString(3));
			           
				
						
						vacantblocks.add(c);
					}
					
					conn1.close();
					ps.close();
					
			        
							}catch(Exception e){
								System.out.println(e);
								System.out.println("there is an exception in getting vacantblocks from blocks table");
							}
				break;
			
			}

	    	
	    	
	    }
	   
		Set<Integer> blocksset = new HashSet<Integer>();
		
	    for(int i=0;i<vacantblocks.size();i++) {
	    	Blocks vacntblocks = vacantblocks.get(i);
            blocksset.add(vacntblocks.getBlockid());
	    }
	 

		return vacantblocks;
	}

	@Override
	public ArrayList<Hostel> getVacantHostels(int blockid,Student stu) {
        ArrayList <Bed> vacantbeds = new ArrayList<Bed>();
		
		
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from bed where status=?");
		ps.setString(1, "VACANT");	

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Bed d = new Bed();
		 d.setBedid(rs.getInt(1)); 
		 d.setRoomid(rs.getInt(2));
		 d.setBedno(rs.getInt(3));
		 d.setStatus(rs.getString(4));
           
	
			
			vacantbeds.add(d);
		}
		
		conn1.close();
		ps.close();
		
        
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting Bed from bed table");
				}

	

		Set<Integer> roomset = new HashSet<Integer>();
		
	    for(int i=0;i<vacantbeds.size();i++) {
	    	Bed vacantbed = vacantbeds.get(i);
            roomset.add(vacantbed.getRoomid());
	    }
	    
	    
	    
		ArrayList <Room> vacantrooms = new ArrayList<Room>();
		
        for(Integer Roomid: roomset) {
        	int roomid = Roomid;
        	 
        	
        	
        	switch(stu.getStatus()) {
        	case "L":
        		switch(stu.getGrp()) {
        		case "2":
        			try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=? and type!=?");
        				ps.setInt(1, roomid);
        				ps.setString(2, "S");

        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
        			break;
        		case "3":
try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=? and (type!=? and type!=?)");
        				ps.setInt(1, roomid);
        				ps.setString(2, "S");
        				ps.setString(3, "D");
        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
        			break;
        		case "4":
try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=? and (type=? or type=?)");
        				ps.setInt(1, roomid);
        				ps.setString(2, "Q");
        				ps.setString(3, "SE");
        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
        			break;
        		default:
        		  break;
        		
        		}

    			break;
    			default:
    	   			try {
        				
        				conn1 = ConnectionProvider.getconn();
        				ps = conn1.prepareStatement("select * from rooms where roomid=?");
        				ps.setInt(1, roomid);	

        				

        				ResultSet rs = ps.executeQuery();
        				while(rs.next()) {
        					Room e = new Room();
        				 e.setRoomid(rs.getInt(1)); 
        				 e.setHostelid(rs.getInt(2));
        				 e.setRoomno(rs.getInt(3));
        				 e.setType(rs.getString(4));
        		           
        			
        					
        				 vacantrooms.add(e);
        				}
        				
        				conn1.close();
        				ps.close();
        				
        		        
        						}catch(Exception e){
        							System.out.println(e);
        							System.out.println("there is an exception in getting room from rooms table");
        						}
    			break;	
        	}

        	
        }
	
	    	
	    	

	  
	    

		Set<Integer> hostelset = new HashSet<Integer>();
		
	    for(int i=0;i<vacantrooms.size();i++) {
	    	Room vacantroom = vacantrooms.get(i);
            hostelset.add(vacantroom.getHostelid());
	    }
	    
	
		
		ArrayList<Block> vacantblock = new ArrayList<Block>();
		
		
		for(Integer hs : hostelset) {
			int hostelid = hs;
			 
			try {
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from block where  blockid=? and hostelid=?");
				ps.setInt(1,blockid );
				ps.setInt(2,hostelid );
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Block b = new Block();
					b.setBlockid(rs.getInt(1));
					b.setHostelid(rs.getInt(2));

			
					
					vacantblock.add(b);
				}
				
				conn1.close();
				ps.close();
					
		
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception in getting block from block table");
		}
		
	
			}
		ArrayList <Hostel> vacanthostels = new ArrayList<Hostel>();
		
		for(int p=0;p<vacantblock.size();p++) {
			Block b = vacantblock.get(p);
			switch(stu.getGender()) {
			case "MALE":
				try {
					
					conn1 = ConnectionProvider.getconn();
					ps = conn1.prepareStatement("select * from hostels where hostelid=? and category=?");
					ps.setInt(1,b.getHostelid() );
					ps.setString(2,"MALE" );
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						Hostel i = new Hostel();
						i.setHostelid(rs.getInt(1));
						i.setHostelname(rs.getString(2));
						i.setNoOfRooms(rs.getString(3));
						i.setNoOfSingleRooms(rs.getString(4));
						i.setNoOfDoubleRooms(rs.getString(5));
						i.setNoOfTripleRooms(rs.getString(6));
						i.setNoOfQuadRooms(rs.getString(7));
						i.setNoOfSextupleRooms(rs.getString(8));
				
						
						vacanthostels.add(i);
					}
					
					conn1.close();
					ps.close();
						
			
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in getting hostels from hostel table");
			}
				break;

			default:
				try {
					
					conn1 = ConnectionProvider.getconn();
					ps = conn1.prepareStatement("select * from hostels where hostelid=? and category=?");
					ps.setInt(1,b.getHostelid() );
					ps.setString(2,"FEMALE" );
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						
						Hostel i = new Hostel();
						i.setHostelid(rs.getInt(1));
						i.setHostelname(rs.getString(2));
						i.setNoOfRooms(rs.getString(3));
						i.setNoOfSingleRooms(rs.getString(4));
						i.setNoOfDoubleRooms(rs.getString(5));
						i.setNoOfTripleRooms(rs.getString(6));
						i.setNoOfQuadRooms(rs.getString(7));
						i.setNoOfSextupleRooms(rs.getString(8));
				
						
						vacanthostels.add(i);
					}
					
					conn1.close();
					ps.close();
						
			
			}catch(Exception e){
				System.out.println(e);
				System.out.println("there is an exception in getting hostels from hostel table");
			}
				break;
			}
		}
		

		
	
			 

		
	
		
		
		
		return vacanthostels;
	}

	@Override
	public ArrayList<Room> getVacantRooms(int hostelid,Student stu) {
		  ArrayList <Bed> vacantbeds = new ArrayList<Bed>();
			
			
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from bed where status=?");
			ps.setString(1, "VACANT");	

			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bed d = new Bed();
			 d.setBedid(rs.getInt(1)); 
			 d.setRoomid(rs.getInt(2));
			 d.setBedno(rs.getInt(3));
			 d.setStatus(rs.getString(4));
	           
		
				
				vacantbeds.add(d);
			}
			
			conn1.close();
			ps.close();
			
	        
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting Bed from bed table");
					}

		

			Set<Integer> roomset = new HashSet<Integer>();
			
		    for(int i=0;i<vacantbeds.size();i++) {
		    	Bed vacantbed = vacantbeds.get(i);
	            roomset.add(vacantbed.getRoomid());
		    }
		    
		    
		    
			ArrayList <Room> vacantrooms = new ArrayList<Room>();
			
	        for(Integer Roomid: roomset) {
	        	int roomid = Roomid;
	        	switch(stu.getStatus()) {
	        	case "L":
	        		switch(stu.getGrp()) {
	        		case "2":
	        			try {
	        				
	        				conn1 = ConnectionProvider.getconn();
	        				ps = conn1.prepareStatement("select * from rooms where roomid=? and hostelid=? and type!=?");
	        				ps.setInt(1, roomid);
	        				ps.setInt(2, hostelid);
	        				ps.setString(3, "S");

	        				

	        				ResultSet rs = ps.executeQuery();
	        				while(rs.next()) {
	        					Room e = new Room();
	        				 e.setRoomid(rs.getInt(1)); 
	        				 e.setHostelid(rs.getInt(2));
	        				 e.setRoomno(rs.getInt(3));
	        				 e.setType(rs.getString(4));
	        		           
	        			
	        					
	        				 vacantrooms.add(e);
	        				}
	        				
	        				conn1.close();
	        				ps.close();
	        				
	        		        
	        						}catch(Exception e){
	        							System.out.println(e);
	        							System.out.println("there is an exception in getting room from rooms table");
	        						}
	        			break;
	        		case "3":
	try {
	        				
	        				conn1 = ConnectionProvider.getconn();
	        				ps = conn1.prepareStatement("select * from rooms where roomid=? and hostelid=? and  (type!=? and type!=?)");
	        				ps.setInt(1, roomid);
	        				ps.setInt(2, hostelid);
	        				ps.setString(3, "S");
	        				ps.setString(4, "D");
	        				

	        				ResultSet rs = ps.executeQuery();
	        				while(rs.next()) {
	        					Room e = new Room();
	        				 e.setRoomid(rs.getInt(1)); 
	        				 e.setHostelid(rs.getInt(2));
	        				 e.setRoomno(rs.getInt(3));
	        				 e.setType(rs.getString(4));
	        		           
	        			
	        					
	        				 vacantrooms.add(e);
	        				}
	        				
	        				conn1.close();
	        				ps.close();
	        				
	        		        
	        						}catch(Exception e){
	        							System.out.println(e);
	        							System.out.println("there is an exception in getting room from rooms table");
	        						}
	        			break;
	        		case "4":
	try {
	        				
	        				conn1 = ConnectionProvider.getconn();
	        				ps = conn1.prepareStatement("select * from rooms where roomid=? and hostelid=? and (type=? or type=?)");
	        				ps.setInt(1, roomid);
	        				ps.setInt(2, hostelid);
	        				ps.setString(3, "Q");
	        				ps.setString(4, "SE");
	        				

	        				ResultSet rs = ps.executeQuery();
	        				while(rs.next()) {
	        					Room e = new Room();
	        				 e.setRoomid(rs.getInt(1)); 
	        				 e.setHostelid(rs.getInt(2));
	        				 e.setRoomno(rs.getInt(3));
	        				 e.setType(rs.getString(4));
	        		           
	        			
	        					
	        				 vacantrooms.add(e);
	        				}
	        				
	        				conn1.close();
	        				ps.close();
	        				
	        		        
	        						}catch(Exception e){
	        							System.out.println(e);
	        							System.out.println("there is an exception in getting room from rooms table");
	        						}
	        			break;
	        		default:
	        		  break;
	        		
	        		}

	    			break;
	    			default:
	    	   			try {
	        				
	        				conn1 = ConnectionProvider.getconn();
	        				ps = conn1.prepareStatement("select * from rooms where roomid=? and hostelid=?");
	        				ps.setInt(1, roomid);	
	        				ps.setInt(2, hostelid);

	        				

	        				ResultSet rs = ps.executeQuery();
	        				while(rs.next()) {
	        					Room e = new Room();
	        				 e.setRoomid(rs.getInt(1)); 
	        				 e.setHostelid(rs.getInt(2));
	        				 e.setRoomno(rs.getInt(3));
	        				 e.setType(rs.getString(4));
	        		           
	        			
	        					
	        				 vacantrooms.add(e);
	        				}
	        				
	        				conn1.close();
	        				ps.close();
	        				
	        		        
	        						}catch(Exception e){
	        							System.out.println(e);
	        							System.out.println("there is an exception in getting room from rooms table");
	        						}
	    			break;	
	        	}
	        	
	        }
	        
		return vacantrooms;
	}

	@Override
	public ArrayList<Bed> getVacantBeds(int roomid,Student stu) {
		  ArrayList <Bed> vacantbeds = new ArrayList<Bed>();
			
			
			
			try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from bed where roomid=? and status=?");
			ps.setInt(1, roomid);
			ps.setString(2, "VACANT");	

			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bed d = new Bed();
			 d.setBedid(rs.getInt(1)); 
			 d.setRoomid(rs.getInt(2));
			 d.setBedno(rs.getInt(3));
			 d.setStatus(rs.getString(4));
	           
		
				
				vacantbeds.add(d);
			}
			
			conn1.close();
			ps.close();
			
	        
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting Bed from bed table");
					}
			switch(stu.getStatus()) {
			case "L":
				switch(stu.getGrp()) {
				case "2":
					int counter2=0;
					for(int i=0;i<vacantbeds.size();i++) {
						Bed bn = vacantbeds.get(i);
						if(bn.getStatus().equals("VACANT")) {
							counter2++;
						}
					}
					if(counter2<2) {
						vacantbeds.clear();
					}
					break;
				case "3":
					int counter3=0;
					for(int i=0;i<vacantbeds.size();i++) {
						Bed bn = vacantbeds.get(i);
						if(bn.getStatus().equals("VACANT")) {
							counter3++;
						}
					}
					if(counter3<3) {
						vacantbeds.clear();
					}
					break;
				case "4":
					int counter4=0;
					for(int i=0;i<vacantbeds.size();i++) {
						Bed bn = vacantbeds.get(i);
						if(bn.getStatus().equals("VACANT")) {
							counter4++;
						}
					}
					if(counter4<4) {
						vacantbeds.clear();
					}
					break;
				}
				break;
			default:
				int counter=0;
				for(int i=0;i<vacantbeds.size();i++) {
					Bed bn = vacantbeds.get(i);
					if(bn.getStatus().equals("VACANT")) {
						counter++;
					}
				}
				if(counter==0) {
					vacantbeds.clear();
				}
			
				break;
			}
			return vacantbeds;
			
	}

	@Override
	public int bookroom(Student stu,int roomid) {
		GroupDao gd = new GroupDaoImp();
		int num = 0;
		Boolean flag =false;
		int bed = 0;
		ArrayList <Bed> vacantbeds = new ArrayList<Bed>();
		
		System.out.println(roomid);
		
		try {
		
		conn1 = ConnectionProvider.getconn();
		ps = conn1.prepareStatement("select * from bed where roomid=? and status=?");
		ps.setInt(1, roomid);
		ps.setString(2, "VACANT");	

		

		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Bed d = new Bed();
		 d.setBedid(rs.getInt(1)); 
		 d.setRoomid(rs.getInt(2));
		 d.setBedno(rs.getInt(3));
		 d.setStatus(rs.getString(4));
           
	
			
			vacantbeds.add(d);
		}
		
		conn1.close();
		ps.close();
		
        
				}catch(Exception e){
					System.out.println(e);
					System.out.println("there is an exception in getting Bed from bed table");
				}
	
			int counter=0;
			ArrayList<Integer> bedid = new ArrayList<Integer>();
			for(int i=0;i<vacantbeds.size();i++) {
				Bed bn = vacantbeds.get(i);
				if(bn.getStatus().equals("VACANT")) {
					bedid.add(bn.getBedid());
					System.out.println(i+ bn.getBedid());
					counter++;
				}
			}

		
			
		

		
		
		if(stu.getStatus().equals("L")) {

			String grpname = gd.getgrpname(stu.getRegno(), stu.getGrp(), stu.getReg());
			System.out.println(grpname);
			if(stu.getGrp().equals("2")) {
				
		     group2 g2 = gd.getgroup2(stu.getRegno());
		    
		     
		     Student leader = gd.getRegno(g2.getLeader());
		     Student snd = gd.getRegno(g2.getRegno2());
		     
		    

		     
		     ArrayList <Student> members = new ArrayList<Student>();
		     members.add(leader);
		     members.add(snd);
		     
		     System.out.println("Counter number is "+counter);
		     if(counter>=2) {
				  LocalDate  today  = LocalDate.now();
				  LocalDate  tomorrow  = LocalDate.now().plusYears(1);
				  int stoday = today.getYear();
				  int stomorrow = tomorrow.getYear();
		          String year = stoday+"/"+stomorrow;
		    	 for(int i=0;i<2;i++) {
		    		 Student mem = members.get(i);
		    		 System.out.println(mem.getRegno());
		    		 int id = bedid.get(i);
		    		 try {
		    				
		    				conn1 = ConnectionProvider.getconn();
		    				ps = conn1.prepareStatement("insert into booked (regno, bedid, year) values(?,?,?)");
		    				
		    				ps.setString(1, mem.getRegno());
		    				ps.setInt(2, id);
		    				ps.setString(3, year);
		    				
		    		
		    				bed = ps.executeUpdate();
		    				
		    				conn1.close();
		    				ps.close();
		    					
		    				}catch(Exception e){
		    					System.out.println(e);
		    					System.out.println("there is an exception in inserting data into booked table");
		    				}
		    			try{  
		    	        	conn1 = ConnectionProvider.getconn();  
		    	            PreparedStatement ps=conn1.prepareStatement("update bed set status=? where bedid=?");  
		    	            
		    	            ps.setString(1,"BOOKED"); 
		    	            ps.setInt(2,id);
		    	           
		    	            
		    	              
		    	            ps.executeUpdate(); 
		    	          

		    	            flag = true;
		    	              
		    	            
		    	        }catch(Exception e){
		    	        	System.out.println(e);
		    	            System.out.println("there is an exception in updating bed");
		    	        	
		    	        	}
		    		 
		    	 }
		     }
		     
		     
				
			}
			if(stu.getGrp().equals("3")) {
			
				
			     group3 g3 = gd.getgroup3(stu.getRegno());
			     	
			     
			     Student leader = gd.getRegno(g3.getLeader());
			     Student snd = gd.getRegno(g3.getRegno2());
			     Student trd = gd.getRegno(g3.getRegno3());

			     
			     
			     ArrayList <Student> members = new ArrayList<Student>();
			     members.add(leader);
			     members.add(snd);
			     members.add(trd);
			     
			     if(counter>=3) {
					  LocalDate  today  = LocalDate.now();
					  LocalDate  tomorrow  = LocalDate.now().plusYears(1);
					  int stoday = today.getYear();
					  int stomorrow = tomorrow.getYear();
			          String year = stoday+"/"+stomorrow;
			    	 for(int i=0;i<3;i++) {
			    		 Student mem = members.get(i);
			    		 int id = bedid.get(i);
			    		 try {
			    				
			    				conn1 = ConnectionProvider.getconn();
			    				ps = conn1.prepareStatement("insert into booked (regno, bedid, year) values(?,?,?)");
			    				
			    				ps.setString(1, mem.getRegno());
			    				ps.setInt(2, id);
			    				ps.setString(3, year);
			    				
			    		
			    				bed = ps.executeUpdate();
			    				
			    				conn1.close();
			    				ps.close();
			    					
			    				}catch(Exception e){
			    					System.out.println(e);
			    					System.out.println("there is an exception in inserting data into booked table");
			    				}
			    			try{  
			    	        	conn1 = ConnectionProvider.getconn();  
			    	            PreparedStatement ps=conn1.prepareStatement("update bed set status=? where bedid=?");  
			    	            
			    	            ps.setString(1,"BOOKED"); 
			    	            ps.setInt(2,id);
			    	           
			    	            
			    	              
			    	            ps.executeUpdate(); 
			    	          

			    	            flag = true;
			    	              
			    	            
			    	        }catch(Exception e){
			    	        	System.out.println(e);
			    	            System.out.println("there is an exception in updating bed");
			    	        	
			    	        	}
			    	 }
			     }
			     
				
			}
			if(stu.getGrp().equals("4")) {
				
			     group4 g4 = gd.getgroup4(stu.getRegno());
			     
			     
			     Student leader = gd.getRegno(g4.getLeader());
			     Student snd = gd.getRegno(g4.getRegno2());
			     Student trd = gd.getRegno(g4.getRegno3());
			     Student frt = gd.getRegno(g4.getRegno4());
			    

			     
			     ArrayList <Student> members = new ArrayList<Student>();
			     members.add(leader);
			     members.add(snd);
			     members.add(trd);
			     members.add(frt);
			   
			     if(counter>=4) {
					  LocalDate  today  = LocalDate.now();
					  LocalDate  tomorrow  = LocalDate.now().plusYears(1);
					  int stoday = today.getYear();
					  int stomorrow = tomorrow.getYear();
			          String year = stoday+"/"+stomorrow;
			    	 for(int i=0;i<4;i++) {
			    		 Student mem = members.get(i);
			    		 int id = bedid.get(i);
			    		 try {
			    				
			    				conn1 = ConnectionProvider.getconn();
			    				ps = conn1.prepareStatement("insert into booked (regno, bedid, year) values(?,?,?)");
			    				
			    				ps.setString(1, mem.getRegno());
			    				ps.setInt(2, id);
			    				ps.setString(3, year);
			    				
			    		
			    				bed = ps.executeUpdate();
			    				
			    				conn1.close();
			    				ps.close();
			    					
			    				}catch(Exception e){
			    					System.out.println(e);
			    					System.out.println("there is an exception in inserting data into booked table");
			    				}
			    			try{  
			    	        	conn1 = ConnectionProvider.getconn();  
			    	            PreparedStatement ps=conn1.prepareStatement("update bed set status=? where bedid=?");  
			    	            
			    	            ps.setString(1,"BOOKED"); 
			    	            ps.setInt(2,id);
			    	           
			    	            
			    	              
			    	            ps.executeUpdate(); 
			    	          

			    	            flag = true;
			    	              
			    	            
			    	        }catch(Exception e){
			    	        	System.out.println(e);
			    	            System.out.println("there is an exception in updating bed");
			    	        	
			    	        	}

			    	 }
			     }
				
			}
			
		}
		if(flag == true && bed ==1) {
			num = 1;
		}
		
		return num;
	}

	@Override
	public int bookbed(Student stu,int bedid) {
		int num = 0;
		Boolean flag =false;
		int bed = 0;
		
		 LocalDate  today  = LocalDate.now();
		  LocalDate  tomorrow  = LocalDate.now().plusYears(1);
		  int stoday = today.getYear();
		  int stomorrow = tomorrow.getYear();
         String year = stoday+"/"+stomorrow;
   

   		 try {
   				
   				conn1 = ConnectionProvider.getconn();
   				ps = conn1.prepareStatement("insert into booked (regno, bedid, year) values(?,?,?)");
   				
   				ps.setString(1, stu.getRegno());
   				ps.setInt(2, bedid);
   				ps.setString(3, year);
   				
   		
   				bed = ps.executeUpdate();
   				
   				conn1.close();
   				ps.close();
   					
   				}catch(Exception e){
   					System.out.println(e);
   					System.out.println("there is an exception in inserting data into booked table");
   				}
   			try{  
   	        	conn1 = ConnectionProvider.getconn();  
   	            PreparedStatement ps=conn1.prepareStatement("update bed set status=? where bedid=?");  
   	            
   	            ps.setString(1,"BOOKED"); 
   	            ps.setInt(2,bedid);
   	           
   	            
   	              
   	            ps.executeUpdate(); 
   	          

   	            flag = true;
   	              
   	            
   	        }catch(Exception e){
   	        	System.out.println(e);
   	            System.out.println("there is an exception in updating bed");
   	        	
   	        	}
		
		
		if(flag == true && bed ==1) {
			num = 1;
		}
		return num;
	}

	@Override
	public int checkbookedbed(String regno) {
     int bedid=0;
     Booked b = new Booked();
     try {
			
			conn1 = ConnectionProvider.getconn();
			ps = conn1.prepareStatement("select * from booked where regno=? and status=?");
			ps.setString(1, regno);	
			ps.setString(2, "OPEN");

			

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			 b.setRegno(rs.getString(1)); 
			 b.setBedid(rs.getInt(2));
			 b.setYear(rs.getString(3));
			 b.setStatus(rs.getString(4));
	           
		
				
			 
			}
			
			conn1.close();
			ps.close();
			
	        
					}catch(Exception e){
						System.out.println(e);
						System.out.println("there is an exception in getting booked from booked table");
					}
     if(b!=null) {
    	 bedid= b.getBedid();
     }
     
     return bedid;
	}

	@Override
	public String checkbookedstudent(int bedid) {
		Booked b = new Booked();
		String regno=null;
	     try {
				
				conn1 = ConnectionProvider.getconn();
				ps = conn1.prepareStatement("select * from booked where bedid=? and status=?");
				ps.setInt(1, bedid);	
				ps.setString(2, "OPEN");

				

				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
				 b.setRegno(rs.getString(1)); 
				 b.setBedid(rs.getInt(2));
				 b.setYear(rs.getString(3));
				 b.setStatus(rs.getString(4));
		           
			
					
				 
				}
				
				conn1.close();
				ps.close();
				
		        
						}catch(Exception e){
							System.out.println(e);
							System.out.println("there is an exception in getting booked from booked table");
						}
	     regno = b.getRegno();
		
		
		
		return regno;
	}

	@Override
	public int unbook(int bedid, String regno) {
		System.out.println("Regno:"+regno+" Bedid is:"+ bedid);
		int num = 0;
		Boolean flag =false;
		int bed = 0;

   

   		 try {
   				
   				conn1 = ConnectionProvider.getconn();
   				ps = conn1.prepareStatement("update booked set status=? where regno=? and bedid=?");
   				
   				ps.setString(1, "CLOSED");
   				ps.setString(2, regno);
   				ps.setInt(3, bedid);
   				
   				
   		
   				bed = ps.executeUpdate();
   				
   				conn1.close();
   				ps.close();
   					
   				}catch(Exception e){
   					System.out.println(e);
   					System.out.println("there is an exception in updating into booked table");
   				}
   			try{  
   	        	conn1 = ConnectionProvider.getconn();  
   	            PreparedStatement ps=conn1.prepareStatement("update bed set status=? where bedid=?");  
   	            
   	            ps.setString(1,"VACANT"); 
   	            ps.setInt(2,bedid);
   	           
   	            
   	              
   	            ps.executeUpdate(); 
   	          

   	            flag = true;
   	              
   	            
   	        }catch(Exception e){
   	        	System.out.println(e);
   	            System.out.println("there is an exception in Vacating bed");
   	        	
   	        	}
		
		
		if(flag == true && bed ==1) {
			num = 1;
		}
		return num;
	}


	
 
	
}
