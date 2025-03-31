# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the container
COPY target/*.jar app.jar

# Expose the application's port (change if needed)
EXPOSE 8085

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
