package Server;

import Communs.Espece;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Oiseau extends Espece   {
    public Oiseau(String nom, int dureeVie)  {
        super(nom, dureeVie);
    }
}
