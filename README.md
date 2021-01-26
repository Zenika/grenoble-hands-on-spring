# Hands-on Backend Series : Spring

Suite au succès fou des Hands-on front, on a décidé de poursuivre avec la partie Back. 

Cette suite de Hands-on sera sur les frameworks et outils que l’on pratique (ou pas) à Grenika (Zenika Grenoble) et commencera par Spring Boot en Kotlin !

En repartant de l’application météo, on fera une implémentation de l’API REST en incluant :

* Persistence
* Ajout de la sécurité
* Utilisation d’un client REST pour accéder aux données météo
* Mise en place de tests unitaires et d’intégrations

## Prerequisite

- maven ou gradle
- JDK 11 ou +

## Install

### avec Maven

```
./mvnw install
```

### avec Gradle

```
./gradlew assemble
```

## Usage

### avec Maven

```
./mvnw spring-boot:run
```

### avec Gradle

```
./gradlew bootRun
```



## Technologies

### Langage

* Kotlin

### Frameworks

* Spring Boot
* Spring MVC (REST Server + Client)
* Spring Data JPA (H2/postgresql)
* Spring Test
* Spring Security
* Spring Actuator
* Spring Cache

## Découpage des steps

* Step 0 : Init projet (dépendances, ...)
* Step 1 : Création du controller REST des villes et test avec une implémentation en dur
* Step 2 : Ajout du repository JPA pour les villes
* Step 3 : Création du controller REST de la météo et test avec une implémentation en dur
* Step 4 : Ajout d'un service de météo pour récupérer les coordonnées d'une ville avec météo en dur
* Step 5 : Création d'un repository HTTP pour la météo

### Bonus

* Step 6 : Ajout d'un cache pour la météo
* Step 7 : Création d'un endpoint REST pour ajouter une ville
* Step 8 : Sécuriser l'application 

## Other Hands-on

### Front

* [VueJS](https://github.com/Zenika/grenoble-hands-on-vuejs)
* [Angular](https://github.com/Zenika/grenoble-hands-on-angular)
* [React](https://github.com/Zenika/grenoble-hands-on-react)

## Contributing

<a href="https://github.com/glefloch">
  <img src="https://github.com/glefloch.png?size=50">
</a>
<a href="https://github.com/chocho01">
  <img src="https://github.com/chocho01.png?size=50">
</a>
<a href="https://github.com/flyingtof">
  <img src="https://github.com/flyingtof.png?size=50">
</a>
