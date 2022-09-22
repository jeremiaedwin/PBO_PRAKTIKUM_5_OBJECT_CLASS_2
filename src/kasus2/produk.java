package kasus2;

public class produk {
	private String nama_produk;
	private double harga;
	private int qty;
	
	public produk() {
		setNama_produk("");
		setHarga(0);
		setQty(0);
	}

	public double getHarga() {
		return harga;
	}

	public void setHarga(double harga) {
		this.harga = harga;
	}

	public String getNama_produk() {
		return nama_produk;
	}

	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
