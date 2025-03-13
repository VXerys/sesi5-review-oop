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
     public double addSetor(double setor){
          super.addSetor(setor);
          return this.getSaldo();
     }

     @Override
     public double addTarik(double tarik){
          super.addTarik(tarik);
          return this.getSaldo();
     }

    public void setor(double jumlahPenarikan) {
          super.addSetor(jumlahPenarikan);
     }

     public void setor(double jumlah, boolean transfer){
          super.addSetor(jumlah);
          if (transfer == true){
               super.addSetor(2500);
          }
     }

     public void penarikan(double jumlahPenarikan) {
          if (jumlahPenarikan <= limitPenarikan) {
               super.addTarik(jumlahPenarikan);
          } else {
               System.out.println("Penarikan melebihi limit penarikan.");
          }
     }


}
