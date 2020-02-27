package Groups;



public interface GroupDao {
	public int insertGroup(Group g) ;
	
	public Group getGroup(String status);
	
	public boolean closeGroup();
	
	public String getToDate(String status);

	public String checkGroupstates();

	boolean checkGroupdates(String from, String to);
	
	
}
