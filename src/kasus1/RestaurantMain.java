package kasus1;
import java.util.Scanner;

public class RestaurantMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean stop = true;
		String nama_menu;
		int verify;
		int qty;
		
		Restaurant menu = new Restaurant();
		menu.tambahMenuMakanan("Bala-bala", 1_000, 20);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Gehu", 1_000, 20);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Tahu", 1_000, 0);
		Restaurant.nextId();
		menu.tambahMenuMakanan("Molen", 1_000, 20);
		
		while(stop) {
			menu.tampilMenuMakanan();
			System.out.println("Masukkan Nama Menu : ");
			nama_menu = scan.nextLine();
			System.out.println("Masukkan Jumlah Pembelian");
			qty = scan.nextInt();
			menu.pesanMakanan(nama_menu, qty);
			System.out.println("Lanjut Pemesanan?");
			verify = scan.nextInt();
			if(verify == 0) {
				stop = false;
			}
		}
		menu.tampilMenuMakanan();
	}
}
