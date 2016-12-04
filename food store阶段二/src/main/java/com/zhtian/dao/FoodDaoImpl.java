package com.zhtian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;

import com.zhtian.entities.Food;

@Repository("FoodDao")
public class FoodDaoImpl implements FoodDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public static final class FoodMapper implements RowMapper<Food> {
		public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
			Food food = new Food();
			food.setId(rs.getInt("id"));
			food.setName(rs.getString("name"));
			food.setCost(rs.getDouble("cost"));
			food.setImg_src(rs.getString("src"));
			food.setBargain(rs.getBoolean("bargain"));
			return food;
		}
	}
	
	public List<Food> findAll() {
		List<Food> foods = this.jdbcTemplate.query("select * from food", new FoodMapper());
		return foods;
	}

	public Food findById(Integer id) {
		Food food = this.jdbcTemplate.queryForObject("select * from food where id = ?", new Object[]{id}, new FoodMapper());
		return food;
	}

	public int findIdByName(String name) {
		Food food = new Food();
		try {
			food = this.jdbcTemplate.queryForObject("select * from food where name = ?", new Object[]{name}, new FoodMapper());
		}
		catch (DataAccessException ex) {
			return -1;
		}
		return food.getId();
	}
	
	public KeyHolder addFood(String name, double cost, String src) {
		final String INSERT_SQL = "insert into food (name, cost, src) values(?, ?, ?)";
		final String NAME = name;
		final double COST = cost;
		final String SRC = src;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	            PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] {"id"});
	            ps.setString(1, NAME);
	            ps.setDouble(2, COST);
	            ps.setString(3, SRC);
	            return ps;
	        }
		}, keyHolder);
		return keyHolder;
	}

}
