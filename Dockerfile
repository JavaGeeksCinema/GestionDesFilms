FROM openjdk:17

EXPOSE 8084
COPY target/movies-0.0.1-SNAPSHOT.jar movies.jar
ENTRYPOINT ["java", "-jar", "movies.jar"]
