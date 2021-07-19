package by.wadikk.servicedelivery.test;

import java.sql.Date;

public class Item {
private int id;
private int rooms_quantity;
private double  total_area;
private String item_class;
private double price;
private int floor;
private String  type;
private String  item_type;
private String status;
private int address_id;
private Date begin;
public Item(int id, int rooms_quantity, double total_area, String item_class,
		double price, int floor, String type, String item_type, String status,
		int address_id, Date begin) {
	super();
	this.id = id;
	this.rooms_quantity = rooms_quantity;
	this.total_area = total_area;
	this.item_class = item_class;
	this.price = price;
	this.floor = floor;
	this.type = type;
	this.item_type = item_type;
	this.status = status;
	this.address_id = address_id;
	this.begin = begin;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getRooms_quantity() {
	return rooms_quantity;
}
public void setRooms_quantity(int rooms_quantity) {
	this.rooms_quantity = rooms_quantity;
}
public double getTotal_area() {
	return total_area;
}
public void setTotal_area(double total_area) {
	this.total_area = total_area;
}
public String getItem_class() {
	return item_class;
}
public void setItem_class(String item_class) {
	this.item_class = item_class;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getFloor() {
	return floor;
}
public void setFloor(int floor) {
	this.floor = floor;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getItem_type() {
	return item_type;
}
public void setItem_type(String item_type) {
	this.item_type = item_type;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public Date getBegin() {
	return begin;
}
public void setBegin(Date begin) {
	this.begin = begin;
}



}
