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


public class TabelleFrame extends JFrame {
    public static String text = "";
    public static int counting = 0;
    public static int max = 0;
    public static JButton tabelTab = new JButton();
    public static JButton schButton = new JButton();
    public static JTable jTable1 = new JTable();
    public static DefaultTableModel jTable = (DefaultTableModel) jTable1.getModel();
    public static JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
    public static JMenuBar jMenuBar = new JMenuBar();
    public static JLabel sideLabel = new JLabel();
    public static JLabel sidePlorer = new JLabel();
    public static JButton newPwbut = new JButton();
    public static JButton exitButton = new JButton();
    public static JLabel iconLabel = new JLabel();
    public static ImageIcon iconLabelIcon = new ImageIcon("images\\key.png");
    


    public TabelleFrame(){
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
        Container cp = getContentPane();
        cp.setBackground(new Color(37,37,38));
        cp.setLayout(null);
     
        jMenuBar.setBackground(new Color(62, 62, 64));
        setJMenuBar(jMenuBar);
        jMenuBar.setBorderPainted(false);

        jFrameConfig.labelConfiguration();
        
        cp.add(jFrameConfig.explorerJLabel);

        jMenuBar.add(iconLabel);

        jFrameConfig.tabelleFrameButtonConfiguration();

        tabelTab.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                tabelTab_ActionPerformed(evt);
            }
        });
        cp.add(tabelTab);

        schButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                schButton_ActionPerformed(evt);
            }
        });
        cp.add(schButton);

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
        jFrameConfig.seekButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                seekButton_ActionPerformed(evt);
            }
        });
        cp.add(jFrameConfig.seekButton);
        
        cp.add(sideLabel);
        cp.add(sidePlorer);
        
        zeilenCount();
        
        
        jTable.setRowCount(counting);
        jTable.setColumnCount(2);

        jFrameConfig.tabelleFrameTableConfiguration();

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

        new TabelleFrame();
        
    }
    public static void aktivitaetLesen(int c){
        String zeile = "";
        text = " ";
        int i = 0;
        c = c + 2;
        try(BufferedReader reader = new BufferedReader(new FileReader("data\\aktivitaet"))){
        /*FileReader filereader = new FileReader ("aktivitaet");
        BufferedReader reader = new BufferedReader (filereader);*/
            
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
    public static void pwLesen(int b){
        String zeile = "";
        text = " ";
        int i = 0;
        b = b + 2;
        try(BufferedReader reader = new BufferedReader(new FileReader("data\\pw"))){
        /*FileReader filereader = new FileReader ("pw");
        BufferedReader reader = new BufferedReader (filereader);*/
            
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
    public static void zeilenCount(){
        
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
                new TabelleFrame();
            }
        }
    }
    public void newPwbut_ActionPerformed(ActionEvent evt) {
        dispose();
        new QuestionFrame();
    }
    public void exitButton_ActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
    public void tabelTab_ActionPerformed(ActionEvent evt) {
        jFrameConfig.ToExplorer();
    }
    public void seekButton_ActionPerformed(ActionEvent evt) {
        jFrameConfig.ToSeek();
    }
}
