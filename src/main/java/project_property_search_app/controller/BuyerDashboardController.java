package project_property_search_app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Visit;
import project_property_search_app.service.BuyerService;

@Controller
@RequestMapping("/buyer")
public class BuyerDashboardController {

    @Autowired
    private BuyerService buyerService;

    @RequestMapping("/buyerDashboard")
    public String showBuyerDashboard(Model model) {
        return "buyerDashboard";
    }
        
    @GetMapping("/buyerProfile")
    public String viewProfile(Model model, HttpSession session) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        model.addAttribute("buyer", buyer);
        return "buyerprofile";
    }

    @GetMapping("/changePassword")
    public String showChangePasswordForm() {
        return "changePassword";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(HttpSession session, @RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmNewPassword, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        if (!buyer.getPassword().equals(oldPassword)) {
            model.addAttribute("error", "Old password is incorrect.");
            return "changePassword";
        }
        if (newPassword.equals(oldPassword)) {
            model.addAttribute("error", "Old password and new password should be different.");
            return "changePassword";
        }
        if (!newPassword.equals(confirmNewPassword)) {
            model.addAttribute("error", "New passwords do not match.");
            return "changePassword";
        }
        buyerService.updateBuyerProfile(buyerId, buyer.getEmail(), newPassword);
        model.addAttribute("message", "Password updated successfully.");
        return "changePassword";
    }

    @GetMapping("/changeEmail")
    public String showChangeEmailForm() {
        return "changeEmail";
    }

    @PostMapping("/updateEmail")
    public String updateEmail(HttpSession session, @RequestParam String password, @RequestParam String oldEmail, @RequestParam String newEmail, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        if (!buyer.getPassword().equals(password)) {
            model.addAttribute("error", "Password is incorrect.");
            return "changeEmail";
        }
        if (!buyer.getEmail().equals(oldEmail)) {
            model.addAttribute("error", "Old email is incorrect.");
            return "changeEmail";
        }
        if (oldEmail.equals(newEmail)) {
            model.addAttribute("error", "Old email and new email should be different.");
            return "changeEmail";
        }
        buyerService.updateBuyerProfile(buyerId, newEmail, buyer.getPassword());
        model.addAttribute("message", "Email updated successfully.");
        return "changeEmail";
    }
        
    @GetMapping("/searchProperties")
    public String searchProperties(@RequestParam("location") String location, Model model) {
        List<Property> properties = buyerService.searchProperties(location);
        model.addAttribute("properties", properties);
        model.addAttribute("location", location);
        return "searchResults";
    }

    @GetMapping("/filterProperties")
    public String filterProperties(@RequestParam("location") String location,
                                   @RequestParam("minPrice") double minPrice,
                                   @RequestParam("maxPrice") double maxPrice,
                                   @RequestParam("amenities") String amenities,
                                   Model model) {
        List<Property> properties = buyerService.filterProperties(location, minPrice, maxPrice, amenities);
        model.addAttribute("properties", properties);
        model.addAttribute("location", location);
        return "filterResults";
    }

    @RequestMapping("/filterPropertiesForm")
    public String showFilterPropertiesForm(Model model) {
        return "filterPropertiesForm";
    }

    @GetMapping("/addFavoriteForm")
    public String showAddFavoriteForm(Model model) {
        List<Property> favoriteProperties = buyerService.getAllProperties();
        System.out.println("Favorite Properties: " + favoriteProperties); // Debug statement
        model.addAttribute("favoriteProperties", favoriteProperties);
        return "addFavoriteForm";
    }

    @RequestMapping(value = "/addFavorite", method = RequestMethod.POST)
    public String addFavorite(HttpSession session, @RequestParam("propertyTitle") String propertyTitle, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        boolean isAdded = buyerService.addFavorite(buyer.getUsername(), propertyTitle);
        model.addAttribute("isAdded", isAdded);
        return "favoriteResult";
    }

    @GetMapping("/favoriteProperties")
    public String getFavoriteProperties(HttpSession session, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        List<Property> favoriteProperties = buyerService.getFavoritePropertiesByBuyerUsername(buyer.getUsername());
        model.addAttribute("favoriteProperties", favoriteProperties);
        return "favoriteProperties";
    }

    @RequestMapping("/addInquiryForm")
    public String showAddInquiryForm(Model model) {
        List<Property> properties = buyerService.getAllProperties();
        System.out.println("Properties: " + properties); // Debug statement
        model.addAttribute("properties", properties);
        return "addInquiryForm";
    }

    @RequestMapping(value = "/addInquiry", method = RequestMethod.POST)
    public String addInquiry(@RequestParam("propertyTitle") String propertyTitle,
                             @RequestParam("message") String message,
                             HttpSession session,
                             Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        boolean isAdded = buyerService.addInquiry(buyer.getUsername(), propertyTitle, message);
        model.addAttribute("isAdded", isAdded);
        return "inquiryResult";
    }

    @RequestMapping("/scheduleVisitForm")
    public String showScheduleVisitForm(Model model) {
        model.addAttribute("visit", new Visit());
        return "scheduleVisitForm";
    }

    @RequestMapping(value = "/scheduleVisit", method = RequestMethod.POST)
    public String scheduleVisit(HttpSession session,
                                @RequestParam("propertyTitle") String propertyTitle,
                                @RequestParam("visitDate") String visitDate,
                                @RequestParam("status") String status,
                                Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        boolean isScheduled = buyerService.scheduleVisit(buyer.getUsername(), propertyTitle, visitDate, status);
        String statusMessage;

        if (isScheduled) {
            if ("completed".equalsIgnoreCase(status)) {
                statusMessage = "Visit completed successfully!";
            } else if ("cancelled".equalsIgnoreCase(status)) {
                statusMessage = "Visit has been cancelled.";
            } else {
                statusMessage = "Visit scheduled successfully!";
            }
        } else {
            statusMessage = "Failed to schedule visit. Please try again.";
        }

        model.addAttribute("statusMessage", statusMessage);
        return "visitResult";
    }
}