# First stage: Build the application
FROM eclipse-temurin:21 AS builder

WORKDIR /app

# Copy all project files
COPY . .

# Ensure the mvnw script has execution permissions
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Second stage: Create a lightweight runtime image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy only the built JAR from the first stage
COPY --from=builder /app/target/shrtcut-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
