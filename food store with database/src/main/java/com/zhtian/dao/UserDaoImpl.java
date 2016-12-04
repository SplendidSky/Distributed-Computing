package com.zhtian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.zhtian.entities.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setVip(rs.getBoolean("vip"));
			return user;
		}
	}
	
	public User findById(Integer id) {
		User user = this.jdbcTemplate.queryForObject("select * from user where id = ?", new Object[]{id}, new UserMapper());
		return user;
	}

	public User findByUsername(String username) {
		String sql = "select * from user where username=?";
		List<User> userList = jdbcTemplate.query(sql, new UserMapper(), username);
		if(userList.size() == 0) {
			System.out.println(userList.size()+1);
			return null;
		}
		return userList.get(0);
	}

	public Set<String> findRoles(String username) {
		String sql = "select role from user u, roles r,users_roles ur where u.username=? and u.id=ur.user_id and r.id=ur.role_id";
		return new HashSet(jdbcTemplate.queryForList(sql, String.class, username));
	}

}
