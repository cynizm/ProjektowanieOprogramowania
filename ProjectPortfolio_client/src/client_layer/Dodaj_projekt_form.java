package client_layer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dodaj_projekt_form extends JPanel implements ActionListener {
    
    JLabel lNazwaProjektu = new JLabel("Nazwa projektu");
    JTextField tfNazwaProjektu = new JTextField(30);
    
    JLabel lStatusProjektu = new JLabel("Status projektu");
    JTextField tfStatusProjektu = new JTextField(10);
    
    JLabel lKierownikProjektu = new JLabel("Kierownik projektu");
    JComboBox cbKierownikProjektu = new JComboBox();
    
 
    JButton bDodajProjekt = new JButton("Dodaj projekt");
    
     Dodaj_projekt_form() 
     {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(lNazwaProjektu);
        add(tfNazwaProjektu);
        tfNazwaProjektu.setName("NazwaProjektu");
        
        add(lStatusProjektu);
        add(tfStatusProjektu);
        tfStatusProjektu.setName("StatusProjektu");
        
        add(lKierownikProjektu);
        for(Object r : Client.getFasada().pobierzTabliceKierownikow())
            cbKierownikProjektu.addItem(r.toString());
        add(cbKierownikProjektu);
        
        cbKierownikProjektu.setName("KierownikProjektu");
     
        add(bDodajProjekt);
        bDodajProjekt.addActionListener(this);
        
    }
    
    public void init() {
        cbKierownikProjektu.removeAllItems();
        for (Object email : Client.getFasada().pobierzTabliceKierownikow()) {
            cbKierownikProjektu.addItem((String) email);
        }
    }
     
    @Override
    public void actionPerformed(ActionEvent evt) {
        String[] data = form_content();
        if (data == null) {
            return;
        }
        int result = Client.getFasada().addProjekt(cbKierownikProjektu.getSelectedItem().toString(),data); // ???
        if (result == 0) 
            JOptionPane.showMessageDialog(this, "Dodano projekt!");
        else if (result == 1) 
            JOptionPane.showMessageDialog(this, "Podana osoba nie jest kierownikiem!");
        else if (result == 2) 
            JOptionPane.showMessageDialog(this, "Projekt juz istnieje!");
        
    }

    public String[] form_content() {
        if (content_validate(tfNazwaProjektu) == null) {
            return null;
        }
        
        try {
            Integer.parseInt(tfStatusProjektu.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Identyfikator projektu nie jest liczbą.\nNie można wykonać operacji.");
            return null;
        }
        
        String data[] = { (String) tfNazwaProjektu.getText(), (String) tfStatusProjektu.getText()
        }; 
        return data;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);

    }

    public String content_validate(JTextField tf) {
        String str = tf.getText();

        if (str.equals("")) {
                JOptionPane.showMessageDialog(this, "Nie wpisano wymaganej zawartości!");
                return null;
        }
        else if("NazwaProjektu".equals(tf.getName())){

                str = str.replaceAll(" ", "_");
                tfNazwaProjektu.setText(str);
                return str;
        }
        else if ("KierownikProjektu".equals(tf.getName())){
        return str;
        }
        else{
        return null; 
        }
    }
    
}
