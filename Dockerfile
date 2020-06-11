FROM openjdk:11.0.5-jdk-slim as build
ARG JAR
ENV JAR $JAR
ADD build/libs/$JAR .
ENTRYPOINT java -jar $JAR