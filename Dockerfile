FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/bike-reservation-system-0.0.1-SNAPSHOT.jar bike-reservation-system-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bike-reservation-system-0.0.1-SNAPSHOT.jar"]