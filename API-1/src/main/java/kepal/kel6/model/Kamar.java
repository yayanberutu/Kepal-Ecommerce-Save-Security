package kepal.kel6.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "t_kamar")
public class Kamar {
	@Id
	@Column(name="kamar_id")
	private int kamarid;
	
	@Column(name="kategori")
	private String kategori;
	
	@Column(name="harga_kamar")
	private String harga_kamar;
	
	@Column(name="jumlah_tersedia")
	private int jumlah_tersedia;

	public int getKamarid() {
		return kamarid;
	}

	public void setKamarid(int kamarid) {
		this.kamarid = kamarid;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String getHarga_kamar() {
		return harga_kamar;
	}

	public void setHarga_kamar(String harga_kamar) {
		this.harga_kamar = harga_kamar;
	}

	public int getJumlah_tersedia() {
		return jumlah_tersedia;
	}

	public void setJumlah_tersedia(int jumlah_tersedia) {
		this.jumlah_tersedia = jumlah_tersedia;
	}
	
	
}
