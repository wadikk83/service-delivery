package by.wadikk.servicedelivery.test;

import java.util.ArrayList;



public class TestDao {

	public void test() {
	DAOFactory<Address> factory=new AddressDAOFactory();
	//DAO<Address> dao=factory.getDao("JDBC");
	DAO<Address> dao=factory.getDao("XML");
	dao.insert(new Address("Lviv","Main","Down"));
	ArrayList<Address> all=dao.getAll();
	for (Address i: all)
	{
	System.out.println(i);
	}
	}
	
}
