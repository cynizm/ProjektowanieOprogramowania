package business_layer.entities;

import java.util.Objects;

public class Osoba {

	private Projekt projekt = null;
	private String imie;
	private String nazwisko;
	private String email;
	private Integer idProjektu;
	private Rola rola;

	public Osoba() {
	}
        
        public Osoba(String n) {
            email = n;
        }

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdProjektu() {
		return idProjektu;
	}

	public void setIdProjektu(Integer idProjektu) {
		this.idProjektu = idProjektu;
	}

	public Rola getRola() {
		return rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}
        
        public boolean sprawdz_email_Kierownika(String email)
        {
            return (getEmail().equals(email) && getRola() == Rola.KIEROWNIK_PROJEKTU);
        }
        
        public boolean sprawdz_id_Kierownika(String dane)
        {
            String idProj = getIdProjektu().toString();
            Rola rolaOsoby = getRola();
            return (idProj.equals(dane) && rolaOsoby == Rola.KIEROWNIK_PROJEKTU);
        }


	@Override
	public boolean equals(Object obj) {
		return email == null ?
			((Osoba) obj).getEmail() == null : email.equals(((Osoba) obj).getEmail()); 
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + Objects.hashCode(this.imie);
		hash = 53 * hash + Objects.hashCode(this.nazwisko);
		hash = 53 * hash + Objects.hashCode(this.email);
		return hash;
	}

	@Override
	public String toString() {
		return "Imie: " + getImie()
			+ " | Nazwisko: " + getNazwisko()
			+ " | E-mail: " + getEmail()
			+ " | IdProjektu: " + getIdProjektu().toString()
			+ " | Rola: " + getRola().getText();
	}
        
        public String[] toStringArray() {
            String[] array = new String[3];
            array[0] = this.getImie();
            array[1] = this.getNazwisko();
            array[2] = this.getEmail();
            return array;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}
}
