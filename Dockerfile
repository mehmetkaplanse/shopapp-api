FROM openjdk:11

COPY shopapp-0.0.1-SNAPSHOT.jar shopapp.jar

ENTRYPOINT ["java","-jar","/shopapp.jar"]