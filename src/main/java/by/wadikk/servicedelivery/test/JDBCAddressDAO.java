package by.wadikk.servicedelivery.test;


public class JDBCAddressDAO {
	/*@Override
    public Address getById(int id)
    {
    ConnectionFactory connFactory = new ConnectionFactoryImpl();
    final Connection con = connFactory.getConnection(); // create connection
    try (Statement stm=con.createStatement();ResultSet rs=stm.executeQuery("select * from address where id="+id);){
	while (rs.next()) {                            //if rs.next() returns false
	return new Address(id,rs.getString("city"),rs.getString("district"), rs.getString("street"));
	}
    }
	catch (SQLException e) 
	{
	e.printStackTrace();
	}
    try {
    con.close();
    } catch (SQLException ex) {
    Logger.getLogger(JDBCAddressDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;    
    }
	@Override
    public void update(Address adr)
    {
    ConnectionFactory connFactory = new ConnectionFactoryImpl();
    final Connection con = connFactory.getConnection(); // create connection
    try {
	final Statement stm = con.createStatement();
	String query="UPDATE address SET city='"+adr.getCity()+"',district='"+adr.getDistrict()+"',street='"+adr.getStreet()+"'  WHERE id="+adr.getId()+" ;";
	System.out.println(query);
	stm.executeUpdate(query);
	con.close();
	}
	catch (SQLException y) {
	y.printStackTrace();	}	    	
    }
    @Override
    public ArrayList<Address> getAll() {
    ArrayList<Address> res=new ArrayList<>();
    
    ConnectionFactory connFactory = new ConnectionFactoryImpl();
    final Connection con = connFactory.getConnection(); // create connection
    try (Statement stm=con.createStatement();ResultSet rs=stm.executeQuery("select * from address  " );){
		while (rs.next()) {                            //if rs.next() returns false
			res.add(new Address(rs.getInt("id"),rs.getString("city"),rs.getString("district"), rs.getString("street")));}
	}
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return res;
    }
	@Override
	public void insert(Address adr) {
	ConnectionFactory connFactory = new ConnectionFactoryImpl();
   	final Connection con = connFactory.getConnection(); // create connection
   	    
   	try {
			final Statement stm = con.createStatement();
			String query="INSERT INTO address (city,district,street) VALUES ('"+adr.getCity()+"','"+adr.getDistrict()+"','"+adr.getStreet()+"') ";
			stm.executeUpdate(query);
			con.close();
		}
		catch (SQLException y) 
		{
		y.printStackTrace();
		}	    
	}
	@Override
	public void delete(Address adr) {
	ConnectionFactory connFactory = new ConnectionFactoryImpl();
    final Connection con = connFactory.getConnection(); // create connection
    try {
	final Statement stm = con.createStatement();
	String query="DELETE FROM address WHERE item.id="+adr.getId()+" ;";
	stm.executeUpdate(query);
	con.close();
	}
		catch (SQLException y){ 
			y.printStackTrace();
		}	    
	}*/
}