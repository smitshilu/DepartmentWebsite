package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AlumniInfoModel;
import model.AnnouncementModel;
import model.CoursesViewModel;
import model.DiscussionBoardModel;
import model.ExamDetailsModel;
import model.ExamResultModel;
import model.GetProfileModel;
import model.PhDStudentInfoModel;
import model.PhDStudentStatusModel;
import model.ReserveResourceModel;
import model.ResourceModel;

public class DAO {

	Connection conn = null;
	Statement s = null;

	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/setermproject", "root", "");
			s = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean LoginAuth(String netid, String password) {
		String sql = "select * from login where netid='" + netid + "'";

		try {

			ResultSet rs = s.executeQuery(sql);
			String thisnetid = "null";
			String thispassword = "null";

			while (rs.next()) {
				thisnetid = rs.getString("Netid");
				thispassword = rs.getString("Password");
			}

			if (thisnetid.equals(netid) && thispassword.equals(password)) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public String LoginType(String netid) {
		String sql = "select * from login where netid='" + netid + "'";

		try {

			ResultSet rs = s.executeQuery(sql);
			String thisnetid = "null";
			String type = "null";

			while (rs.next()) {
				thisnetid = rs.getString("Netid");
				type = rs.getString("Type");
			}

			if (thisnetid.equals(netid)) {
				return type;
			} else {
				return "0";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0";

	}

	public String getProgram(String netid) {

		String sql = "select * from student where Netid='" + netid + "'";
		ResultSet rs;
		String program = "null";
		try {
			rs = s.executeQuery(sql);

			while (rs.next()) {
				program = rs.getString("Program");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return program;
	}

	public String getPhdStatus(String netid) {

		String sql = "select * from phdstudents where Netid='" + netid + "'";
		ResultSet rs;
		String program = "null";
		try {
			rs = s.executeQuery(sql);

			while (rs.next()) {
				program = rs.getString("Status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return program;
	}

	public boolean addUserStudent(String netid, String password, String role,
			String fname, String lname, String year, String program,
			String major) {

		try {

			String sql = "INSERT INTO student VALUES ('" + netid + "', '"
					+ fname + "', '" + lname + "', '" + year + "', '" + program
					+ "', '" + major + "')";

			String sql1 = "INSERT INTO login VALUES ('" + netid + "', '"
					+ password + "', '1')";

			if (s.executeUpdate(sql) == 1) {
				if (s.executeUpdate(sql1) == 1) {
					sql = "INSERT INTO phdstudents VALUES ('" + netid
							+ "','null','null')";
					if (s.executeUpdate(sql) == 1) {
						return true;
					}
				}
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean addUserFaculty(String netid, String password, String role,
			String fname, String lname, String email) {

		try {

			String sql = "INSERT INTO faculty VALUES ('" + netid + "', '"
					+ fname + "', '" + lname + "', '" + email + "')";

			String sql1 = "INSERT INTO login VALUES ('" + netid + "', '"
					+ password + "', '2')";

			if (s.executeUpdate(sql) == 1) {
				if (s.executeUpdate(sql1) == 1) {
					return true;
				}
				return false;
			}
			// return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean addUserStaff(String netid, String password, String role,
			String fname, String lname) {

		try {

			String sql = "INSERT INTO staff VALUES ('" + netid + "', '" + fname
					+ "', '" + lname + "')";

			String sql1 = "INSERT INTO login VALUES ('" + netid + "', '"
					+ password + "', '3')";

			if (s.executeUpdate(sql) == 1) {
				if (s.executeUpdate(sql1) == 1) {
					return true;
				}
				return false;
			}
			// return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean checkNetIDAvailble(String netid) {

		String query = "select * from login where Netid = '" + netid + "'";

		try {
			ResultSet rs = s.getResultSet();
			rs = s.executeQuery(query);
			String thisnetid = "null";
			if (rs.next()) {
				thisnetid = rs.getString("Netid");
			}

			if (netid.equals(thisnetid))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean postContent(String id, String netid, String title,
			String content, String parentid, String datetime)
			throws SQLException {

		String query = "INSERT INTO discussionboard VALUES ('" + id + "', '"
				+ netid + "', '" + title + "', '" + content + "', '" + parentid
				+ "', '" + datetime + "');";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean deleteContent(String id) throws SQLException {

		String query = "delete from discussionboard where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean editContent(String id, String title, String content)
			throws SQLException {

		String query = "update discussionboard set Title='" + title
				+ "', Content='" + content + "' where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public ArrayList<DiscussionBoardModel> getContent() throws SQLException {

		String query = "select * from discussionboard";
		ResultSet rs = s.executeQuery(query);
		ArrayList<DiscussionBoardModel> content = new ArrayList<DiscussionBoardModel>();

		while (rs.next()) {
			DiscussionBoardModel dbm = new DiscussionBoardModel(
					rs.getString("ID"), rs.getString("Netid"),
					rs.getString("Title"), rs.getString("Content"),
					rs.getString("ParentID"), rs.getString("Datetime"));
			content.add(dbm);
		}

		return content;

	}

	public ArrayList<CoursesViewModel> getCourseInfo(String term)
			throws SQLException {

		ArrayList<CoursesViewModel> courses = new ArrayList<>();
		String query = "select * from courses where Term='" + term + "';";

		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			CoursesViewModel cvm = new CoursesViewModel(
					rs.getString("Coursenumber"), rs.getString("Coursename"),
					rs.getString("Instructor"), rs.getString("Netid"),
					rs.getString("Courseinfo"), rs.getString("Term"));
			courses.add(cvm);
		}

		return courses;
	}

	public boolean editCourseInfo(String coursenumber, String courseinfo)
			throws SQLException {

		String query = "update courses set Courseinfo='" + courseinfo
				+ "' where Coursenumber='" + coursenumber + "';";

		System.out.println(query);

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean createCourse(String coursenumber, String coursename,
			String instructor, String netid, String courseinfo, String term)
			throws SQLException {

		String query = "INSERT INTO courses VALUES ('" + coursenumber + "', '"
				+ coursename + "', '" + instructor + "', '" + netid + "', '"
				+ courseinfo + "', '" + term + "');";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean makeMyCourse(String coursenumber, String netid)
			throws SQLException {

		String query = "select * from faculty where Netid='" + netid + "';";
		String instructor = "null";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			instructor = rs.getString("Fname") + " " + rs.getString("Lname");
		}

		query = "update courses set Instructor='" + instructor + "', Netid='"
				+ netid + "' where Coursenumber='" + coursenumber + "';";

		System.out.println(query);

		try {
			s.executeUpdate(query);
			System.out.println("true");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public ArrayList<GetProfileModel> getStudentProfile(String netid)
			throws SQLException {

		String query = "select * from student where Netid='" + netid + "';";
		ResultSet rs = s.executeQuery(query);
		ArrayList<GetProfileModel> profile = new ArrayList<GetProfileModel>();

		while (rs.next()) {
			GetProfileModel gpm = new GetProfileModel(rs.getString("Netid"),
					rs.getString("Fname"), rs.getString("Lname"),
					rs.getString("Year"), rs.getString("Major"),
					rs.getString("Program"), rs.getString("Advisorname"),
					rs.getString("Advisornumber"), rs.getString("Advisoremail"));
			profile.add(gpm);
		}

		return profile;

	}

	public ArrayList<GetProfileModel> getFacultyProfile(String netid)
			throws SQLException {

		String query = "select * from faculty where Netid='" + netid + "';";
		ResultSet rs = s.executeQuery(query);
		ArrayList<GetProfileModel> profile = new ArrayList<GetProfileModel>();

		while (rs.next()) {
			GetProfileModel gpm = new GetProfileModel(rs.getString("Netid"),
					rs.getString("Fname"), rs.getString("Lname"), "null",
					"null", "null");
			profile.add(gpm);
		}

		return profile;

	}

	public ArrayList<GetProfileModel> getStaffProfile(String netid)
			throws SQLException {

		String query = "select * from staff where Netid='" + netid + "';";
		ResultSet rs = s.executeQuery(query);
		ArrayList<GetProfileModel> profile = new ArrayList<GetProfileModel>();

		while (rs.next()) {
			GetProfileModel gpm = new GetProfileModel(rs.getString("Netid"),
					rs.getString("Fname"), rs.getString("Lname"), "null",
					"null", "null");
			profile.add(gpm);
		}

		return profile;

	}

	public boolean updateStudentProfile(String netid, String password,
			String fname, String lname, String year, String program,
			String major, String advisorname, String advisornumber,
			String advisoremail) throws SQLException {

		String query = "update student set Fname='" + fname + "', Lname='"
				+ lname + "', Year='" + year + "', Program='" + program
				+ "', Major='" + major + "', Advisorname='" + advisorname
				+ "', Advisornumber='" + advisornumber + "', Advisoremail='"
				+ advisoremail + "' where Netid='" + netid + "';";

		if (s.executeUpdate(query) == 1) {
			query = "update login set Password='" + password
					+ "' where Netid='" + netid + "';";
			if (s.executeUpdate(query) == 1) {
				return true;
			}
		}

		return false;
	}

	public boolean updateFacultyProfile(String netid, String password,
			String fname, String lname) throws SQLException {

		String query = "update faculty set Fname='" + fname + "', Lname='"
				+ lname + "' where Netid='" + netid + "';";

		if (s.executeUpdate(query) == 1) {
			query = "update login set Password='" + password
					+ "' where Netid='" + netid + "';";
			if (s.executeUpdate(query) == 1) {
				return true;
			}
		}

		return false;
	}

	public boolean updateStaffProfile(String netid, String password,
			String fname, String lname) throws SQLException {

		String query = "update staff set Fname='" + fname + "', Lname='"
				+ lname + "' where Netid='" + netid + "';";

		if (s.executeUpdate(query) == 1) {
			query = "update login set Password='" + password
					+ "' where Netid='" + netid + "';";
			if (s.executeUpdate(query) == 1) {
				return true;
			}
		}

		return false;
	}

	public ArrayList<PhDStudentStatusModel> getPhDStudents(String netid)
			throws SQLException {

		ArrayList<PhDStudentStatusModel> phdstudents = new ArrayList<>();

		String query = "select * from phdstudents where Netid='" + netid + "'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			PhDStudentStatusModel pssm = new PhDStudentStatusModel(
					rs.getString("Netid"), rs.getString("Numberofsemester"),
					rs.getString("Status"));

			phdstudents.add(pssm);
		}

		return phdstudents;
	}

	public ArrayList<PhDStudentInfoModel> getPhDStudentsInfo()
			throws SQLException {

		ArrayList<PhDStudentInfoModel> phdstudents = new ArrayList<>();

		String query = "select * from student where Program='PhD'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			PhDStudentInfoModel pssm = new PhDStudentInfoModel(
					rs.getString("Netid"), rs.getString("Fname"),
					rs.getString("Lname"));

			phdstudents.add(pssm);
		}

		return phdstudents;
	}

	public boolean updateStudentStatus(String netid, String numberofsemester,
			String status) throws SQLException {

		String query = "update phdstudents set Numberofsemester='"
				+ numberofsemester + "', Status='" + status + "' where Netid='"
				+ netid + "';";

		System.out.println(query);

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean addJobAnnouncement(String id, String netid,
			String announcement, String type, String email, String link,
			String date) throws SQLException {

		String query = "INSERT INTO announcement VALUES ('" + id + "', '"
				+ netid + "', '" + announcement + "', '" + type + "', '"
				+ email + "', '" + link + "', '" + date + "');";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean addEventNewsAnnouncement(String id, String netid,
			String announcement, String type, String date) throws SQLException {

		String query = "INSERT INTO announcement VALUES ('" + id + "', '"
				+ netid + "', '" + announcement + "', '" + type
				+ "', 'null', 'null', '" + date + "');";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean editJobAnnouncement(String id, String netid,
			String announcement, String type, String email, String link,
			String date) throws SQLException {

		String query = "update announcement set Announcement='" + announcement
				+ "', Type='job', Email='" + email + "',Link='" + link
				+ "' where Netid='" + netid + "';";

		System.out.println(query);

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean editEventNewsAnnouncement(String id, String netid,
			String announcement, String type, String date) throws SQLException {

		String query = "update announcement set Announcement='" + announcement
				+ "', Type='" + type + "', Email='null',Link='null' where ID='"
				+ id + "';";

		System.out.println(query);

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean deleteAnnouncement(String id) throws SQLException {

		String query = "delete from announcement where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public ArrayList<AnnouncementModel> getAnnouncement() throws SQLException {

		ArrayList<AnnouncementModel> announcementfeed = new ArrayList<>();

		String query = "select * from announcement ORDER BY date";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			AnnouncementModel am = new AnnouncementModel(rs.getString("ID"),
					rs.getString("Netid"), rs.getString("Announcement"),
					rs.getString("Type"), rs.getString("Email"),
					rs.getString("Link"), rs.getString("Date"));

			announcementfeed.add(am);
		}

		return announcementfeed;
	}

	public boolean postExamResult(String examname, String result, String netid)
			throws SQLException {

		String query = "insert into result values(NULL,'" + examname + "','"
				+ result + "','" + netid + "')";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean editExamResult(String id, String examname, String result,
			String netid) throws SQLException {

		String query = "update result set Examname='" + examname
				+ "', Result='" + result + "', Netid='" + netid
				+ "' where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public ArrayList<ExamResultModel> getExamNames() throws SQLException {

		ArrayList<ExamResultModel> result = new ArrayList<>();

		String query = "select * from result";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			ExamResultModel erm = new ExamResultModel(rs.getString("ID"),
					rs.getString("Examname"), rs.getString("Result"),
					rs.getString("Netid"));

			result.add(erm);
		}

		return result;
	}

	public ArrayList<ExamResultModel> getExamDetails(String examid)
			throws SQLException {

		ArrayList<ExamResultModel> result = new ArrayList<>();

		String query = "select * from result where ID='" + examid + "'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			ExamResultModel erm = new ExamResultModel(rs.getString("ID"),
					rs.getString("Examname"), rs.getString("Result"),
					rs.getString("Netid"));

			result.add(erm);
		}

		return result;
	}

	public boolean postExamDetails(String netid, String examname,
			String examdate, String details) throws SQLException {

		String query = "insert into exam values(NULL, '" + examname + "','"
				+ examdate + "','" + details + "' , ',')";

		if (s.executeUpdate(query) == 1) {
			query = "insert into result values(NULL, '" + examname
					+ "','null','" + netid + "')";
			if (s.executeUpdate(query) == 1) {
				return true;
			}
		}

		return false;
	}

	public ArrayList<ExamDetailsModel> getExamDetails() throws SQLException {
		ArrayList<ExamDetailsModel> exam = new ArrayList<ExamDetailsModel>();

		String query = "select * from exam";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			ExamDetailsModel edm = new ExamDetailsModel(rs.getString("ID"),
					rs.getString("Examname"), rs.getString("Date"),
					rs.getString("Details"), rs.getString("Registration"));

			exam.add(edm);
		}

		return exam;
	}

	public boolean registerExam(String examid, String netid)
			throws SQLException {

		String query = "select * from exam where ID='" + examid + "'";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			String registered = rs.getString("Registration");
			registered = registered + "," + netid;

			query = "update exam set Registration='" + registered
					+ "' where ID='" + examid + "';";

			if (s.executeUpdate(query) == 1) {
				return true;
			}

		}

		return false;
	}

	public boolean createResource(String resourcename, String resourcetype,
			String resourcedetails) {

		String query = "insert into resource values('" + resourcename + "','"
				+ resourcetype + "','" + resourcedetails + "')";

		try {
			if (s.executeUpdate(query) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean checkResourceNameAvailble(String resourcename) {

		String query = "select * from resource where Name = '" + resourcename
				+ "'";

		try {
			ResultSet rs = s.getResultSet();
			rs = s.executeQuery(query);
			String thisresourcename = "null";
			if (rs.next()) {
				thisresourcename = rs.getString("Name");
			}

			if (resourcename.equals(thisresourcename))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<ResourceModel> getResourceDetails() throws SQLException {
		ArrayList<ResourceModel> resource = new ArrayList<ResourceModel>();

		String query = "select * from resource";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {

			ResourceModel rm = new ResourceModel(rs.getString("Name"),
					rs.getString("Type"), rs.getString("Details"));

			resource.add(rm);
		}

		return resource;
	}

	public ArrayList<ReserveResourceModel> getResourceReservationDetails(
			String resourcename, String resourcedate) {
		ArrayList<ReserveResourceModel> resource = new ArrayList<ReserveResourceModel>();

		String query = "select * from reservation where Name='" + resourcename
				+ "' and Date='" + resourcedate + "';";
		ResultSet rs;

		try {
			rs = s.executeQuery(query);

			while (rs.next()) {

				ReserveResourceModel rrm = new ReserveResourceModel(
						rs.getString("ID"), rs.getString("Netid"),
						rs.getString("Name"), rs.getString("Date"),
						rs.getString("Time"));

				resource.add(rrm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resource;
	}

	public boolean reserveResource(String ID, String netid,
			String resourcename, String resourcedate, String resourcetime) {

		String query = "insert into reservation values('" + ID + "','" + netid
				+ "','" + resourcename + "','" + resourcedate + "','"
				+ resourcetime + "')";

		try {
			if (s.executeUpdate(query) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<ReserveResourceModel> getMyResourceReservationDetails(
			String netid) {
		ArrayList<ReserveResourceModel> resource = new ArrayList<ReserveResourceModel>();

		String query = "select * from reservation where Netid='" + netid + "';";
		ResultSet rs;

		try {
			rs = s.executeQuery(query);

			while (rs.next()) {

				ReserveResourceModel rrm = new ReserveResourceModel(
						rs.getString("ID"), rs.getString("Netid"),
						rs.getString("Name"), rs.getString("Date"),
						rs.getString("Time"));

				resource.add(rrm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resource;
	}

	public boolean cancelReservarion(String id) throws SQLException {

		String query = "delete from reservation where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public ArrayList<AlumniInfoModel> getAlumniInfo() {

		ArrayList<AlumniInfoModel> alumniinfo = new ArrayList<AlumniInfoModel>();

		String query = "select * from alumni";
		ResultSet rs;
		try {
			rs = s.executeQuery(query);

			while (rs.next()) {
				AlumniInfoModel aim = new AlumniInfoModel(rs.getString("ID"),
						rs.getString("Name"), rs.getString("Info"),
						rs.getString("URL"));
				alumniinfo.add(aim);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumniinfo;

	}

	public boolean postAlumniInfo(String name, String info, String url)
			throws SQLException {

		String query = "insert into alumni values(NULL, '" + name + "', '"
				+ info + "', '" + url + "');";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean editAlumniInfo(String id, String name, String info,
			String url) throws SQLException {

		String query = "update alumni set Name='" + name + "', URL='" + url
				+ "', Info = '" + info + "' where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public boolean deleteAlumniInfo(String id) throws SQLException {

		String query = "delete from alumni where ID='" + id + "';";

		if (s.executeUpdate(query) == 1) {
			return true;
		}

		return false;
	}

	public ArrayList<CoursesViewModel> getMyCourseInfo(String netid)
			throws SQLException {

		ArrayList<CoursesViewModel> courses = new ArrayList<>();
		String query = "select * from courses where Netid='" + netid + "';";

		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {
			CoursesViewModel cvm = new CoursesViewModel(
					rs.getString("Coursenumber"), rs.getString("Coursename"),
					rs.getString("Instructor"), rs.getString("Netid"),
					rs.getString("Courseinfo"), rs.getString("Term"));
			courses.add(cvm);
		}

		return courses;
	}

	public ArrayList<ExamResultModel> getMyExamNames(String netid)
			throws SQLException {

		ArrayList<ExamResultModel> result = new ArrayList<>();

		String query = "select * from result";
		ResultSet rs = s.executeQuery(query);

		while (rs.next()) {

			ExamResultModel erm = new ExamResultModel(rs.getString("ID"),
					rs.getString("Examname"), rs.getString("Result"),
					rs.getString("Netid"));

			result.add(erm);
		}

		return result;
	}

	public boolean checkCourseIDAvailble(String id, String term) {

		String query = "select * from courses where Coursenumber = '" + id
				+ "' and Term = '" + term + "'";

		try {
			ResultSet rs = s.getResultSet();
			rs = s.executeQuery(query);
			String thisid = "null";
			if (rs.next()) {
				thisid = rs.getString("Coursenumber");
			}

			if (id.equals(thisid))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<String> getConcentration() {

		String sql = "select * from subjects";
		try {
			ResultSet rs = s.executeQuery(sql);

			ArrayList<String> concentration = new ArrayList<String>();

			while (rs.next()) {
				concentration.add(rs.getString("concentration"));
			}

			return concentration;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public String getCourse(String concentration) {

		String sql = "select * from subjects where concentration='"
				+ concentration + "'";
		try {
			ResultSet rs = s.executeQuery(sql);
			String courses = "";

			while (rs.next()) {
				courses = rs.getString("courses");
			}

			return courses;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public ArrayList<String> getMyExamList(String netid) {
		String sql = "select * from exam";
		ResultSet rs;
		ArrayList<String> result = new ArrayList<String>();
		try {
			rs = s.executeQuery(sql);
			while (rs.next()) {
				String resultt = rs.getString("Registration");
				String temp[] = resultt.split(",");
				if (temp.length > 1) {
					result.add(rs.getString("Examname"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getMyExamResult(String examname) {
		String sql = "select * from result where Examname='" + examname + "'";
		System.out.println(sql);
		ResultSet rs;
		String result = "null";
		try {
			rs = s.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString("Examname") + ";"
						+ rs.getString("Result");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<String> getEmail() {
		ArrayList<String> email = new ArrayList<String>();

		String sql = "select * from faculty";
		try {
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				String temp = rs.getString("Fname") + " "
						+ rs.getString("Fname") + ";" + rs.getString("email");
				email.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return email;
	}

}
