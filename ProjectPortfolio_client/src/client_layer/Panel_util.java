
package client_layer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Panel_util implements ActionListener {
    
    Client client;
    
    JPanel cards;
    final static String RYZYKO = "Dodaj ryzyko";
    final static String LISTA_RYZYK = "Lista ryzyk";
    final static String OSOBA = "Dodaj osobe";
    final static String LISTA_OSOB = "Lista osob";
    final static String KLIENT = "Dodaj klienta";
    final static String PROJEKT = "Dodaj projekt";
    final static String LISTA_PROJEKTOW = "Lista projektów";
    final static String SPRINT = "Dodaj sprint";
    final static String LISTA_SPRINTOW = "Lista sprintow";
    final static String STAN_SPRINTU = "Dodaj stan sprintu";
    
    
        public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("Menu");
        menuBar.add(menu);
   
        menuItem = new JMenuItem(KLIENT);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem(OSOBA);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem(PROJEKT);
        menuItem.addActionListener(this);
        menu.add(menuItem); 
        
        menuItem = new JMenuItem(RYZYKO);
        menuItem.addActionListener(this);
        menu.add(menuItem);
         
        menuItem = new JMenuItem(LISTA_OSOB);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem(LISTA_PROJEKTOW);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem(LISTA_RYZYK);
        menuItem.addActionListener(this);
        menu.add(menuItem);
       
        menuItem = new JMenuItem(SPRINT);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menuItem = new JMenuItem(LISTA_SPRINTOW);
        menuItem.addActionListener(this);
        menu.add(menuItem);
       
        menuItem = new JMenuItem(STAN_SPRINTU);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        return menuBar;
    }
        
    public Container createContentPane() {

        DodajKlienta_form card0 = new DodajKlienta_form();
        DodajRyzyko_form card1 = new DodajRyzyko_form();
        ListaRyzyk_form card2 = new ListaRyzyk_form();
        DodajOsobe_form card3 = new DodajOsobe_form(client);
        ListaOsob_form card4 = new ListaOsob_form(client);
        Dodaj_projekt_form card5 = new Dodaj_projekt_form();
        Lista_projektow_form card6 = new Lista_projektow_form();
        DodajSprint_form card7 = new DodajSprint_form();
        Lista_sprintow_form card8 = new Lista_sprintow_form();
        DodajStanSprintu_form card9 = new DodajStanSprintu_form();
        
        card2.init();

        cards = new JPanel(new CardLayout());
        cards.add(card0, KLIENT);
        cards.add(card1, RYZYKO);
        cards.add(card2, LISTA_RYZYK);
        cards.add(card3, OSOBA);
        cards.add(card4, LISTA_OSOB);
        cards.add(card5, PROJEKT);
        cards.add(card6, LISTA_PROJEKTOW);
        cards.add(card7, SPRINT);
        cards.add(card8, LISTA_SPRINTOW);
        cards.add(card9, STAN_SPRINTU);
        
        JPanel panel = new JPanel();

        panel.add(cards, BorderLayout.CENTER);
        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem source = (JMenuItem) (e.getSource());
        CardLayout cl = (CardLayout) (cards.getLayout());
        switch (source.getText()) {
            case KLIENT:
                cl.show(cards, KLIENT);
                break;
            case OSOBA:
                cl.show(cards, OSOBA);
                break;
            case RYZYKO:
                ((DodajRyzyko_form) cards.getComponent(1)).init();
                cl.show(cards, RYZYKO);
                break;
            case LISTA_OSOB:
                cl.show(cards, LISTA_OSOB);
                break;
            case LISTA_RYZYK:
                ((ListaRyzyk_form) cards.getComponent(2)).init();
                cl.show(cards, LISTA_RYZYK);
                break;
            case PROJEKT:
                ((Dodaj_projekt_form) cards.getComponent(5)).init();
                cl.show(cards, PROJEKT);
                break;
            case LISTA_PROJEKTOW:
                cl.show(cards, LISTA_PROJEKTOW);
                break;
            case SPRINT:
                ((DodajSprint_form) cards.getComponent(7)).init();
                cl.show(cards, SPRINT);
                break;
            case LISTA_SPRINTOW:
                ((Lista_sprintow_form) cards.getComponent(8)).init();
                cl.show(cards, LISTA_SPRINTOW);
                break;
            case STAN_SPRINTU:
                ((DodajStanSprintu_form) cards.getComponent(9)).init();                
                cl.show(cards, STAN_SPRINTU);    
        }
    }


    public void createAndShowGUI(Client client) {
        this.client = client;
       JFrame frame = new JFrame("Project Portfolio");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(400,450));
     
        Panel_util demo = new Panel_util();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
        
        frame.setVisible(true);
    }
}
