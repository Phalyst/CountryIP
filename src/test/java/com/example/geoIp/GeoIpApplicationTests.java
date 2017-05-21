package com.example.geoIp;

import java.io.IOException;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoIpApplicationTests {

	@Test
	public void contextLoads() throws IOException, GeoIp2Exception {
		CountryModel countryModel =  new CountryModel();
		Assert.assertEquals("South Africa", countryModel.getCountryName("196.43.34.190"));  
		
	}

}
