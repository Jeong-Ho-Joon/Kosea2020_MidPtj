import java.sql.*;
import java.util.Vector;

public class DAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "kosea";
	private static final String PASS = "kosea2019a";
	Project mList;

	public DAO() {

	}

	public DAO(Project mList) {
		this.mList = mList;
		System.out.println("DAO=>" + mList);
	}

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

	public Vector getList(String che1, String che2) {
		Vector data = new Vector();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

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

	public Vector getList() {

		Vector data = new Vector();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = getConn();
			String sql2 = "select * from Restaurant order by Div";
			System.out.println(sql2);
			ps = con.prepareStatement(sql2);
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