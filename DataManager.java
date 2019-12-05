import java.sql.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class DataManager {
	Connection connection = null;

	public DataManager() {
		try {
	        Class.forName("com.mysql.jdbc.Driver"); //Used to have .newInstance() at the end
	    } catch (Exception e) {
	        System.err.println(e.toString());
	    }
		String url = "jdbc:mysql://cs2043.cs.unb.ca:3306/cs204302ateam1";
		try {
		connection = DriverManager.getConnection(url, "cs204302ateam1", "48LYyVIF");
		} catch (SQLException e) {
		System.err.println("Database connection error.");
      System.err.println(e);
		}
	}

    public StudentAccount getStudentAccount(String id, String pass) {
        StudentAccount acc = null;

        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * from StudentAccount where " +
                              "StudID = " + id + " and " +
                              "Password = sha1('" + pass + "');";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);

			//convert retrieved rows to CustomerAccount object
			while (rs.next()) {
				acc = new StudentAccount();
                acc.id = rs.getString(1);
                acc.username = rs.getString(2);
                acc.password = rs.getString(3);
                acc.name = rs.getString(4);
                acc.address = rs.getString(5);
                acc.email = rs.getString(6);
                acc.nickname = rs.getString(7);
                acc.hometown = rs.getString(8);
                acc.hostname = rs.getString(9);
			}
		} catch (SQLException e) {
			System.err.println("SQL error: getStudentAccount");
		}

        return acc;
    }
    
    public int isStudent(String id) {
        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * from StudentAccount where " +
                              "StudID = " + id + " ; ";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);

			//convert retrieved rows to CustomerAccount object
			if (rs.next()) 
				return 1;
		} catch (SQLException e) {
			System.err.println("SQL error: getStudentAccount");
		}
        return 0;
    }

    public ProfessorAccount getProfessorAccount(String id, String pass) {
        ProfessorAccount acc = null;

        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * from ProfessorAccount where " +
                              "ProfID = " + id + " and " +
                              "Password = sha1('" + pass + "');";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);

			//convert retrieved rows to CustomerAccount object
			while (rs.next()) {
				acc = new ProfessorAccount();
                acc.id = rs.getString(1);
                acc.username = rs.getString(2);
                acc.password = rs.getString(3);
                acc.name = rs.getString(4);
			}
		} catch (SQLException e) {
			System.err.println("SQL error: getProfessorAccount");
		}

        return acc;
    }

    public TAAccount getTAAccount(String id, String pass) {
        TAAccount acc = null;

        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * from TAAccount where " +
                              "TAID = " + id + " and " +
                              "Password = sha1('" + pass + "');";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);

			//convert retrieved rows to CustomerAccount object
			while (rs.next()) {
				acc = new TAAccount();
                acc.id = rs.getString(1);
                acc.username = rs.getString(2);
                acc.password = rs.getString(3);
                acc.name = rs.getString(4);
			}
		} catch (SQLException e) {
			System.err.println("SQL error: getTAAccount");
		}

        return acc;
    }

    public AdminAccount getAdminAccount(String id, String pass) {
        AdminAccount acc = null;

        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * from AdminAccount where " +
                              "AdminID = " + id + " and " +
                              "Password = sha1('" + pass + "');";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);

			//convert retrieved rows to CustomerAccount object
			while (rs.next()) {
				acc = new AdminAccount();
                acc.id = rs.getString(1);
                acc.username = rs.getString(2);
                acc.password = rs.getString(3);
			}
		} catch (SQLException e) {
			System.err.println("SQL error: getAdminAccount");
		}

        return acc;
    }

	public int createAdmin(String id, String username, String password) throws SQLException{
		int success = 0;
		Statement st = connection.createStatement();

		String query = "insert into AdminAccount values ('" +id+ "', '" +username+ "', sha1('" +password+ "'));";
		success = st.executeUpdate(query);

		return success;
	}

	public int createProfessor(String id, String username, String password, String name) throws SQLException {
		int success = 0;

		Statement st = connection.createStatement();

		String query = "insert into ProfessorAccount values ('" +id+ "', '" +username+ "', sha1('" +password+ "'), '" +name+ "');";
		success = st.executeUpdate(query);

		return success;
	}

	public int createTA(String id, String username, String password, String name) throws SQLException {
		int success = 0;

		Statement st = connection.createStatement();

		String query = "insert into TAAccount values ('" +id+ "', '" +username+ "', sha1('" +password+ "'), '" +name+ "');";
		success = st.executeUpdate(query);
		return success;
	}

	public int createStudent(String id, String username, String password, String name, String address, String email) throws SQLException {
		int success = 0;

		Statement st = connection.createStatement();

		String query = "insert into StudentAccount values ('" +id+ "', '" +username+ "', sha1('" +password+ "'), '" +name+ "', '" +address+ "', '" +email+ "', null, null, null);";
		success = st.executeUpdate(query);

		return success;
	}

	public int updateProfileInformation(String id, String nickname, String hometown, String hostname) throws SQLException {
		int success = 0;
		Statement st = connection.createStatement();

		String query = "UPDATE StudentAccount "+
					   "SET Nickname = '"+nickname+"', "+
					   	   "Hometown = '"+hometown+"', "+
						   "Hostname = '"+hostname+"' "+
					   "WHERE StudID = '" +id+ "';";
		success = st.executeUpdate(query);

		return success;
	}

	public ArrayList<Course> getCoursesForStudent(String studID){
		ArrayList<Course> c = new ArrayList<Course>();
        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select CourseID,CourseName,CourseNumber,CourseDescription,ProfID " +
							  "from Course natural join CourseRegistration where " +
                              "StudID = " + studID + ";";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);
			//convert retrieved rows to CustomerAccount object
			while (rs.next()) {
				Course course = new Course();
                course.courseID = rs.getString(1);
                course.courseName = rs.getString(2);
                course.courseNumber = rs.getString(3);
                course.courseDescription = rs.getString(4);
                course.profID = rs.getString(5);
                c.add(course);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

        return c;
	}
//NEED TO CHANGE VARIABLE NOTIFICAIONTYPE INTO COURSEID IN DATABASE!!!!!!!!!!!!!!!

	public ArrayList<Notification> getNotifications(String CourseID) {
		ArrayList<Notification> list = new ArrayList<Notification>();
		try {
			Statement st = connection.createStatement();
			String sqlQuery = "select * from Notification where CourseID = "+ CourseID;
			ResultSet rs = st.executeQuery(sqlQuery);
			while(rs.next()) {
				Notification note =new Notification();
				note.NotificationID = rs.getString(1);
				note.NotificationType = rs.getString(2);
				note.description = rs.getString(3);
				note.CourseID = rs.getString(4);
				list.add(note);

			}

		}catch (SQLException e) {
			System.err.println("SQL error: get notifications");
			System.err.println(e.toString());
		}return list;
	}
/*
	public ArrayList<BookInfoObject> getBooksByKeywords(ArrayList<String> keywords) {
		ArrayList<BookInfoObject> bookList = new ArrayList<BookInfoObject>();
		try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * from BookInfo where ";
			for (int i=0; i<keywords.size(); i++) {
				if (i < keywords.size() - 1)
					sqlQuery = sqlQuery + "Title like '%" + keywords.get(i) + "%' or ";
				else sqlQuery = sqlQuery + "Title like '%" + keywords.get(i) + "%';";
			}

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);

			//convert retrieved rows to BookInfoObject[]
			while (rs.next()) {
				BookInfoObject book = new BookInfoObject();
				book.id = rs.getString(1);
				book.title = rs.getString(2);
				book.description = rs.getString(3);
				book.author = rs.getString(4);
				book.isbn = rs.getString(5);
				book.publisher = rs.getString(6);
				book.year = rs.getInt(7);
				book.inventory = rs.getInt(8);
				bookList.add(book);
			}
		} catch (SQLException e) {
			System.err.println("SQL error: getBooksByKeywords");
		}

		return bookList;
	}
*/

	public ArrayList<String> getCourseByPName(String id) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			Statement st = connection.createStatement();
			String sqlQuery = "select * from Course where profID = "+ id;
			ResultSet rs = st.executeQuery(sqlQuery);
			while(rs.next()) {
				list.add(rs.getString(1));
			}

		}catch (SQLException e) {
			System.err.println("SQL error: get course by profID");
			System.err.println(e.toString());
		}
		return list;
	}

	public boolean PostNotification(String NotID, String CourseID, String Description, char courseType) {
		int result = 0;
		System.out.print("insert into Notification values ("+NotID+",'"+ courseType +"','"+Description+"','"+CourseID+"')");
		try {
			Statement st = connection.createStatement();
			String sqlQuery = "insert into Notification values ("+NotID+",'"+ courseType +"','"+Description+"',"+CourseID+")";
			result = st.executeUpdate(sqlQuery);
		}catch (SQLException e) {
			System.err.println("SQL error: insert new notification");
			System.err.println(e.toString());
		}
		if(result>0) {
			return true;
		}else {
			return false;
		}

	}

	public ArrayList<Course> getCoursesForProf(String profID){
		ArrayList<Course> c = new ArrayList<Course>();
        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * " +
							  "from Course where " +
                              "ProfID = " + profID + ";";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);
			//convert retrieved rows to CustomerAccount object
			while (rs.next()) {
				Course course = new Course();
                course.courseID = rs.getString(1);
                course.courseName = rs.getString(2);
                course.courseNumber = rs.getString(3);
                course.courseDescription = rs.getString(4);
                course.profID = rs.getString(5);
                c.add(course);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

        return c;
	}

	public int postAssignment(String name, String courseID, File file) {
		int success = 0;
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Statement st = connection.createStatement();

			String query = "insert into Assignment(AssignmentName,AssignmentDocument,CourseID) values(?,?,?);";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setBinaryStream(2,input,(int)file.length());
			pstmt.setInt(3,Integer.parseInt(courseID));
			success = pstmt.executeUpdate();
		}
		catch (SQLException e) {
			System.err.println("SQL error: postAssignment");
			System.err.println(e.toString());
		}

		return success;
	}

	public ArrayList<Assignment> getAssignmentByCourse(String courseID){
		ArrayList<Assignment> a = new ArrayList<Assignment>();
        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select * " +
							  "from Assignment where " +
                              "CourseID = " + courseID + ";";

			//execute SQL query
			ResultSet rs = st.executeQuery(sqlQuery);
			//System.out.println("Query: " + sqlQuery);
			//convert retrieved rows to CustomerAccount object
			while (rs.next()) {
				Assignment assignment = new Assignment();
                assignment.assignmentID = rs.getString(1);
                assignment.assignmentName = rs.getString(2);
                assignment.assignmentDocument = rs.getBinaryStream(3);
                assignment.datePosted = rs.getString(4);
                assignment.dateDue = rs.getString(5);
                assignment.courseID = rs.getString(6);
                a.add(assignment);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

        return a;
	}

	public ArrayList<Course> getCoursesForTA(String taID){
		ArrayList<Course> c = new ArrayList<Course>();
        try {
			Statement st = connection.createStatement();

			//create query string
			String sqlQuery = "select CourseID,CourseName,CourseNumber,CourseDescription,ProfID " +
							  "from Course natural join TACourseAssignment where " +
                              "TAID = " + taID + ";";

			ResultSet rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				Course course = new Course();
                course.courseID = rs.getString(1);
                course.courseName = rs.getString(2);
                course.courseNumber = rs.getString(3);
                course.courseDescription = rs.getString(4);
                course.profID = rs.getString(5);
                c.add(course);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

        return c;
	}
	
	  public ResultSet getAwards(String id) {//JustinC
		  	ResultSet rs = null;
	        try {
				Statement st = connection.createStatement();

				//create query string
				String sqlQuery = "select * from Award where StudID = "+ id + ";";

				rs = st.executeQuery(sqlQuery);
				}
			catch (SQLException e) {
				System.err.println(e);
			}

	        return rs;
		}
	  
	  public boolean addAward(String studID, String name, String desc) {//JustinC
	        boolean pass = true;
		  	try {
				Statement st = connection.createStatement();

				//create query string
				String sqlQuery = "insert into Award (AwardName, AwardDescription, StudID) values('" + name + "','" + desc + "','" + studID +"');";

				st.executeQuery(sqlQuery);
				
				}
			catch (SQLException e) {
				System.err.println(e);
				pass = false;
			}
	        return pass;
		}
	  
	  
	  public boolean addCourse(String courseID, String name, String desc, String prof) {//JustinC
		  boolean pass = true;
	        try {
				Statement st = connection.createStatement();

				//create query string
				String sqlQuery = "insert into Course (CourseName, CourseDescription, CourseNumber, ProfID ) values('" + name + "','" + desc + "','" + courseID + "','" + prof +"');";

				st.executeQuery(sqlQuery);
				
				}
			catch (SQLException e) {
				System.err.println(e);
				pass = false;
			}
	        return pass;
		}

	//QuizMethods
	
	public QuizData getQuiz(int QID) throws IOException
	{
		//ArrayList<QuizData> list1 = new ArrayList<QuizData>();
		try
		{
			QuizData q = null;
			Statement stmt = connection.createStatement();
			String sqlQuery = "select QuizName,QuizDescription,Question1,Question2,Question3,Question4,Question5,Ans1,Ans2,Ans3,Ans4,Ans5,O1a,O1b,O1c,O2a,O2b,O2c,O3a,O3b,O3c,O4a,O4b,O4c,O5a,O5b,O5c from Quiz where QuizID = '"+ QID +"'";
			ResultSet rset = stmt.executeQuery(sqlQuery);
			while(rset.next())
			{
				q = new QuizData();
				q.QuizName = rset.getString(1);
				q.QuizDescription = rset.getString(2);
				q.Q1 = rset.getString(3);
				//System.out.println(q.Q1);
				q.Q2 = rset.getString(4);
				q.Q3 = rset.getString(5);
				q.Q4 = rset.getString(6);
				q.Q5 = rset.getString(7);
				q.A1 = rset.getString(8);
				q.A2 = rset.getString(9);
				q.A3 = rset.getString(10);
				q.A4 = rset.getString(11);
				q.A5 = rset.getString(12);
				q.O1a = rset.getString(13);
				q.O1b = rset.getString(14);
				q.O1c = rset.getString(15);
				q.O2a = rset.getString(16);
				q.O2b = rset.getString(17);
				q.O2c = rset.getString(18);
				q.O3a = rset.getString(19);
				q.O3b = rset.getString(20);
				q.O3c = rset.getString(21);
				q.O4a = rset.getString(22);
				q.O4b = rset.getString(23);
				q.O4c = rset.getString(24);
				q.O5a = rset.getString(25);
				q.O5b = rset.getString(26);
				q.O5c = rset.getString(27);
				//list1.add(q);
			}
			return q;
		}
		catch(SQLException e)
		{
			System.out.println("Problem");
			e.printStackTrace();
			return null;
		}
		
	}			
	
	public void insertQuizResult(int QzID, String studentID, int score)
	{
		 try 
		 {
			 	//DataManager q = new DataManager();
			 //	QuizControl c = new QuizControl(q);
			 	//String SID = c.getStudentID();
			 	
			 	//Integer score = c.PassResult();
			 	String scores = Integer.toString(score);
			 	
			 	 //System.out.println("The ID =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+QzID);
				Statement st = connection.createStatement();
				//create query string
				//int Q = Integer.parseInt(QzID);
				String sqlQuery = "insert into QuizScore values ('" + studentID + "'," + QzID +"," + scores + ");";// where QuizID =" + QzID;
				System.out.print("passed");
				st.executeUpdate(sqlQuery);
		 }
		 catch(SQLException e)
		 {
			 System.out.println("error");
			 e.printStackTrace();
		 }
	 }
	
	public ArrayList<String> GetQuizInfo(int course) {
		// TODO Auto-generated method stub
		ArrayList<String> s = new ArrayList<String>();
		try
		{
			Statement st = connection.createStatement();
			String query = "Select QuizID from Quiz where CourseID = "+ course ;
			ResultSet rs =	st.executeQuery(query);
			//String s = null;
			while(rs.next())
			{
				String st1 = rs.getString("QuizID");
				s.add(st1);
			}
			return s;
		}
		catch(Exception e)
		{
			return null;
		}
		
		
	}


	public void StoreQuiz(QuizData q) 
	{
		try
		{
			Statement st = connection.createStatement();
			String Q = "insert into Quiz(QuizID,QuizName, QuizDescription, courseID, Question1, Question2, Question3, Question4, Question5, Ans1, Ans2, Ans3, Ans4, Ans5,O1a,O1b,O1c,O2a,O2b,O2c,O3a,O3b,O3c,O4a,O4b,O4c,O5a,O5b,O5c) values('"+ q.QuizID +"','"+ q.QuizName +"','"+ q.QuizDescription +"','"+ q.CourseID +"','"+ q.Q1 +"','"+ q.Q2 +"','"+ q.Q3 +"','"+ q.Q4 +"','"+ q.Q5 +"','"+ q.A1 +"','"+ q.A2 +"','"+ q.A3 +"','"+ q.A4 +"','"+ q.A5 +"','"+ q.O1a+"','"+ q.O1b+"','"+ q.O1c+"','"+ q.O2a+"','"+ q.O2b+"','"+ q.O2c+"','"+ q.O3a+"','"+ q.O3b+"','"+ q.O3c+"','"+ q.O4a+"','"+ q.O4b+"','"+ q.O4c+"','"+ q.O5a+"','"+ q.O5b+"','"+ q.O5c+"')";
			st.executeUpdate(Q);
			System.out.println("here");
		}
		catch(SQLException e)
		{
			System.err.println(e);
		}
	}
	
	public ArrayList<Notification> getNotificationsByID(String profID) {
		ArrayList<Notification> list = new ArrayList<Notification>();
		try {
			Statement st = connection.createStatement();
			String sqlQuery = "select * from Notification join Course on Notification.CourseID = Course.CourseID where profID = "+ profID+";";
			ResultSet rs = st.executeQuery(sqlQuery);
			while(rs.next()) {
				Notification note =new Notification();
				note.NotificationID = rs.getString(1);
				note.NotificationType = rs.getString(2);
				note.description = rs.getString(3);
				note.CourseID = rs.getString(4);
				list.add(note);

			}

		}catch (SQLException e) {
			System.err.println("SQL error: get notifications");
			System.err.println(e.toString());
		}return list;
	}

	public boolean DeleteNotification(String NotificationID) {
		try {
			Statement st = connection.createStatement();
			String sqlQuery = "delete from Notification where NotificationID = "+ NotificationID +";";
		}catch(SQLException e) {
			return false;
		}
		return true;
	}
	
	public boolean UpdateNotification(String NotificationID, String Description) {
		try {
			Statement st = connection.createStatement();
			String sqlQuery = "update Notification set NotificationDescription = "+Description +" where NotificationID = "+ NotificationID +";";
		}catch(SQLException e) {
			return false;
		}
		return true;
	}


	
}
