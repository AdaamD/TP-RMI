package Communs;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICabinetVeterinaire extends Remote {

    void ajouterAnimal(IAnimal animal) throws RemoteException;

    void ajouterAnimal(String nom, String nom_maitre, Espece espece, String race, IDossierSuivi suivi) throws  RemoteException;

    void supprimerAnimal(IAnimal animal) throws RemoteException;

    IAnimal chercherAnimalParNom(String nom) throws RemoteException;

    // Récupère la liste de tous les animaux.
    List<IAnimal> obtenirAnimaux() throws RemoteException;

}
