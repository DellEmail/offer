//
// Offer related controller
//
package offer.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import offer.bean.OfferBean;
import offer.bean.validator.OfferBeanCalculator;
import offer.bean.validator.OfferBeanValidator;
import offer.service.OfferService;

@Controller
public class OfferController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OfferController.class);

	@Autowired
	OfferService offerService;

	@Autowired
	OfferBeanValidator offerBean;

	@Autowired
	OfferBeanValidator offerBeanValidator;

	@Autowired
	OfferBeanCalculator offerBeanCalculator;

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(offerBeanValidator);
		binder.addValidators(offerBeanCalculator);
	}

	@RequestMapping("/offers")
	public ModelAndView getOffersPage() {
		LOGGER.debug("Getting offers page");
		return new ModelAndView("offers", "offers", offerService.getAllOffers());
	}
	
	//@PreAuthorize("@currentOfferServiceImpl.canAccessOffer(principal, #id)") // muidu current offer service vaja?
	@RequestMapping("/offer/{id}")
    public ModelAndView getOfferPage(@PathVariable Long id) {
		LOGGER.debug("Getting page for offer={}", id);
        return new ModelAndView("offer", "offer", offerService.getOfferById(id));
    }
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/offer/create", method = RequestMethod.GET)
	public ModelAndView getOfferCreatePage() {
		LOGGER.debug("Getting offer create form");
		return new ModelAndView("offer_create", "form", new OfferBean());
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/offer/create", method = RequestMethod.POST)
	public String handleOfferCreateForm(@Valid @ModelAttribute("form") OfferBean form, BindingResult bindingResult) {
		LOGGER.debug("Processing offer create form={}, bindingResult={}", form, bindingResult);
		if (bindingResult.hasErrors()) {
			return "offer_create";
		}
		try {
			offerService.create(form);
		} catch (DataIntegrityViolationException e) {
			LOGGER.warn("Exception occurred when trying to save the offer, assuming duplicate", e);
			bindingResult.reject("offer.exists", "Offer already exists");
			return "offer_create";
		}

		return "redirect:/offers";
		//return "redirect:/offer";
	}
}
