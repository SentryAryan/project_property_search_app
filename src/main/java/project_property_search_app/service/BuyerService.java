package project_property_search_app.service;

import java.util.List;

import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Property;

public interface BuyerService {
    List<Buyer> getAllBuyers();
    Buyer addNewBuyer(Buyer buyer);
    Buyer updateBuyer(int buyer_id, String email, String password);
    Buyer getBuyerById(int buyer_id);
    void save(Buyer buyer);
    Buyer findByEmail(String email);
    Buyer updateBuyerProfile(int buyerId, String email, String password);
    Buyer getBuyerProfile(int buyerId);
    List<Property> searchProperties(String location);
    List<Property> filterProperties(String location, double minPrice, double maxPrice, String amenities);
    boolean addFavorite(String buyerUsername, String propertyTitle);
    List<Property> getFavoritePropertiesByBuyerUsername(String username);
    boolean addInquiry(String buyerUsername, String propertyTitle, String message);
    boolean scheduleVisit(String buyerUsername, String propertyTitle, String visitDate, String status);
    List<Property> getAllProperties();
    
    
}