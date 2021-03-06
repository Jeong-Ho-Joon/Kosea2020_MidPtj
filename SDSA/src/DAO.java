import java.sql.*;
import java.util.Vector;

public class DAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "kosea";
	private static final String PASS = "kosea2019a";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Connection getConn() {

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// 일반검색 쿼리문

	public Vector getList1(String che1, String che2) {
		Vector data = new Vector();

		try {
			con = getConn();
			String sql = "select * from Restaurant where Location like '%" + che1 + "%' and Div = '" + che2
					+ "'  order by NO";
			System.out.println(sql);
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	// 전체조회 쿼리문

	public Vector getList2() {

		Vector data = new Vector();

		try {

			con = getConn();
			String sql = "select * from Restaurant order by Div";
			System.out.println(sql);
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	// 랜덤조회 쿼리문

	public Vector getList3() {

		Vector data = new Vector();

		try {

			con = getConn();
			String sql = "SELECT * FROM ( SELECT * FROM Restaurant ORDER BY DBMS_RANDOM.RANDOM ) WHERE ROWNUM < 15";
			System.out.println(sql);
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}