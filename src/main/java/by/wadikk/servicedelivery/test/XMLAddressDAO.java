package by.wadikk.servicedelivery.test;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;




public class XMLAddressDAO extends DAO<Address>{

	private static int auto_increment=10;
	@Override
	public void insert(Address adr) {
		try{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("resources/address.xml");
        Element root = document.getDocumentElement();

        // Root Element
        Element rootElement = document.getDocumentElement();

        
            // server elements
            Element address = document.createElement("address");
            rootElement.appendChild(address);
            
            
            Element id = document.createElement("id");
            id.appendChild(document.createTextNode(Integer.toString(auto_increment++)));
            address.appendChild(id);

            Element city = document.createElement("city");
            city.appendChild(document.createTextNode(adr.getCity()));
            address.appendChild(city);
            
            Element street = document.createElement("street");
            street.appendChild(document.createTextNode(adr.getStreet()));
            address.appendChild(street);
            
            Element district = document.createElement("district");
            district.appendChild(document.createTextNode(adr.getDistrict()));
            address.appendChild(district);

            root.appendChild(address);
        

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult("resources/address.xml");
        transformer.transform(source, result);
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
	}

	@Override
	public Address getById(int id) {
		   try{
			     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			     DocumentBuilder builder = factory.newDocumentBuilder();
			     Document doc = builder.parse("resources/address.xml");
			     doc.getDocumentElement().normalize();; // ������ ������ �������
			     NodeList nodeList = doc.getElementsByTagName("address");  			     
			     for (int temp = 0; temp < nodeList.getLength(); temp++) {  
			    	    Node node = nodeList.item(temp);  			    	  
			    	    if (node.getNodeType() == Node.ELEMENT_NODE) {  			    	  
			    	     Element student = (Element) node; 
			    	     if(Integer.parseInt(student.getElementsByTagName("id").item(0).getTextContent())==id){
			    	     Address tempAddress=new Address();			    	     
			    	     tempAddress.setId(id);  
			    	     tempAddress.setCity(student.getElementsByTagName("city").item(0).getTextContent());  
			    	     tempAddress.setDistrict(student.getElementsByTagName("district").item(0).getTextContent());  
			    	     tempAddress.setStreet(student.getElementsByTagName("street").item(0).getTextContent());  
			    	     return tempAddress;
			    	     }
			    	    }}     
			    }
			    catch(Exception e)
			    {
			     e.printStackTrace();
			    }
		return null;
	}

	@Override
	public void update(Address adr) {
		
		
	}

	@Override
	public void delete(Address adr) {
	
		
	}

	@Override
	public ArrayList<Address> getAll() {
		ArrayList<Address> res=new ArrayList<>();
		   try{
			     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			     DocumentBuilder builder = factory.newDocumentBuilder();
			     Document doc = builder.parse("resources/address.xml");
			     doc.getDocumentElement().normalize();; // ������ ������ �������
			     NodeList nodeList = doc.getElementsByTagName("address");  			     
			     for (int temp = 0; temp < nodeList.getLength(); temp++) {  
			    	    Node node = nodeList.item(temp);  			    	  
			    	    if (node.getNodeType() == Node.ELEMENT_NODE) {  			    	  
			    	     Element student = (Element) node;  			    	  
			    	     Address tempAddress=new Address();			    	     
			    	     tempAddress.setId(Integer.parseInt(student.getElementsByTagName("id").item(0).getTextContent()));  
			    	     tempAddress.setCity(student.getElementsByTagName("city").item(0).getTextContent());  
			    	     tempAddress.setDistrict(student.getElementsByTagName("district").item(0).getTextContent());  
			    	     tempAddress.setStreet(student.getElementsByTagName("street").item(0).getTextContent());  
			    	     res.add(tempAddress);		    	  
			    	    }}     
			    }
			    catch(Exception e)
			    {
			     e.printStackTrace();
			    }
		return res;
	}
}
