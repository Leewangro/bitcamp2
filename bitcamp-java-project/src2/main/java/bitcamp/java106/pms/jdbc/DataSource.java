// DB 커넥션 객체를 관리하는 역할의 규칙 정의
// => 빌려주는 역할을 수행한다.
package bitcamp.java106.pms.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

public interface DataSource {
    Connection getConnection() throws Exception;
    void returnConnection(Connection con);
}
