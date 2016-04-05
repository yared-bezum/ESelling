package edu.mum.eselling.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.Admin;
import edu.mum.eselling.repository.AdminRepository;
import edu.mum.eselling.repository.CredentialRepository;
import edu.mum.eselling.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired 
	AdminRepository adminRepository;
	
	
	@Autowired 
	private CredentialRepository credentialRepository;
	
	public Admin getAdminByUserName(String name){
		
		return adminRepository.findAdminByUserName(name);
	}
	
	
	

}
