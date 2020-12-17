package com.xworkz.jdbcconnectivity.insertstatement;

public class Hotel {
	
	private int id;
	private String hotelname;
	private int noOfRooms ;
	private double rating ;
	private boolean isRestautant ;

	public Hotel(int id, String hotelname, int noOfRooms, double rating, boolean isRestautant) {
		super();
		this.id = id;
		this.hotelname = hotelname;
		this.noOfRooms = noOfRooms;
		this.rating = rating;
		this.isRestautant = isRestautant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isRestautant() {
		return isRestautant;
	}

	public void setRestautant(boolean isRestautant) {
		this.isRestautant = isRestautant;
	}

	@Override
	public String toString() {
		return "Hotels [id=" + id + ", hotelname=" + hotelname + ", noOfRooms=" + noOfRooms + ", rating=" + rating
				+ ", isRestautant=" + isRestautant + "]";
	}

}
