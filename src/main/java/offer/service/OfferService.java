//
// 
//
package offer.service;

import java.util.Collection;

import offer.bean.OfferBean;
import offer.model.Offer;

public interface OfferService {
	
	Offer getOfferById(long id);

	Offer getOfferByPrice(String price);

	Collection<Offer> getAllOffers();

    Offer create(OfferBean offerBean);
}
