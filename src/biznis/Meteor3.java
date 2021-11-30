
package biznis;

import java.awt.Image;
import javax.swing.ImageIcon;


/**CS111 - Projektni zadatak
 *
 * @author Nikola Kuburovic 1095
 */
public class Meteor3 extends Meteor{

    private Image meteor3;
 
    
    /**
     *prazan konstruktor klase Meteor3
     */
    public Meteor3() {
        
    }

    /**
     *konstruktor klase Meteor3 koji prima podatke
     * @param x
     * @param y
     */
    public Meteor3(int x, int y) {

        meteor3 = new ImageIcon("meteor3.png").getImage();
        this.x = x;
        this.y = y;
        visina = meteor3.getHeight(null);
        sirina = meteor3.getWidth(null);
    }

    /**
     *brzina kretanja i vracanje na novi polozaj Meteora3
     */
    @Override
    public void kretnja() {
        if(x<-50){
            x = 1200;
        }
        x -= 2;
    }

    /**
     *vraca sliku Meteora3
     * @return slika
     */
    public Image getMeteor3() {
        return meteor3;
    }

} //kraj klase Meteor2
