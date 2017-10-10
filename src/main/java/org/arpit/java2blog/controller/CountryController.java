package org.arpit.java2blog.controller;

import java.util.List;
import org.arpit.java2blog.model.Country;
import org.arpit.java2blog.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

//	localhost:8080/SpringHibernateXml/getAllCountries
	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {

		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/getCountry/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		return countryService.getCountry(id);
	}

//	localhost:8080/SpringHibernateXml/addCountry
//	{
//		"countryName": "Ha Noi",
//		"population": 10000
//	}
	@RequestMapping(value = "/addCountry", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCountry(@RequestBody Country country) {
		countryService.addCountry(country);

	}

//	localhost:8080/SpringHibernateXml/updateCountry
//	{
//		"id": 4,
//		"countryName": "Can Tho",
//		"population": 8500
//	}
	@RequestMapping(value = "/updateCountry", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
	}

//	localhost:8080/SpringHibernateXml/deleteCountry/1
	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);
	}
}
