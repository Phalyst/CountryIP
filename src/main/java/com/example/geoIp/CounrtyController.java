package com.example.geoIp;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maxmind.geoip2.exception.GeoIp2Exception;


@RequestMapping("/api")
@CrossOrigin
@RestController
public class CounrtyController {
	@Autowired @Qualifier("CountryModel")
	private CountryModel countryModel;
	private final Logger log = LoggerFactory.getLogger(CounrtyController.class);
	
	@RequestMapping(value = "/getCountry", method = RequestMethod.GET)
	    public String getCountrydetails() throws IOException, GeoIp2Exception {
			return countryModel.getCountry();
		}
	 
	@RequestMapping( value = "/Country/{ip}", method = RequestMethod.GET)
    public String   getCountryIp( @PathVariable String ip )    throws IOException, GeoIp2Exception {
		log.debug("REST request to get Country Name for IP : {}", ip);
		String name = countryModel.getCountryName(ip);
		
		log.debug("REST response Country name : {}", name);
		return name;
	}

}
