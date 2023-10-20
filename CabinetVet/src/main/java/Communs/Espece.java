package Communs;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Espece   implements Serializable  {
    private String nom ;
    private  int durée_vie; // en années


    protected Espece()  {
        super();
    }

    public Espece(String nom, int durée_vie)  {
        super();
        this.nom=nom;
        this.durée_vie=durée_vie;
    }
    public String getNom()  {
        return nom;
    }

    public int getDuréeVie() {
        return durée_vie;
    }


}

