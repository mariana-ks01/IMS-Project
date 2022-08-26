package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.qa.ims.controller.Action;

public class ActionTest {
	@Test
	public void notNullTest() {
		assertNotNull(Action.READ);
	}
	
	@Test
	public void getDescription() {
		String description = "READ: To read an entity from the database";
		assertEquals(description, Action.READ.getDescription());
	}
}
