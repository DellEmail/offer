//
// Offer model
//
package offer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "offer")
public class Offer implements Serializable{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Offer.class);

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offerid", nullable = false, updatable = false)
	Long offerid;
	
	@Column(name = "price", nullable = false)
	String price;
	
	@Column(name = "calcvalue", nullable = true)
	String calcvalue;
	
	public Long getOfferid() {
		LOGGER.debug("getOfferid {}", offerid);
		return offerid;
	}
	
	public void setOfferid(Long offerid) {
		LOGGER.debug("setOfferid {}", offerid);
		this.offerid = offerid;
	}
	
	public String getPrice() {
		LOGGER.debug("getPrice {}", price);
		return price;
	}
	
	public void setPrice(String price) {
		LOGGER.debug("setPrice {}", price);
		this.price = price;
	}
	
	public String getCalcvalue() {
		LOGGER.debug("getCalcvalue {}", calcvalue);
		return calcvalue;
	}
	
	public void setCalcvalue(String calcvalue) {
		LOGGER.debug("setCalcvalue {}", calcvalue);
		this.calcvalue = calcvalue;
	}
	
	@Override
	public String toString() {
		return "Offer [offerid=" + offerid + ", price=" + price + "]";
	}

}
