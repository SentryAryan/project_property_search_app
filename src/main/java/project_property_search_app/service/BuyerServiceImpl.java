package project_property_search_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Visit;
import project_property_search_app.repository.BuyerRepository;
import project_property_search_app.repository.PropertyRepository;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;
    
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.getAllBuyers();
    }

    @Override
    public Buyer addNewBuyer(Buyer buyer) {
        return buyerRepository.addNewBuyer(buyer);
    }

    @Override
    public Buyer updateBuyer(int buyer_id, String email, String password) {
        buyerRepository.updateBuyer(buyer_id, email, password);
        return buyerRepository.getBuyerById(buyer_id);
    }

    @Override
    public Buyer getBuyerById(int buyer_id) {
        return buyerRepository.getBuyerById(buyer_id);
    }

    @Override
    public void save(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @Override
    public Buyer findByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }

    @Override
    public Buyer updateBuyerProfile(int buyerId, String email, String password) {
        buyerRepository.updateBuyerProfile(buyerId, email, password);
        return buyerRepository.getBuyerProfile(buyerId);
    }

    @Override
    public Buyer getBuyerProfile(int buyerId) {
        return buyerRepository.getBuyerProfile(buyerId);
    }
    @Override
    public List<Property> searchProperties(String location) {
        return propertyRepository.searchProperties(location);
    }

    @Override
    public List<Property> filterProperties(String location, double minPrice, double maxPrice, String amenities) {
        return propertyRepository.filterProperties(location, minPrice, maxPrice, amenities);
    }

    @Override
    public boolean addFavorite(String buyerUsername, String propertyTitle) {
        Integer buyerId = buyerRepository.getBuyerIdByUsername(buyerUsername);
        Integer propertyId = propertyRepository.getPropertyIdByTitle(propertyTitle);

        if (buyerId == null || propertyId == null) {
            return false;
        }

        return buyerRepository.addFavorite(buyerId, propertyId);
    }

    @Override
    public List<Property> getFavoritePropertiesByBuyerUsername(String username) {
        return buyerRepository.getFavoritePropertiesByBuyerUsername(username);
    }

    @Override
    public boolean addInquiry(String buyerUsername, String propertyTitle, String message) {
        Integer buyerId = buyerRepository.getBuyerIdByUsername(buyerUsername);
        Integer propertyId = propertyRepository.getPropertyIdByTitle(propertyTitle);

        if (buyerId == null || propertyId == null) {
            return false;
        }

        boolean isAdded = buyerRepository.addInquiry(buyerId, propertyId, message);
        if (isAdded) {
            notifySeller(propertyId, message);
        }
        return isAdded;
    }

    private void notifySeller(int propertyId, String message) {
        // Logic to notify the seller about the inquiry
        // This could be an email notification, a message in the system, etc.
    }

    @Override
    public boolean scheduleVisit(String buyerUsername, String propertyTitle, String visitDate, String status) {
        Visit visit = new Visit();
        visit.setBuyerUsername(buyerUsername);
        visit.setPropertyTitle(propertyTitle);
        visit.setVisitDate(visitDate);
        visit.setStatus(status);
        return true;
    }
    

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.getAllProperties();
    }
    
    
}