package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import database.DAO;
import junit.framework.TestCase;

public class DeleteDisscussion extends TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testDeleteContent() throws SQLException {
		DAO dao = new DAO();
		boolean temp = dao.deleteContent("20160422121888");
		Assert.assertTrue(temp);
	}

}
