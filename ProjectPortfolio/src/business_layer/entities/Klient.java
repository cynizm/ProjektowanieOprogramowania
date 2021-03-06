
package business_layer.entities;

public class Klient {
    
    private String nazwaFirmy;
    private String ulica;
    private String nrDomu;
    private String nrLokalu;
    private String kodPocztowy;
    private String miejscowosc;
    private String nip;
    
    public Klient() {
        
    }
       
    public void zmienAdres(String ulica, String nrDomu, String nrLokalu, String kodPocztowy, String miejscowosc) {
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
        this.kodPocztowy = kodPocztowy;
        this.miejscowosc = miejscowosc;       
    }
    
    public String getNrLokalu() {
        return nrLokalu;
    }
    
    public String getNrDomu() {
        return nrDomu;
    }
    
    public String getUlica() {
        return ulica;
    }
    
    public String getNazwaFirmy() {
        return nazwaFirmy;
    }
    
    public String getMiejscowosc() {
        return miejscowosc;
    }
    
    public String getKodPocztowy() {
        return kodPocztowy;
    }
    
    public String getNip() {
        return nip;
    }
    
    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }
    
    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }
    
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }
    
    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }    
 
    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }
    
    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }   
    
    public void setNip(String nip) {
        this.nip = nip;
    }
    
    // sprawdzamy na podstawie nipu (unikatowa wartosc)
    @Override
    public boolean equals(Object obj) {    
        return (getNip().equals(((Klient) obj).getNip()));
    }
    
    @Override
    public String toString() {
        String val = "\nNazwa firmy: " + getNazwaFirmy();
        val += " NIP: " + getNip();
        val += " Adres: " + getUlica();
        val += " " + getNrDomu() + "/" + getNrLokalu();
        val += " " + getKodPocztowy() + " " + getMiejscowosc();
        return val;
    }
    
}
