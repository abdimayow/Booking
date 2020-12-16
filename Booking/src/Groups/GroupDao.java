package Groups;

import java.util.ArrayList;

import Blocks.Blocks;
import Login.Student;

public interface GroupDao {
	public int insertGroup(Group g) ;
	public int removegroup(String leader);
	public int editmessage(String leader, String message);
	
	public int insertgroups(groups g);
	public int insertgroup2(group2 g);
	public int deletegroup2(String leader);
	
	public int insertgroup3(group3 g);
	public int deletegroup3(String leader);
	
	public int insertgroup4(group4 g);
	public int deletegroup4(String leader);
	
	public ArrayList<groups> getgroups();
	public ArrayList<groups> getspecificgroups(String category);
	public ArrayList<groups> getroups(String from, String to);

	public groups getgroup(String leader);
	public groups group(int gid);
	public ArrayList<groups> getroup();
	public group2 getgroup2(String leader);
	public group2 student2(String regno2);
	
	public group3 getgroup3(String leader);
	public group3 group3student2(String regno2);
	public group3 group3student3(String regno3);
	
	public group4 getgroup4(String leader);
	public group4 group4student2(String regno2);
	public group4 group4student3(String regno3);
	public group4 group4student4(String regno4);
	
    public int checkgroups(String leader);
    
	public String getLeader(String leader);
	
	public String getstudentstatus(String regno);
	public String getgrpname(String regno,String grp,String reg);
	public String checkgrpname(String name);
	
	public Student getRegno(String leader);
	
	public int pendingStudent(String regno);
	public int confirmedStudent(String regno);
	public int confirmedLeader(String regno);
	public int declineStudent(String regno);
	public int declineLeader(String regno);
	public int deletestatus(String regno);
	
	public int reg1(String regno);
	public int reg2(String regno);
	public int reg3(String regno);
	public int reg4(String regno);
	public int deletereg(String regno);
	
	public int grp2(String regno);
	public int grp3(String regno);
	public int grp4(String regno);
	public int deletegrp(String regno);
	
	
	public Group getGroup(String status);
	
	public boolean closeGroup();
	public boolean closeallgroups();
	
	public String getToDate();

	public String checkGroupstates();

	boolean checkGroupdates(String from, String to);
	
	
}
