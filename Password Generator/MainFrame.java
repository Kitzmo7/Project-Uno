//java --enable-preview -jar pwGen.jar


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import javax.swing.table.*;
import java.util.Random;

//import java.lang.Math;

public class MainFrame extends JFrame {

    private JLabel Heading = new JLabel();
    private JButton NewPassword = new JButton();
    private JButton Table = new JButton();
    

    public MainFrame() {
        super();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 1920;
        int frameHeight = 1080;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Password Generator");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);

        Heading.setBounds(0, 0, 1920, 100);
        Heading.setText("Hallo");
        Heading.setVerticalAlignment(SwingConstants.CENTER);
        Heading.setHorizontalAlignment(SwingConstants.CENTER);
        Heading.setOpaque(true);
        cp.add(Heading);

       
        NewPassword.setBounds(280, 350, 75, 25);
        NewPassword.setText("Neues Passwort");
        NewPassword.setMargin(new Insets(2, 2, 2, 2));
        NewPassword.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                NewPassword_ActionPerformed(evt);
            }
        });
        cp.add(NewPassword);

        Table.setBounds(880, 350, 75, 25);
        Table.setText("Table");
        Table.setMargin(new Insets(2, 2, 2, 2));
        Table.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                Table_ActionPerformed(evt);
            }
        });
        cp.add(Table);

        setVisible(true);
    }
    public static void main(String [] args) throws IOException{
        new MainFrame();

    }
    
    public void NewPassword_ActionPerformed(ActionEvent evt) {
        new QuestionFrame();
    }
    public void Table_ActionPerformed(ActionEvent evt) {
        new TabelleFrame();
    }
}
