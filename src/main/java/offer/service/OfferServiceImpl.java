//
// 
//
package offer.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import offer.bean.OfferBean;
import offer.model.Offer;
import offer.model.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OfferServiceImpl.class);

	@Autowired
	OfferRepository offerRepository;

	@Override
	public Offer getOfferById(long id) {
		LOGGER.debug("Getting offer={}", id);
		return offerRepository.findOne(id);
	}

	@Override
	public Collection<Offer> getAllOffers() {
		LOGGER.debug("Getting all offers");
		return (Collection<Offer>) offerRepository.findAll();
	}

	@Override
	public Offer create(OfferBean offerBean) {
		// Save data from bean to model
		Offer offer = new Offer();
		offer.setPrice(offerBean.getPrice());
		offer.setCalcvalue(offerBean.getCalcvalue());
		return offerRepository.save(offer);
	}

	@Override
	public Offer getOfferByPrice(String price) {
		LOGGER.debug("Getting offer={}", price);
		return offerRepository.findOneByPrice(price);
	}

}
