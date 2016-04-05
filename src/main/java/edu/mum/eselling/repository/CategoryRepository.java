


package edu.mum.eselling.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.eselling.domain.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{

}
