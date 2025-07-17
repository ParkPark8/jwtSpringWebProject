import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests {
	@BeforeAll
	public static void setup(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	@DisplayName("JDBC 드라이버 연결이 된다.")
	public void testConnection(){
		String url = "jdbc:mysql://localhost:3306/scoula_db";
		try (Connection con= DriverManager.getConnection(url,"scoula","1234")){
			log.info(con);
			log.info("DDDDD");
		}catch (Exception e){
			fail(e.getMessage());
		}
	}
}
