# Use an official Java runtime as a parent image
FROM openjdk:21-jdk-slim

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Set executable permissions for mvnw (if you decide to keep using it)
RUN chmod +x mvnw

# Build the application using Maven, skipping tests
RUN mvn clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/ask-manager-0.0.1-SNAPSHOT.jar"]
