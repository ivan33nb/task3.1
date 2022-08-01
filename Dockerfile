FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/task3.1-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]