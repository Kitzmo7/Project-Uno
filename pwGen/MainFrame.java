import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.security.DigestException;

import javax.swing.table.*;
import java.util.Random;


public class MainFrame extends JFrame {
    public static String text = "";
    public static int counting = 0;
    public static int max = 0;
    public static JButton tabelTab = new JButton();
    public JButton schButton = new JButton();
    public static JTable jTable1 = new JTable();
    public static DefaultTableModel jTable = (DefaultTableModel) jTable1.getModel();
    public static JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
    public static JMenuBar jMenuBar = new JMenuBar();
    public static JLabel sideLabel = new JLabel();
    public static JLabel sidePlorer = new JLabel();
    public JButton newPwbut = new JButton();
    public static JButton exitButton = new JButton();
    public static JLabel iconLabel = new JLabel();
    public static ImageIcon iconLabelIcon = new ImageIcon("images\\key.png");
    public  Container cp = getContentPane();
    private static int tableTabY = 35;
    public static ImageIcon butIcon = new ImageIcon("images\\tableTabIcon1.png");
    public static ImageIcon butIcon2 = new ImageIcon("images\\tableTabIcon2.png"); //#C0C0C0
    public static ImageIcon seekButIcon = new ImageIcon("images\\seekIcon1.png");
    public static ImageIcon seekButIcon2 = new ImageIcon("images\\seekIcon2.png"); 
    public static JLabel activeLabel = new JLabel();
    public static JButton seekButton = new JButton();
    private static MouseListener mouseListenerExplorer = new MouseAdapter() {};
    private static MouseListener mouseListenerSeek = new MouseAdapter() {};
    public static JLabel explorerJLabel = new JLabel();

    public MainFrame(){
        super();

        
        setIconImage(iconLabelIcon.getImage());
        counting = 0;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 1920;
        int frameHeight = 1060;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        /*int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;*/
        setLocation(0, 0);
        setTitle("Password Generator");
        setUndecorated(true);
        setResizable(true);
        //Container cp = getContentPane();
        cp.setBackground(new Color(37,37,38));
        cp.setLayout(null);
     
        jMenuBar.setBackground(new Color(62, 62, 64));
        setJMenuBar(jMenuBar);
        jMenuBar.setBorderPainted(false);

        jFrameConfig.labelConfiguration();
        
        cp.add(jFrameConfig.explorerJLabel);

        jMenuBar.add(iconLabel);
        cp.add(activeLabel);

        jFrameConfig.mainFrameButtonConfiguration();

        tabelTab.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                tabelTab_ActionPerformed(evt);
            }
        });
        cp.add(tabelTab);




        schButton.setBounds(75, 80, 200, 50);
        schButton.setText("> Aktualisieren");
        schButton.setMargin(new Insets(2, 2, 2, 2));
        schButton.setForeground(new Color(169,169,169));
        schButton.setFont(new Font("Arial", Font.PLAIN, 19));
        schButton.setHorizontalAlignment(SwingConstants.LEFT);
        schButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                schButton.setContentAreaFilled(true);
                schButton.setBackground(new Color(33, 43, 43));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                schButton.setBackground(UIManager.getColor("control"));
                schButton.setContentAreaFilled(false);
            }
        });
        schButton.setOpaque(false);
        schButton.setBorderPainted(false);
        schButton.setContentAreaFilled(false);
        schButton.setVisible(true);
        schButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                schButton_ActionPerformed(evt);
            }
        });
        cp.add(schButton);




        newPwbut.setBounds(75, 120, 200, 50);
        newPwbut.setText("> Neues Passwort");
        newPwbut.setMargin(new Insets(2, 2, 2, 2));
        newPwbut.setForeground(new Color(169,169,169));
        newPwbut.setFont(new Font("Arial", Font.PLAIN, 19));
        newPwbut.setHorizontalAlignment(SwingConstants.LEFT);
        newPwbut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newPwbut.setContentAreaFilled(true);
                newPwbut.setBackground(new Color(33, 43, 43));
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newPwbut.setBackground(UIManager.getColor("control"));
                newPwbut.setContentAreaFilled(false);
            }
        });
        newPwbut.setOpaque(false);
        newPwbut.setBorderPainted(false);
        newPwbut.setContentAreaFilled(false);
        newPwbut.setVisible(true);
        newPwbut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                newPwbut_ActionPerformed(evt);
            }
        });
        
        cp.add(newPwbut);

        exitButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                exitButton_ActionPerformed(evt);
            }
        });
        seekButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                seekButton_ActionPerformed(evt);
            }
        });
        cp.add(seekButton);
        
        cp.add(sideLabel);
        cp.add(sidePlorer);
        
        zeilenCount();
        
        
        jTable.setRowCount(counting);
        jTable.setColumnCount(2);

        jFrameConfig.mainFrameTableConfiguration();

        int rowCount = jTable.getRowCount();

        max = rowCount;
        max--;
        for(int c = 0; c <= max; c++){
            aktivitaetLesen(c);
            jTable1.setValueAt(text, c, 0);
        }
        Object rowValue = jTable1.getValueAt(max, 0);
        String rowValue2 = (String) rowValue;
        System.out.println(rowValue2);
        if(rowValue2 == " "){
        }   
        else{
            jTable.addRow(new Object[]{""});
            max++;
            
        }
        for(int b = 0; b <= max; b++){
            pwLesen(b);
            jTable1.setValueAt(text, b, 1);
        }
        cp.add(jTable1ScrollPane);
        //jTable1ScrollPane.setVisible(false);

     
        setVisible(true);
       

        
    }
    public static void main(String [] args){

        new MainFrame();
        
    }
    public void aktivitaetLesen(int c){
        String zeile = "";
        text = " ";
        int i = 0;
        c = c + 2;
        try(BufferedReader reader = new BufferedReader(new FileReader("data\\aktivitaet"))){
            while ((zeile = reader.readLine()) != null){
                i++;
                if(i == c){ 
                    text = text.concat(zeile + "");
                }
                
            }
        }
        catch(Exception leseFehler){
        System.err.println(leseFehler);
        }
    }
    public void pwLesen(int b){
        String zeile = "";
        text = " ";
        int i = 0;
        b = b + 2;
        try(BufferedReader reader = new BufferedReader(new FileReader("data\\pw"))){
            
            while ((zeile = reader.readLine()) != null){
                i++;
                if(i == b){ 
                    text = text.concat(zeile + ""); 
                    
                }
                
            }

        }
        catch(Exception leseFehler){
        System.err.println(leseFehler);
        }
    }
    public void zeilenCount(){
        
        try(BufferedReader reader = new BufferedReader(new FileReader("data\\aktivitaet"))){
            
            while ((reader.readLine()) != null){
                counting++;
            }
            
        }
        catch(Exception leseFehler){
        System.err.println(leseFehler);
        }
    }

    public void schButton_ActionPerformed(ActionEvent evt) {
        Object sValue = jTable1.getValueAt(max, 0);
        String scValue = (String) sValue;
        if(scValue == " "){dispose();new FehlerCodeFrame();}
        else{
            try(BufferedWriter wr = new BufferedWriter(new FileWriter("data\\aktivitaet", true))){
            wr.write("\n"+ scValue);
            }
            catch (IOException e) {
                System.out.println("Exception occurred: " + e.getMessage());

            }
            Object sPwValue = jTable1.getValueAt(max, 1);
            String scPwValue = (String) sPwValue;
            if(scPwValue == " "){dispose();new FehlerCodeFrame();}
            else{
                try(BufferedWriter wr = new BufferedWriter(new FileWriter("data\\pw", true))){
                    wr.write("\n"+ scPwValue);
                }
                catch (IOException e) {
                    System.out.println("Exception occurred: " + e.getMessage());

                }
                
                dispose();
                new MainFrame();
                
            }
        }
    }
    public static void explorerHover(){

        mouseListenerExplorer = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MainFrame.tabelTab.setIcon(butIcon2);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MainFrame.tabelTab.setIcon(butIcon);
            }
        };
        MainFrame.tabelTab.addMouseListener(mouseListenerExplorer);
    }
    public static void seekHover(){
        mouseListenerSeek = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                seekButton.setIcon(seekButIcon2);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                seekButton.setIcon(seekButIcon);
            }
        };
        seekButton.addMouseListener(mouseListenerSeek);
    }
    public void ToSeek(){

        tableTabY = 120;
        activeLabelChange();

        MainFrame.tabelTab.setIcon(butIcon);
        explorerHover();

        
        schButton.setVisible(false);
        newPwbut.setVisible(false);
        jTable1ScrollPane.setVisible(false);
        seekButton.removeMouseListener(mouseListenerSeek);
        seekButton.setIcon(seekButIcon2);
        
        explorerJLabel.setText("SUCHEN");                               //hier krachts
    }
    public void ToExplorer(){
        
        tableTabY = 35;
        activeLabelChange();

        seekButton.setIcon(seekButIcon);
        
        /*jFrameConfig.mainFrameButtonConfiguration();
        jFrameConfig.mainFrameTableConfiguration();*/
        schButton.setVisible(true);
        newPwbut.setVisible(true);
        jTable1ScrollPane.setVisible(true);
        
        MainFrame.tabelTab.removeMouseListener(mouseListenerExplorer);
        MainFrame.tabelTab.setIcon(butIcon2);
        
        explorerJLabel.setText("EXPLORER");
    }
    public static void activeLabelChange(){
        
        activeLabel.setBounds(0,tableTabY,2,75);
        activeLabel.setBackground(new Color(192,192,192));
        activeLabel.setOpaque(true);
    }



    public void newPwbut_ActionPerformed(ActionEvent evt) {
        dispose();
        new QuestionFrame();
    }
    public void exitButton_ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
    public void tabelTab_ActionPerformed(ActionEvent evt) {
        ToExplorer();
    }
    public void seekButton_ActionPerformed(ActionEvent evt) {
        ToSeek();
    }
}
