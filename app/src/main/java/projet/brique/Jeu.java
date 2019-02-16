package projet.brique;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class Jeu extends View{
    Plateau p;
    Balle b;
    ThreadBalle tB;
    Brique brq;
    float milieu;
    private Paint pinceau = new Paint();
    ArrayList<Balle> lBalle = new ArrayList<Balle>();

    public Jeu(Context context) {
        super(context);
        p = new Plateau(context,275,425);
        brq = new Brique(100,50,1);
        b= new Balle(context,p,brq,this,0);
        lBalle.add(b);
        brq.dessinerBrique();
        tB = new ThreadBalle(this,lBalle,p);
        tB.setEtat(true);
        tB.start();
    }

    public ArrayList<Balle> getlBalle(){
        return lBalle;
    }
    public Plateau getPlateau(){
        return p;
    }
    public float getMilieu(){
        return milieu;
    }
    public void setMilieu(float n){
        milieu = n;
    }
    public ThreadBalle gettB(){
        return tB;
    }

    public void onDraw(Canvas c) {
        p.draw(c);
        int taille = lBalle.size();
        for(int i = 0;i<taille;i++){
            lBalle.get(i).score(c);
            lBalle.get(i).draw(c);
        }
        setMilieu(c.getWidth() / 2);
        //Vector v = brq.dessinerBrique();
        for(int i = 0;i< brq.gettB().length;i++){
            brq.gettB()[i].onDraw(c);
        }

        //Log.i("VECTOR", String.valueOf(v));
    }

    public boolean onTouchEvent(MotionEvent e){
        if(e.getX() < getMilieu()) getPlateau().deplacerGauche();
        else if(e.getX() > getMilieu()) getPlateau().deplacerDroite();
        this.postInvalidate();
        return true;
    }

    public void ajoutBalle(){
        Balle b2= new Balle(getContext(),p,brq,this,b.getBrq1());
        lBalle.add(b2);
    }
}
