# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /shrtcut

# Argument for the JAR file (use correct name)
ARG JAR_FILE=target/shrtcut.jar

# Copy the JAR file to the container
COPY ${JAR_FILE} shrtcut.jar

# Expose the application's port
EXPOSE 8085

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "shrtcut.jar"]
