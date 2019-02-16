package projet.brique;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by ITU on 06/04/2018.
 */
public class Balle extends View{
    private Paint pinceau;
    private float x = 350, y = 860;
    private float ecranL, ecranH;
    private int deplacementX = 5;
    private int deplacementY = 5;
    Plateau p;
    Brique br;
    Jeu j;
    int score;
    int rebours = 3;
    int temp;
    int brq1;
    int point;

    public  int getPoint(){
        return point;
    }
    public void setPoint(int n){
        point=n;
    }
    public int getBrq1(){
        return brq1;
    }
    public void setBrq1(int i){
        brq1 = i;
    }
    public  int getRebours(){
        return rebours;
    }
    public void setRebours(int n){
        rebours=n;
    }
    public  int getScore(){
        return score;
    }
    public void setScore(int n){
        score=n;
    }
    private Context c;

    public int getDeplacementX(){
        return deplacementX;
    }
    public void setDeplacementX(int n){
        deplacementX = n;
    }

    public int getDeplacementY(){
        return deplacementY;
    }
    public void setDeplacementY(int n){
        deplacementY = n;
    }

    public float getX(){
        return x;
    }
    public void setX(float n){
        x = n;
    }

    public float getEcranL(){
        return ecranL;
    }
    public void setEcranL(float n){
        ecranL = n;
    }

    public float getEcranH(){
        return ecranH;
    }
    public void setEcranH(float n) {
        ecranH = n;
    }

    public float getY(){
        return y;
    }
    public void setY(float n){
        y = n;
    }

    public Balle(Context context,Plateau p,Brique br,Jeu j,int temp) {
        super(context);
        x = getX();
        y = getY();
        this.c = context;
        this.p = p;
        this. br = br;
        this.j = j;
        this.temp=temp;
        pinceau = new Paint();
        pinceau.setColor(Color.BLACK);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, 12, pinceau);
        setEcranH(canvas.getHeight());
        setEcranL(canvas.getWidth());
        //pinceau.setTextSize(30);
        //canvas.drawText("Score: "+getScore(),50,1000,pinceau);
        //teto no napidirina
        /*if(getScore()==63){
            pinceau.setTextSize(70);
            canvas.drawText("Vous avez gagné!", 100, 500, pinceau);
            setX(-1000);
            j.gettB().setEtat(false);
        }*/
        /*if(getY()>865){
            pinceau.setTextSize(70);
            canvas.drawText("Game over", 200, 500, pinceau);
            setX(-1000);
            j.gettB().setEtat(false);
        }*/
    }

    public void score(Canvas canvas){
        pinceau.setTextSize(30);
        canvas.drawText("Score: " + getPoint(), 50, 30, pinceau);
        canvas.drawText("Rebours: " + getRebours(), 450, 30, pinceau);
    }

    public void deplacer(){
        setX(getX() + deplacementX);
        setY(getY() - deplacementY);
        int oppose = -1;
        if(getX() == 0  || getX() >= getEcranL()){
            setDeplacementX(getDeplacementX() * oppose);
        }
        if(testCollision(this, p) == true || getY() == 0){
            setDeplacementY(getDeplacementY() * oppose);
        }
        if(testCollisionBriqueTotal(this, br.gettB())==true){
            setDeplacementY(getDeplacementY() * oppose);
        }
    }

    public boolean testCollision(Balle b, Plateau p){
        if((b.getY()==865 && p.getGauche()<= b.getX()-12 && b.getX() <= p.getDroite()) ){
            return true;
        }
        return false;
    }

    public boolean testCollisionBriqueTotal(Balle b, Brique[] tabBr){
        for(int i = 0; i<tabBr.length; i++){
            if(tabBr[i].get_Y()<b.getY()-12 && b.getY()-12< tabBr[i].get_Y()+tabBr[i].getHaut()&& tabBr[i].get_X()< b.getX()+12&& b.getX()+12 < tabBr[i].get_X()+tabBr[i].getLarge()){
                if(temp==0){
                    temp = i;
                    setScore(getScore() + 1);
                }
                setBrq1(temp);
                setPoint(getScore());
                if(temp!=i){
                    //setScore(getScore() + 1);
                    setPoint(getPoint() + 1);
                    tabBr[i].setScore(tabBr[i].getScore() - 1);
                    if (tabBr[i].getScore() == 0) tabBr[i].set_X(-500);
                    return true;
                }
                if(getBrq1()==temp){
                    setRebours(getRebours() - 1);
                    //setScore(getScore() + 1);
                    setPoint(getPoint() + 1);
                    tabBr[i].setScore(tabBr[i].getScore() - 1);
                    setDeplacementX(getDeplacementX() * (-1));
                    //if(getRebours()==0)tabBr[temp].set_X(-500);
                    return true;
                }
            }
        }
        return false;
    }
}
