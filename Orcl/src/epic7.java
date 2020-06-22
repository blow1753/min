import java.sql.*;
import java.util.Vector;

public class epic7 {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "kosea";
	private static final String PASS = "kosea2019a";
	Project mList;

	public epic7() {

	}

	public epic7(Project mList) {
		this.mList = mList;
		System.out.println("epic7=>" + mList);
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
			String sql = "select * from epic7 where CLASS like '%" + che1 + "%' and Constellation = '" + che2
					+ "'  order by id";
			System.out.println(sql);
			String sql2 = "select * from epic7 order by id";
			System.out.println(sql2);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String ID = rs.getString("ID");
				String NAME = rs.getString("NAME");
				String CLASS = rs.getString("CLASS");
				String ATTRIBUTE = rs.getString("ATTRIBUTE");
				String Constellation = rs.getString("Constellation");
				String affiliation = rs.getString("affiliation");
				String Speed = rs.getString("Speed");

				Vector row = new Vector();
				row.add(ID);
				row.add(NAME);
				row.add(CLASS);
				row.add(ATTRIBUTE);
				row.add(Constellation);
				row.add(affiliation);
				row.add(Speed);
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
			String sql2 = "select * from epic7 order by id";
			Statement stmt;
			System.out.println(sql2);
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				String NAME = rs.getString("NAME");
				String CLASS = rs.getString("CLASS");
				String ATTRIBUTE = rs.getString("ATTRIBUTE");
				String Constellation = rs.getString("Constellation");
				String affiliation = rs.getString("affiliation");
				String Speed = rs.getString("Speed");

				Vector row = new Vector();
				row.add(ID);
				row.add(NAME);
				row.add(CLASS);
				row.add(ATTRIBUTE);
				row.add(Constellation);
				row.add(affiliation);
				row.add(Speed);

				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}