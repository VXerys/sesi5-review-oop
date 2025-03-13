
# Sistem Perbankan Sederhana (Java OOP) 💰

Selamat datang di proyek **Sistem Perbankan Sederhana** yang dibuat dengan konsep Java Object-Oriented Programming. Proyek ini mencakup pengelolaan rekening nasabah, transaksi penyetoran dan penarikan, perhitungan bunga tabungan, serta penerapan logika limit penarikan pada rekening Giro.

---

## Daftar Isi
- [Sistem Perbankan Sederhana (Java OOP) 💰](#sistem-perbankan-sederhana-java-oop-)
  - [Daftar Isi](#daftar-isi)
  - [Ikhtisar](#ikhtisar)
  - [Struktur Proyek](#struktur-proyek)
    - [Rekening.java](#rekeningjava)
    - [Tabungan.java](#tabunganjava)
    - [Giro.java](#girojava)
    - [appBank.java (Main Class)](#appbankjava-main-class)
  - [Cara Kompilasi \& Jalankan](#cara-kompilasi--jalankan)
  - [Contoh Skenario \& Output](#contoh-skenario--output)
  - [Penjelasan Konsep Kunci](#penjelasan-konsep-kunci)
  - [Referensi](#referensi)

---

## Ikhtisar

Proyek ini mengimplementasikan:
- **Kelas & Objek:** Membangun kelas dasar `Rekening` untuk mengelola data nasabah.
- **Inheritance & Overriding:** Kelas `Tabungan` dan `Giro` mewarisi dari `Rekening` dan mengoverride beberapa metode, misalnya untuk perhitungan bunga dan penarikan.
- **Method Overloading:** Penerapan overloading pada method `setor` di kelas `Giro` untuk menangani transaksi transfer antar bank.
- **Validasi & Logika Matematika:** Pada kelas `Rekening` dan `Giro`, terdapat validasi untuk memastikan penarikan tidak melebihi saldo (atau dalam Giro, tidak melebihi limit overdraft).

---

## Struktur Proyek

### Rekening.java
Kelas dasar yang memuat atribut:
- `namaPemilik`
- `nomorRekening`
- `saldo`

Method penting:
- **setor(double jumlah):** Menambah saldo jika nilai setor valid.
- **tarik(double jumlah):** Mengurangi saldo jika saldo mencukupi.
- **tampilkanInfo():** Menampilkan informasi rekening.

```java
public class Rekening {
    String namaPemilik;
    String nomorRekening;
    double saldo;
    
    public Rekening(String namaPemilik, String nomorRekening, double saldo) {
        this.namaPemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }
    
    public String getNamaPemilik() {
        return namaPemilik;
    }
    
    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }
    
    public String getNomorRekening() {
        return nomorRekening;
    }
    
    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void setor(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setor: " + jumlah);
        } else {
            System.out.println("Jumlah setor tidak valid.");
        }
    }
    
    public void tarik(double jumlah) {
        if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup untuk penarikan.");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik: " + jumlah);
        }
    }
    
    public void tampilkanInfo() {
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Saldo: " + saldo);
    }
}
```

---

### Tabungan.java
Subclass dari `Rekening` yang menambahkan atribut:
- `bungaTahunan` (dalam persen)

Method tambahan:
- **hitungBunga(int bulan):** Menghitung bunga untuk periode tertentu dengan rumus bunga sederhana.

```java
public class Tabungan extends Rekening {
     double bungaTahunan; // dalam persen
     
     public Tabungan(String namaPemilik, String nomorRekening, double saldo, double bungaTahunan) {
         super(namaPemilik, nomorRekening, saldo);
         this.bungaTahunan = bungaTahunan;
     }
     
     public double getBungaTahunan() {
         return bungaTahunan;
     }
     
     public void setBungaTahunan(double bungaTahunan) {
         this.bungaTahunan = bungaTahunan;
     }
     
     public double hitungBunga(int bulan) {
         double bungaBulanan = (bungaTahunan / 100.0) / 12;
         return saldo * bungaBulanan * bulan;
     }
     
     @Override
     public void tampilkanInfo() {
         super.tampilkanInfo();
         System.out.println("Jenis Rekening: Tabungan");
         System.out.println("Bunga Tahunan: " + bungaTahunan + "%");
         System.out.println("Bunga per 1 bulan: " + hitungBunga(1));
     }
}
```

---

### Giro.java
Subclass dari `Rekening` yang menambahkan:
- `limitPenarikan` (batas overdraft)

Fitur penting:
- **Override tarik(double jumlah):** Memungkinkan saldo turun hingga -limitPenarikan.
- **Overloading setor(double jumlah, boolean transfer):** Jika setor dari transfer antar bank, akan ditambahkan biaya administrasi Rp 2500.

```java
public class Giro extends Rekening {
     double limitPenarikan;
     
     public Giro(String namaPemilik, String nomorRekening, double saldo, double limitPenarikan) {
         super(namaPemilik, nomorRekening, saldo);
         this.limitPenarikan = limitPenarikan;
     }
     
     public double getLimitPenarikan() {
         return limitPenarikan;
     }
     
     public void setLimitPenarikan(double limitPenarikan) {
         this.limitPenarikan = limitPenarikan;
     }
     
     @Override
     public void tarik(double jumlah) {
         if (saldo - jumlah < -limitPenarikan) {
             System.out.println("Penarikan melebihi limit giro.");
         } else {
             saldo -= jumlah;
             System.out.println("Tarik: " + jumlah);
         }
     }
     
     // Overloading setor: jika transfer antar rekening, tambahkan biaya administrasi Rp 2500
     public void setor(double jumlah, boolean transfer) {
         super.setor(jumlah); 
         if (transfer) {
             saldo += 2500;
             System.out.println("Biaya administrasi transfer diterima: Rp 2500");
         }
     }
     
     @Override
     public void tampilkanInfo() {
         super.tampilkanInfo();
         System.out.println("Jenis Rekening: Giro");
         System.out.println("Limit Penarikan: " + limitPenarikan);
     }
}
```

---

### appBank.java (Main Class)
Kelas utama ini menggunakan `Scanner` untuk menerima input dari pengguna dengan blok try-catch dan switch-case. Pengguna dapat memilih jenis rekening dan melakukan transaksi seperti setor dan tarik, serta melihat informasi rekening.

```java
import java.util.Scanner;

public class appBank {
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
            scanner.nextLine(); // membersihkan buffer
            
            switch (pilihan) {
                case 1 ->  {
                    // Rekening Umum
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
                    // Tabungan
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
                    // Giro
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
```

---

## Cara Kompilasi & Jalankan

1. **Pastikan semua file (.java) berada dalam satu direktori.**  
2. Buka terminal/command prompt di direktori proyek.
3. **Kompilasi:**

   ```bash
   javac Rekening.java Tabungan.java Giro.java appBank.java
   ```

4. **Jalankan:**

   ```bash
   java appBank
   ```

---

## Contoh Skenario & Output

**Rekening Umum:**
- **Input:**  
  - Nama Pemilik: Budi  
  - Nomor Rekening: 001  
  - Saldo awal: 50000  
  - Setor: 20000  
  - Tarik: 15000  
- **Output yang Diharapkan:**  
  ```
  Nama Pemilik: Budi
  Nomor Rekening: 001
  Saldo: 55000.0
  ```

**Tabungan:**
- **Input:**  
  - Nama Pemilik: Andi  
  - Nomor Rekening: 002  
  - Saldo awal: 100000  
  - Bunga Tahunan: 6  
  - Setor: 50000  
  - Tarik: 20000  
  - Periode: 6 bulan  
- **Output yang Diharapkan:**  
  ```
  Bunga yang didapat: 3900.0
  Nama Pemilik: Andi
  Nomor Rekening: 002
  Saldo: 130000.0
  Jenis Rekening: Tabungan
  Bunga Tahunan: 6.0%
  Bunga per 1 bulan: 650.0
  ```

**Giro:**
- **Input:**  
  - Nama Pemilik: Siti  
  - Nomor Rekening: 003  
  - Saldo awal: 200000  
  - Limit Penarikan: 100000  
  - Setor: 50000 (dengan opsi transfer: false)  
  - Tarik: 250000  
- **Output yang Diharapkan:**  
  ```
  Nama Pemilik: Siti
  Nomor Rekening: 003
  Saldo: 0.0   // karena 200000+50000=250000 dan penarikan 250000
  Jenis Rekening: Giro
  Limit Penarikan: 100000.0
  ```

---

## Penjelasan Konsep Kunci

- **Inheritance & Overriding:**  
  `Tabungan` dan `Giro` mewarisi atribut dan method dari `Rekening`. Keduanya mengoverride `tampilkanInfo()` untuk menampilkan informasi spesifik masing-masing jenis rekening.  
- **Overloading:**  
  Pada kelas `Giro`, terdapat method overloading untuk `setor(double jumlah, boolean transfer)`, yang menambahkan biaya administrasi transfer jika diperlukan.
- **Validasi & Logika Matematika:**  
  Pada `Rekening`, metode `tarik()` memastikan penarikan tidak melebihi saldo. Sedangkan pada `Giro`, override `tarik()` mengizinkan saldo turun hingga -limitPenarikan.
- **Penggunaan Scanner & Exception Handling:**  
  Kelas `appBank` menggunakan `Scanner` untuk menerima input pengguna dan penanganan error dengan try-catch serta penggunaan switch-case untuk navigasi menu.

---

## Referensi

- [Dokumentasi Java Oracle](https://docs.oracle.com/javase/)
- [Tutorial Java oleh Oracle](https://docs.oracle.com/javase/tutorial/)
- [Konsep OOP di Java](https://www.javatpoint.com/java-oops)
- [Java Code Conventions](https://www.oracle.com/java/technologies/javase/codeconventions-contents.html)

