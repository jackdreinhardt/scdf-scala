FROM openjdk:11.0.5-jdk-slim as build
ARG JAR
ADD build/libs/$JAR program.jar
ENTRYPOINT ["java", "-jar", "program.jar"]