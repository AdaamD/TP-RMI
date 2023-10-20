package Server;

import Communs.Espece;
import Communs.IAnimal;
import Communs.ICabinetVeterinaire;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String args[]) {
   /*     // Spécifiez le chemin vers le fichier de politique de sécurité du serveur
            System.setProperty("java.security.policy", "src/main/java/security.policy");

        //Activer le gestionnaire de sécurité
            if (System.getSecurityManager() == null) {
             System.setSecurityManager(new SecurityManager());
            }
*/
        System.setProperty("java.rmi.server.codebase", "file:/TP1/untitled//src//maiin//java//codebase");

        try {


            //Création du registre au port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            if(registry==null){
                System.err.println("RmiRegistry pas trouvé");
            }else
            {

                System.out.println("\nServeur pret à être utilisé !\n");


                //Création des instances
                Espece félin =new Espece("félin", 20);
                Espece hominidé =new Espece("hominidé", 80);
                Espece oiseau = new Oiseau("oiseau", 30);

                ICabinetVeterinaire cabinetVeterinaireMTP = new CabinetVeterinaire();

                DossierSuiviImpl dossierTigre =new DossierSuiviImpl ("DossierDuTigre_Vierge");
                DossierSuiviImpl dossierLion =new DossierSuiviImpl ("DossierDuLion_Vierge");
                DossierSuiviImpl dossierGorille =new DossierSuiviImpl ("DossierDuGorille_Vierge");
                DossierSuiviImpl dossierPerroquet =new DossierSuiviImpl ("DossierDuPerroquet_Vierge");
                DossierSuiviImpl dossierAigle =new DossierSuiviImpl ("DossierDueAigle_Vierge");

                IAnimal tigre= new AnimalImp("Tigre", "Adam", félin, "Race1", dossierTigre) ;
                IAnimal lion = new AnimalImp("Lion", "H", félin, "Race2", dossierLion);
                IAnimal gorille = new AnimalImp("Gorille", "Karim", hominidé, "Dos_Argenté", dossierGorille);
                IAnimal perroquet = new AnimalImp("Paco", "AD", oiseau, "Ara", dossierPerroquet);


                //Remplissage du cabinet avec des animaux
                cabinetVeterinaireMTP.ajouterAnimal(tigre);
                cabinetVeterinaireMTP.ajouterAnimal(lion);
                cabinetVeterinaireMTP.ajouterAnimal(perroquet);

                //Mise dans le registre
                registry.bind("DossierDu_Tigre", dossierTigre);
                registry.bind("DossierDu_Lion", dossierLion);
                registry.bind("DossierDu_Gorille", dossierGorille);
                registry.bind("DossierDu_Perroquet", dossierPerroquet);
                registry.bind("DossierDe_Aigle", dossierAigle);

                registry.bind("Tigre", tigre);
                registry.bind("Lion", lion);
                registry.bind("Gorille", gorille);

                registry.bind("CabinetVeterinaireMTP", cabinetVeterinaireMTP);

            }

        } catch (RemoteException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }
}