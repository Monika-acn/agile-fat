FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/password-reset-system-1.0.0.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
