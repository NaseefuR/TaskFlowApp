# Use an official Java runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Build the application using Maven (if applicable)
RUN ./mvnw clean package

# Run the application
CMD ["java", "-jar", "target/task-manager.jar"]
