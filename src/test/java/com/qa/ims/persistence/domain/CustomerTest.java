package com.qa.ims.persistence.domain;


import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	
	@Test
	public void customerCreation() {
	Customer customer = new Customer();
	assertNotNull(customer);
	
	}
	
	@Test
	public void hashTest() {
		Customer x = new Customer("Nancy", "Drew");  // equals and hashCode check name field value
	    Customer y = new Customer("Nancy", "Drew");
	    Assert.assertTrue(x.equals(y) && y.equals(x));
	    Assert.assertTrue(x.hashCode() == y.hashCode());
	}
}
