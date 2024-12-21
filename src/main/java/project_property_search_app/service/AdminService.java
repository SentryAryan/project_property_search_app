package project_property_search_app.service;



import org.springframework.stereotype.Service;

import project_property_search_app.entity.Admin;

@Service
public interface AdminService {
	void save(Admin admin);
	Admin findByEmail(String email) ;

}
