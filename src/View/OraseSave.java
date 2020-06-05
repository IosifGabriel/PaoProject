package View;

import DBService.AngajatDBService;
import DBService.OrasDBService;
import models.Oras;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;

import static javax.swing.JOptionPane.showMessageDialog;


public class OraseSave extends JPanel implements ActionListener
{
    JTextArea taArea0;
    JTextArea taArea4;
    JButton btSalveaza;
    JButton btBack;


    public OraseSave()
    {
        super();
        setBorder( BorderFactory.createTitledBorder(""));
        GridBagLayout gbSaveORas = new GridBagLayout();
        GridBagConstraints gbcSaveORas = new GridBagConstraints();
        setLayout( gbSaveORas );

        taArea0 = new JTextArea(2,10);
        gbcSaveORas.gridx = 0;
        gbcSaveORas.gridy = 3;
        gbcSaveORas.gridwidth = 20;
        gbcSaveORas.gridheight = 1;
        gbcSaveORas.fill = GridBagConstraints.BOTH;
        gbcSaveORas.weightx = 1;
        gbcSaveORas.weighty = 1;
        gbcSaveORas.anchor = GridBagConstraints.NORTH;
        gbSaveORas.setConstraints( taArea0, gbcSaveORas );
        add( taArea0 );

        taArea4 = new JTextArea(2,10);
        gbcSaveORas.gridx = 0;
        gbcSaveORas.gridy = 6;
        gbcSaveORas.gridwidth = 20;
        gbcSaveORas.gridheight = 3;
        gbcSaveORas.fill = GridBagConstraints.BOTH;
        gbcSaveORas.weightx = 1;
        gbcSaveORas.weighty = 1;
        gbcSaveORas.anchor = GridBagConstraints.NORTH;
        gbSaveORas.setConstraints( taArea4, gbcSaveORas );
        add( taArea4 );

        btSalveaza = new JButton( "Salveaza"  );
        btSalveaza.addActionListener( this );
        gbcSaveORas.gridx = 0;
        gbcSaveORas.gridy = 12;
        gbcSaveORas.gridwidth = 20;
        gbcSaveORas.gridheight = 3;
        gbcSaveORas.fill = GridBagConstraints.BOTH;
        gbcSaveORas.weightx = 1;
        gbcSaveORas.weighty = 0;
        gbcSaveORas.anchor = GridBagConstraints.NORTH;
        gbSaveORas.setConstraints( btSalveaza, gbcSaveORas );
        add( btSalveaza );

        btBack = new JButton( "Back"  );
        btBack.addActionListener( this );
        gbcSaveORas.gridx = 0;
        gbcSaveORas.gridy = 16;
        gbcSaveORas.gridwidth = 20;
        gbcSaveORas.gridheight = 4;
        gbcSaveORas.fill = GridBagConstraints.BOTH;
        gbcSaveORas.weightx = 1;
        gbcSaveORas.weighty = 0;
        gbcSaveORas.anchor = GridBagConstraints.NORTH;
        gbSaveORas.setConstraints( btBack, gbcSaveORas );
        add( btBack );
    }

    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == btSalveaza )
        {

            OrasDBService.getInstance().saveOras(new Oras(taArea0.getText(), taArea0.getText()));
            showMessageDialog(null,  "Oras adaugat cu succes");

        }
        if ( e.getSource() == btBack )
        {
            this.setVisible(false);
        }
    }
}

