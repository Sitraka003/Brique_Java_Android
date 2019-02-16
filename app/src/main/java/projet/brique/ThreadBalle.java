package projet.brique;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

/**
 * Created by Rna on 06/04/2018.
 */
public class ThreadBalle extends Thread {
    private boolean etat = false;//thread ts mandeh
    private Jeu jeu;
    private ArrayList<Balle> b;
    private Plateau p;

    public boolean getEtat(){
        return  etat;
    }
    public  void setEtat(boolean n){
        etat = n;
    }

    public ArrayList<Balle> getBalle(){
        return b;
    }

    public ThreadBalle(Jeu jeu, ArrayList<Balle> b,Plateau p) {
        this.jeu = jeu;
        this.b = b;
        this.p = p;
    }

    public ThreadBalle(){}

    public void run(){
        while(etat) {
            try {
                int taille = b.size();
                for(int i =0;i<taille;i++){
                    b.get(i).deplacer();
                }
                jeu.postInvalidate();
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
