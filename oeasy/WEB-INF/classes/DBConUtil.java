import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConUtil {
	private static final String URL = "jdbc:postgresql://localhost:5432/oeasy";
	private static final String USER = "postgres";
	private static final String PASSWORD = "oeasy@pg";
	private static final String DRIVERPATH = "org.postgresql.Driver";
	private static Connection conn = null;
	static {
		try {
			Class.forName(DRIVERPATH);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		// 处理线程安全问题
		synchronized (DBConUtil.class) {
			try {
				// 如果conn为null或者conn已关闭得时候，需要重新创建conn对象
				if (null == conn || conn.isClosed()) {
					synchronized (DBConUtil.class) {
						conn = DriverManager.getConnection(URL, USER, PASSWORD);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return conn;
	}

	public static void close(Connection conn, PreparedStatement pstm, Statement stmt, ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (null != stmt) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (null != pstm) {
							try {
								pstm.close();
							} catch (SQLException e) {
								e.printStackTrace();
							} finally {
								if (null != conn) {
									try {
										conn.close();
									} catch (SQLException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
