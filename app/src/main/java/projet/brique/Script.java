package projet.brique;

/**
 * Created by Rna on 08/05/2018.
 */
public class Script {
    public String script(String mdp){
        String rep ="";
        char[] lettre = mdp.toCharArray();
        char tab[] = {'a','b','c','d','e','f','g','h','i'};
        int taille = tab.length, taille2 = lettre.length;
        for(int i = 0;i<taille;i++){
            for(int j = 0;j<taille2;j++){
                if(lettre[j]==tab[i]){
                    String temp =  Integer.toString(i+1);
                    lettre[j]=temp.charAt(0);
                }
            }
        }
        rep = new String(lettre);
        System.out.println(rep);
        return rep;
    }
}
