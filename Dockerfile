# Use an official Java runtime as a parent image
# Use an official Java runtime as a parent image
FROM openjdk:21-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Build the application using Maven
RUN mvn clean package

# Run the application
CMD ["java", "-jar", "target/task-manager.jar"]
