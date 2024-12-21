package project_property_search_app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Property;

@Repository
public class BuyerRepositoryImpl implements BuyerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Buyer> getAllBuyers() {
        String sql = "SELECT * FROM Buyer";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Buyer buyer = new Buyer();
            buyer.setBuyerId(rs.getInt("buyer_id"));
            buyer.setUsername(rs.getString("username"));
            buyer.setPassword(rs.getString("password"));
            buyer.setEmail(rs.getString("email"));
            return buyer;
        });
    }

    @Override
    public Buyer addNewBuyer(Buyer buyer) {
        String sql = "INSERT INTO Buyer (username, password, email) VALUES (?, ?, ?)";
        int n = jdbcTemplate.update(sql, buyer.getUsername(), buyer.getPassword(), buyer.getEmail());
        return (n > 0) ? buyer : null;
    }

    @Override
    public void updateBuyer(int buyer_id, String email, String password) {
        String sql = "UPDATE Buyer SET email = ?, password = ? WHERE buyer_id = ?";
        jdbcTemplate.update(sql, email, password, buyer_id);
    }

    @Override
    public Buyer getBuyerById(int buyer_id) {
        String sql = "SELECT * FROM Buyer WHERE buyer_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{buyer_id}, (rs, rowNum) -> {
            Buyer buyer = new Buyer();
            buyer.setBuyerId(rs.getInt("buyer_id"));
            buyer.setEmail(rs.getString("email"));
            buyer.setPassword(rs.getString("password"));
            return buyer;
        });
    }

    @Override
    public void save(Buyer buyer) {
        String sql = "INSERT INTO Buyer (buyer_id, username, email, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, buyer.getBuyerId(), buyer.getUsername(), buyer.getEmail(), buyer.getPassword());
    }

    @Override
    public Buyer findByEmail(String email) {
        String sql = "SELECT * FROM Buyer WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
            Buyer buyer = new Buyer();
            buyer.setBuyerId(rs.getInt("buyer_id"));
            buyer.setUsername(rs.getString("username"));
            buyer.setEmail(rs.getString("email"));
            buyer.setPassword(rs.getString("password"));
            return buyer;
        });
    }

    @Override
    public void updateBuyerProfile(int buyerId, String email, String password) {
        String sql = "UPDATE Buyer SET email = ?, password = ? WHERE buyer_id = ?";
        jdbcTemplate.update(sql, email, password, buyerId);
    }

    @Override
    public Buyer getBuyerProfile(int buyerId) {
        String sql = "SELECT * FROM Buyer WHERE buyer_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{buyerId}, (rs, rowNum) -> {
            Buyer buyer = new Buyer();
            buyer.setBuyerId(rs.getInt("buyer_id"));
            buyer.setUsername(rs.getString("username"));
            buyer.setEmail(rs.getString("email"));
            buyer.setPassword(rs.getString("password"));
            return buyer;
        });
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
    public List<Property> filterProperties(double minPrice, double maxPrice, double minSize, double maxSize, String amenities) {
        String sql = "SELECT * FROM Properties WHERE price BETWEEN ? AND ? AND size BETWEEN ? AND ? AND amenities LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{minPrice, maxPrice, minSize, maxSize, "%" + amenities + "%"}, (rs, rowNum) -> {
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
    public Integer getBuyerIdByUsername(String username) {
        String sql = "SELECT buyer_id FROM Buyer WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        } catch (Exception e) {
            return null;
        }
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

    @Override
    public boolean addFavorite(int buyerId, int propertyId) {
        String sql = "INSERT INTO Favorites (buyer_id, property_id) VALUES (?, ?)";
        int result = jdbcTemplate.update(sql, buyerId, propertyId);
        return result > 0;
    }

    @Override
    public boolean addInquiry(int buyerId, int propertyId, String message) {
        String sql = "INSERT INTO Inquiries (buyer_id, property_id, message) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, buyerId, propertyId, message);
        return result > 0;
    }

    @Override
    public List<Property> getFavoritePropertiesByBuyerUsername(String username) {
        String sql = "SELECT p.property_id, p.title, p.description, p.price, p.location, p.squareft, p.amenities, p.status, p.seller_id " +
                     "FROM Properties p " +
                     "INNER JOIN Favorites f ON p.property_id = f.property_id " +
                     "INNER JOIN Buyer b ON f.buyer_id = b.buyer_id " +
                     "WHERE b.username = ?";
        return jdbcTemplate.query(sql, new Object[]{username}, (rs, rowNum) -> {
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
    
    
    
    
}