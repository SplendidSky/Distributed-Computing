package com.zhtian.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zhtian.entities.Food;
import com.zhtian.entities.OrderLine;

@Repository("OrderLineDao")
public class OrderLineDaoImpl implements OrderLineDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public static final class OrderLineMapper implements RowMapper<OrderLine> {
		public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderLine orderLine = new OrderLine();
			orderLine.setFoodId(rs.getInt("foodId"));
			orderLine.setAmount(rs.getInt("amount"));
			orderLine.setOrderId(rs.getInt("orderId"));
			orderLine.setCheaper(rs.getBoolean("isCheaper"));
			return orderLine;
		}
	}
	
	public List<OrderLine> findByOrderId(Integer orderId) {
		List<OrderLine> orderLines = this.jdbcTemplate.query("select * from orderLine where orderId = ?", new Object[]{orderId}, new OrderLineMapper());
		return orderLines;
	}

	public void addOrderLineDao(Food food, Integer amount, Integer orderId, boolean isCheaper) {
		this.jdbcTemplate.update("insert into orderLine (foodId, amount, orderId, isCheaper) values(?, ?, ?, ?)", food.getId(), amount, orderId, isCheaper);
	}

}
