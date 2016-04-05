package edu.mum.eselling.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, Long> {

	@Query("SELECT v FROM Vendor v WHERE v.credentials.username = :name")
	public Vendor findVendorByUserName(@Param(value = "name") String name);

}
