package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class SucursalePannel extends JPanel implements ActionListener
{
    JButton btAdauga;
    JButton btCauta;
    JButton btSterge;
    JButton btUpdate;
    JButton btBack;


    public SucursalePannel()
    {
        super();
        setBorder( BorderFactory.createTitledBorder( "Oras " ) );

        GridBagLayout gbOrase = new GridBagLayout();
        GridBagConstraints gbcOrase = new GridBagConstraints();
        setLayout( gbOrase );

        btAdauga = new JButton( "Adauga"  );
        btAdauga.addActionListener( this );
        gbcOrase.gridx = 1;
        gbcOrase.gridy = 1;
        gbcOrase.gridwidth = 17;
        gbcOrase.gridheight = 5;
        gbcOrase.fill = GridBagConstraints.BOTH;
        gbcOrase.weightx = 1;
        gbcOrase.weighty = 0;
        gbcOrase.anchor = GridBagConstraints.NORTH;
        gbOrase.setConstraints( btAdauga, gbcOrase );
        add( btAdauga );

        btCauta = new JButton( "Cauta"  );
        btCauta.addActionListener( this );
        gbcOrase.gridx = 1;
        gbcOrase.gridy = 7;
        gbcOrase.gridwidth = 17;
        gbcOrase.gridheight = 5;
        gbcOrase.fill = GridBagConstraints.BOTH;
        gbcOrase.weightx = 1;
        gbcOrase.weighty = 0;
        gbcOrase.anchor = GridBagConstraints.NORTH;
        gbOrase.setConstraints( btCauta, gbcOrase );
        add( btCauta );

        btSterge = new JButton( "Sterge"  );
        btSterge.addActionListener( this );
        gbcOrase.gridx = 1;
        gbcOrase.gridy = 13;
        gbcOrase.gridwidth = 17;
        gbcOrase.gridheight = 5;
        gbcOrase.fill = GridBagConstraints.BOTH;
        gbcOrase.weightx = 1;
        gbcOrase.weighty = 0;
        gbcOrase.anchor = GridBagConstraints.NORTH;
        gbOrase.setConstraints( btSterge, gbcOrase );
        add( btSterge );

        btUpdate = new JButton( "Update"  );
        btUpdate.addActionListener( this );
        gbcOrase.gridx = 1;
        gbcOrase.gridy = 19;
        gbcOrase.gridwidth = 17;
        gbcOrase.gridheight = 5;
        gbcOrase.fill = GridBagConstraints.BOTH;
        gbcOrase.weightx = 1;
        gbcOrase.weighty = 0;
        gbcOrase.anchor = GridBagConstraints.NORTH;
        gbOrase.setConstraints( btUpdate, gbcOrase );
        add( btUpdate );

        btBack = new JButton( "Back"  );
        btBack.addActionListener( this );
        gbcOrase.gridx = 10;
        gbcOrase.gridy = 26;
        gbcOrase.gridwidth = 10;
        gbcOrase.gridheight = 3;
        gbcOrase.fill = GridBagConstraints.BOTH;
        gbcOrase.weightx = 1;
        gbcOrase.weighty = 0;
        gbcOrase.anchor = GridBagConstraints.NORTH;
        gbOrase.setConstraints( btBack, gbcOrase );
        add( btBack );
    }


    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == btAdauga )
        {

        }
        if ( e.getSource() == btCauta )
        {
            JFrame f1 = new JFrame("");
            f1.setVisible(true);
            SucursaleFind sf = new SucursaleFind();
            sf.setVisible(true);
            f1.setSize(400,400);
            f1.add(sf);
        }
        if ( e.getSource() == btSterge )
        {
            JFrame f2 = new JFrame("");
            f2.setVisible(true);
            SucursaleDelete sd = new SucursaleDelete();
            sd.setVisible(true);
            f2.setSize(400,400);
            f2.add(sd);
        }
        if ( e.getSource() == btUpdate )
        {
            // Action for btUpdate
        }
        if ( e.getSource() == btBack )
        {
            this.setVisible(false);
        }
    }
}


