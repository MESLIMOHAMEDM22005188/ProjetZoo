# ProjetZoo

> 📢 ***Consigne: créer une application de simulation d’un ZOO FANTASTIQUE***
> 

> 🎮 ***Simulation: On doit incarner un MAITRE DE ZOO qui s’occupe d’un ZOO.***
> 

> 📆 ***Organisation de code: Nous allons coder en utilisant les outils Github***
> 

> 🔨 ***Structure de code: Nous programmons en POO en utilisant un pattern abstract***
> 

> 🛠️ ***Outils: Github, Notion***
> 

> 💻 ***IDE: VSC, Eclipse***
> 

> 🌐 ***Systeme d’exploitation: Ubuntu, Windows ***


</br></br></br>


🔍📜Règles à respecter pour toute les créatures📜

| **Nom**              | **Type**     |
|------------------|----------|
| 😃 Nom           | String   |
| ♂♀ Sexe         | Boolean  |
| ⚖️ Poids        | Double   |
| 📏 Taille        | Double   |
| 🎂âge           | Int      |
| 🥩 Indicateur de faim   | Int      |
| 💤 Indicateur de sommeil | Int      |
| 💪 Indicateur de santé   | Int      |
| 🌍 Barre de vie | Int      |

</br></br></br>


### **LES CREATURES**

> 🐺 Les lycanthropes
>

> 🦄 Les licornes
>

> 🦑 Les krakens
>

> 🧜‍♀️ Les sirènes
>

> 🦈 Les Mégalodons
>

> 🦅 Les phénix
>

> 🐲 Les dragons
>

> 🌿 Les nymphes
> 


</br></br></br>


## **LES CATEGORIES DE CREATURES**

### Capacités des créatures

> 🍴manger
> 

> 🔊émettre un son
> 

> 💖être soigner
> 

> ⏰s’endormir ou se réveiller😴
> 

> ⌛️vieillir
> 


</br></br></br></br></br>


## 🚧ENCLOS🚧

### **Caractéristique des enclos (à stocker dans des tableaux)**

| **Nom**                                | **Type**     |
|------------------------------------|----------|
| 🛑 Nom                             | Int      |
| 📐 Superficie                       | Double   |
| 🔝 Nombre maximum de créature qu’il peut contenir | Int      |
| ✅ Le nombre de créature présent   | Int      |
| 🧼 Un degré de propreté             | String   |

</br></br></br>

### **Capacité d’utilisation des enclos**

afficher ses caractéristiques  

caractéristiques des créatures qu’il contient;

ajouter des créatures

enlever des créatures

nourri les créature

signaler quand il est sale et vide

</br></br></br>

### Types d’Enclos **(different type de tableaux)**

- ENCLOS VOLTIGEURS🦅🐲
    
    Dragon Phenix
    
    **⚠️ UNE VERIFICATION SUPLEMENTAIRE ⚠️**
    
    - VERIFICATION DU TOIT 🏰
- ENCLOS NAGEURS 🦑🐲🧜‍♀️🦈
    
    lycanthropes, licornes, nymphes, sirènes
    
    **⚠️DEUX VERIFICATIONS SUPLEMENTAIRES⚠️**
    
    - PROFONDEUR📏
    - SANITE💧👍

</br></br></br></br></br>

## 👨MAITRE DE ZOO👩

### Caractéristique du maitre

***Nom                                     Type***                             

Nom                                     String

Sexe                                      Boolean

Age (qui évolue)                   Int

</br></br></br>

### Capacité du maitre

examiner un enclos en voyant les caractéristiques

nettoyer un enclos

nourrir les créatures

transférer une créature d’un enclos à un autre

</br></br></br></br></br>

## 🌲🐲Le ZOO FANTASTIQUE🐲🌲

### Caractéristique du zoo

NOM

MAITRE DE ZOO

NOMBRE MAXIMAL D’ENCLOS

LES ENCLOS EXISTANTS

### Capacité du zoo

AFFICHER LE NOMBRE DE CREATURE PRESENTES DANS LE ZOO

AFFICHER LES CREATEUR DANS TOUS LES ENCLOS.

</br></br></br>

### 🎲EVENEMENT ALEATOIRE🎲

24H de vie 12h de nuit ou les animaux évoluent sans le maitre

(Jour → 1/2 heure, Nuit → 1min50)

Sexe de l’enfant

12h d’entretien 1 action par heure.

Bonjour, Veuillez choisir un nom pour votre zoo:

…..

Veuillez renseigner votre nom (mettre un system anti int)

Veuillez renseigner votre sexe (Boolean )

Veuillez renseigner votre age (en int de 18-99)

Félicitation + NOM, Vous êtes maitre du  + ZOO

> Problématique: d’ou pronviennent les animaux ? on les trouves dans la nature ? on les achetes ?
> 

VOUS AVEZ 20 ENCLOS DISPONIBLES ACHETEZ UN COUPLE D’ANIMAUX

Acheter un 

1. Licornes (nécessite 4 jours)
2. lyncanthropes (nécessite 1 jours)
3. dragon (nécessite 5 jours)
4. Krakens (nécessite 2 jours)
5. sirenes (nécessite 2 jour)
6. mégalodons (nécessite 4 jours)
7. phenix (nécessite 5 jours)
