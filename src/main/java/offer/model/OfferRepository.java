//
// Repository
//
package offer.model;

import org.springframework.data.repository.CrudRepository;

public interface OfferRepository extends CrudRepository<Offer, Long>{
	
	Offer findOneByPrice(String price);
}
