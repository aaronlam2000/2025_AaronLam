# Use an OpenJDK 22 base image
FROM openjdk:22-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy the app's JAR file from the target folder
COPY target/coin_calculator-1.0-SNAPSHOT.jar /app/coin_calculator.jar

# Copy the config.yml file into container
COPY config.yml /app/config.yml

# Expose the application's port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "coin_calculator.jar", "server", "config.yml"]
