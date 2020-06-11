# to provide --build-arg functionality at build time
ARG CLASSPATH
ARG JAR

FROM openjdk:11.0.5-jdk-slim as build
ARG JAR
ADD build/libs/$JAR .
RUN jar -xf $JAR

FROM openjdk:11.0.5-jdk-slim
ARG CLASSPATH
ENV CLASSPATH $CLASSPATH
COPY --from=build /BOOT-INF/lib /app/lib
COPY --from=build /META-INF /app/META-INF
COPY --from=build /BOOT-INF/classes /app
ENTRYPOINT java -cp app:app/lib/* $CLASSPATH