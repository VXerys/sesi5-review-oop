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
