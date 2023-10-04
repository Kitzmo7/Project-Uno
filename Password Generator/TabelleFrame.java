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
    private JButton Password = new JButton();
    

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




        zeilenCount();
        
        JTable jTable1 = new JTable(counting, 2);
        DefaultTableModel jTable = (DefaultTableModel) jTable1.getModel();
        JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);

        jTable1ScrollPane.setBounds(8, 144, 800, 500);
        jTable1.getColumnModel().getColumn(0).setHeaderValue("Aktivitaet");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Password");
        jTable1.getColumnModel().getColumn(0).setWidth(100);
        jTable1.setRowHeight(100);

        int rowCount = jTable.getRowCount();

        int max = rowCount;
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

    public static void schreiben(){
        
    }
    public void Password_ActionPerformed(ActionEvent evt) {
        dispose();
        new QuestionFrame();
    }
}
