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
    private static MouseListener mouseListener = new MouseAdapter() {};
    private static ImageIcon seekButIcon2 = new ImageIcon("images\\seekIcon2.png");
    private static ImageIcon butIcon = new ImageIcon("images\\tableTabIcon1.png");
    private static ImageIcon butIcon2 = new ImageIcon("images\\tableTabIcon2.png"); //#C0C0C0
    public static void main(String [] args){

    }
    public static void labelConfiguration(){
        
        TabelleFrame.jMenuBar.remove(glue);

        TabelleFrame.sideLabel.setBounds(0, 0, 75, 1080);
        TabelleFrame.sideLabel.setBackground(new Color(62,62,66));
        TabelleFrame.sideLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TabelleFrame.sideLabel.setVerticalAlignment(SwingConstants.CENTER);
        TabelleFrame.sideLabel.setOpaque(true);

        TabelleFrame.sidePlorer.setBounds(75, 0, 200, 1080);
        TabelleFrame.sidePlorer.setBackground(new Color(45,45,48));
        TabelleFrame.sidePlorer.setHorizontalAlignment(SwingConstants.CENTER);
        TabelleFrame.sidePlorer.setVerticalAlignment(SwingConstants.CENTER);
        TabelleFrame.sidePlorer.setOpaque(true);

        TabelleFrame.iconLabel.setIcon(TabelleFrame.iconLabelIcon);
        TabelleFrame.iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TabelleFrame.iconLabel.setVerticalAlignment(SwingConstants.CENTER);
        TabelleFrame.iconLabel.setOpaque(false);

        explorerJLabel.setBounds(75, 0, 200, 80);
        explorerJLabel.setText("EXPLORER");
        explorerJLabel.setForeground(Color.GRAY);
        explorerJLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        explorerJLabel.setBackground(new Color(45,45,48));
        explorerJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        explorerJLabel.setVerticalAlignment(SwingConstants.CENTER);
        explorerJLabel.setOpaque(true);
       
    }

    public static void tabelleFrameButtonConfiguration(){

        ImageIcon butIcon = new ImageIcon("images\\tableTabIcon1.png");
        ImageIcon butIcon2 = new ImageIcon("images\\tableTabIcon2.png"); //#C0C0C0
        TabelleFrame.tabelTab.setBounds(0, 35, 75, 75);
        TabelleFrame.tabelTab.setIcon(butIcon);
        TabelleFrame.tabelTab.setMargin(new Insets(2, 2, 2, 2));
        TabelleFrame.tabelTab.setOpaque(false);
        TabelleFrame.tabelTab.setBorderPainted(false);
        TabelleFrame.tabelTab.setContentAreaFilled(false);
        
       
        TabelleFrame.tabelTab.setVisible(true);

        TabelleFrame.schButton.setBounds(75, 80, 200, 50);
        TabelleFrame.schButton.setText("> Aktualisieren");
        TabelleFrame.schButton.setMargin(new Insets(2, 2, 2, 2));
        TabelleFrame.schButton.setForeground(new Color(169,169,169));
        TabelleFrame.schButton.setFont(new Font("Arial", Font.PLAIN, 19));
        TabelleFrame.schButton.setHorizontalAlignment(SwingConstants.LEFT);
        TabelleFrame.schButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabelleFrame.schButton.setContentAreaFilled(true);
                TabelleFrame.schButton.setBackground(new Color(33, 43, 43));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TabelleFrame.schButton.setBackground(UIManager.getColor("control"));
                TabelleFrame.schButton.setContentAreaFilled(false);
            }
        });
        TabelleFrame.schButton.setOpaque(false);
        TabelleFrame.schButton.setBorderPainted(false);
        TabelleFrame.schButton.setContentAreaFilled(false);
        TabelleFrame.schButton.setVisible(true);

        TabelleFrame.newPwbut.setBounds(75, 120, 200, 50);
        TabelleFrame.newPwbut.setText("> Neues Passwort");
        TabelleFrame.newPwbut.setMargin(new Insets(2, 2, 2, 2));
        TabelleFrame.newPwbut.setForeground(new Color(169,169,169));
        TabelleFrame.newPwbut.setFont(new Font("Arial", Font.PLAIN, 19));
        TabelleFrame.newPwbut.setHorizontalAlignment(SwingConstants.LEFT);
        TabelleFrame.newPwbut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabelleFrame.newPwbut.setContentAreaFilled(true);
                TabelleFrame.newPwbut.setBackground(new Color(33, 43, 43));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TabelleFrame.newPwbut.setBackground(UIManager.getColor("control"));
                TabelleFrame.newPwbut.setContentAreaFilled(false);
            }
        });
        TabelleFrame.newPwbut.setOpaque(false);
        TabelleFrame.newPwbut.setBorderPainted(false);
        TabelleFrame.newPwbut.setContentAreaFilled(false);
        TabelleFrame.newPwbut.setVisible(true);

        ImageIcon exitButtonIcon = new ImageIcon("images\\x.png");
        TabelleFrame.exitButton.setIcon(exitButtonIcon);
        TabelleFrame.exitButton.setMargin(new Insets(2, 2, 2, 2));
        TabelleFrame.exitButton.setOpaque(false);
        TabelleFrame.exitButton.setBorderPainted(false);
        TabelleFrame.exitButton.setContentAreaFilled(false);
        TabelleFrame.exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TabelleFrame.exitButton.setContentAreaFilled(true);
                TabelleFrame.exitButton.setBackground(Color.RED);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TabelleFrame.exitButton.setBackground(UIManager.getColor("control"));
                TabelleFrame.exitButton.setContentAreaFilled(false);
            }
        });
        TabelleFrame.exitButton.setPreferredSize(new Dimension(50, 20));
        TabelleFrame.exitButton.setVisible(true);
        
        TabelleFrame.jMenuBar.add(glue);
        TabelleFrame.jMenuBar.add(TabelleFrame.exitButton);

        ImageIcon seekButIcon = new ImageIcon("images\\seekIcon1.png");
        ImageIcon seekButIcon2 = new ImageIcon("images\\seekIcon2.png"); //#C0C0C0
        seekButton.setBounds(0, 120, 75, 75);
        seekButton.setIcon(seekButIcon);
        seekButton.setMargin(new Insets(2, 2, 2, 2));
        seekButton.setOpaque(false);
        seekButton.setBorderPainted(false);
        seekButton.setContentAreaFilled(false);
        seekButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setContentAreaFilled(true);
                seekButton.setIcon(seekButIcon2);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setBackground(UIManager.getColor("control"));
                seekButton.setIcon(seekButIcon);
                //TabelleFrame.tabelTab.setContentAreaFilled(false);
            }
        });
        


        
        
    }
    public static void tabelleFrameTableConfiguration(){
        TabelleFrame.jTable1ScrollPane.setBounds(400, 75, 1395, 880);
        TabelleFrame.jTable1.getColumnModel().getColumn(0).setHeaderValue("null");
        TabelleFrame.jTable1.getColumnModel().getColumn(1).setHeaderValue("Password");
        TabelleFrame.jTable1.getColumnModel().getColumn(0).setResizable(false);
        TabelleFrame.jTable1.getColumnModel().getColumn(1).setResizable(false);
        TabelleFrame.jTable1.getTableHeader().setPreferredSize(new Dimension(300,50));
        TabelleFrame.jTable1.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 22));
        TabelleFrame.jTable1.setForeground(new Color(143, 143, 143));
        TabelleFrame.jTable1.setFont(new Font("Futura", Font.PLAIN, 22));
        TabelleFrame.jTable1.getTableHeader().setBackground(new Color(91,91,91));
        TabelleFrame.jTable1.setBackground(new Color(68,68,68));
        TabelleFrame.jTable1.getColumnModel().getColumn(0).setWidth(100);
        TabelleFrame.jTable1.setRowHeight(100);
        TabelleFrame.jTable1ScrollPane.setBackground(new Color(62, 62, 64));
        TabelleFrame.jTable1ScrollPane.setOpaque(true);
        TabelleFrame.jTable1.setOpaque(true);
        //jTable1.setBackground(new Color(62, 62, 64));
        TabelleFrame.jTable1.setBorder(BorderFactory.createEmptyBorder());

        TabelleFrame.jTable1ScrollPane.getVerticalScrollBar().setBorder(null);
        TabelleFrame.jTable1ScrollPane.getHorizontalScrollBar().setBorder(null);
        TabelleFrame.jTable1ScrollPane.setBorder(null);

        TabelleFrame.jTable1ScrollPane.setVisible(true);
    }
    public static void explorerHover(){
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setContentAreaFilled(true);
                TabelleFrame.tabelTab.setIcon(butIcon2);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //TabelleFrame.tabelTab.setBackground(UIManager.getColor("control"));
                TabelleFrame.tabelTab.setIcon(butIcon);
                //TabelleFrame.tabelTab.setContentAreaFilled(false);
            }
        };
        TabelleFrame.tabelTab.addMouseListener(mouseListener);
    }
    public static void removeExplorerHover(){
        TabelleFrame.tabelTab.removeMouseListener(mouseListener);
    }

    public static void ToSeek(){
        explorerHover();
        seekButton.setIcon(seekButIcon2);
        TabelleFrame.schButton.setVisible(false);
        TabelleFrame.newPwbut.setVisible(false);
        TabelleFrame.jTable1ScrollPane.setVisible(false);
        explorerJLabel.setText("SUCHEN");                               //hier krachts
    }
    public static void ToExplorer(){
        removeExplorerHover();
        TabelleFrame.tabelTab.setIcon(butIcon2);
        tabelleFrameButtonConfiguration();
        tabelleFrameTableConfiguration();
        explorerJLabel.setText("EXPLORER");
    }
}
