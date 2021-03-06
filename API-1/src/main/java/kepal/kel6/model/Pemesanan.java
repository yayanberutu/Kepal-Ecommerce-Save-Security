package kepal.kel6.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_pesanan")
public class Pemesanan {
	@Id
	@Column(name="pesanan_id")
	private int pesanan_id;
	
	@Column(name="kamar_id")
	private String kamar_id;

	@Column(name="user_id")
	private String user_id;
	
	@Column(name="tanggal_booking")
	private Date tanggal_booking;
	
	@Column(name="tanggal_check_out")
	private Date tanggal_check_out;
	
	@Column(name="nama_pemesan")
	private String nama_pemesan;
	
	@Column(name="total_harga")
	private String total_harga;
	
	@Column(name="kode_booking")
	private String kode_booking;

	public int getPesanan_id() {
		return pesanan_id;
	}

	public void setPesanan_id(int pesanan_id) {
		this.pesanan_id = pesanan_id;
	}

	public String getKamar_id() {
		return kamar_id;
	}

	public void setKamar_id(String kamar_id) {
		this.kamar_id = kamar_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getTanggal_booking() {
		return tanggal_booking;
	}

	public void setTanggal_booking(Date tanggal_booking) {
		this.tanggal_booking = tanggal_booking;
	}

	public Date getTanggal_check_out() {
		return tanggal_check_out;
	}

	public void setTanggal_check_out(Date tanggal_check_out) {
		this.tanggal_check_out = tanggal_check_out;
	}

	public String getNama_pemesan() {
		return nama_pemesan;
	}

	public void setNama_pemesan(String nama_pemesan) {
		this.nama_pemesan = nama_pemesan;
	}

	public String getTotal_harga() {
		return total_harga;
	}

	public void setTotal_harga(String total_harga) {
		this.total_harga = total_harga;
	}

	public String getKode_booking() {
		return kode_booking;
	}

	public void setKode_booking(String kode_booking) {
		this.kode_booking = kode_booking;
	}
	
	
}
