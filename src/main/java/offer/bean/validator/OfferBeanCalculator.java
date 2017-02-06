//
//   Calculates values when new offer is created
//
package offer.bean.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import offer.bean.OfferBean;
import offer.service.OfferService;

@Component
public class OfferBeanCalculator implements Validator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OfferBeanCalculator.class);
	
	@Autowired
	OfferService offerService;

	//@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(OfferBean.class);
	}

	//@Override
	public void validate(Object target, Errors errors) {
		LOGGER.debug("Calculating {}", target);
		OfferBean bean = (OfferBean) target;
        calculateValue(errors, bean);
	}

    private void calculateValue(Errors errors, OfferBean bean) {
    	
		LOGGER.debug("Setting calcvalue {}", bean.getPrice());
    	bean.setCalcvalue(bean.getPrice() + "0");
		LOGGER.debug("Calcvalue = {}", bean.getCalcvalue());
    	
    }
}
