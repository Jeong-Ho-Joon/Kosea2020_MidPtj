import java.sql.*;
import java.util.Vector;

public class DAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "kosea"; // DB ID
	private static final String PASS = "kosea2019a"; // DB 패스워드
	List mList;

	public DAO() {

	}

	public DAO(List mList) {
		this.mList = mList;
		System.out.println("DAO=>" + mList);
	}

	/** DB연결 메소드 */
	public Connection getConn() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	/*리스트 출력 */
	public Vector getList() {

		Vector data = new Vector(); // Jtable에 값을 쉽게 넣는 방법 1. 2차원배열 2. Vector 에 vector추가

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = getConn();
			String sql = "select * from Restaurant order by name asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int NO = rs.getInt("NO");
				String Div = rs.getString("Div");
				String Name = rs.getString("Name");
				String Location = rs.getString("Location");
				String Tel = rs.getString("Tel");
				String Mainmenu = rs.getString("Mainmenu");
				String RF = rs.getString("RF");

				Vector row = new Vector();
				row.add(NO);
				row.add(Div);
				row.add(Name);
				row.add(Location);
				row.add(Tel);
				row.add(Mainmenu);
				row.add(RF);

				data.add(row);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}// getList()