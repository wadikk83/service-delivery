package by.wadikk.servicedelivery.test;


public class Address  {
   private int id;
   private String city;
   private String district;
   private String street;

    public Address(int id, String city, String district, String street) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public void setId(int id) {
		this.id = id;
	}

	public Address() {
		super();
	}

	public Address(String city, String district, String street) {
		super();
		this.city = city;
		this.district = district;
		this.street = street;
	}

	public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", city=" + city + ", district=" + district + ", street=" + street + '}';
    }

    
   
}