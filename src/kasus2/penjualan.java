package kasus2;
import java.util.Scanner;
import kasus1.Restaurant;

public class penjualan {
	private produk[] produk;
	public static byte id = 0;
	private double total_harga;
	private String nama_produk;
	private int quantity;
	
	public penjualan() {
		produk = new produk[10];
		for(int i = 0; i < 10; i++) {
			produk[i] = new produk();
		}
		id = 0;
	}
	
	public void tambahProduk(String nama_produk, double harga, int qty) {
		this.produk[id].setNama_produk(nama_produk);
		this.produk[id].setHarga(harga);
		this.produk[id].setQty(qty);
	}
	
	public void tampilkanProduk() {
		System.out.println("Daftar Menu Makanan");
		System.out.println("================================");
		for(int i = 0; i < id; i++) {
			if(!isOutOfStock(i)) {
				System.out.println((i+1)+". "+ produk[i].getNama_produk()+"["+produk[i].getQty()+"]"+"\t\t"+"Rp "+produk[i].getHarga());
			}
		}
	}
	
	public boolean isOutOfStock(int id) {
		if(produk[id].getQty() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void nextId () {
		id++;
	}

	public double getTotal_harga() {
		return total_harga;
	}

	public void setTotal_harga(double total_harga) {
		this.total_harga = total_harga;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNama_produk() {
		return nama_produk;
	}

	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}
	
	public void pesanProduk() {
		int newStock;
		double price;
		for(int i = 0; i<produk.length; i++) {
			if(produk[i].getNama_produk().equals(nama_produk)) {
				if(produk[i].getQty() >= quantity) {
					newStock = produk[i].getQty();
					newStock = newStock - quantity;
					produk[i].setQty(newStock);
					
					price = produk[i].getHarga() * quantity;
					this.total_harga = price;
				}else {
					System.out.println("Stok Barang Tidak Cukup");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		penjualan menu = new penjualan();
		Scanner scan = new Scanner(System.in);
		boolean stop = true;
		int kuantitas = 0;
		String nama_produk;
		String konfirmasi;
		String konfirmasi2;
		
		menu.tambahProduk("Mie Goreng", 5_000, 20);
		penjualan.nextId();
		menu.tambahProduk("Mie Rebus", 4_000, 20);
		penjualan.nextId();
		menu.tambahProduk("Nasi Goreng", 8_000, 13);
		penjualan.nextId();
		menu.tambahProduk("Nasi Kuning", 6_000, 8);
		penjualan.nextId();
		menu.tambahProduk("Nasi Uduk", 6_000, 10);
		penjualan.nextId();
		menu.tambahProduk("Lotek", 5_000, 9);
		penjualan.nextId();
		menu.tambahProduk("Karedok", 5_000, 11);
		penjualan.nextId();
		menu.tambahProduk("Air Putih", 2_000, 25);
		penjualan.nextId();
		menu.tambahProduk("Teh Manis", 3_000, 12);
		penjualan.nextId();
		menu.tambahProduk("Kopi", 3_500, 11);
		penjualan.nextId();
		
		while(stop) {
			menu.tampilkanProduk();
			System.out.println("Masukkan nama produk :");
			nama_produk = scan.nextLine();
			menu.setNama_produk(nama_produk);
			System.out.println("Masukkan kuantitas produk");
			kuantitas = scan.nextInt();
			menu.setQuantity(kuantitas);
			menu.pesanProduk();
			System.out.println("Produk :"+menu.getNama_produk()+"\nKuantitias: "+menu.getQuantity()+"\nTotal Harga: "+menu.getTotal_harga());
			System.out.println("Konfirmasi Pesanan");
			konfirmasi = scan.next();
			
			if(konfirmasi.equals("yes")) {
				System.out.println("Pesanan berhasil");
			}
			System.out.println("Lanjutkan Pembelian? ");
			konfirmasi2 = scan.next();
			if(!konfirmasi2.equals("yes")) {
				break;
			}
		}
		
	}
}
