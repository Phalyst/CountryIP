package com.example.geoIp;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.omg.CORBA.portable.InputStream;
import org.springframework.context.annotation.Configuration;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;


@Configuration(value = "CountryModel")
public class CountryModel {

	   public static final String DATABASE_COUNTRY = "GeoLite2-Country.mmdb";   
	   public static final String DATABASE_CITY = "geoIp/GeoLite2-City.mmdb";
	   
	   public String getCountry() throws IOException, GeoIp2Exception{
		    String ip = "128.101.101.101";
		    
		    DatabaseReader reader = CountryModel.loadDB();
		    
		    InetAddress ipAddress = InetAddress.getByName(ip);
		    CityResponse response = reader.city(ipAddress);

	       Country country = response.getCountry();
	       //System.out.println("Country IsoCode: "+ country.getIsoCode()); // 'US'
	       //System.out.println("Country Name: "+ country.getName()); // 'United States'
	       
	       //Subdivision subdivision = response.getMostSpecificSubdivision();
	      // System.out.println("Subdivision Name: " +subdivision.getName()); // 'Minnesota'
	      // System.out.println("Subdivision IsoCode: "+subdivision.getIsoCode()); // 'MN'
	 
	       return country.getName();

	   }
	   
	   public String getCountryName(String ip) throws IOException, GeoIp2Exception{
		    
		    DatabaseReader reader = CountryModel.loadDB();
		    
		    InetAddress ipAddress = InetAddress.getByName(ip);
		    CityResponse response = reader.city(ipAddress);

	        Country country = response.getCountry();
	        
	        return country.getName();
	   }
	   
	   public static DatabaseReader loadDB() throws IOException{

		   ClassLoader classLoader = new ClassLoader() {
		    };
		   classLoader.getClass().getClassLoader();
		    File dbFile = new File(classLoader.getResource("GeoLite2-City.mmdb").getFile());

		   DatabaseReader reader = new DatabaseReader.Builder(dbFile).build();
		   
		   return reader;
		   
	   }

}
