package Server;

import Communs.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinetVeterinaire {

    // Liste contenant les animaux du cabinet.
    private List<IAnimal> animaux;
    private int nombrePatients = 0;


    public CabinetVeterinaire() throws RemoteException {
        this.animaux = new ArrayList<>();
    }

    private void verifierSeuilsAlerte() {
        if (nombrePatients == 3) {
            System.out.println("Alerte : Le nombre de patients a dépassé 3 !");
        } else if (nombrePatients == 4) {
            System.out.println("Alerte : Le nombre de patients a dépassé 4 !");
        } else if (nombrePatients == 5) {
            System.out.println("Alerte : Le nombre de patients a dépassé 5 !");
        }
    }


    @Override //Ajout depuis le serveur lorsque l'naimla est déja créer
    public void ajouterAnimal(IAnimal animal) throws RemoteException {
        animaux.add(animal);
        nombrePatients++;
        verifierSeuilsAlerte();
    }


    @Override //Ajout depuis le client lon créer nous meme l'animal avant de l'ajouter
    public void ajouterAnimal(String nom, String nom_maitre, Espece espece, String race, IDossierSuivi suivi) throws RemoteException {
        animaux.add(new AnimalImp(nom, nom_maitre,  espece,  race,  suivi ));
        nombrePatients++;
        verifierSeuilsAlerte();
    }

    @Override
    public void supprimerAnimal(IAnimal animal) throws RemoteException {
        animaux.remove(animal);
        nombrePatients--;
    }

    @Override
    public IAnimal chercherAnimalParNom(String nom) throws RemoteException {
        for (IAnimal animal : animaux) {
            if (animal.getNom().equals(nom)) {
                return animal;
            }
        }
        return null; // Aucun animal trouvé avec ce nom
    }

    @Override
    public List<IAnimal> obtenirAnimaux() throws RemoteException {
        return new ArrayList<>(animaux); // Retourne une copie de la liste pour éviter des modifications directes.
    }
}
