
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;
import java.util.Objects;
import java.util.Random;

public class QuestionFrame extends JFrame implements FocusListener{

    private JTextField AktivitaetField = new JTextField();
    private JButton generate = new JButton();
    public static String randomString = "Fehler2";
    public static String AktivitaetString = "fehler";
    

    public QuestionFrame(){
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 500;
        int frameHeight = 250;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("");
        setResizable(false);
        Container cp = getContentPane();
        AktivitaetField.addFocusListener(this);
        
        cp.setLayout(null);

        generate.setBounds(280, 150, 75, 25);
        generate.setText("Neues Passwort");
        generate.setMargin(new Insets(2, 2, 2, 2));
        generate.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                generate_ActionPerformed(evt);
            }
        });
        cp.add(generate);

        AktivitaetField.setBounds(30, 50, 100, 100);
        AktivitaetField.setText("Name der Anwendung");
        AktivitaetField.setOpaque(true);
        cp.add(AktivitaetField);

        setVisible(true);
    }
    public static void main(String [] args) throws IOException{

        new QuestionFrame();
    
    }
    public void generate_ActionPerformed(ActionEvent evt) {
        
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int length = 10;

        for(int i = 0; i < length; i++) {

            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }

        randomString = sb.toString();
        
       AktivitaetString = AktivitaetField.getText();
       

       if(!AktivitaetString.isEmpty()){
        dispose();

        try(BufferedWriter wr = new BufferedWriter(new FileWriter("data\\aktivitaet", true))) {
            wr.write("\n" + AktivitaetString);
            
        } 
        catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());

        }

        try(BufferedWriter wr = new BufferedWriter(new FileWriter("data\\pw", true))) {
            wr.write("\n" + randomString);
            
        } 
        catch (IOException e) {
            System.out.println("Exception occurred: " + e.getMessage());

        }



        new TabelleFrame();
        
       }
       else{ 
        new FehlerCodeFrame();
       }
       
	}

    
    public void focusGained(FocusEvent foc) {
		AktivitaetField.selectAll();
        
    }
	public void focusLost(FocusEvent foc) {
	}
}

