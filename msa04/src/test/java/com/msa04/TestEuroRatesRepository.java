package com.msa04;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.msa04.config.MongoDBConfig;
import com.msa04.documents.EuroRate;
import com.msa04.repositories.EuroRatesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MongoDBConfig.class})
@ActiveProfiles("scratch")
public class TestEuroRatesRepository extends TestCase implements CommandLineRunner {

	@Autowired
	EuroRatesRepository euroRatesRepository;
	
	
	protected void setUp() throws Exception {
		SpringApplication.run(TestEuroRatesRepository.class, "");
	}
	
	protected void tearDown() throws Exception {
		System.exit(0);
	}
	
	
	@Override	
	public void run(String... args) throws Exception {
		testEuroRatesRepository();
	}
	
	@Test
	public void testEuroRatesRepository() {

		List<EuroRate> euroRates = euroRatesRepository.findAll();
		assertNotNull(euroRates);
		assertTrue(euroRates.size() > 0);
		System.out.println("Size of euro rates: " + euroRates.size());
		
		euroRates = euroRatesRepository.findByDate("2016-08-10");
		assertNotNull(euroRates);
		assertTrue(euroRates.size() > 0);		
		System.out.println("Size of euro rates: " + euroRates.size());
		
		EuroRate euroRate = euroRatesRepository.findByDateAndCurrency("2016-08-11", "SEK");
		assertNotNull(euroRate);
		System.out.println(euroRate);

	}

}

