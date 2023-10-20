package Server;

import Communs.IDossierSuivi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DossierSuiviImpl extends UnicastRemoteObject implements IDossierSuivi {
    private String dossier ;


protected DossierSuiviImpl() throws RemoteException {}
public DossierSuiviImpl(String dossier) throws RemoteException {
    this.dossier=dossier;
}
    public String getDossierSuivi()throws RemoteException{
        return dossier;
    }


    public void setDossierSuivi(String dossier)throws RemoteException{
         this.dossier=dossier;
    }

}