package project_property_search_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_property_search_app.entity.Property;
import project_property_search_app.repository.PropertyRepository;



@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.getAllProperties();
    }

    @Override
    public Property addNewProperty(Property property) {
        return propertyRepository.addNewProperty(property);
    }

	
	
	@Override
    public Property updateProperty(int property_id, Double price) {
        propertyRepository.updateProperty(property_id, price);
        return propertyRepository.getPropertyByPropertyId(property_id);
    }

	@Override
	public Property getPropertyByPropertyId(int property_id) {
		Property property= propertyRepository.getPropertyByPropertyId(property_id);
		return property;
		
	}

	@Override
	public List<Property> searchProperties(String location) {
	 return propertyRepository.searchProperties(location);
	}

    @Override
    public Integer getPropertyIdByTitle(String title) {
        return propertyRepository.getPropertyIdByTitle(title);
    }
    
}