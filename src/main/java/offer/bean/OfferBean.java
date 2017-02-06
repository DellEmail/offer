//
//  Offer model
//
package offer.bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OfferBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(OfferBean.class);
	
	@NotEmpty
    private String price = "";
    private String calcvalue = "";
	
	public String getPrice() {
		LOGGER.debug("getPrice {}", price);
		return price;
	}

	public void setPrice(String price) {
		LOGGER.debug("setPrice {}", price);
		this.price = price;
	}

	public String getCalcvalue() {
		LOGGER.debug("setPrice {}", calcvalue);
		return calcvalue;
	}
	
	public void setCalcvalue(String calcvalue) {
		LOGGER.debug("setCalcvalue {}", calcvalue);
		this.calcvalue = calcvalue;
	}
	
}
