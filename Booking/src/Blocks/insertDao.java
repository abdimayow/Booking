package Blocks;

import java.util.ArrayList;




public interface insertDao {
	
	public int insertBlocks(Blocks b);
	public int insertHostel (Hostel n);
	public int insertRoom (Room n);
	public int insertBed(Bed b);
	public int insertBlock(Block b);
	public int checkBlock(int blockid);
	
	public Hostel getHostel(int hostelid);
	public String getHostelname(int hostelid);
	public Room   getRoom(int roomid);
    public ArrayList<Blocks> getBlocks(); 
    public ArrayList<Hostel> getHostels(); 
    public ArrayList<Room> getRooms();
	
	public Room  getRooms(int roomno);
	public Room  getRooms2(String hostelnumber);
	public Hostel getHostels(String Single);
	public Hostel getHostels2(String Double);
	public Hostel getHostels3(String Triple);
	public Hostel getHostels4(String Quad);
	
	
	
	

}
