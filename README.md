# ****# Description****

Ce projet a été réalisé  en Java avec JUnit 5.
Le but était de créer une classe BookShelf permettant de stocker des livres dans une liste.

### **Fonctionnalités du jour**

* Ajouter un ou plusieurs livres avec add()

* Retourner la liste des livres avec books()

* Empêcher la modification directe de la liste retournée


#### Nous avons développé le projet test par test :

* Vérifier qu’une bibliothèque vide ne contient aucun livre

* Vérifier l’ajout de deux livres

* Vérifier le comportement de add() sans argument

* Vérifier que la liste retournée est non modifiable


#### Technologies utilisées

* JDK 21

* JUnit 5

* Collections Java (ArrayList, List, Collections.unmodifiableList)