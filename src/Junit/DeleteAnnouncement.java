package Junit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import announcement.EventAnnouncement;
import junit.framework.TestCase;

public class DeleteAnnouncement extends TestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testDeleteAnnouncement() throws Exception {
		EventAnnouncement ev = new EventAnnouncement();
		boolean temp = ev.deleteAnnouncement("20160504110531");
		Assert.assertTrue(temp);
	}

}
