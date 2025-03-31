# Use a lightweight OpenJDK 17 runtime
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application using Maven
RUN ./mvnw clean package

# Copy the generated JAR file into the container
COPY target/shrtcut-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8085

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
