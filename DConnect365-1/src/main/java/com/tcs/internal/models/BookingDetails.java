package com.tcs.internal.models;

public class BookingDetails {
	String patientName;
	int bookingId;
	String PCP;
    String bookingDate;
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getPCP() {
		return PCP;
	}
	public void setPCP(String pCP) {
		PCP = pCP;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
}
