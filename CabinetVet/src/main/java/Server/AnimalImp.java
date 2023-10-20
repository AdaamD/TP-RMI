package Server;

import Communs.Espece;
import Communs.IAnimal;
import Communs.IDossierSuivi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AnimalImp extends UnicastRemoteObject implements IAnimal {
    //extends UnicastRemoteObject pour déclarer que c'est notre objet distant
    private String nom ;
    private  String nom_maitre ;
    private Espece espece ;
    private String race ;
    private IDossierSuivi suivi ;

    public AnimalImp(String nom, String nom_maitre, Espece espece, String race, IDossierSuivi suivi)  throws RemoteException {
        this.nom=nom;
        this.nom_maitre=nom_maitre;
        this.espece=espece;
        this.race=race ;
        this.suivi=suivi ;

    }

    @Override
    public Espece getEspece() throws RemoteException {
        return espece;
    }

    @Override
    public String getNom()throws RemoteException {
        return nom;
    }

    @Override
    public IDossierSuivi getDossier() throws RemoteException {
        return suivi;
    }

    @Override
    public String getNom_maitre()throws RemoteException {
        return nom_maitre;
    }

    @Override
    public String getRace()throws RemoteException {
        return race;
    }


}
