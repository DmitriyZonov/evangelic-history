FROM amazoncorretto:18-alpine

WORKDIR /app

COPY target/evangelic-history-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]