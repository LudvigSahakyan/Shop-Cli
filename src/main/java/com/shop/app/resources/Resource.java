package com.shop.app.resources;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;


public class Resource {

	private Node element;

	public Resource(String resourceName) {

		try {
		element = DocumentBuilderFactory
				.newInstance()
				.newDocumentBuilder()
				.parse(new File("src/main/resources/" + resourceName + ".xml"))
		        .getElementsByTagName("resource").item(0); 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getXmlElement(String attributeName) {
		
	return element.getAttributes().getNamedItem(attributeName).getNodeValue();

	}

	

}
