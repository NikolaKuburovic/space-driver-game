
package biznis;

import java.awt.Rectangle;


/**CS111 - Projektni zadatak
 *
 * @author Nikola Kuburovic 1095
 */
public class Meteor {

    /**
     * pozicija po x-osi
     */
    protected int x;
    /**
     * pozicija po y-osi
     */
    protected int y;
    /**
     * visina objekta
     */
    protected int visina;
    /**
     * sirina objekta
     */
    protected int sirina;
    
    /**
     *konstruktor klase Meteor
     */
    public Meteor() {
        
    }

    /**
     *konstruktor klase Meteor koji prima podatke
     * @param x
     * @param y
     */
    public Meteor(int x, int y) {

        this.x = x;
        this.y = y;
           
    }

    /**
     *brzina kretanja i vracanje na novi polozaj Meteora
     */
    public void kretnja() {
        
    }

    /**
     *vraca poziciju Meteora po x-osi
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     *vraca poziciju Meteora po y-osi
     * @return y
     */
    public int getY() {
        return y;
    }
   
    /**
     *vraca dimenzije Meteora
     * @return dimenzije
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, sirina-1, visina-1);
    }

} //kraj klase Meteor
