package Communs;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IDossierSuivi extends Remote{


    public String getDossierSuivi() throws RemoteException ;
    public void setDossierSuivi(String dossier)  throws RemoteException ;
}
