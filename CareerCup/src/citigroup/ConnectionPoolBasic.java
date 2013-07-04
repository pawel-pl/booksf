package citigroup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPoolBasic {

	static List<Connection> pool;

	static {
		pool = new LinkedList<Connection>();
		for (int i = 0; i < 5; i++) {

			Connection connection = null;

			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mydb", "userName",
						"Password");
				pool.add(connection);
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public static Connection getConnection() {

		if (pool.size() > 0) {
			return pool.remove(pool.size() - 1);
		} else {
			throw new Error("no conn available");
		}
	}

	public static void returnConnection(Connection conn) {
		pool.add(conn);
	}

	public static void main(String[] args) {
		Connection conn = ConnectionPoolBasic.getConnection();
		// do something
		ConnectionPoolBasic.returnConnection(conn);
	}

}
