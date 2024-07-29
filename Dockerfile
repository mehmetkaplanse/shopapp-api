FROM openjdk:17-jdk-alpine
EXPOSE 8081
ARG JAR_FILE=target/shopapp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
