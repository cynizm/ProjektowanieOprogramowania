
package client_layer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DodajOsobe_form extends JPanel implements ActionListener {

    Client client;
    JLabel limie = new JLabel("Imię");
    JTextField imie = new JTextField(10);
    JLabel lnazwisko = new JLabel("Nazwisko");
    JTextField nazwisko = new JTextField(10);
    JLabel lemail = new JLabel("E-mail");
    JTextField email = new JTextField(10);
    JLabel lidprojektu = new JLabel("Id Projektu");
    JTextField idprojektu = new JTextField(5);
    JLabel lrola = new JLabel("Rola");
    JComboBox<String> rola = new JComboBox<>();
    JButton dodaj_osobe = new JButton("Dodaj osobę");
    DodajOsobe_form thisClass = this;

    DodajOsobe_form(Client client) {
        this.client = client;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(limie);
        add(imie);
        add(lnazwisko);
        add(nazwisko);
        add(lemail);
        add(email);
        add(lidprojektu);
        add(idprojektu);
        add(lrola);
        for (String r : Client.getFasada().modelRole())
            rola.addItem(r);
        add(rola);
        dodaj_osobe.addActionListener(thisClass);
        add(dodaj_osobe);
    }

    
    public String content_validate(JTextField val) {
        String s = val.getText();
        if (s.equals("")|| s.length()>30) {
            JOptionPane.showMessageDialog(this, "Nie wprowadzono wszystkich danych.\nNie można wykonać operacji.");
            return null;
        } else {
            val.setText(s);
            return s;
        }
    }
    
    public String[] validateForm() {
        if (content_validate(imie) == null) {
            return null;
        }
        if (content_validate(nazwisko) == null) {
            return null;
        }
        if (content_validate(email) == null) {
            return null;
        } else {
            if(!email.getText().matches("[0-9a-zA-Z_-]{1,}@[0-9a-zA-Z_-]{1,}.[0-9a-zA-Z_-]{1,}"))
            {
                JOptionPane.showMessageDialog(this, "Niepoprawny adres e-mail.");
                return null;
            }
        }
      String idprojektu_ = "-1"; 
      if (((String) rola.getSelectedItem()).equals("Kierownik projektu")) 
        if (content_validate(idprojektu) == null) {
            return null;
        } else {
            try {
                Integer.parseInt(idprojektu.getText());
                idprojektu_ = (String) idprojektu.getText(); //Zmiana
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Identyfikator projektu nie jest liczbą.\nNie można wykonać operacji.");
                return null;
            }
        }
        String data[] = {
            "1", 
            (String) imie.getText(), 
            (String) nazwisko.getText(),
            (String) email.getText(),
            idprojektu_,
            (String) rola.getSelectedItem()
        };
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String[] data = validateForm();    
        if (data == null) {
            return;
        }
        if(data[5].equals("Kierownik projektu") && Client.getFasada().sprawdzKierownika(data[4]) != null)
            JOptionPane.showMessageDialog(this, "Projekt ma kierownika.");
        else {
            if (Client.getFasada().dodajOsobe(data) == null)
                JOptionPane.showMessageDialog(this, "Osoba o podanym adresie e-mail już istnieje w systemie.\nNie można dodać.");
            else
                JOptionPane.showMessageDialog(this, "Dodano pomyślnie!");
        }
    }

}
