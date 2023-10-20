package Communs;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IAnimal extends Remote{


    public Espece getEspece() throws RemoteException ;
    public String getNom()throws RemoteException;
    public IDossierSuivi getDossier() throws RemoteException ;

    public String getNom_maitre()throws RemoteException;
    public String getRace()throws RemoteException;
}
