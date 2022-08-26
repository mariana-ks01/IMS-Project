package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DomainTest {
	@Test
	public void notNullTest() {
		assertNotNull(Domain.CUSTOMER);
	}
	
	@Test
	public void getDescription() {
		String description = "CUSTOMER: Information about customers";
		assertEquals(description, Domain.CUSTOMER.getDescription());
	}
}
