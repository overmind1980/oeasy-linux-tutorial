import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class jdbc{
	public static void main(String args[]) {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/oeasy",
						"postgres", "oeasy@linux");
			c.setAutoCommit(false);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from urls");
			while(rs.next()){
				String topic  = rs.getString("topic");
				String url = rs.getString("url");
				System.out.println(topic + ":" + url + "\n");
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
	}
}

