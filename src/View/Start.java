package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Start extends JPanel implements ActionListener
{
    JButton btBut0;
    JButton btBut1;
    JLabel lbLabelGUI;

    public Start()
    {
        super();
        setBorder( BorderFactory.createTitledBorder( "" ) );

        GridBagLayout gbStart = new GridBagLayout();
        GridBagConstraints gbcStart = new GridBagConstraints();
        setLayout( gbStart );

        btBut0 = new JButton( "Sucursale"  );
        btBut0.addActionListener( this );
        gbcStart.gridx = 0;
        gbcStart.gridy = 21;
        gbcStart.gridwidth = 9;
        gbcStart.gridheight = 9;
        gbcStart.fill = GridBagConstraints.BOTH;
        gbcStart.weightx = 1;
        gbcStart.weighty = 1;
        gbcStart.anchor = GridBagConstraints.NORTH;
        gbcStart.insets = new Insets( 10,10,10,10 );
        gbStart.setConstraints( btBut0, gbcStart );
        add( btBut0 );

        btBut1 = new JButton( "Orase"  );
        btBut1.addActionListener( this );
        gbcStart.gridx = 11;
        gbcStart.gridy = 21;
        gbcStart.gridwidth = 9;
        gbcStart.gridheight = 9;
        gbcStart.fill = GridBagConstraints.BOTH;
        gbcStart.weightx = 1;
        gbcStart.weighty = 0;
        gbcStart.anchor = GridBagConstraints.NORTH;
        gbcStart.insets = new Insets( 10,10,10,10 );
        gbStart.setConstraints( btBut1, gbcStart );
        add( btBut1 );

        lbLabelGUI = new JLabel( " Firma Arhivistica"  );
        gbcStart.gridx = 1;
        gbcStart.gridy = 1;
        gbcStart.gridwidth = 18;
        gbcStart.gridheight = 9;
        gbcStart.fill = GridBagConstraints.BOTH;
        gbcStart.weightx = 1;
        gbcStart.weighty = 1;
        gbcStart.anchor = GridBagConstraints.NORTH;
        gbcStart.insets = new Insets( 10,10,0,10 );
        gbStart.setConstraints( lbLabelGUI, gbcStart );
        add( lbLabelGUI );
    }



    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == btBut0 )
        {
            JFrame f3 = new JFrame("");
            f3.setVisible(true);
            SucursalePannel sp  = new SucursalePannel();
            sp.setVisible(true);
            f3.setSize(400,400);
            f3.add(sp);
        }
        if ( e.getSource() == btBut1 )
        {

            JFrame f2 = new JFrame("");
            f2.setVisible(true);
            OrasePannel op = new OrasePannel();
            op.setVisible(true);
            f2.setSize(400,400);
            f2.add(op);

        }
    }
}


