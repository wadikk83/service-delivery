package by.wadikk.servicedelivery.test;

public class AddressDAOFactory extends DAOFactory<Address> {

    @Override
    public DAO<Address> getDao(String type) {
        //if(type=="JDBC") return new JDBCAddressDAO();
        if(type=="XML") return new XMLAddressDAO();
        if(type=="JSON") return null;

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
