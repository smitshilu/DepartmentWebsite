package Junit;

import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import database.DAO;
import junit.framework.TestCase;

public class PostDisscussionTest extends TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testPostContent() throws SQLException {
		DAO dao = new DAO();
		boolean temp = dao.postContent("20160422121888", "SS665414", "Hello", "Hello Hi", "0", "2016-04-22 12:17:44");
		Assert.assertTrue(temp);
	}

}
