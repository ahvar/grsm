/**
 * 
 */
package com.circa.mrv.grs_manager.catalog;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

import com.circa.mrv.grs_manager.document.Order;
import com.circa.mrv.grs_manager.ui.ResearchCompanyOrderEntryPanel;

/**
 * Test for OrderRecord
 * @author Arthur Vargas
 */
public class OrderRecordTest {
	/** The filename for order records */
	private final String orderRecordFile = "test-files/order-record-test/order-records-least";
	/** The filename for order records */
	private final String moreOrderRecords = "test-files/order-record-test/order-record-all";
	/** The filename for order record titles */
	private static final String orderRecordTitles = "test-files/order-record-test/titles";
	/** the filename for order records */
	private static final String someOrderRecords = "test-files/order-record-test/order-record-and-more";
	/** study 006155 */
	private final String study006155 = "006155";
	/** study 145986 */
	private final String study145986 = "145986";
	/** study 006156 */
	private final String study006156 = "006156";
	/** study 006186 */
	private final String study006186 = "006186";
	/** site for the 21st order in the order-record-2 file */
	private final String site5005 = "5005";
	/** site for the 2nd order in the order-record-2 file */
	private final String site5002 = "5002";
	/** site for the 2nd order in the order-record-2 file */
	private final String site5007 = "5007";
	/** site for 2nd order in the order-record file */
	private final String site5008 = "5008";
	/** site for the 5th order in the order-record-2 file */
	private final String site5015 = "5015";
	/** site for the 6th order in the order-record-2 file */
	private final String site5018 = "5018";
	/** order number one*/
	private final long one = 1;
	/** order number three */
	private final long three = 3;
	/** order number 6 */
	private final long six = 6;
	/** Order count */
	private int orderCount = 7;
	/** ProductTitle count */
	private int ptCount = 22;
	/** Column count */
	private int columnCount = 52;
	/** JFrame for the GUI */
	private static JFrame gui;
	
	
	/**
	 * Tests OrderRecord constructor
	 */
	@Test
	public void testOrderRecord() {

		
	}

	/**
	 * Tests loadOrdersFromFile() method. Loads
	 */
	@Test
	public void testLoadOrdersFromFile() {
		OrderRecord or = new OrderRecord();
		or.loadTitlesFromFile(orderRecordTitles);
		or.loadOrdersFromFile(orderRecordFile);
		assertEquals(or.getFirst(),3); // the first column that is a product title
		assertEquals(or.getLast(),24); //  the last column that is a product title
		for(int i = 3; i <= 24; i++) { // if a column title is within this range, it is a produc title
			if(!or.isProductTitle(i))
				fail();
		}
		assertEquals(or.getProductTitles().size(), ptCount);
		try {
		assertEquals(or.getShortOrderInfo().length, 800);
		}catch(IOException ioe ) {
			throw new IllegalArgumentException(ioe.getMessage());
		}catch(NullPointerException npe ) {
			throw new NullPointerException(npe.getMessage());
		}
		// order list is empty before update method is called and contains 7 orders after method completes
		assertEquals(or.getOrderRecordList().size(),6);
		assertEquals(or.getStudyList().size(),2);
		assertEquals(or.getSiteList().size(),6);
		
		if(!or.getStudyList().get(0).equals(study006155))
			fail();
		if(!or.getStudyList().get(1).equals(study145986))
			fail();
		
		if(!or.getSiteList().get(1).equals(site5007))
			fail();
		if(!or.getSiteList().get(2).equals(site5008))
			fail();
		if(!or.getSiteList().get(5).equals(site5018))
			fail();
		if(or.getOrderRecordList().get(0).getNumber() != one )
			fail();
		if(or.getOrderRecordList().get(2).getNumber() != three )
			fail();
		if(or.getOrderRecordList().get(5).getNumber() != six )
			fail();
		
		// create new order record with more orders and check study list
		OrderRecord or2 = new OrderRecord();
		or2.loadTitlesFromFile(orderRecordTitles);
		or2.loadOrdersFromFile(moreOrderRecords);
		
		if(!or2.getStudyList().get(0).equals(study006155))
			fail();
		if(!or2.getStudyList().get(1).equals(study145986))
			fail();
		if(!or2.getStudyList().get(2).equals(study006156))
			fail();
		if(!or2.getStudyList().get(7).equals("006186"))
			fail();
		if(!or2.getSiteList().get(0).equals("5002") || !or2.getSiteList().get(1).equals("5007") || !or2.getSiteList().get(2).equals("5008"))
			fail();
		if(!or2.getSiteList().get(10).equals("2352") || !or2.getSiteList().get(11).equals("2353") || !or2.getSiteList().get(12).equals("2354"))
			fail();
		if(!or2.getSiteList().get(23).equals("2034") || !or2.getSiteList().get(24).equals("SHP") )
			fail();
		if(!or2.getSiteList().get(92).equals("2539") || !or2.getSiteList().get(93).equals("5017") || !or2.getSiteList().get(94).equals("2211") ||
				!or2.getSiteList().get(97).equals("2533") || !or2.getSiteList().get(98).equals("2502") || !or2.getSiteList().get(99).equals("5053")	)
			fail();
		
		
		if(!or2.getOrderRecordList().get(528).getPo().equals("17004101 OD")) fail();
		if(!or2.getOrderRecordList().get(529).getPo().equals("17004102 OD")) fail();
		if(!or2.getOrderRecordList().get(530).getPo().equals("17004103 OD")) fail();
		if(!or2.getOrderRecordList().get(531).getPo().equals("17004539 OD")) fail();
		if(!or2.getOrderRecordList().get(532).getPo().equals("18000008 OD")) fail();
		if(!or2.getOrderRecordList().get(533).getPo().equals("18000009 OD")) fail();
		if(!or2.getOrderRecordList().get(534).getPo().equals("18000027 OD")) fail();
		
		if(!or2.getOrderRecordList().get(442).getCity().equals("Tokyo")) fail();
		if(!or2.getOrderRecordList().get(462).getCity().equals("Oklahoma City")) fail();
		if(!or2.getOrderRecordList().get(246).getCity().equals("Jerez de La Frontera")) fail();
		if(!or2.getOrderRecordList().get(248).getCity().equals("Salamanca, Castilla y Leon")) fail();
		if(!or2.getOrderRecordList().get(43).getCity().equals("Milano")) fail();
		if(!or2.getOrderRecordList().get(45).getCity().equals("Winston Salem")) fail();
		if(!or2.getOrderRecordList().get(73).getCity().equals("Landsberg")) fail();
		if(!or2.getOrderRecordList().get(530).getCity().equals("Tampa")) fail();
		
	}
	
	/**
	 * Tests updateOrderList()
	 */
	@Test
	public void testUpdateOrdersAndSites() {
		OrderRecord or = new OrderRecord();
		or.loadTitlesFromFile(orderRecordTitles);
		or.loadOrdersFromFile(moreOrderRecords);
		try {
		System.out.println(or.getOrderRecordList().size());
		
		} catch(IllegalArgumentException iae) {
			fail();
		}
		
		
	}
	
	
	/**
	 * Tests updateStudyList()
	 */
	@Test
	public void testUpdateStudyList() {
		OrderRecord or = new OrderRecord();
		or.loadTitlesFromFile(orderRecordTitles);
		or.loadOrdersFromFile(moreOrderRecords);
		or.updateStudyList();
		assertEquals(or.getStudyList().get(0),"006155");
		assertEquals(or.getStudyList().get(1),"145986");
		assertEquals(or.getStudyList().get(2),"006156");
		
		assertEquals(or.getStudyList().toArray()[0],"006155");
		assertEquals(or.getStudyList().toArray()[1],"145986");
		assertEquals(or.getStudyList().toArray()[2],"006156");	
	}
	
	/**
	 * Tests updateSiteList()
	 */
	@Test
	public void testUpdateSiteList() {
		OrderRecord or = new OrderRecord();
		or.loadTitlesFromFile(orderRecordTitles);
		or.loadOrdersFromFile(moreOrderRecords);
		or.updateSiteList();
	
		assertEquals(or.getSiteList().get(0),"5002");
		assertEquals(or.getSiteList().get(1),"5007");
		assertEquals(or.getSiteList().get(2),"5008");
		assertEquals(or.getSiteList().get(3),"5009");
		assertEquals(or.getSiteList().get(4),"5015");
		assertEquals(or.getSiteList().get(5),"5018");
		assertEquals(or.getSiteList().get(6),"5019");
		assertEquals(or.getSiteList().get(7),"2031");
		assertEquals(or.getSiteList().get(8),"2032");
		assertEquals(or.getSiteList().get(9),"2351");
		assertEquals(or.getSiteList().get(10),"2352");
		assertEquals(or.getSiteList().get(11),"2353");
		assertEquals(or.getSiteList().get(12),"2354");
		
		assertEquals(or.getSiteList().toArray()[0],"5002");
		assertEquals(or.getSiteList().toArray()[1],"5007");
		assertEquals(or.getSiteList().toArray()[2],"5008");	
		
	}
	
	
	/**
	 * Tests loadTitlesFromFile
	 */
	@Test
	public void testLoadTitlesFromFile() {
		OrderRecord or = new OrderRecord();
		or.loadTitlesFromFile(orderRecordTitles);
		//String product = null;
		//for(int i = 0; i < or.getProductTitles().size(); i++) {
			//product = or.getProductTitles().get(i).getFam() + " " + or.getProductTitles().get(i).getGen() + " " + 
				//	or.getProductTitles().get(i).getDescription();
			//System.out.println(product);
		//}
		assertEquals(or.getProductTitles().size(),ptCount);
	}

	/**
	 * Test method for {@link com.circa.mrv.grs_manager.catalog.OrderRecord#getOrderById(long)}.
	 */
	@Test
	public void testGetOrderById() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.circa.mrv.grs_manager.catalog.OrderRecord#getShortOrderInfo()}.
	 */
	@Test
	public void testGetShortOrderInfo() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.circa.mrv.grs_manager.catalog.OrderRecord#getOrderByPOAndStudy(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetOrderByPOAndStudy() {
		//fail("Not yet implemented");
	}

	/**
	 * Tests getLastOrder()
	 */
	@Test
	public void testGetLastOrder() {
		OrderRecord or = new OrderRecord();
		or.loadTitlesFromFile(orderRecordTitles);
		or.loadOrdersFromFile(moreOrderRecords);
		for(int i = 0; i < or.getOrderRecordList().size(); i++) {
			//System.out.println(i + " " + or.getOrderRecordList().get(i).getPo());
			//System.out.println(i + " " + or.getOrderRecordList().get(i).getNumber());
			//System.out.println(i + " " + or.getOrderRecordList().get(i).getState());
			//System.out.println(i + " " + or.getOrderRecordList().get(i).getCountry());
			//System.out.println();
		}
		Order o = or.getLastOrder();
		assertEquals(o.getNumber(),541);
		//System.out.println(o.getStudy());
		//System.out.println(o.getSite());
		//assertEquals(o.getStudy(),"006186");
		//assertEquals(o.getSite(),"9004");
		//System.out.println(o.getPo());
		//System.out.println(o.getCity() + " " + o.getCountry() + " " + o.getStatus());
	}

	/**
	 * Test method for {@link com.circa.mrv.grs_manager.catalog.OrderRecord#getCalendarFromString(java.lang.String)}.
	 */
	@Test
	public void testGetCalendarFromString() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.circa.mrv.grs_manager.catalog.OrderRecord#getStudyNumbers()}.
	 */
	@Test
	public void testGetStudyNumbers() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.circa.mrv.grs_manager.catalog.OrderRecord#getDefaultStudyNumbers()}.
	 */
	@Test
	public void testGetDefaultStudyNumbers() {
		//fail("Not yet implemented");
	}

}
