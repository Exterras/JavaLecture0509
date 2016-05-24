package javaJdbc;

public class JdbcEx01 {
	public static void main(String[] args) {
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Interlock Success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
