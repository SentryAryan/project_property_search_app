package project_property_search_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Seller;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.PropertyService;
import project_property_search_app.service.SellerService;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
	
	@Autowired
    private BuyerService buyerService;
 
    @Autowired
    private SellerService sellerService;
 
    @Autowired
    private PropertyService propertyService;
    
    @GetMapping("/adminDashboard")
    public String showAdminDashboard() {
        return "adminDashboard"; // This will render adminDashboard.jsp
    }
    
    // Buyer Management
    @RequestMapping("/getAllBuyers")
    public String getAllBuyers(Model model) {
        List<Buyer> list = buyerService.getAllBuyers();
        model.addAttribute("list", list);
        return "buyerlist";
    }

    @RequestMapping("/addNewBuyerForm")
    public String addNewBuyerForm() {
        return "buyer-form";
    }

    @RequestMapping(value = "/addNewBuyer", method = RequestMethod.POST)
    public String addNewBuyer(@ModelAttribute Buyer buyerDetails, Model model) {
        Buyer buyer = buyerService.addNewBuyer(buyerDetails);
        model.addAttribute("buyer", buyer);
        return "buyer";
    }
    
    @GetMapping("/updateBuyerForm")
    public String showUpdateBuyerForm() {
        return "updatebuyer-form";
    }

    @PostMapping("/updateBuyer")
    public String updateBuyer(@RequestParam("buyer_id") int buyer_id,
                              @RequestParam("email") String email,
                              @RequestParam("password") String password,
                              Model model) {
        Buyer updatedBuyer = buyerService.updateBuyer(buyer_id, email, password);
        model.addAttribute("buyer", updatedBuyer);
        return "buyer";
    }
    @GetMapping("/getBuyerByIdForm")
    public String showGetBuyerByIdForm() {
        return "getbuyerbyid-form";
    }

    @GetMapping("/getBuyerById")
    public String getBuyerById(@RequestParam("buyer_id") int buyer_id, Model model) {
        Buyer buyer = buyerService.getBuyerById(buyer_id);
            model.addAttribute("buyer", buyer);
            return "buyer";
        }
    
    // Seller Management
    @RequestMapping("/getAllSellers")
    public String getAllSellers(Model model) {
        List<Seller> list = sellerService.getAllSellers();
        model.addAttribute("list", list);
        return "sellerlist";
    }

    @RequestMapping("/addNewSellerForm")
    public String addNewSellerForm() {
        return "seller-form";
    }

    @RequestMapping(value = "/addNewSeller", method = RequestMethod.POST)
    public String addNewSeller(@ModelAttribute Seller sellerDetails, Model model) {
        Seller seller = sellerService.addNewSeller(sellerDetails);
        model.addAttribute("seller", seller);
        return "seller";
    }
    
   
    @GetMapping("/updateSellerForm")
    public String showUpdateSellerForm() {
        return "updateseller-form";
    }

    @PostMapping("/updateSeller")
    public String updateSeller(@RequestParam("seller_id") int seller_id,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model) {
        Seller updatedSeller = sellerService.updateSeller(seller_id, email, password);
        if(updatedSeller !=null) {
        model.addAttribute("seller", updatedSeller);
        return "seller";
        }
        else {
        	return "error";
        }
    }
    @RequestMapping(value = "/getSellerByIdForm", method = RequestMethod.GET)
    public String showGetSellerByIdForm() {
        return "getsellerbyid-form";
    }

    @RequestMapping(value = "/getSellerbySellerId", method = RequestMethod.GET)
    public String getSellerbySellerId(@RequestParam("seller_id") int seller_id, Model model) {
        Seller seller = sellerService.getSellerbySellerId(seller_id);
        if (seller != null) {
            model.addAttribute("seller", seller);
            return "seller";
        } else {
            return "error";
        }
    }
    
 
    // Property Management
    @RequestMapping("/getAllProperties")
    public String getAllProperties(Model model) {
        List<Property> list = propertyService.getAllProperties();
        model.addAttribute("list", list);
        return "propertylist";
    }

    @RequestMapping("/addNewPropertyForm")
    public String addNewPropertyForm() {
        return "property-form";
    }

    @RequestMapping(value = "/addNewProperty", method = RequestMethod.POST)
    public String addNewProperty(@ModelAttribute Property propertyDetails, Model model) {
        Property property = propertyService.addNewProperty(propertyDetails);
        model.addAttribute("property", property);
        return "property";
    }
   
    
    @GetMapping("/updatePropertyForm")
    public String showUpdatePropertyForm() {
        return "updateproperty-form";
    }

    @PostMapping("/updateProperty")
    public String updateProperty(@RequestParam("property_id") int property_id,
                                 @RequestParam("price") Double price,
                                 Model model) {
        Property updatedProperty = propertyService.updateProperty(property_id, price);
        if( updatedProperty!=null) {
        model.addAttribute("property", updatedProperty);
        return "property";
        }else {
        	return "error";
        }
    }
    

    @RequestMapping(value = "/getPropertyByIdForm", method = RequestMethod.GET)
    public String showGetPropertyByIdForm() {
        return "getpropertybyid-form";
    }

    @RequestMapping(value = "/getPropertyByPropertyId", method = RequestMethod.GET)
    public String getPropertyByPropertyId(@RequestParam("property_id") int property_id, Model model) {
        Property property = propertyService.getPropertyByPropertyId(property_id);
        if (property != null) {
            model.addAttribute("property", property);
            return "property";
        } else {
            return "error";
        }
    }
}