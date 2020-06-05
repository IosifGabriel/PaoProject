package View;

import DBService.CladiriDBService;
import models.Sucursale;

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


class SucursaleFind extends JPanel implements ActionListener
{
    JTextArea taArea0;
    JButton btFInd;
    JButton btBut1;

    public SucursaleFind()
    {
        super();

        GridBagLayout gbOraseFind = new GridBagLayout();
        GridBagConstraints gbcOraseFind = new GridBagConstraints();
        setLayout( gbOraseFind );

        taArea0 = new JTextArea(2,10);
        gbcOraseFind.gridx = 0;
        gbcOraseFind.gridy = 0;
        gbcOraseFind.gridwidth = 20;
        gbcOraseFind.gridheight = 7;
        gbcOraseFind.fill = GridBagConstraints.BOTH;
        gbcOraseFind.weightx = 1;
        gbcOraseFind.weighty = 1;
        gbcOraseFind.anchor = GridBagConstraints.NORTH;
        gbOraseFind.setConstraints( taArea0, gbcOraseFind );
        add( taArea0 );

        btFInd = new JButton( "Find"  );
        btFInd.addActionListener( this );
        gbcOraseFind.gridx = 0;
        gbcOraseFind.gridy = 11;
        gbcOraseFind.gridwidth = 20;
        gbcOraseFind.gridheight = 5;
        gbcOraseFind.fill = GridBagConstraints.BOTH;
        gbcOraseFind.weightx = 1;
        gbcOraseFind.weighty = 0;
        gbcOraseFind.anchor = GridBagConstraints.NORTH;
        gbOraseFind.setConstraints( btFInd, gbcOraseFind );
        add( btFInd );

        btBut1 = new JButton( "Back"  );
        btBut1.addActionListener( this );
        gbcOraseFind.gridx = 0;
        gbcOraseFind.gridy = 16;
        gbcOraseFind.gridwidth = 20;
        gbcOraseFind.gridheight = 4;
        gbcOraseFind.fill = GridBagConstraints.BOTH;
        gbcOraseFind.weightx = 1;
        gbcOraseFind.weighty = 0;
        gbcOraseFind.anchor = GridBagConstraints.NORTH;
        gbOraseFind.setConstraints( btBut1, gbcOraseFind );
        add( btBut1 );
    }


    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == btFInd )
        {
            int i = Integer.parseInt(taArea0.getText());
            Sucursale s = CladiriDBService.getInstance().findSucursala(i);
            showMessageDialog(null,  s.getAdresa());
        }
        if ( e.getSource() == btBut1 )
        {
            this.setVisible(false);
        }
    }
}


