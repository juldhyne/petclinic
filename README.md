# Petclinic
Projet scolaire utilisant SpringBoot pour le backend REST, Reactjs pour le frontend et Liquibase pour le versioning de la base de donnée


## Instalation

Créer une base de donnée "liquibase-petclinic"

```
gradle dev update
gradle build
gradle bootRun
```

Port par défaut: 9999

## Utilisation

### Vétérianaire

`/api/v1/vets`

Endpoint | Description | Sortie
-|-|-
/ | | Liste de tout les vétérinaires

Format:
```json
{
"lastname": "Carter",
"firstname": "James",
"speciality": "radiology"
}
```

### Propritétaire

`/api/v1/owners`

Endpoint | Description | Sortie
-|-|-
/ | | Liste de tout les propriétaires
/{id} | Identifiant unique d'un propriétaire | Propriétaire spécifique

Format:
```json
{
"id": 2,
"lastname": "Davis",
"firstname": "Betty",
"city": "638 Cardinal Ave.",
"address": "Sun Prairie",
"telephone": "6085551749"
}
```
### Animale

`/api/v1/pets`

Endpoint | Description | Sortie
-|-|-
/{id} | Identifiant unique d'un animal | Animal spécifique
/{type} | Type d'animal | Liste d'animal de même type
/o/{id} | Identifiant unique d'un utilisateur | Liste d'animal d'un même propriétaire
Format:
```json
{
"id": 1,
"name": "Leo",
"birthdate": "2000-09-07",
"type": "cat",
"ownerId": 1
}
```
### Visiite

`/api/v1/visits`

Endpoint | Description | Sortie
-|-|-
/{id} | Identifiant unique d'une visite | Animal spécifique
/p/{id} | Identifiant unique d'un animal | Liste de visite d'un même animal

Format:
```json
{
"id": 1,
"date": "2010-03-04",
"description": "rabies shot",
"petId": 7
}
```

## Todo

- [ ] React frontend
  - [ ] Page d'erreur
  - [ ] Page d'acceuil
  - [ ] Page des vétérinaires
  - [ ] Page de recherche de propriétaire
  - [ ] Page de propriétaire
  - [ ] Page d'animal

- [ ] Endpoints
  - [ ] Propriétaire comprenant la liste de nom de ses animaux
  - [ ] Animal comprenant le nom de son maitre

- [ ] POST endpoints pour les éditions

### Optionnel

- [ ] Dockerifier
- [ ] Convertir en PokéCenter
- [ ] Migrer vers Firebase

## Projet
- **TRIGianni** - *Professeur*
- **Juldhyne** - *Elève*
- **Naboris** - *Elève*