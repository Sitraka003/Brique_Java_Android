package projet.brique;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Rna on 05/04/2018.
 */
public class Plateau extends View{
    private Rect barre;
    private Paint pinceau = new Paint();
    int gauche;
    int droite;
    int deplacement = 10;
    int ecranW;

    public int getDeplacement(){
        return  deplacement;
    }
    public void setDeplacement(int n){
        deplacement = n;
    }

    public int getGauche(){
        return  gauche;
    }
    public void setGauche(int n){
        gauche = n;
    }

    public int getDroite(){
        return  droite;
    }
    public void setDroite(int n){
        droite = n;
    }

    public int getEcranW(){
        return  ecranW;
    }
    public void setEcranW(int ecranW) {
        this.ecranW = ecranW;
    }

    public Plateau(Context context,int g, int d){
        super(context);
        setGauche(g);
        setDroite(d);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pinceau.setColor(Color.GRAY);
        barre = new Rect(getGauche(),875,getDroite(),900);
        canvas.drawRect(barre, pinceau);
        setEcranW(canvas.getWidth());
    }

    public void deplacerGauche(){
        setGauche(getGauche() - getDeplacement());
        setDroite(getDroite() - getDeplacement());
        if(getGauche() <= 0) {
            setGauche(10);
            setDroite(getDroite()+10);
        }
    }
    public void deplacerDroite(){
        setGauche(getGauche()+getDeplacement());
        setDroite(getDroite()+getDeplacement());
        if(getDroite() >= getEcranW()) {
            setGauche(getGauche()-10);
            setDroite(getDroite()-10);
        }
    }
}
