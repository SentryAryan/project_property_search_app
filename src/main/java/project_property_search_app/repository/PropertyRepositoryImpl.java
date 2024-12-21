package project_property_search_app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import project_property_search_app.entity.Property;



@Repository
public class PropertyRepositoryImpl implements PropertyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Property> getAllProperties() {
        String sql = "SELECT * FROM Properties";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Property property = new Property();
            property.setPropertyId(rs.getInt("property_id"));
            property.setTitle(rs.getString("title"));
            property.setDescription(rs.getString("description"));
            property.setPrice(rs.getDouble("price"));
            property.setLocation(rs.getString("location"));
            property.setSquareft(rs.getString("squareft"));
            property.setAmenities(rs.getString("amenities"));
            property.setStatus(rs.getString("status"));
            property.setSellerId(rs.getInt("seller_id"));
            return property;
        });
    }

    @Override
    public Property addNewProperty(Property property) {
        String sql = "INSERT INTO Properties (title, description, price, location, squareft, amenities, status, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int n = jdbcTemplate.update(sql, property.getTitle(), property.getDescription(), property.getPrice(), property.getLocation(), property.getSquareft(), property.getAmenities(), property.getStatus(), property.getSellerId());
        return (n > 0) ? property : null;
    }

	
	
	@Override
    public void updateProperty(int property_id, Double price) {
        String sql = "UPDATE Properties SET price = ? WHERE property_id = ?";
        jdbcTemplate.update(sql,property_id, price);
    } 


	@Override
	public Property getPropertyByPropertyId(int property_id) {
		 String sql = "select * from Properties  where property_id = ?";
		    try {
		        return jdbcTemplate.queryForObject(sql, new Object[]{property_id}, (rs, rowNum) -> {
		            Property property = new Property();
		            property.setPropertyId(rs.getInt("property_id"));
		            property.setTitle(rs.getString("title"));
		            property.setDescription(rs.getString("description"));
		            property.setPrice(rs.getDouble("price"));
		            property.setLocation(rs.getString("location"));
		            property.setSquareft(rs.getString("squareft"));
		            property.setAmenities(rs.getString("amenities"));
		            property.setStatus(rs.getString("status"));
		            property.setSellerId(rs.getInt("seller_id"));
		            return property;
		        });
		    } catch (Exception e) {
		        return null; // Handle the case where no rows match the query
		    }
		
	}
	
	@Override
	 public List<Property> searchProperties(String location) {
        String sql = "SELECT * FROM Properties WHERE location = ?";
        return jdbcTemplate.query(sql, new Object[]{location}, (rs, rowNum) -> {
            Property property = new Property();
            property.setPropertyId(rs.getInt("property_id"));
            property.setTitle(rs.getString("title"));
            property.setDescription(rs.getString("description"));
            property.setPrice(rs.getDouble("price"));
            property.setLocation(rs.getString("location"));
            property.setSquareft(rs.getString("squareft"));
            property.setAmenities(rs.getString("amenities"));
            property.setStatus(rs.getString("status"));
            property.setSellerId(rs.getInt("seller_id"));
            return property;
        });
    }
	@Override
    public List<Property> filterProperties(String location, double minPrice, double maxPrice, String amenities) {
        String sql = "SELECT * FROM Properties WHERE location = ? AND price BETWEEN ? AND ? AND amenities LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{location, minPrice, maxPrice, "%" + amenities + "%"}, (rs, rowNum) -> {
            Property property = new Property();
            property.setPropertyId(rs.getInt("property_id"));
            property.setTitle(rs.getString("title"));
            property.setDescription(rs.getString("description"));
            property.setPrice(rs.getDouble("price"));
            property.setLocation(rs.getString("location"));
            property.setSquareft(rs.getString("squareft"));
            property.setAmenities(rs.getString("amenities"));
            property.setStatus(rs.getString("status"));
            property.setSellerId(rs.getInt("seller_id"));
            return property;
        });
    }
	
	 @Override
	    public Integer getPropertyIdByTitle(String title) {
	        String sql = "SELECT property_id FROM Properties WHERE title = ?";
	        try {
	            return jdbcTemplate.queryForObject(sql, new Object[]{title}, Integer.class);
	        } catch (Exception e) {
	            return null;
	        }
	    }
	 
	 
	 
}