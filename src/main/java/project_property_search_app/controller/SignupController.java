package project_property_search_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Seller;
import project_property_search_app.service.AdminService;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.SellerService;

@Controller
public class SignupController {

	@Autowired
    private AdminService adminService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("role") String role) {
    	//it adds new user according to the role and also add the credentials 
        switch (role) {
            case "Admin":
                Admin admin = new Admin();
                admin.setUsername(username);
                admin.setEmail(email);
                admin.setPassword(password);
                adminService.save(admin);
                break;
            case "Seller":
                Seller seller = new Seller();
                seller.setUsername(username);
                seller.setEmail(email);
                seller.setPassword(password);
                sellerService.save(seller);
                break;
            case "Buyer":
                Buyer buyer = new Buyer();
                buyer.setUsername(username);
                buyer.setEmail(email);
                buyer.setPassword(password);
                buyerService.save(buyer);
                break;
        }
        return "redirect:/login";
    }
}