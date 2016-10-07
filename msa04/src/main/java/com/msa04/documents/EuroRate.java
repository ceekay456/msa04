package com.msa04.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eurorates")
public class EuroRate {

	@Id
	String id;
	String currency;
	String date;
	Double rate;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "{\""
				+ (id != null ? "id\":\"" + id + "\",\"" : "")
				+ (currency != null ? "currency\":\"" + currency + "\",\"" : "")
				+ (date != null ? "date\":\"" + date + "\",\"" : "")
				+ (rate != null ? "rate\":\"" + rate : "") + "\"} ";
	}
}
