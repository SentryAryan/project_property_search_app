package project_property_search_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_property_search_app.entity.Seller;
import project_property_search_app.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.getAllSellers();
    }

    @Override
    public Seller addNewSeller(Seller seller) {
        return sellerRepository.addNewSeller(seller);
    }

    @Override
    public Seller updateSeller(int seller_id, String email, String password) {
        sellerRepository.updateSeller(seller_id, email, password);
        return sellerRepository.getSellerbySellerId(seller_id);
    }

    @Override
    public Seller getSellerbySellerId(int seller_id) {
        return sellerRepository.getSellerbySellerId(seller_id);
    }

    @Override
    public void respondToInquiry(int sellerId, int inquiryId, String response) {
        sellerRepository.respondToInquiry(sellerId, inquiryId, response);
    }

    public void save(Seller seller) {
        sellerRepository.save(seller);
    }

    public Seller findByEmail(String email) {
        return sellerRepository.findByEmail(email);
    }

    
}