package Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import announcement.EventAnnouncement;
import junit.framework.TestCase;

public class PostAnnouncement extends TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddEventNewsAnnouncement() throws Exception {
		EventAnnouncement ev = new EventAnnouncement();
		boolean temp = ev.postAnnouncement("ss665414", "Hi", "event", "null", "null");
		Assert.assertTrue(temp);
	}

}
