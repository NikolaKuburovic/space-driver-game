
package gui;

import biznis.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**CS111 - Projektni zadatak
 *
 * @author Nikola Kuburovic 1095
 */
public class PanelIgra extends JPanel {

    private Sbrod sbrod;
    private ArrayList meteori1;
    private ArrayList meteori2;
    private ArrayList meteori3;
    private Timer vreme;
    private boolean ziv;
    private int visina;
    private int sirina;
    private long startms;
    private long stopms;
    private long stopsec;

    
    //lista sa pocetnim pozicijama meteora1
    private int[][] ppozicija1 = {
        {3800, 400}, {8800, 20}, {7650, 80}, {4800, 160},
        {5700, 130}, {6680, 220}, {2760, 300}, {2500, 390},
        {3100, 190}, {7900, 460}, {9850, 260},{7100, 320}
    };
    //lista sa pocetnim pozicijama meteora2
    private int[][] ppozicija2 = {
        {5800, 100}, {16500, 50}, {10650, 150}, {2200, 400},
        {4600, 200}, {9400, 250}, {7100, 300}, {14100, 450}
    };
    //lista sa pocetnim pozicijama meteora
    private int[][] ppozicija3 = {
        {3800, 240}, {1900, 80}, {1650, 350}, {2700, 200},
        {1080, 160}, {1500, 380}, {1780, 300}, {2500, 440},
        {3600, 50}, {2000, 280}, {1850, 10}, {2890, 110}
    };

    /**
     *Konstruktor klase PanelIgra
     */
    public PanelIgra() {
        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {
               sbrod.keyPressed(ke);
           }
            @Override
            public void keyReleased(KeyEvent ke) {
               sbrod.keyReleased(ke);
           }
        });
        setFocusable(true);
        ziv = true;
        sbrod = new Sbrod();
        sirina = 800; //sirina panela
        visina = 500; //visina panela
        startms = System.currentTimeMillis(); //belezi vreme pocetka programa
       
        inicijalizacijaMeteora1();
        inicijalizacijaMeteora2();
        inicijalizacijaMeteora3();

        vreme = new Timer(5, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                for(int i = 0; i < meteori1.size(); i++) {
                    Meteor1 m1 = (Meteor1)meteori1.get(i);
                    m1.kretnja();//kretanje meteora1
                }
                 for(int i = 0; i < meteori2.size(); i++) {
                    Meteor2 m2 = (Meteor2)meteori2.get(i);
                    m2.kretnja();//kretanje meteora2
                }
                for(int i = 0; i < meteori3.size(); i++) {
                    Meteor3 m3 = (Meteor3)meteori3.get(i);
                    m3.kretnja();//kretanje meteora3
                }

                sbrod.voznja();//kretanje broda
                sudar();
                repaint();
            }
        }); //kraj tajmera
        vreme.start();
    } //kraj konstruktora PanelIgra
   
    /**
     *metoda sudar koja treba da detektuje sudar meteora i broda
     */
    public void sudar() {
        Rectangle r = sbrod.getBounds();//izracunavanje dimenzija broda
        for(int j = 0; j < meteori1.size(); j++) {
            Meteor1 m1 = (Meteor1)meteori1.get(j);
            Rectangle r2 = m1.getBounds();//izracunavanje dimenzija meteora1
            
            if(r.intersects(r2))//provera da li je doslo do sudara broda i meteora1
            {
                ziv = false;
            }
        }
        for(int j = 0; j < meteori2.size(); j++) {
            Meteor2 m2 = (Meteor2)meteori2.get(j);
            Rectangle r3 = m2.getBounds();//izracunavanje dimenzija meteora2

            if(r.intersects(r3))//provera da li je doslo do sudara broda i meteora2
            {
                ziv = false;
            }
        }
        for(int j = 0; j < meteori3.size(); j++) {
            Meteor3 m3 = (Meteor3)meteori3.get(j);
            Rectangle r3 = m3.getBounds();//izracunavanje dimenzija meteora3

            if(r.intersects(r3))//provera da li je doslo do sudara broda i meteora3
            {
                ziv = false;
            }
        }
    } //kraj metode sudar

    /**
     *metoda koja inicijalizuje objekte klase Meteor1
     */
    public void inicijalizacijaMeteora1() {
        meteori1 = new ArrayList();

        for(int i = 0; i < ppozicija1.length; i++) {
            meteori1.add(new Meteor1(ppozicija1[i][0], ppozicija1[i][1]));
        }
    }
  
    /**
     *metoda koja inicijalizuje objekte klase Meteor2
     */
    public void inicijalizacijaMeteora2() {
        meteori2 = new ArrayList();

        for(int i = 0; i < ppozicija2.length; i++) {
            meteori2.add(new Meteor2(ppozicija2[i][0], ppozicija2[i][1]));
        }
    }

    /**
     *metoda koja inicijalizuje objekte klase Meteor
     */
    public void inicijalizacijaMeteora3() {
        meteori3 = new ArrayList();

        for(int i = 0; i < ppozicija3.length; i++) {
            meteori3.add(new Meteor3(ppozicija3[i][0], ppozicija3[i][1]));
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if(ziv) //ako je brod ziv i do sudara nije doslo - igra traje
        {
           
            Graphics2D g2 = (Graphics2D) g;
            
            g2.drawImage(new ImageIcon("kosmos.png").getImage(), 0, 0, this);//iscrtavanje pozadine u igri
            g2.drawImage(sbrod.getBrod(), sbrod.getX(), sbrod.getY(), this);
            
            stopms = (System.currentTimeMillis()-startms);//izracinavanje vremena trajanja igre
            stopsec = (long) (stopms / 1000F);//pretvaranje vremena trajanja u sekunde
            String stoperica = "Vreme: "+ stopsec;
            Font f = new Font("SansSerif", Font.PLAIN, 12);
          
            g.setColor(Color.GREEN);
            g.setFont(f);
            g2.drawString(stoperica, sirina-75, 20);//pozicija stoperice na ekranu u toku igre
           
            for(int i = 0; i < meteori1.size(); i++) {
                Meteor1 m1 = (Meteor1)meteori1.get(i);
                
                    g2.drawImage(m1.getMeteor1(), m1.getX(), m1.getY(), this);//iscrtavanje meteora1 na ekranu
            }
            for(int i = 0; i < meteori2.size(); i++) {
                Meteor2 m2 = (Meteor2)meteori2.get(i);

                    g2.drawImage(m2.getMeteor2(), m2.getX(), m2.getY(), this);//iscrtavanje meteora2 na ekranu
            }
            for(int i = 0; i < meteori3.size(); i++) {
                Meteor3 m3 = (Meteor3)meteori3.get(i);

                    g2.drawImage(m3.getMeteor3(), m3.getX(), m3.getY(), this);//iscrtavanje meteora3 na ekranu
            }
        } //kraj if
        else //ukoliko je do sudara doslo - igra se zavrsava
        {
                            
            String poruka = "KRAJ IGRE";
            Font f = new Font("SansSerif", Font.BOLD, 50);
            FontMetrics fm = this.getFontMetrics(f);
            g.setColor(Color.GREEN);
            g.setFont(f);
            g.drawString(poruka, (sirina-fm.stringWidth(poruka))/2, visina/2);
            
            stopsec = (long) (stopms / 1000F);

            Font f1 = new Font("SansSerif", Font.BOLD, 30);
            FontMetrics fm1 = this.getFontMetrics(f1);
            g.setColor(Color.GREEN);
            g.setFont(f1);
            String poruka2 = "Tvoje vreme je: " + stopsec + " s";
            g.drawString(poruka2, (sirina-fm1.stringWidth(poruka2))/2, visina/3);

            Font f2 = new Font("SansSerif", Font.PLAIN, 12);
            FontMetrics fm2 = this.getFontMetrics(f2);
            g.setColor(Color.DARK_GRAY);
            g.setFont(f2);
            String poruka4 =  "Projekat za predmet CS111";
            g.drawString(poruka4, (sirina-fm2.stringWidth(poruka4))/2, visina-100);
            String poruka5 =  "Fakultet Informacionih Tehnologija - Beograd";
            g.drawString(poruka5, (sirina-fm2.stringWidth(poruka5))/2, visina-80);
            String poruka6 =  "Student: Nikola Kuburović 1095";
            g.drawString(poruka6, (sirina-fm2.stringWidth(poruka6))/2, visina-60);
            
        } //kraj else
    } //kraj metode paintComponent
} //kraj klase PanelIgra