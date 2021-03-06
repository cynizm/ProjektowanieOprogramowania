
package business_layer.entities;

import business_layer.Factory;
import java.util.ArrayList;
import java.util.Date;

public class Sprint {
    
    private Integer numer_sprintu;
    private Date data_rozpoczecia;
    private Date data_zakonczenia;
    private StatusSprintu status_sprintu;
    private ArrayList<Zadanie> zadania;
    private ArrayList<StanSprintu> stany_sprintu;
    
    
    public Sprint() {
        this.numer_sprintu = 0;
        this.data_rozpoczecia = new Date();
        this.data_zakonczenia = new Date();
        this.status_sprintu = StatusSprintu.NIEROZPOCZETY;
        this.zadania = new ArrayList <Zadanie> ();
        this.stany_sprintu = new ArrayList <StanSprintu> ();
    }

    public Integer getNumerSprintu() {
        return numer_sprintu;
    }

    public void setNumerSprintu(Integer numerSprintu) {
        this.numer_sprintu = numerSprintu;
    }

    public Date getDataRozpoczecia() {
        return data_rozpoczecia;
    }

    public void setDataRozpoczecia(Date data_rozpoczecia) {
        this.data_rozpoczecia = data_rozpoczecia;
    }

    public Date getDataZakonczenia() {
        return data_zakonczenia;
    }

    public void setDataZakonczenia(Date data_zakonczenia) {
        this.data_zakonczenia = data_zakonczenia;
    }

    public StatusSprintu getStatusSprintu() {
        return status_sprintu;
    }

    public void zmienStatusSprintu(StatusSprintu status_sprintu) {
        this.status_sprintu = status_sprintu;
    }

    public ArrayList<StanSprintu> getStanySprintu() {
        return stany_sprintu;
    }

    public void setStanySprintu(ArrayList<StanSprintu> stany_sprintu) {
        this.stany_sprintu = stany_sprintu;
    }
    
    public StanSprintu findStanSprintu(StanSprintu stansprintu)
    {
        int index = this.stany_sprintu.indexOf(stansprintu);
	if (index != -1) {
            return this.stany_sprintu.get(index);
	}
	return null;
    }
    
    public int addStanSprintu (String stansprintu[])
    {   Factory factory=new Factory();
        StanSprintu stan = factory.createStanSprintu(stansprintu);
        //stan = findStanSprintu(stan);
        if (findStanSprintu(stan) == null) {
            stany_sprintu.add(stan);
            return 0;
        }
        return 2;
    }

public int addStanSprintu(StanSprintu stansprintu) {
        StanSprintu stan = findStanSprintu(stansprintu);
        if (stan == null) {
            stany_sprintu.add(stansprintu);
            return 0;
        }
        return 2;
    }
     public String toString(){
         String str = "Nr. sprintu: " + this.numer_sprintu.toString() + " Data rozpoczęcia: "+ this.data_rozpoczecia.toString() +
                    " Data zakończenia: "+ this.data_zakonczenia+ " Status: "+ this.status_sprintu.toString();
         return str;
     }
     
     public String[] toStringArray() {
        String[] array = new String[4];
        
        array[0] = numer_sprintu.toString();
        array[1] = data_rozpoczecia.toString();
        array[2] = data_zakonczenia.toString();
        array[3] = status_sprintu.getText();
        return array;
    }
     
    public boolean equals(Object obj) {    
        return (getNumerSprintu().equals(((Sprint)obj).getNumerSprintu()));
    }

    
   
    public void toArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
