# Football Standing Micro service

## Problem:

Description:

Develop, Test and Deploy a Microservice to find standings of a team playing league football match using country name, league name and team name;
• End user should be able to view results by changing the input parameters
• The service should be ready to be released to production or live environment
• The service should be accessible via web browser or postman (using any one of JavaScript frameworks, HTML or JSON)
• The solution should support offline mode with toggles
• The service should return relevant results as expected, even while the underlying dependencies (Ex: Public API) are not available!

API Sources

API: https://apifootball.com/documentation/#Standings
Key: <API_KEY>
Documentation: https://apifootball.com/documentation/

Expected output

Country ID & Name: (<ID>) - <name>
League ID & Name: (<ID>) - <name>
Team ID & Name: (<ID>) - <name>
Overall League Position: <position>

## Solution:

Requirements

For building and running the application you need:

- [Spring Boot](http://projects.spring.io/spring-boot/) service.
- [JDK 11](https://adoptium.net/temurin/releases?version=11)
- [Maven 3.x](https://maven.apache.org)
- [Docker](https://www.docker.com/)
- [JENKINS](CI-CD)

## How to run application

There are several ways to run a Spring Boot application on your local machine. 

- Execute the `main` method in the `com.football.league.FootballApplication` class from your IDE.

- Run using spring-boot maven plugin
[Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

- Run executable jar file

```shell
java -jar football-service.jar
```

- Build image and run as container

```shell
docker build -t football-service:1.0.0 --no-cache -f Dockerfile .
docker container run --name c_football-service -d -p 8080:8080 -t football-service:1.0.0
```

## CI-CD Pipeline

Configure job in Jenkins and run pipeline

## Sequence Diagram

```
 ![Football_SD](Football_SD.jpg)

```

## Copyright

Released under the Apache License 2.0. See the [LICENSE]
