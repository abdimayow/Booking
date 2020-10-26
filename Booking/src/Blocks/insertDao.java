package Blocks;

import java.util.ArrayList;

import Login.Student;




public interface insertDao {
	
	public int insertBlocks(Blocks b);
	public int insertHostel (Hostel n);
	public int insertRoom (Room n);
	public int insertBed(Bed b);
	public int deleteBed();
	public int insertBlock(Block b);
	public int checkBlock(int blockid);
	public int bookroom(Student stu,int roomid );
	public int bookbed(Student stu, int bedid);
	public int checkbookedbed(String regno);
	public String checkbookedstudent(int bedid);
	public int unbook(int bedid,String regno);
	
	public Hostel getHostel(int hostelid);
	public String getHostelname(int hostelid);
	public Room   getRoom(int roomid);
    public ArrayList<Blocks> getBlocks(); 
    public ArrayList<Blocks> getVacantBlocks(Student stu);
    public ArrayList<Hostel> getHostels(); 
    public ArrayList<Hostel> getBlockHostels(int blockid); 
    public ArrayList<Hostel> getVacantHostels(int blockid,Student stu);
    public ArrayList<Room> getRooms();
    public ArrayList<Room> getHostelRooms(int hostelid);
    public ArrayList<Room> getVacantRooms(int hostelid,Student stu);
    public ArrayList<Bed> getRoomBeds(int roomid);
    public ArrayList<Bed> getVacantBeds(int roomid,Student stu);
	public Room  getRooms(int roomno);
	public Room  getRooms2(String hostelnumber);
	public Hostel getHostels(String Single);
	public Hostel getHostels2(String Double);
	public Hostel getHostels3(String Triple);
	public Hostel getHostels4(String Quad);
	
	
	
	

}
