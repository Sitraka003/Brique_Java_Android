package projet.brique;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import java.util.Vector;

/**
 * Created by Rna on 09/04/2018.
 */
public class Brique{
    int point;
    int x,y,large = 75, haut = 60;
    Brique[] tB;
    public Brique[] gettB(){
        return tB;
    }
    public void settB(Brique[] n){
        tB = n;
    }
    Paint pinceau;
    int score;

    public  int getScore(){
        return  score;
    }
    public void setScore(int n){
        score = n;
    }

    public Paint getPinceau(){
        return pinceau;
    }
    public void setPinceau(Paint n){
        pinceau = n;
    }
    /*Rect rect;

    public Rect getRect(){
        return rect;
    }*/

    public int getLarge(){
        return  large;
    }

    public int getHaut(){
        return haut;
    }

    public int get_X(){
        return x;
    }
    public  void  set_X(int n){
        x = n;
    }

    public int get_Y(){
        return y;
    }
    public  void  set_Y(int n){
        y = n;
    }

    public Brique(int g, int d,int s){
        x = g;
        y = d;
        score = s;
    }


    public void onDraw(Canvas canvas) {
        pinceau = new Paint();
        if(score == 1) pinceau.setColor(Color.LTGRAY);
        if(score == 2) pinceau.setColor(Color.RED);
        if(score == 3) pinceau.setColor(Color.BLUE);
        if(score == 4) pinceau.setColor(Color.GRAY);
        if(score == 5) pinceau.setColor(Color.CYAN);
        if(score == 6) pinceau.setColor(Color.DKGRAY);

        canvas.drawRect(get_X(),get_Y(),get_X()+getLarge(),get_Y()+getHaut(), pinceau);
    }

    public void dessinerBrique(){
        int temp = get_X();
        Brique[] lB = new Brique[18];
        for(int i = 0;i<18;i++,setScore(getScore()+1)){
            lB[i] = new Brique(get_X(),get_Y(),getScore());
            set_X(get_X() + 85);
            if(i==5 || i == 11 || i==17){
                set_Y(get_Y()+125);
                set_X(temp);
                setScore(0);
            }
        }
        settB(lB);
        //return rep;
    }
    /*private Rect rect;
    private Paint pinceau = new Paint();
    private boolean affichage = true;
    int gauche,haut,droite,bas;
    Brique[] br = new Brique[18];
    Brique[] complet = new Brique[18];

    public Brique[] getComplet(){
        return  complet;
    }
    public void setComplet(Brique[] n){
        complet = n;
    }
    public Paint getPinceau(){
        return  pinceau;
    }
    public void setPinceau(Paint n){
        pinceau = n;
    }

    public Brique[] getBr(){
        return  br;
    }
    public void setBr(Brique[] n){
        br = n;
    }

    public int getGauche(){
        return gauche;
    }
    public  void  setGauche(int n){
        gauche = n;
    }

    public int getHaut(){
        return haut;
    }
    public  void  setHaut(int n){
        haut = n;
    }

    public int getDroite(){
        return droite;
    }
    public  void  setDroite(int n){
        droite = n;
    }

    public int getBas(){
        return bas;
    }
    public  void  setBas(int n){
        bas = n;
    }

    public Rect getRect(){
        return this.rect;
    }
    public void setRect(Rect n){
        this.rect = n;
    }

    public boolean getAffichage(){
        return affichage;
    }
    public void setAffichage(boolean n){
        affichage = n;
    }

    public Brique() {
        pinceau = new Paint();
        //pinceau.setColor(Integer.parseInt(getCouleur()));
        //if(b.getCollisionBrique1()== false || b.getCollisionBrique2()== false || b.getCollisionBrique3()== false || b.getCollisionBrique4()== false || b.getCollisionBrique5()== false || b.getCollisionBrique6()== false) pinceau.setColor(Color.WHITE);
        pinceau.setColor(Color.BLUE);
    }

    public Brique[] dessinerBrique(Canvas c) {
        int i = 0;
        setGauche(100);
        setHaut(25);
        setDroite(175);
        setBas(85);
        int tempGauche = getGauche(), tempDroite = getDroite();
        for (i = 0; i < 18; i++) {
            getBr()[i] = new Brique();
            Rect rect2 = new Rect(getGauche(),getHaut(),getDroite(),getBas());
            getBr()[i].setRect(rect2);
            c.drawRect(getBr()[i].getRect(), pinceau);
            setGauche(getGauche() + 85);
            setDroite(getDroite()+ 85);
            if(i==5 || i == 11 || i==17){
                setHaut(getHaut() + 100);
                setBas(getBas() + 100);
                setGauche(tempGauche);
                setDroite(tempDroite);
            }
        }
        setComplet(getBr());
        return getComplet();
    }*/
}
