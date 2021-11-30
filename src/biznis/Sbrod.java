
package biznis;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

/**CS111 - Projektni zadatak
 *
 * @author Nikola Kuburovic 1095
 */
public class Sbrod {

    private Image brod;
    private int x;
    private int y;
    private int px;
    private int py;
    private int visina;
    private int sirina;
   
    /**
     *konstruktor klase Sbrod
     */
    public Sbrod() {

        brod = new ImageIcon("svbrod.png").getImage();
        x = 40;
        y = 40;
        visina = brod.getHeight(null);
        sirina = brod.getWidth(null);
    }

    /**
     *metoda voznja koja odredjuje kretanje broda
     */
    public void voznja() {
        x += px;
        y += py;

        if(x<1) {
            x = 1;
        }
        if(x>(800-sirina)) {
            x = (800-sirina);
        }
        if(y<1) {
            y = 1;
        }
        if(y>(470-visina)){
            y = (470-visina);
        }
    } //kraj metode voznja

    /**
     *metoda koja vraca sliku broda
     * @return slika
     */
    public Image getBrod() {
        return brod;
    }

    /**
     *metoda koja vraca polozaj broda po x-osi
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     *metoda koja vraca polozaj broda po y-osi
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     *vraca dimenzije objekta
     * @return dimenzije
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, sirina-4, visina-4);
    }

    /**
     *prima komande sa tastature - pritisnuta dirka
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        if(k == KeyEvent.VK_RIGHT) {
            px = 3;
        }
        else if(k == KeyEvent.VK_LEFT) {
            px = -3;
        }
        else if(k == KeyEvent.VK_UP) {
            py = -3;
        }
        else if(k == KeyEvent.VK_DOWN) {
            py = 3;
        }
    }
    
    /**
     *prima komande sa tastature - otpustena dirka
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        int k = e.getKeyCode();

        if(k == KeyEvent.VK_RIGHT) {
            px = 0;
        }
        else if(k == KeyEvent.VK_LEFT) {
            px = 0;
        }
        else if(k == KeyEvent.VK_UP) {
            py = 0;
        }
        else if(k == KeyEvent.VK_DOWN) {
            py = 0;
        }
    }
} //kraj klase Sbrod
