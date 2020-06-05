package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class OrasePannel extends JPanel implements ActionListener
{
    JButton btAdauga;
    JButton btCauta;
    JButton btSterge;
    JButton btUpdate;
    JButton btBack;


    public OrasePannel()
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
            JFrame f3 = new JFrame("");
            f3.setVisible(true);
            OraseSave os = new OraseSave();
            os.setVisible(true);
            f3.setSize(400,400);
            f3.add(os);
        }
        if ( e.getSource() == btCauta )
        {
            JFrame f4 = new JFrame("");
            f4.setVisible(true);
            OraseFind of = new OraseFind();
            of.setVisible(true);
            f4.setSize(400,400);
            f4.add(of);
        }
        if ( e.getSource() == btSterge )
        {
            JFrame f5 = new JFrame("");
            f5.setVisible(true);
            OraseDelete od = new OraseDelete();
            od.setVisible(true);
            f5.setSize(400,400);
            f5.add(od);
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


