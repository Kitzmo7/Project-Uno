import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.net.*;


public class FehlerCodeFrame extends JFrame{
    private JLabel FehlerCode = new JLabel();
    private JButton bestaetigungButton = new JButton();

    public FehlerCodeFrame(){
        
        super();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 200;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Password Generator");
        setResizable(false);
        
        Container cp = getContentPane();
        cp.setLayout(null);

        bestaetigungButton.setBounds(100, 125, 75, 25);
        bestaetigungButton.setText("OK");
        bestaetigungButton.setMargin(new Insets(2, 2, 2, 2));
        bestaetigungButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                bestaetigungButton_ActionPerformed(evt);
            }
        });
        cp.add(bestaetigungButton);

        FehlerCode.setBounds(0, 0, 300, 80);
        FehlerCode.setHorizontalAlignment(SwingConstants.CENTER);
        FehlerCode.setVerticalAlignment(SwingConstants.CENTER);
        FehlerCode.setAlignmentY(CENTER_ALIGNMENT);
        
        FehlerCode.setText("Ein Fehler ist aufgetreten. Bitte überprüfen Sie das Programm und versuchen Sie es erneut");
        FehlerCode.setOpaque(true);
        cp.add(FehlerCode);

        setVisible(true);
    }
    public static void main(String [] args){
        new FehlerCodeFrame();
    }
    public void bestaetigungButton_ActionPerformed(ActionEvent evt){
        dispose();
        new MainFrame();
    }
}
