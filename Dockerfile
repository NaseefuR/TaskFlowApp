# Use an official Maven image with OpenJDK
FROM maven:3.9.4-openjdk-21-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Build the application using Maven, skipping tests
RUN mvn clean package -DskipTests

# List the contents of the target directory for verification
RUN ls -l target

# Use an official Java runtime as a parent image for the final image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous build stage
COPY --from=build /app/target/ask-manager-0.0.1-SNAPSHOT.jar .

# Run the application
CMD ["java", "-jar", "ask-manager-0.0.1-SNAPSHOT.jar"]
