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
    public static JButton seekButton = new JButton();
    private static Component glue = Box.createHorizontalGlue();
    private static MouseListener mouseListenerExplorer = new MouseAdapter() {};
    private static MouseListener mouseListenerSeek = new MouseAdapter() {};
    private static ImageIcon butIcon = new ImageIcon("images\\tableTabIcon1.png");
    private static ImageIcon butIcon2 = new ImageIcon("images\\tableTabIcon2.png"); //#C0C0C0
    private static ImageIcon seekButIcon = new ImageIcon("images\\seekIcon1.png");
    private static ImageIcon seekButIcon2 = new ImageIcon("images\\seekIcon2.png"); 
    public static JTextField seekField = new JTextField();
    public static JLabel activeLabel = new JLabel();
    private static int tableTabY = 35;
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

        activeLabelChange();
       
    }

    public static void tabelleFrameButtonConfiguration(){

        MainFrame.tabelTab.setBounds(0, tableTabY, 75, 75);
        MainFrame.tabelTab.setIcon(butIcon2);
        MainFrame.tabelTab.setMargin(new Insets(2, 2, 2, 2));
        MainFrame.tabelTab.setOpaque(false);
        MainFrame.tabelTab.setBorderPainted(false);
        MainFrame.tabelTab.setContentAreaFilled(false);
        
       
        MainFrame.tabelTab.setVisible(true);

        MainFrame.schButton.setBounds(75, 80, 200, 50);
        MainFrame.schButton.setText("> Aktualisieren");
        MainFrame.schButton.setMargin(new Insets(2, 2, 2, 2));
        MainFrame.schButton.setForeground(new Color(169,169,169));
        MainFrame.schButton.setFont(new Font("Arial", Font.PLAIN, 19));
        MainFrame.schButton.setHorizontalAlignment(SwingConstants.LEFT);
        MainFrame.schButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MainFrame.schButton.setContentAreaFilled(true);
                MainFrame.schButton.setBackground(new Color(33, 43, 43));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MainFrame.schButton.setBackground(UIManager.getColor("control"));
                MainFrame.schButton.setContentAreaFilled(false);
            }
        });
        MainFrame.schButton.setOpaque(false);
        MainFrame.schButton.setBorderPainted(false);
        MainFrame.schButton.setContentAreaFilled(false);
        MainFrame.schButton.setVisible(true);

        MainFrame.newPwbut.setBounds(75, 120, 200, 50);
        MainFrame.newPwbut.setText("> Neues Passwort");
        MainFrame.newPwbut.setMargin(new Insets(2, 2, 2, 2));
        MainFrame.newPwbut.setForeground(new Color(169,169,169));
        MainFrame.newPwbut.setFont(new Font("Arial", Font.PLAIN, 19));
        MainFrame.newPwbut.setHorizontalAlignment(SwingConstants.LEFT);
        MainFrame.newPwbut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MainFrame.newPwbut.setContentAreaFilled(true);
                MainFrame.newPwbut.setBackground(new Color(33, 43, 43));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MainFrame.newPwbut.setBackground(UIManager.getColor("control"));
                MainFrame.newPwbut.setContentAreaFilled(false);
            }
        });
        MainFrame.newPwbut.setOpaque(false);
        MainFrame.newPwbut.setBorderPainted(false);
        MainFrame.newPwbut.setContentAreaFilled(false);
        MainFrame.newPwbut.setVisible(true);

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
        seekButton.setBounds(0, 120, 75, 75);
        seekButton.setIcon(seekButIcon);
        seekButton.setMargin(new Insets(2, 2, 2, 2));
        seekButton.setOpaque(false);
        seekButton.setBorderPainted(false);
        seekButton.setContentAreaFilled(false);
        seekHover();
    }
    public static void tabelleFrameTableConfiguration(){
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
    public static void explorerHover(){

        mouseListenerExplorer = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setContentAreaFilled(true);
                MainFrame.tabelTab.setIcon(butIcon2);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setBackground(UIManager.getColor("control"));
                MainFrame.tabelTab.setIcon(butIcon);
                //TabelleFrame.tabelTab.setContentAreaFilled(false);
            }
        };
        MainFrame.tabelTab.addMouseListener(mouseListenerExplorer);
    }

    public static void seekHover(){
        mouseListenerSeek = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setContentAreaFilled(true);
                seekButton.setIcon(seekButIcon2);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setBackground(UIManager.getColor("control"));
                seekButton.setIcon(seekButIcon);
                //TabelleFrame.tabelTab.setContentAreaFilled(false);
            }
        };
        seekButton.addMouseListener(mouseListenerSeek);
    }

    public static void ToSeek(){

        tableTabY = 120;
        activeLabelChange();

        MainFrame.tabelTab.setIcon(butIcon);
        explorerHover();

        
        MainFrame.schButton.setVisible(false);
        MainFrame.newPwbut.setVisible(false);
        MainFrame.jTable1ScrollPane.setVisible(false);
        seekButton.removeMouseListener(mouseListenerSeek);
        seekButton.setIcon(seekButIcon2);
        
        explorerJLabel.setText("SUCHEN");                               //hier krachts
    }
    public static void ToExplorer(){
        
        tableTabY = 35;
        activeLabelChange();

        seekButton.setIcon(seekButIcon);
        
        tabelleFrameButtonConfiguration();
        tabelleFrameTableConfiguration();
        
        MainFrame.tabelTab.removeMouseListener(mouseListenerExplorer);
        MainFrame.tabelTab.setIcon(butIcon2);
        
        explorerJLabel.setText("EXPLORER");
    }
    public static void activeLabelChange(){
        
        activeLabel.setBounds(0,tableTabY,2,75);
        activeLabel.setBackground(new Color(192,192,192));
        activeLabel.setOpaque(true);
    }
}
