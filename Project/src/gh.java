import java.sql.*;

public class gh {
   public static void main(String[] args) {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:orcl";
      String user = "kosea";
      String password = "kosea2019a";
      try {
         Class.forName(driver);
         System.out.println("jdbc driver loading success.");
         Connection conn = DriverManager.getConnection(url, user, password);
         System.out.println("oracle connection success.\n");
         Statement stmt = conn.createStatement();
         String sql = "SELECT * FROM Restaurant";
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            System.out.print(rs.getString("NO") + " ");
            System.out.print(rs.getString("Div") + " ");
            System.out.print(rs.getString("Name") + " ");
            System.out.print(rs.getString("Location") + " ");
            System.out.print(rs.getString("Tel") + " ");
            System.out.print(rs.getString("MainMenu") + " ");
            System.out.println(rs.getString("RF") + " ");
         }
      } catch (ClassNotFoundException e) {
         System.out.println(e);
      } catch (SQLException e) {
         System.out.println(e);
      }
   }
}