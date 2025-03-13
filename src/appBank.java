
public class appBank {
     public appBank() {
     }

     public static void main(String[] args) {

          System.out.println("Selamat Datang di Bank XYZ");
          
          // Rekening rekening = new Rekening("Akbar Dokoni", "12345678", 0);
          // rekening.tampilkanInfo();
          // System.out.println("Setor : " + rekening.addSetor(100));
          // System.out.println("Tarik : " + rekening.addTarik(50));
          // System.out.println("Setor : " + rekening.addSetor(10));
          // rekening.tampilkanInfo();
          // System.out.println("================================================================");


         
          // Tabungan tabungan = new Tabungan("Resandi Alfa", "12345678", 0, 0.5);
          // System.out.println("Setor : " + tabungan.addSetor(200));
          // System.out.println("Tarik : " + tabungan.addTarik(100));
          // tabungan.tampilkanInfo();
          // System.out.println("================================================================");

          // Giro giro = new Giro("Sehan Alfarisi", "12345678", 0, 500000);
          // System.out.println("Setor : " + giro.addSetor(100));
          // System.out.println("Tarik : " + giro.addTarik(50));
          // System.out.println("Setor : " + giro.addSetor(20));
          // giro.tampilkanInfo();

          Giro giro = new Giro("Sehan Alfarisi", "12345678", 0, 50000);
          System.out.println("Setor : " + giro.addSetor(100));
          System.out.println("Tarik : " + giro.addTarik(50));
          System.out.println("Setor : " + giro.addSetor(20));
          giro.tampilkanInfo();

          

          
     }
}

