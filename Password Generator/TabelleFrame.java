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
import javax.swing.table.*;
import java.util.Random;


public class TabelleFrame extends JFrame {
    public static String text = "";
    public static int counting = 0;
    public static int max = 0;
    private JButton Password = new JButton();
    private JButton schButton = new JButton();
    JTable jTable1 = new JTable();
    DefaultTableModel jTable = (DefaultTableModel) jTable1.getModel();
    JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);

    public TabelleFrame(){

        super();

        

        counting = 0;
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

        Password.setBounds(880, 350, 75, 25);
        Password.setText("Neues Passwort");
        Password.setMargin(new Insets(2, 2, 2, 2));
        Password.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                Password_ActionPerformed(evt);
            }
        });
        cp.add(Password);

        schButton.setBounds(880, 750, 75, 25);
        schButton.setText("Schreiben");
        schButton.setMargin(new Insets(2, 2, 2, 2));
        schButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                schButton_ActionPerformed(evt);
            }
        });
        cp.add(schButton);



        zeilenCount();
        
        
        jTable.setRowCount(counting);
        jTable.setColumnCount(2);

        jTable1ScrollPane.setBounds(8, 144, 800, 500);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("Aktivitaet");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Password");
        jTable1.getColumnModel().getColumn(0).setWidth(100);
        jTable1.setRowHeight(100);

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
        
        //selber pw eintragen
        


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
        try(BufferedReader reader = new BufferedReader(new FileReader("aktivitaet"))){
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
        try(BufferedReader reader = new BufferedReader(new FileReader("pw"))){
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
        
        try(BufferedReader reader = new BufferedReader(new FileReader("aktivitaet"))){
            
            while ((reader.readLine()) != null){
                counting++;
            }
            
        }
        catch(Exception leseFehler){
        System.err.println(leseFehler);
        }
    }


    public void Password_ActionPerformed(ActionEvent evt) {
        dispose();
        new QuestionFrame();
    }
    public void schButton_ActionPerformed(ActionEvent evt) {
        Object sValue = jTable1.getValueAt(max, 0);
        String scValue = (String) sValue;
        
        try(BufferedWriter wr = new BufferedWriter(new FileWriter("aktivitaet", true))){
            wr.write("\n"+ scValue);
        }
        catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());

        }
        Object sPwValue = jTable1.getValueAt(max, 1);
        String scPwValue = (String) sPwValue;
        
        try(BufferedWriter wr = new BufferedWriter(new FileWriter("pw", true))){
            wr.write("\n"+ scPwValue);
        }
        catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());

        }
        dispose();
        new TabelleFrame();
    }
}
