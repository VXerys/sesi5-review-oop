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
 