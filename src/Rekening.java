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

    public double addSetor(double setor){
        this.saldo += setor;
        return this.saldo;
    }

    public double addTarik(double tarik){
        this.saldo -= tarik;
        return this.saldo;
    }




    public void tampilkanInfo(){
     System.out.println("Nama Pemilik : " + getNamaPemilik());
     System.out.println("Nomor Rekening : " + getNomorRekening());
     System.out.println("Saldo : " + getSaldo());
    }


}