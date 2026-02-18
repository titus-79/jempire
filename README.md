# JEMPIRE

## Tables des matières

- [Description](#description)
- [Objectif](#objectif)
- [Les Ressources](#les-ressources)
- [Déroulement d'un Tour](#déroulement-dun-tour)
- [Les Actions Possibles](#les-actions-possibles)
- [Pré-requis](#pré-requis)
- [Installation et Lancement](#installation-et-lancement)
- [Structure du projet](#structure-du-projet)
- [Auteurs](#auteurs)

## Description

JEMPIRE est un jeu de gestion de ressources médiéval.

## Objectif

Le joueur commence avec un seul habitant. Il doit gérer ses ressources tour par tour pour construire un CHÂTEAU. S'il n'a plus d'habitants, c'est PERDU.

## Les Ressources

Les ressources au commencement :

    Bois (0)
    Pierre (0)
    Or (50)
    Nourriture (100)
    Habitants (1)

## Déroulement d'un Tour

Affiche les ressources actuelles.
Demande au joueur ce qu'il veut faire.
Chaque habitant mange 1 unité de nourriture.

-> Si pas assez de nourriture : les habitants meurent de faim (Habitants = 0 => Game Over).

## Les Actions Possibles

| Choix | Action | Coût / Risque | Gain |

| 1 | Explorer la forêt | Aucun | +5 Bois, +3 Nourriture |

| 2 | Créer une mine | -10 Bois | (Débloque l'accès à la pierre pour les tours suivants) |

| 3 | Travailler à la mine | -5 Nourriture | +5 Pierre, +2 Or (Seulement si mine construite !) |

| 4 | Recruter un soldat | -30 Or | +1 Habitant |

| 5 | Commercer | -5 Pierre | +10 Or |

| 6 | CONSTRUIRE LE CHÂTEAU | -100 Bois, -100 Pierre, -200 Or, -40 Habitants | VICTOIRE IMMÉDIATE ! |

## Pré-requis

- Java JDK 17 ou supérieur
- Un IDE Java

## Installation et Lancement

Cloner le repos dans le répertoir courant :
```bash
git clone https://github.com/titus-79/jempire.git
```

Compiler le projet :
```bash
javac -d build ./src/main.java ./src/Player.java
```

Lancer l'application:
```bash
java -cp build/ main
```

## Structure du Projet

```bash
jempire/
├── src/
│   ├── Player.java
│   └── main.java
└── README.md
```

## Auteurs

LOPEZ Aymeric et LEGERON Rodolphe
