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
    "id": 1,
    "lastname": "Franklin",
    "firstname": "George",
    "city": "110 W. Liberty St.",
    "address": "Madison",
    "telephone": "6085551023",
    "petsNames": [
        "Leo",
        "Samantha",
        "Max",
        "Sly"
        ]
}
```
### Animal

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
    "owner": {
        "lastName": "Franklin",
        "firstName": "George",
        "id": "1"
        }
}
```
### Visite

`/api/v1/visits`

Endpoint | Description | Sortie
-|-|-
/{id} | Identifiant unique d'une visite | Visite spécifique
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
  - [x] Page d'erreur
  - [x] Page d'acceuil
  - [x] Page des vétérinaires
  - [x] Page de recherche de propriétaire
  - [x] Page de propriétaire
  - [x] Page d'animal
  - [ ] Validation formulaire
  - [ ] Envoi formulaire
    
- [ ] GET Endpoints
  - [x] Propriétaire comprenant la liste de nom de ses animaux
  - [x] Animal comprenant le nom de son maitre
  - [ ] Page d'erreur par défaut

- [ ] POST endpoints pour les éditions

### Optionnel

- [ ] Variable d'environement
- [ ] Dockerifier
- [ ] Page d'erreur spécifique
- [ ] Convertir en PokéCenter
- [ ] Migrer vers Firebase

## Projet
- **TRIGianni** - *Professeur*
- **Juldhyne** - *Elève*
- **Naboris** - *Elève*