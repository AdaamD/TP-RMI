package Client;

import Communs.*;
import Server.Oiseau;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    public Client() {
    }

    public static void main(String args[]) throws RemoteException, NotBoundException {
    /*
        // Spécifiez le chemin vers le fichier de politique de sécurité du client
        System.setProperty("java.security.policy", "src/main/java/security.policy");

        // Activer le gestionnaire de sécurité du client
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

    */
        System.setProperty("java.rmi.server.codebase", "file:/TP1/untitled//src//main//java//codebase");

        try {
            //Récupère instance du registre distant au n° d'hote
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);

            //recherche d'un objet distant das le registre
            IAnimal stubTigre = (IAnimal) registry.lookup("Tigre");
            IAnimal stubGorille = (IAnimal) registry.lookup("Gorille");

            IDossierSuivi stubDossierAigle = (IDossierSuivi) registry.lookup("DossierDe_Aigle");

            ICabinetVeterinaire stubCabinetVeterinaireMTP = (ICabinetVeterinaire) registry.lookup("CabinetVeterinaireMTP");


            Espece oiseau =new Oiseau("oiseau", 30);


            //Modification du Dossier de Suivi du Tigre
            System.out.println( "DossierSuivi du stubTigre : " +stubTigre.getDossier().getDossierSuivi());
            stubTigre.getDossier().setDossierSuivi("J'ai modifié dossier du tigre");
            System.out.println( "DossierSuivi du stubTigre : " +stubTigre.getDossier().getDossierSuivi());


            //Ajout d'un animal au cabinet
            stubCabinetVeterinaireMTP.ajouterAnimal("Aigle", "Adam", oiseau, "Aigle_Royal", stubDossierAigle);

            //Listing des animaux dans le cabinet
            List<IAnimal> AnimauxCabinetMTP= stubCabinetVeterinaireMTP.obtenirAnimaux();
            for (IAnimal animal : AnimauxCabinetMTP){
                System.out.println("\nNom de l'animal : "+ animal.getNom());
                System.out.println("Espèce : "+ animal.getEspece().getNom());
                System.out.println("Durée de vie moyen  : "+ animal.getEspece().getDuréeVie());
                System.out.println("Dossier de suivi : "+ animal.getDossier().getDossierSuivi());
            }System.out.println("\nFin du listing des animaux dans le CabinetVeterinaireMTP" );

            //Ajout du Gorille au cabinet
            stubCabinetVeterinaireMTP.ajouterAnimal(stubGorille);
            IAnimal rechecheGorille1 = stubCabinetVeterinaireMTP.chercherAnimalParNom("Gorille");
            System.out.println("\nCherche de <Gorille> dans le cabinet: "+ rechecheGorille1.getNom());

            //Supression du Gorille du cabinet
            stubCabinetVeterinaireMTP.supprimerAnimal(stubGorille);
            IAnimal rechecheGorille2 = stubCabinetVeterinaireMTP.chercherAnimalParNom("gorille");
            System.out.println("Gorille a été supprimé : "+ rechecheGorille2); //return null car Gorille a bien été supprimé

            //Recherche du perroquet dans le cabinet
            IAnimal perroquet = stubCabinetVeterinaireMTP.chercherAnimalParNom("Paco");

            if (perroquet != null) {
                System.out.println("Le perroquet a été ajouté au cabinet avec succès!");
            } else {
                System.out.println("Le perroquet n'a pas été trouvé dans le cabinet.");
            }

        } catch (Exception e) {
            System.err.println("Client exception : " + e.toString());

        }
    }
}