
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;



/**CS111 - Projektni zadatak
 *
 * @author Nikola Kuburovic 1095
 */
public class Main extends JFrame{

    private JPanel pan;

    /**
     *Konstruktor klase Main
     */
    public Main() {
        super("CS111 Svemirski Reli");
        pan = new PanelIgra();
        add(pan);
        pan.setBackground(Color.black);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         new Main();
       
    }
}

