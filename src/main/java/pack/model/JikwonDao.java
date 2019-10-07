package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	@Autowired
	private DataSource dataSource;
	
	public JikwonDao() {
	}
	
	public ArrayList<JikwonDto> getDataSelect(String num) {
		ArrayList<JikwonDto> list = new ArrayList<JikwonDto>();
		
		try {
			String sql = "select j.jikwon_no, j.jikwon_name, b.buser_name, j.jikwon_jik from jikwon j , buser b where j.buser_num = b.buser_no and jikwon_no = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JikwonDto dto = new JikwonDto();
				
				dto.setJikwon_no(rs.getString(1));
				dto.setJikwon_name(rs.getString(2));
				dto.setBuser_name(rs.getString(3));
				dto.setJikwon_jik(rs.getString(4));
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return list;
	}
}