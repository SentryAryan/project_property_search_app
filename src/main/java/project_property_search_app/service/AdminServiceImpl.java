package project_property_search_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_property_search_app.entity.Admin;
import project_property_search_app.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
}