import java.util.Scanner;

public class appBank {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("=== Selamat Datang di Bank XYZ ===");
            System.out.println("Pilih jenis rekening:");
            System.out.println("1. Rekening Umum");
            System.out.println("2. Tabungan");
            System.out.println("3. Giro");
            System.out.print("Masukkan pilihan (1-3): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (pilihan) {
                case 1 ->  {
                    System.out.print("Masukkan Nama Pemilik: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nomor Rekening: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Masukkan Saldo awal: ");
                    double saldo = scanner.nextDouble();
                    
                    Rekening rekening = new Rekening(nama, noRek, saldo);
                    
                    System.out.print("Masukkan jumlah setor: ");
                    double setor = scanner.nextDouble();
                    rekening.setor(setor);
                    
                    System.out.print("Masukkan jumlah tarik: ");
                    double tarik = scanner.nextDouble();
                    rekening.tarik(tarik);
                    
                    rekening.tampilkanInfo();
                }
                case 2 ->  {
                    System.out.print("Masukkan Nama Pemilik: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nomor Rekening: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Masukkan Saldo awal: ");
                    double saldo = scanner.nextDouble();
                    System.out.print("Masukkan Bunga Tahunan (dalam persen): ");
                    double bungaTahunan = scanner.nextDouble();
                    
                    Tabungan tabungan = new Tabungan(nama, noRek, saldo, bungaTahunan);
                    
                    System.out.print("Masukkan jumlah setor: ");
                    double setor = scanner.nextDouble();
                    tabungan.setor(setor);
                    
                    System.out.print("Masukkan jumlah tarik: ");
                    double tarik = scanner.nextDouble();
                    tabungan.tarik(tarik);
                    
                    System.out.print("Masukkan periode (bulan) untuk hitung bunga: ");
                    int bulan = scanner.nextInt();
                    System.out.println("Bunga yang didapat: " + tabungan.hitungBunga(bulan));
                    
                    tabungan.tampilkanInfo();
                }
                case 3 ->  {
                    System.out.print("Masukkan Nama Pemilik: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Nomor Rekening: ");
                    String noRek = scanner.nextLine();
                    System.out.print("Masukkan Saldo awal: ");
                    double saldo = scanner.nextDouble();
                    System.out.print("Masukkan Limit Penarikan: ");
                    double limit = scanner.nextDouble();
                    
                    Giro giro = new Giro(nama, noRek, saldo, limit);
                    
                    System.out.print("Masukkan jumlah setor: ");
                    double setor = scanner.nextDouble();
                    System.out.print("Apakah setor ini dari transfer? (true/false): ");
                    boolean transfer = scanner.nextBoolean();
                    if (transfer) {
                        giro.setor(setor, true);
                    } else {
                        giro.setor(setor);
                    }
                    
                    System.out.print("Masukkan jumlah tarik: ");
                    double tarik = scanner.nextDouble();
                    giro.tarik(tarik);
                    
                    giro.tampilkanInfo();
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
