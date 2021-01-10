package kepal.kel6.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
@Entity
@Table(name = "t_payment")
public class Payment {
	
	@Id
	@Column(name="invoice_num")
	public int invoice_num;
	
	@Column(name="nominal_pembayaran")
	public int nominal_pembayaran;
	
	@Column(name="user_id")
	public int user_id;
	
	@Column(name="updated_at")
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