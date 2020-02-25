package Groups;



public interface GroupDao {
	public int insertGroup(Group g) ;

	public boolean checkGroup(String status);
	
	public boolean checkGroup(String from,String to);
	
	public Group getGroup(String status);
	
	public boolean closeGroup();
	
	public String getToDate(String status);
	
	
}
