package project_property_search_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.service.SellerService;

@Controller
@RequestMapping("/seller")
public class SellerDashboardController {
    @Autowired
    private SellerService sellerService;

    @GetMapping("/sellerDashboard")
    public String showSellerDashboard() {
        return "sellerDashboard"; // This will render sellerDashboard.jsp
    }

    @GetMapping("/respondToInquiryForm")
    public String showRespondToInquiryForm(Model model) {
        return "respondToInquiryForm";
    }
 
    @PostMapping("/respondToInquiry")
    public String respondToInquiry(@RequestParam int sellerId, @RequestParam int inquiryId, @RequestParam String response, Model model) {
        sellerService.respondToInquiry(sellerId, inquiryId, response);
        return "responseSuccess";
    }

   
}