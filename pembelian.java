import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//interface
public class pembelian implements rumahHantu {

    static Integer id_Pembeli;
    static String nama_Pembeli;
    String tanggal;
    int noHoror;
    int noTingkat;
    static String horornya;
    static int harga;
    static String tingkatnya;
    static String jam;
    static int totalHarga;
    static int metodenya;
    static String jamnya;
    public static String metode;

    static Scanner input = new Scanner(System.in);
    static Scanner inputan = new Scanner(System.in);

    public void id_Pembeli() {
        System.out.print("> Masukkan Id   Pembeli       : ");
    }

    public void nama_Pembeli() {
        System.out.print("> Masukkan Nama Pembeli       : ");
    }

    public void horornya() {
        // String compareTo()
        System.out.print("> Masukkan Pilihan       : ");
        String[] nama = { "Biasa", "Jantungan", "Horor Seru" };
        String temp;

        // Perulangan dengan For
        for (int i = 0; i < (nama.length - 1); i++) {
            for (int j = 0; j < (nama.length - 1); j++) {
                if (nama[j].compareTo(nama[j + 1]) > 0) {
                    temp = nama[j + 1];
                    nama[j + 1] = nama[j];
                    nama[j] = temp;
                }
            }
        }
        for (int i = 0; i < nama.length; i++) {
            System.out.println(i + 1 + " " + nama[i]);
        }
        System.out.print("\n> Masukkan pilihan anda: ");
        noHoror = input.nextInt();
        input.nextLine();
        // percabangan if
        if (this.noHoror == 1) {
            horornya = "Biasa";
        } else if (this.noHoror == 2) {
            horornya = "Jantungan";
        } else if (this.noHoror == 3) {
            horornya = "Horor Seru";
        } else {
            System.out.println("Nomor yang anda masukkan salah");
            System.out.print("\n> Masukkan nomor yang benar: ");
            noHoror = input.nextInt();
            input.nextLine();
        }
    }

    public void tingkatnya() {
        // collectionframework
        System.out.print("> Masukkan Pilihan Harga       : ");

        System.out.println(" 1. Normal   ||  Rp30.000 ");
        System.out.println(" 2. Standar  ||  Rp35.000");
        System.out.println(" 3. High Level  ||  Rp50.000");
        System.out.print("\n > Masukkan tingkatannya : ");
        int noTingkat = input.nextInt();
        input.next();
        // percabangan if
        if (noTingkat == 1) {
            tingkatnya = "Normal";
            harga = 30000;
        } else if (noTingkat == 2) {
            tingkatnya = "Standar";
            harga = 35000;
        } else if (noTingkat == 3) {
            tingkatnya = "High Level";
            harga = 50000;
        } else {
            System.out.println("Nomor yang anda masukkan salah");
            System.out.print("\n > Masukkan pembayaran : ");
            noTingkat = input.nextInt();
            input.next();
        }
        System.out.println(" tingkat : " + tingkatnya);
        System.out.println(" harga : " + harga);
    }

    // DateTime
    public String Tanggal() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        this.tanggal = date.format(frmt);
        return this.tanggal;
    }

    @Override
    public void horor() {

    }

    @Override
    public void tingkat() {

    }

    public void metodenya() {
    }

    @Override
    public void pembayaran() {

    }

}
