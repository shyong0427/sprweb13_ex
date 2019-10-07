package pack.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class DataSource extends DriverManagerDataSource {
	public DataSource() {
		this.setDriverClassName("org.mariadb.jdbc.Driver");
		this.setUrl("jdbc:mysql://localhost:3306/test");
		this.setUsername("root");
		this.setPassword("kic1234");
	}
}