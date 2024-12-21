package project_property_search_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project_property_search_app.entity.Seller;


@Service
public interface SellerService {
    
    List<Seller> getAllSellers();
    Seller addNewSeller(Seller seller);
    Seller updateSeller(int seller_id, String email, String password);
    Seller getSellerbySellerId(int seller_id);
    void respondToInquiry(int sellerId, int inquiryId, String response);
    void save(Seller seller);
    Seller findByEmail(String email) ;
    
    
    
} 
