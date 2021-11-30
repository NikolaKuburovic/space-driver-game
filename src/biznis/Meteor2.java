
package biznis;

import java.awt.Image;
import javax.swing.ImageIcon;


/**CS111 - Projektni zadatak
 *
 * @author Nikola Kuburovic 1095
 */
public class Meteor2 extends Meteor{

    private Image meteor2;
    
    
    /**
     *prazan konstruktor klase Meteor2
     */
    public Meteor2() {
        
    }

    /**
     *konstruktor klase Meteor2 koji prima podatke
     * @param x
     * @param y
     */
    public Meteor2(int x, int y) {

        meteor2 = new ImageIcon("meteor2.png").getImage();
        this.x = x;
        this.y = y;
        visina = meteor2.getHeight(null);
        sirina = meteor2.getWidth(null);
    }

    /**
     *brzina kretanja i vracanje na novi polozaj Meteora2
     */
    @Override
    public void kretnja() {
        if(x<-1500){
            x = 2000;
        }
        x -= 6;
    }

    /**
     *vraca sliku Meteora2
     * @return slika
     */
    public Image getMeteor2() {
        return meteor2;
    }

} //kraj klase Meteor2
