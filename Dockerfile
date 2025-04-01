FROM openjdk:11-jdk-slim

COPY build/libs/PayVacationCalc-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]