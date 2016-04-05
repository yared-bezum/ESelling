package edu.mum.eselling.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.eselling.domain.ProductOrder;

public interface OrderRepository extends CrudRepository<ProductOrder, Long> {

}
