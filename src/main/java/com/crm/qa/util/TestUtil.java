package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_TIMEOUT = 10;
	
	public void switchtoFrame() {
		driver.switchTo().frame("mainpanel");
	}
}
