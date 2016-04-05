package edu.mum.eselling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.Credentials;

@Repository
public interface CredentialRepository extends CrudRepository<Credentials, String> {

}
