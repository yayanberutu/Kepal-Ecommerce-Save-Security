package com.buyer.model;
import java.sql.Timestamp;

public class Payment {
	
	public int invoice_num;
	
	public int nominal_pembayaran;
	
	public int user_id;
	
	public Timestamp updated_at;
	
	public Payment() {}

	public Payment(int invoice_num, int nominal_pembayaran, int user_id, Timestamp updated_at) {
		super();
		this.invoice_num = invoice_num;
		this.nominal_pembayaran = nominal_pembayaran;
		this.user_id = user_id;
		this.updated_at = updated_at;
	}

	public int getInvoice_num() {
		return invoice_num;
	}

	public void setInvoice_num(int invoice_num) {
		this.invoice_num = invoice_num;
	}

	public int getNominal_pembayaran() {
		return nominal_pembayaran;
	}

	public void setNominal_pembayaran(int nominal_pembayaran) {
		this.nominal_pembayaran = nominal_pembayaran;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	

}