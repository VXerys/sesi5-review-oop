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
 