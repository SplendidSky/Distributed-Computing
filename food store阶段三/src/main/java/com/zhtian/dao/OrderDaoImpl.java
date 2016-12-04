package com.zhtian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.zhtian.entities.Order;
import com.zhtian.entities.OrderLine;

@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public static final class OrderMapper implements RowMapper<Order> {
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setId(rs.getInt("id"));
			order.setUserId(rs.getInt("userId"));
			return order;
		}
	}
	
	public List<Order> findAll() {
		List<Order> orders = this.jdbcTemplate.query("select * from orders", new OrderMapper());
		return orders;
	}

	public Order findById(Integer id) {
		Order order = this.jdbcTemplate.queryForObject("select * from orders where id = ?", new Object[]{id}, new OrderMapper());
		return order;
	}
	
	public List<Order> findByUserId(Integer userId) {
		List<Order> orders = this.jdbcTemplate.query("select * from orders where userId = ?", new Object[]{userId}, new OrderMapper());
		return orders;
	}

	public KeyHolder addOrder(List<OrderLine> orderLines, Integer userId) {
		final String INSERT_SQL = "insert into orders (userId) values(?)";
		final Integer USERID = userId;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] {"id"});
	            ps.setInt(1, USERID);
	            return ps;
	        }
		}, keyHolder);
		return keyHolder;
	}

}
