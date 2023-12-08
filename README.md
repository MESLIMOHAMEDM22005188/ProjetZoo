# ProjetZoo 🦄🌿🐲

Bienvenue dans votre zoo fantastique ! Ce projet vise à créer une application de simulation où vous incarnez un Maître de Zoo gérant un lieu magique peuplé de créatures incroyables.

## Objectif
Votre mission, si vous l'acceptez, est de créer et de gérer un zoo fantastique rempli d'animaux fabuleux tels les licornes, dragons, mégalodons et bien d'autres !

### Outils et Environnement de Développement
- Outils : GitHub, Notion
- IDE : VSC, Eclipse
- Système d'exploitation : Ubuntu, Windows


## Sommaire

2. [Créatures du Zoo](#créatures-du-zoo)
3. [Enclos et Gestion](#enclos-et-gestion)
4. [Le Maître de Zoo](#le-maître-de-zoo)
5. [Le Zoo Fantastique](#le-zoo-fantastique)
6. [Événements Aléatoires](#événements-aléatoires)
7. [Problématiques](#problématiques)
8. [Démarrage du Jeu](#démarrage-du-jeu)
9. [Organisation des Fichiers](#organisation-des-fichiers)


## Créatures du Zoo 🐺🦄🦑🧜‍♀️🦈🦅🐲🌿
Voici les incroyables créatures qui peuplent votre zoo fantastique :

- Lycanthropes
- Licornes
- Krakens
- Sirènes
- Mégalodons
- Phénix
- Dragons
- Nymphes

### Règles pour toutes les créatures
Voici les caractéristiques communes à toutes les créatures :

| Nom                | Type     |
|--------------------|----------|
| 😃 Nom             | String   |
| ♂♀ Sexe           | Boolean  |
| ⚖️ Poids          | Double   |
| 📏 Taille          | Double   |
| 🎂 Âge             | Int      |
| 🥩 Indicateur de faim   | Int |
| 💤 Indicateur de sommeil | Int |
| 💪 Indicateur de santé   | Int |
| 🌍 Barre de vie   | Int      |


## Enclos et Gestion
Le zoo est divisé en enclos, chacun ayant ses caractéristiques propres :

### Caractéristiques des Enclos
| Nom                             | Type   |
|---------------------------------|--------|
| 🛑 Nom                          | Int    |
| 📐 Superficie                   | Double |
| 🔝 Nombre maximum de créatures  | Int    |
| ✅ Nombre de créatures présent  | Int    |
| 🧼 Degré de propreté            | String |

### Types d'Enclos
- ENCLOS VOLTIGEURS 🦅🐲
  - Dragon
  - Phénix
  - *Vérification toit* 🏰

- ENCLOS NAGEURS 🦑🐲🧜‍♀️🦈
  - Lycanthropes, Licornes, Nymphes, Sirènes
  - *Vérifications supplémentaires*:
    - Profondeur 📏
    - Santé 💧👍


## Le Maître de Zoo 👨‍🦱👩‍🦱
Le Maître du Zoo a ses propres caractéristiques et capacités :

| Nom                          | Type     |
|------------------------------|----------|
| Nom                          | String   |
| Sexe                         | Boolean  |
| Âge (évolue)                 | Int      |

### Capacités du Maître de Zoo
- Examiner un enclos et ses caractéristiques
- Nettoyer un enclos
- Nourrir les créatures
- Transférer une créature d'un enclos à un autre


## Le Zoo Fantastique 🌲🐲
Caractéristiques du Zoo :
- Nom
- Maître de Zoo
- Nombre maximal d'enclos
- Enclos existants

### Capacités du Zoo
- Afficher le nombre de créatures présentes dans le zoo
- Afficher les créatures dans tous les enclos


## Événements Aléatoires 🎲
Des événements aléatoires surviennent :
- Jour/Nuit
- Évolution des animaux
- Actions d'entretien


## Problématiques
D'où proviennent les animaux ? Sont-ils trouvés dans la nature ou achetés ?


## Démarrage du Jeu
Le jeu commence par la création du zoo :
- Choix du nom du zoo
- Renseignement du nom, sexe, et âge du Maître du Zoo
- Achat initial d'animaux

Prenez plaisir à gérer ce zoo fantastique ! 🌟🐾

</br></br>

# Organisation des fichiers
Les dossiers contenant les classes sont contenues dans le dossier /src. Nous avons ensuite les dossiers :
 - Créatures qui contient l'ensemble des classes de types de créatures ainsi qu'une classe déterminant le comportement de ces créatures.
 - Enclos qui contient les classes des différents enclos en plus de la classe gérant le comportement global de ces enclos.
 - GestionZoo qui contient différentes classes gérant le jeu, du joueur aux évènements aléatoires.
