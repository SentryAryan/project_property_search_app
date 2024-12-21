package project_property_search_app.repository;

import java.util.List;

import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Property;

public interface BuyerRepository {
    List<Buyer> getAllBuyers();
    Buyer addNewBuyer(Buyer buyer);
    void updateBuyer(int buyer_id, String email, String password);
    Buyer getBuyerById(int buyer_id);
    void save(Buyer buyer);
    Buyer findByEmail(String email);
    void updateBuyerProfile(int buyerId, String email, String password);
    Buyer getBuyerProfile(int buyerId);
    List<Property> searchProperties(String location);
    List<Property> filterProperties(double minPrice, double maxPrice, double minSize, double maxSize, String amenities);
    Integer getBuyerIdByUsername(String username);
    Integer getPropertyIdByTitle(String title);
    boolean addFavorite(int buyerId, int propertyId);
    boolean addInquiry(int buyerId, int propertyId, String message);
    List<Property> getFavoritePropertiesByBuyerUsername(String username);
    
}