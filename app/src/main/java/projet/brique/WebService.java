package projet.brique;

import android.os.StrictMode;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by ITU on 19/04/2018.
 */
public class WebService {
    private static final String SOAP_ACTION = "http://tempuri.org/";
    private static final String SOAP_ADDRESS = "http://192.168.1.20/Publ1/Service.asmx";
    private static final String  OPERATION_NAME= "getConnecter";
    private static final String  OPERATION_NAME2= "inserer";

    public static String Login(String name , String mdp)
    {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        String reponse="";
        SoapObject query =new SoapObject(SOAP_ACTION,OPERATION_NAME);
        PropertyInfo pi = new PropertyInfo();
        pi.setName("nom");
        pi.setValue(name);
        pi.setType(Integer.class);
        query.addProperty(pi);

        pi=new PropertyInfo();
        pi.setName("mdp");
        pi.setValue(mdp);
        pi.setType(Integer.class);
        query.addProperty(pi);
        SoapSerializationEnvelope enveloppe = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        enveloppe.dotNet = true;
        enveloppe.setOutputSoapObject(query);
        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);


        Log.i("NOOOOOOMMMMM", name);
        Log.i("MDDDDDDDPPP", mdp);

        try{
            httpTransport.call(SOAP_ACTION + OPERATION_NAME,enveloppe);
            Object result = enveloppe.getResponse();
            reponse = result.toString();
            Log.i("REEPPOONNNSSE", reponse);
        }catch(Exception e){
            e.printStackTrace();
            Log.i("ERRRRREEEEEEUR",e.getMessage());
        }
        return reponse;
    }

    public static void insert(String name , String mdp)
    {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        String reponse="";
        SoapObject query =new SoapObject(SOAP_ACTION,OPERATION_NAME2);
        PropertyInfo pi = new PropertyInfo();
        pi.setName("nom");
        pi.setValue(name);
        pi.setType(Integer.class);
        query.addProperty(pi);

        pi=new PropertyInfo();
        pi.setName("mdp");
        pi.setValue(mdp);
        pi.setType(Integer.class);
        query.addProperty(pi);
        SoapSerializationEnvelope enveloppe = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        enveloppe.dotNet = true;
        enveloppe.setOutputSoapObject(query);
        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);


        Log.i("NOOOOOOMMMMM", name);
        Log.i("MDDDDDDDPPP", mdp);

        try{
            httpTransport.call(SOAP_ACTION + OPERATION_NAME2,enveloppe);
            Object result = enveloppe.getResponse();
            reponse = result.toString();
            Log.i("REEPPOONNNSSE", reponse);
        }catch(Exception e){
            e.printStackTrace();
            Log.i("ERRRRREEEEEEUR",e.getMessage());
        }
    }


}
