public class Tabungan extends Rekening{
     double bungaTabungan;
     

     public Tabungan(String namaPemilik, String nomorRekening, double saldo, double bungaTabungan) {
          super(namaPemilik, nomorRekening, saldo);
          this.bungaTabungan = bungaTabungan; 

     }    

     public double getBungaTabungan() {
          return bungaTabungan;
      }
  
      public void setBungaTabungan(double bungaTabungan) {
          this.bungaTabungan = bungaTabungan;
      }

      @Override
      public double addSetor(double setor){
           return super.addSetor(setor);
       }
   
      @Override
       public double addTarik(double tarik){
           return super.addTarik(tarik);
       }

     public double hitungTabungan(int bulan){
          return getSaldo() * (1 + bungaTabungan/12) * bulan;
     }

     @Override
     public void tampilkanInfo() {
          super.tampilkanInfo();
          System.out.println("Bunga Tabungan : " + bungaTabungan);
          System.out.println("Jenis Rekening : Tabungan");
          System.out.println("Tabungan : " + hitungTabungan(1));
     }


}

