package edu.mum.eselling.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eselling.domain.Credentials;
import edu.mum.eselling.repository.CredentialRepository;
import edu.mum.eselling.service.CredentialsService;


@Service
@Transactional
public class CredentilasServiceImpl implements CredentialsService{
	
	
	@Autowired
	CredentialRepository credentialRepository;
	
	public List<Credentials> getAll(){
		
		return (List<Credentials>)credentialRepository.findAll();
	}

	

}
