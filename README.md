# Cabinet Vétérinaire RMI

Le projet "Cabinet Vétérinaire RMI" est une application Java qui permet la gestion des animaux au sein d'un cabinet vétérinaire à l'aide de la technologie RMI (Remote Method Invocation). Ce projet est divisé en quatre packages : "Client", "Serveur", "Communs", et "Codebase."
Fonctionnalités clés : 

## L'application offre les fonctionnalités suivantes :

-  `Ajout d'Animaux` : Les utilisateurs peuvent ajouter des animaux au cabinet vétérinaire, que ce soit depuis le client ou le serveur. Les informations telles que le nom, le maître, l'espèce, la race et le dossier de suivi sont nécessaires pour ajouter un animal.

- `Suppression d'Animaux` : Il est possible de supprimer des animaux du cabinet à l'aide de la méthode "supprimerAnimal()" pour une gestion efficace de la liste des patients.

- `Recherche d'Animaux` : Les utilisateurs peuvent rechercher un animal spécifique en utilisant la méthode "chercherAnimalParNom()" en saisissant simplement son nom.

- `Liste des Animaux` : La méthode "obtenirAnimaux()" permet d'obtenir une liste complète de tous les animaux dans le cabinet, avec leurs informations essentielles.

- `Ajout de Nouvelles Espèces` : La flexibilité de l'application réside dans sa capacité à ajouter de nouvelles espèces d'animaux sans nécessiter de modifications majeures dans le code. Cela est rendu possible grâce au package "Codebase," qui stocke les classes des nouvelles espèces.

## Structure du Projet

- `Client` : Contient les classes responsables de l'interaction utilisateur et de la communication avec le serveur distant.

- `Serveur` : Comprend les classes du serveur, y compris les implémentations des interfaces pour la gestion des animaux et des espèces.

- `Communs` : Contient les interfaces partagées entre le client et le serveur, définissant les méthodes et les données nécessaires pour la gestion des animaux.

- `Codebase` : Un répertoire spécial où sont stockées les classes des nouvelles espèces, telles que "Oiseau," pour permettre l'ajout dynamique de nouvelles espèces.

## Comment exécuter le projet

- Désarchivez le projet TP1.
- Ouvrir dans l'IDE de votre choix le projet.
- Construisez le projet, grâce à l'option 'BUILD Project'.
- Exécuter le Serveur.
- Exécter le Client.
   

## Remarques

Le fichier comporte, le code source, un rapport du projet, une vidéo d'une brève application et le fichier readme.
J'ai mis en commentaire la partie sur le gestionnaire de sécurité, je comprend le principe de gestionnaire, j'ai essayé de le mettre en place en vain. Peut être cela vient de la façon dont j'ai construit mon projet, ou cela pourrait venir du JDK que j'utilise ( le 11 dans mon cas).

## Auteur

Ce projet a été réalisé par :

- DAIA Adam

En M1 Génie Logiciel à l'Université de Montpellier