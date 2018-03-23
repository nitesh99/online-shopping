package com.sig.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sig.shoppingbackend.dao.CategoryDAO;
import com.sig.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sig.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Television");
	 * category.setDescription("Most of Brand's available");
	 * category.setImageURL("cat100.jpg");
	 * 
	 * assertEquals("Successfully added a category inside the table!", true,
	 * categoryDAO.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category=categoryDAO.get(3);
	 * assertEquals("Successfully fetched single category from the the table!",
	 * "Television", category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(3);
	 * 
	 * category.setName("TV");
	 * assertEquals("Successfully update single category in the the table!",true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(3);
	 * assertEquals("Successfully deleted single category in the the table!",true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() { category = categoryDAO.get(3);
	 * assertEquals("Successfully the list of categories from the the table!",2,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {
		// add operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("cat1.jpg");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("cat2.jpg");

		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));

		//fetching and updating category
		category = categoryDAO.get(2);
		  
		 category.setName("TV");
		 assertEquals("Successfully update single category in the the table!",true,categoryDAO.update(category));
		 
		 //delete the category
		 assertEquals("Successfully deleted single category in the the table!",true,categoryDAO.delete(category));
		 
		 //fetching the list
		 assertEquals("Successfully fetched the list of categories from the the table!",1, categoryDAO.list().size());
	}
}
