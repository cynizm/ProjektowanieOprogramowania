package client_layer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JComboBox;

/**
 *
 * @author SND
 */
public class DodajStanSprintu_form extends JPanel implements ActionListener {

        JLabel lkierownik = new JLabel("Kierownik");
        JComboBox kierownik= new JComboBox();
    
        JLabel lsprinty = new JLabel("Sprinty");
        JComboBox sprinty= new JComboBox();
        
        JLabel ldata_akt = new JLabel("Data aktualizacji (rrrr-mm-dd):");
        JTextField data_akt = new JTextField(30);
        
	JLabel lnumer_dnia_sprintu = new JLabel("Numer dnia sprintu:");
	JTextField numer_dnia_sprintu = new JTextField(30);
        
	JLabel lilosc_zadan_nierozpoczetych = new JLabel("Ilosc zadan nierozpoczetych:");
	JTextField ilosc_zadan_nierozpoczetych = new JTextField(30);
        
	JLabel lilosc_zadan_w_analizie = new JLabel("Ilosc zadan w analizie:");
	JTextField ilosc_zadan_w_analizie = new JTextField(30);
        
        JLabel lilosc_zadan_w_implementacji = new JLabel("Ilosc zadan w implementacji:");
	JTextField ilosc_zadan_w_implementacji = new JTextField(30);
        
        JLabel lilosc_zadan_w_testach = new JLabel("Ilosc zadan w testach:");
	JTextField ilosc_zadan_w_testach = new JTextField(30);
        
        JLabel lilosc_zadan_zakonczonych = new JLabel("Ilosc zadan zakonczonych:");
	JTextField ilosc_zadan_zakonczonych = new JTextField(30);
	
	JButton dodaj_sprint = new JButton("Dodaj stan sprintu");  
        
        //JLabel lstany = new JLabel("Stany:");
        //JComboBox stany= new JComboBox();     
	
        
    DodajStanSprintu_form() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
            add(lkierownik);                      
            kierownik = new JComboBox(Client.getFasada().pobierzTabliceKierownikow());
            add(kierownik);          
            kierownik.setName("Kierownik");
            
            add(lsprinty);      
            
            generujListeSprintow();
            
            add(sprinty);
            sprinty.setName("Sprinty");
                
            add(ldata_akt);
            add(data_akt);
            data_akt.setName("DataAktualizacji");

            add(lnumer_dnia_sprintu);
            add(numer_dnia_sprintu);
            numer_dnia_sprintu.setName("NrDnia");

            add(lilosc_zadan_nierozpoczetych);
            add(ilosc_zadan_nierozpoczetych);
            ilosc_zadan_nierozpoczetych.setName("ZadanNierozpoczetych");

            add(lilosc_zadan_w_analizie);
            add(ilosc_zadan_w_analizie);
            ilosc_zadan_w_analizie.setName("ZadanWAnalizie");

            add(lilosc_zadan_w_implementacji);
            add(ilosc_zadan_w_implementacji);
            ilosc_zadan_w_implementacji.setName("ZadanWImplementacji");

            add(lilosc_zadan_w_testach);
            add(ilosc_zadan_w_testach);
            ilosc_zadan_w_testach.setName("ZadanWTestach");

            add(lilosc_zadan_zakonczonych);
            add(ilosc_zadan_zakonczonych);
            ilosc_zadan_zakonczonych.setName("ZadanZakonczonych");

            dodaj_sprint.addActionListener(this);
            kierownik.addActionListener(this);
            add(dodaj_sprint);

            //add(lstany);
            //add(stany);
            //stany.setName("Stany");
    }
    
    public void init() {
            kierownik.removeAllItems();
            for (Object kier : Client.getFasada().pobierzTabliceKierownikow()) {
                kierownik.addItem((String) kier);
            }
       
            generujListeSprintow();
        }
    
    public void actionPerformed(ActionEvent evt) {        
        Object wywolywacz = evt.getSource();
        
        if (wywolywacz == dodaj_sprint)
        {
            String[] data = form_content();
            if (data == null) {
                    return;
            }

            if (kierownik.getItemCount() != 0)
            {
                if (sprinty.getItemCount() != 0)
                {
                    int i=0;
                    String[] dataSprintu = new String[2];
                    String[] pom;
                    String[] dane = sprinty.getSelectedItem().toString().split(",");
                    for (String a : dane)
                    {
                        pom = a.split(":");
                        dataSprintu[i++] = pom[1];
                    }

                    int rezultat = Client.getFasada().addStanSprintu(data, dataSprintu, kierownik.getSelectedItem().toString());

                    if (rezultat == 0)
                        JOptionPane.showMessageDialog(this, "Dodano stan sprintu!");
                    else
                        JOptionPane.showMessageDialog(this, "Podany stan jest juz przypisany do tego sprintu!");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Nie wskazano sprintu!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Nie wskazano kierownika projektu!");
            }   
        }
        else if (wywolywacz == kierownik)
        {
           generujListeSprintow();
        }
    }    
	

	public String[] form_content() {
		if (!content_validate(data_akt)) {
			return null;
		}
		if (!content_validate(numer_dnia_sprintu)) {
			return null;
		}
		if (!content_validate(ilosc_zadan_nierozpoczetych)) {
			return null;
		}
		if (!content_validate((ilosc_zadan_w_analizie))){
			return null;
		}
                if (!content_validate((ilosc_zadan_w_implementacji))){
			return null;
		}
                if (!content_validate((ilosc_zadan_w_testach))){
			return null;
		}
                if (!content_validate((ilosc_zadan_zakonczonych))){
			return null;
		}
                String data[] = {(String) numer_dnia_sprintu.getText(),(String) ilosc_zadan_nierozpoczetych.getText(),
                    (String) ilosc_zadan_w_analizie.getText(), (String) ilosc_zadan_w_implementacji.getText(),
                    (String) ilosc_zadan_w_testach.getText(), (String) ilosc_zadan_zakonczonych.getText(), (String) data_akt.getText()};
                
                return data;
	}

	//metoda do refaktoryzacji
	public boolean content_validate(JTextField tf) {
		String str = tf.getText();
		if (str.equals("")) {
			JOptionPane.showMessageDialog(this, "Nie wpisano wymaganej zawartości!");
			return false;
		} else if ("DataAktualizacji".equals(tf.getName())) {
                        if(!str.matches("^[0-9]{4}-[01][0-9]-[0-3][0-9]$")) {
                            JOptionPane.showMessageDialog(this, "DataAktualizacji: nieprawidlowy format danych!");
                            return false;
                        }
		} else if ("NrDnia".equals(tf.getName())) {
                        if(!str.matches("^[0-9]{1,2}$")) {
                            JOptionPane.showMessageDialog(this, "NrDnia: nieprawidlowy format danych!");
                            return false;
                        }		
		} else if ("ZadanNierozpoczetych".equals(tf.getName())) {
                        if(!str.matches("^[0-9]+$")) {
                            JOptionPane.showMessageDialog(this, "ZadanNierozpoczetych: nieprawidlowy format danych!");
                            return false;
                        }
		} else if ("ZadanWAnalizie".equals(tf.getName())) {
                        if(!str.matches("^[0-9]+$")) {
                            JOptionPane.showMessageDialog(this, "ZadanWAnalizie: nieprawidlowy format danych!");
                            return false;
                        }
		} else if ("ZadanWImplementacji".equals(tf.getName())) {
                        if(!str.matches("^[0-9]+$")) {
                            JOptionPane.showMessageDialog(this, "ZadanWImplementacji: nieprawidlowy format danych!");
                            return false;
                        }
		} else if ("ZadanWTestach".equals(tf.getName())) {
                        if(!str.matches("^[0-9]+$")) {
                            JOptionPane.showMessageDialog(this, "ZadanWTestach: nieprawidlowy format danych!");
                            return false;
                        }
		} else if ("ZadanZakonczonych".equals(tf.getName())) {
                        if(!str.matches("^[0-9]+$")) {
                            JOptionPane.showMessageDialog(this, "ZadanZakonczonych: nieprawidlowy format danych!");
                            return false;
                        }
		}
                
                return true;    
	}

        
        public void generujListeSprintow()
        {
            sprinty.removeAllItems();
            if (kierownik.getItemCount() != 0)
            {
                for(Object[] sprint : Client.getFasada().modelSprinty(kierownik.getSelectedItem().toString()))
                    sprinty.addItem("Nr sprintu:" + sprint[0] + ", Status sprintu:"+ sprint[3]);
            }
        }
	
}