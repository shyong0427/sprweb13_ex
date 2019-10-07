package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	@Autowired
	private DataSource dataSource;
	
	public DataDao() {
	}
	
	public ArrayList<GogekDto> getDataAll() {
		ArrayList<GogekDto> list = new ArrayList<GogekDto>();
		
		try {
			String sql = "select gogek_no, gogek_name, gogek_tel, gogek_damsano from gogek";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				GogekDto dto = new GogekDto();
				
				dto.setGogek_no(rs.getString(1));
				dto.setGogek_name(rs.getString(2));
				dto.setGogek_tel(rs.getString(3));
				dto.setGogek_damsano(rs.getString(4));
				
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
				System.out.println("getDataAll err : " + e2);
			}
		}
		
		return list;
	}
}