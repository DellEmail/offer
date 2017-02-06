//
//   Validates field entries when new offer is created
//
package offer.bean.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import offer.bean.OfferBean;
import offer.bean.UserBean;
import offer.service.OfferService;

@Component
public class OfferBeanValidator implements Validator{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OfferBeanValidator.class);
	
	@Autowired
	OfferService offerService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(OfferBean.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LOGGER.debug("Validating {}", target);
		OfferBean bean = (OfferBean) target;
        validatePrice(errors, bean);
	}

    private void validatePrice(Errors errors, OfferBean bean) {
        if (offerService.getOfferByPrice(bean.getPrice()) != null) {
            errors.reject("price.exists", "Offer with this price already exists");
        }
    }
}
