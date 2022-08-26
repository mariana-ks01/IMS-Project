package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	} 

	@Test
	public void testCreate() {
		final Item created = new Item(2L, "Harry Potter", 12.95);
		assertEquals("\n" + created + "\n", "\n" + DAO.create(created) + "\n");
	}
	
	@Test
	public void createExcessName() {
		final Item created = new Item(2L, "Asklfs;ghjfdjsa;d’fag;s;ldkfdl;gasffsgasffdg", 12.95);
		assertNull(DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L, "The lord of the rings", 14.96));
		assertEquals("\n" + expected + "\n", "\n" + DAO.readAll() + "\n");
	}

	@Test
	public void testReadLatest() {
		assertEquals("\n" + new Item(1L, "The lord of the rings", 14.96)+ "\n", "\n" + DAO.readLatest() + "\n");
	}
	
	@Test 
	public void readLatestFail() {
		DAO.delete(1);
		assertNull(DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals("\n" + new Item(ID, "The lord of the rings", 14.96)+ "\n", "\n" + DAO.read(ID) + "\n");
	}
	
	@Test
	public void readInvalidId() {
		final long ID = 2L;
		assertNull(DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Item updated = new Item(1L, "The Great Expectations", 9.98);
		assertEquals("\n" + updated+ "\n", "\n" + DAO.update(updated)+ "\n");
	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	} 
}
