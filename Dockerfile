FROM adoptopenjdk/openjdk11:jdk-11.0.16_8

LABEL maintainer="gs-offcl"

WORKDIR /opt/app

COPY target/football-service.jar football-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","football-service.jar"]