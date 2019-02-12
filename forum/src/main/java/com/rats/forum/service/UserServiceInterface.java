package com.rats.forum.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rats.forum.user_crm.CrmUser;

public interface UserServiceInterface extends UserDetailsService {
	

    void save(CrmUser crmUser);
	
}
