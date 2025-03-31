# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Argument for the JAR file (use correct name)
ARG JAR_FILE=target/my-app.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} app.jar

# Expose the application's port
EXPOSE 8085

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
