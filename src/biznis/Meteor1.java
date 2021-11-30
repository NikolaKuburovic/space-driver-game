
package biznis;

import java.awt.Image;
import javax.swing.ImageIcon;


/**CS111 - Projektni zadatak
 *
 * @author Nikola Kuburovic 1095
 */
public class Meteor1 extends Meteor{

    private Image meteor1;
   
    /**
     *prazan konstruktor klase Meteor1
     */
    public Meteor1() {
        
    }

    /**
     *konstruktor klase Meteori1 koji prima podatke
     * @param x
     * @param y
     */
    public Meteor1(int x, int y) {

        meteor1 = new ImageIcon("meteor1.png").getImage();
        this.x = x;
        this.y = y;
        visina = meteor1.getHeight(null);
        sirina = meteor1.getWidth(null);
    }

    /**
     *brzina kretanja i vracanje na novi polozaj Meteora1
     */
    @Override
    public void kretnja() {
        if(x<-350){
            x = 1000;
        }
        x -= 3;
    }
    /**
     *vraca sliku Meteora1
     * @return slika
     */
    public Image getMeteor1() {
        return meteor1;
    }

} //kraj klase Meteor1
