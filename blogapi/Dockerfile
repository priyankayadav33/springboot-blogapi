# Use an official OpenJDK runtime as a parent image (Java 21)
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies first to leverage Docker caching
COPY blogapi/pom.xml .

# Install Maven
RUN apt-get update && apt-get install -y maven

# Run Maven to download the dependencies
RUN mvn clean install -DskipTests

# Copy the entire source code of the project
COPY blogapi/src ./src

# Build the application (this should include your Spring Boot jar)
RUN mvn package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/blogapi-0.0.1-SNAPSHOT.jar"]
