import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresJdbc {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/oeasy", "postgres",
                    "oeasy@pg");
            c.setAutoCommit(false);

            System.out.println("Pq Connection success!");
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("select * from urls");
            while(rs.next()){
                String topic = rs.getString("topic");
                String url = rs.getString("url");
                System.out.print(topic+":"+url+"\n");
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        System.out.println("Pq select query success!");
    }
}

