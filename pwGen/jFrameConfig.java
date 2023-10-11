import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class jFrameConfig {

    public static JLabel explorerJLabel = new JLabel();
    private static Component glue = Box.createHorizontalGlue();
    public static JTextField seekField = new JTextField();
    public static void main(String [] args){

    }
    public static void labelConfiguration(){
        
        MainFrame.jMenuBar.remove(glue);

        MainFrame.sideLabel.setBounds(0, 0, 75, 1080);
        MainFrame.sideLabel.setBackground(new Color(62,62,66));
        MainFrame.sideLabel.setHorizontalAlignment(SwingConstants.CENTER);
        MainFrame.sideLabel.setVerticalAlignment(SwingConstants.CENTER);
        MainFrame.sideLabel.setOpaque(true);

        MainFrame.sidePlorer.setBounds(75, 0, 200, 1080);
        MainFrame.sidePlorer.setBackground(new Color(45,45,48));
        MainFrame.sidePlorer.setHorizontalAlignment(SwingConstants.CENTER);
        MainFrame.sidePlorer.setVerticalAlignment(SwingConstants.CENTER);
        MainFrame.sidePlorer.setOpaque(true);

        MainFrame.iconLabel.setIcon(MainFrame.iconLabelIcon);
        MainFrame.iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        MainFrame.iconLabel.setVerticalAlignment(SwingConstants.CENTER);
        MainFrame.iconLabel.setOpaque(false);

        explorerJLabel.setBounds(75, 0, 200, 80);
        explorerJLabel.setText("EXPLORER");
        explorerJLabel.setForeground(Color.GRAY);
        explorerJLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        explorerJLabel.setBackground(new Color(45,45,48));
        explorerJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        explorerJLabel.setVerticalAlignment(SwingConstants.CENTER);
        explorerJLabel.setOpaque(true);

        MainFrame.activeLabelChange();
       
    }

    public static void mainFrameButtonConfiguration(){

        MainFrame.tabelTab.setBounds(0, 35, 75, 75);
        MainFrame.tabelTab.setIcon(MainFrame.butIcon2);
        MainFrame.tabelTab.setMargin(new Insets(2, 2, 2, 2));
        MainFrame.tabelTab.setOpaque(false);
        MainFrame.tabelTab.setBorderPainted(false);
        MainFrame.tabelTab.setContentAreaFilled(false);
        MainFrame.tabelTab.setVisible(true);

        ImageIcon exitButtonIcon = new ImageIcon("images\\x.png");
        MainFrame.exitButton.setIcon(exitButtonIcon);
        MainFrame.exitButton.setMargin(new Insets(2, 2, 2, 2));
        MainFrame.exitButton.setOpaque(false);
        MainFrame.exitButton.setBorderPainted(false);
        MainFrame.exitButton.setContentAreaFilled(false);
        MainFrame.exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MainFrame.exitButton.setContentAreaFilled(true);
                MainFrame.exitButton.setBackground(Color.RED);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MainFrame.exitButton.setBackground(UIManager.getColor("control"));
                MainFrame.exitButton.setContentAreaFilled(false);
            }
        });
        MainFrame.exitButton.setPreferredSize(new Dimension(50, 20));
        MainFrame.exitButton.setVisible(true);
        
        MainFrame.jMenuBar.add(glue);
        MainFrame.jMenuBar.add(MainFrame.exitButton);

         //#C0C0C0
         MainFrame.seekButton.setBounds(0, 120, 75, 75);
         MainFrame.seekButton.setIcon( MainFrame.seekButIcon);
         MainFrame.seekButton.setMargin(new Insets(2, 2, 2, 2));
         MainFrame.seekButton.setOpaque(false);
         MainFrame.seekButton.setBorderPainted(false);
         MainFrame.seekButton.setContentAreaFilled(false);
        MainFrame.seekHover();
    }
    public static void mainFrameTableConfiguration(){
        MainFrame.jTable1ScrollPane.setBounds(400, 75, 1395, 880);
        MainFrame.jTable1.getColumnModel().getColumn(0).setHeaderValue("Aktivitaet");
        MainFrame.jTable1.getColumnModel().getColumn(1).setHeaderValue("Password");
        MainFrame.jTable1.getColumnModel().getColumn(0).setResizable(false);
        MainFrame.jTable1.getColumnModel().getColumn(1).setResizable(false);
        MainFrame.jTable1.getTableHeader().setPreferredSize(new Dimension(300,50));
        MainFrame.jTable1.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 22));
        MainFrame.jTable1.setForeground(new Color(143, 143, 143));
        MainFrame.jTable1.setFont(new Font("Futura", Font.PLAIN, 22));
        MainFrame.jTable1.getTableHeader().setBackground(new Color(91,91,91));
        MainFrame.jTable1.setBackground(new Color(68,68,68));
        MainFrame.jTable1.getColumnModel().getColumn(0).setWidth(100);
        MainFrame.jTable1.setRowHeight(100);
        MainFrame.jTable1ScrollPane.setBackground(new Color(62, 62, 64));
        MainFrame.jTable1ScrollPane.setOpaque(true);
        MainFrame.jTable1.setOpaque(true);
        //jTable1.setBackground(new Color(62, 62, 64));
        MainFrame.jTable1.setBorder(BorderFactory.createEmptyBorder());

        MainFrame.jTable1ScrollPane.getVerticalScrollBar().setBorder(null);
        MainFrame.jTable1ScrollPane.getHorizontalScrollBar().setBorder(null);
        MainFrame.jTable1ScrollPane.setBorder(null);

        MainFrame.jTable1ScrollPane.setVisible(true);
    }

}
