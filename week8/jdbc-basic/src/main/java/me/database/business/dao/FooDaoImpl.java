package me.database.business.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import me.database.business.model.Foo;

@Repository
public class FooDaoImpl implements FooDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    // result mapping
    public static final class FooMapper implements RowMapper<Foo> {
        public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Foo foo = new Foo();
            foo.setId(rs.getInt("id"));
            foo.setName(rs.getString("name"));
            return foo;
        }
    }

    // API
	public Foo findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Foo> findAll() {
		List<Foo> foos = this.jdbcTemplate.query( "select * from foo", new FooMapper());
		return foos;
	}

	public void create(final Foo entity) {
		
		final String INSERT_SQL = "insert into foo (name) values(?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] {"id"});
		            ps.setString(1, entity.getName());
		            return ps;
		        }
		    },
		    keyHolder);
	
	}

	public Foo update(Foo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Foo entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteById(long entityId) {
		// TODO Auto-generated method stub
		
	}

}
