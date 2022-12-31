import java.util.InputMismatchException;
import java.util.Scanner;

import java.sql.*;

//inheritance
public class App extends pembelian {
    // static Scanner scanner;
    static Connection conn;

    public static void main(String[] args) {

        // CRUD (pengelolaan database)
        try (Scanner input = new Scanner(System.in)) {
            String pilihanUser;
            boolean isLanjutkan = true;
            String url = "jdbc:mysql://localhost:3306/tubes";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, "root", "");

                while (isLanjutkan) {
                    System.out.println("    1. Lihat  Data Pembeli");
                    System.out.println("    2. Tambah Data Pembeli");
                    System.out.println("    3. Ubah   Data Pembeli");
                    System.out.println("    4. Hapus  Data Pembeli");
                    System.out.println("    5. Cari   Data Pembeli");

                    System.out.print("\n> Pilihan anda (1/2/3/4/5): ");
                    pilihanUser = input.next();
                    input.nextLine();

                    switch (pilihanUser) {
                        case "1":
                            lihatdata();
                            break;
                        case "2":
                            tambahdata();
                            break;
                        case "3":
                            ubahdata();
                            break;
                        case "4":
                            hapusdata();
                            break;
                        case "5":
                            caridata();
                            break;
                        default:
                            System.err.println("\nInput anda tidak ditemukan\nInputkan [1-5]");
                    }

                    System.out.print("\n> Apakah Anda ingin melanjutkan [y/n]? ");
                    pilihanUser = input.next();
                    input.nextLine();
                    isLanjutkan = pilihanUser.equalsIgnoreCase("y");
                }
                System.out.println("\nTetap jaga protokol kesehatan dan Terima Kasih\n");
                // Exception
            } catch (ClassNotFoundException ex) {
                System.err.println("\nEror\n");
                System.exit(0);
            } catch (SQLException e) {
                System.err.println("Tidak Terhubung");
            }
        }
    }

    private static void lihatdata() throws SQLException {
        String text1 = "Riwayat Pengunjung Rumah Hantu";
        System.out.println(text1.toUpperCase());

        String sql = "SELECT `id_Pembeli`, `nama_Pembeli`, `tingkat`, `tanggal`, `jam`, `horor`, `total_pembayaran` FROM `pembeli` WHERE 1";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nID Pembeli\t\t: ");
            System.out.print(result.getString("id_Pembeli"));
            System.out.print("\nNama Pembeli\t\t: ");
            System.out.print(result.getString("nama_Pembeli"));
            System.out.print("\nTingkat\t\t: ");
            System.out.print(result.getString("tingkat"));
            System.out.print("\nTanggal\t\t\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nJam\t\t\t: ");
            System.out.print(result.getString("jam"));
            System.out.print("\nHoror\t\t\t: ");
            System.out.print(result.getString("horor"));
            System.out.print("\nTotal Pembayaran\t: ");
            System.out.print(result.getInt("total_pembayaran"));
            System.out.print("\n");
        }
    }

    private static void tambahdata() throws SQLException {

        String text2 = " Tambah Data Pembeli";
        System.out.println(text2.toUpperCase());

        try {

            pembelian buy = new pembelian();
            buy.id_Pembeli();
            Integer id_Pembeli = input.nextInt();
            input.nextLine();
            buy.nama_Pembeli();
            String nama_Pembeli = input.nextLine();
            buy.Tanggal();
            String tanggal = buy.tanggal;
            buy.tingkatnya();
            buy.horornya();
            Integer.toString(totalHarga);

            String sql = "INSERT INTO `pembeli`(`id_Pembeli`, `nama_Pembeli`, `tingkat`, `tanggal`, `jam`, `horor`, `total_pembayaran`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]','[value-7]')"
                    + id_Pembeli + "','" + nama_Pembeli + "','"
                    + tingkatnya + "','" + tanggal + "','" + jam + "','" + horornya + "','"
                    + totalHarga + "')";

            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("\nBerhasil input data");
            // exception
        } catch (SQLException e) {
            System.err.println("\nTerjadi Kesalahan");
        } catch (InputMismatchException e) {
            System.err.println("\nMasukkan Angka");
        }
    }

    private static void ubahdata() throws SQLException {
        String text3 = "        Ubah Data Pembeli";
        System.out.println(text3.toUpperCase());
        System.out.println("==================================");

        try {
            try {
                lihatdata();
                {
                    System.out.print("\n> Masukkan ID Pembeli yang akan di ubah atau update : ");
                    Integer id_Pembeli = Integer.parseInt(inputan.nextLine());

                    String sql = "SELECT `id_Pembeli`, `nama_Pembeli`, `tingkat`, `tanggal`, `jam`, `horor`, `total_pembayaran` FROM `pembeli`  WHERE id_Pembeli = "
                            + id_Pembeli;

                    Statement statement = conn.createStatement();
                    ResultSet result = statement.executeQuery(sql);

                    if (result.next()) {

                        System.out.print("\nNama pembeli [" + result.getString("nama_Pembeli") + "]\t: ");
                        String nama_Pembeli = inputan.nextLine();

                        pembelian buy = new pembelian();
                        buy.Tanggal();
                        String tanggal = buy.tanggal;
                        buy.horor();
                        buy.tingkat();
                        Integer.toString(totalHarga);

                        sql = "UPDATE pembeli SET id_Pembeli='" + id_Pembeli + "',nama_Pembeli='" + nama_Pembeli
                                + "',tingkat = '"
                                + tingkatnya +
                                "',tanggal = '" + tanggal + "', jam='" + jam
                                + "', horor='" + horornya + "', total_pembayaran='"
                                + totalHarga;
                        // System.out.println(sql);

                        if (statement.executeUpdate(sql) > 0) {
                            System.out.println("\nBerhasil memperbaharui data pembeli (id_Pembeli " + id_Pembeli + ")");
                        }
                    }
                    statement.close();
                }
                // exception
            } catch (SQLException e) {
                System.err.println("\nTerjadi kesalahan mengedit data");
                System.err.println(e.getMessage());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void hapusdata() {
        System.out.println("\n==================================");
        String text4 = "         Hapus Data pembeli";
        System.out.println(text4.toUpperCase());
        System.out.println("==================================");

        try {
            try {
                lihatdata();
                System.out.print("\n> Ketik ID pembeli pembeli yang akan Anda Hapus : ");
                Integer id_Pembeli = Integer.parseInt(inputan.nextLine());

                String sql = "DELETE FROM `pembeli` WHERE id_Pembeli = " + id_Pembeli;
                Statement statement = conn.createStatement();
                // ResultSet result = statement.executeQuery(sql);

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("\nBerhasil menghapus data pembeli (ID pembeli " + id_Pembeli + ")");
                }
            } catch (SQLException e) {
                System.out.println("\nTerjadi kesalahan dalam menghapus data pembeli");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void caridata() throws SQLException {
        System.out.println("\n==================================");
        String text5 = "         Cari Data pembeli";
        System.out.println(text5.toUpperCase());
        System.out.println("==================================");

        System.out.print("\nMasukkan nama pembeli : ");

        String keyword = inputan.nextLine();
        Statement statement = conn.createStatement();
        String sql = "SELECT `id_Pembeli`, `nama_Pembeli`, `tingkat`, `tanggal`, `jam`, `horor`, `total_pembayaran` FROM `pembeli` WHERE  nama_Pembeli LIKE '%"
                + keyword + "%'";
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nTanggal Transaksi\t: ");
            System.out.print(result.getString("tanggal"));
            System.out.print("\nID Pembeli\t\t: ");
            System.out.print(result.getString("id_Pembeli"));
            System.out.print("\nNama Pembeli\t\t: ");
            System.out.print(result.getString("nama_Pembeli"));
            System.out.print("\nHoror\t\t: ");
            System.out.print(result.getString("horor"));
            System.out.print("\nJam\t\t\t: ");
            System.out.print(result.getString("jam"));
            System.out.print("\nTingkat\t\t\t: ");
            System.out.print(result.getString("tingkat"));
            System.out.print("\ntotal Pembayaran\t: ");
            System.out.print(result.getInt("total_Pembayaran"));
            System.out.print("\n");
        }
    }
}
