package project_property_search_app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Seller;
import project_property_search_app.service.AdminService;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.SellerService;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This will render login.jsp
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role,
                        HttpSession session) {
        switch (role) {
            case "Admin":
                Admin admin = adminService.findByEmail(email);
                if (admin != null && admin.getPassword().equals(password)) {
                    session.setAttribute("user", admin);
                    return "redirect:/admin/adminDashboard";
                }
                break;
            case "Seller":
                Seller seller = sellerService.findByEmail(email);
                if (seller != null && seller.getPassword().equals(password)) {
                    session.setAttribute("user", seller);
                    return "redirect:/seller/sellerDashboard";
                }
                break;
            case "Buyer":
                Buyer buyer = buyerService.findByEmail(email);
                if (buyer != null && buyer.getPassword().equals(password)) {
                    session.setAttribute("user", buyer);
                    session.setAttribute("buyerId", buyer.getBuyerId()); // Ensure buyerId is set
                    return "redirect:/buyer/buyerDashboard";
                }
                break;
        }
        return "login"; // Redirect to login page if authentication fails
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}