package com.test.demo;

import com.test.productor.DNProvider;
import com.test.productor.DNProviderImpl;

public class ProviderTest {
	
	
	public static void main(String[] args) {
		DNProvider  dnProvider=new DNProviderImpl();
		dnProvider.init();	
		dnProvider.sendMessage("DN-TEST-1");
	}	
}
