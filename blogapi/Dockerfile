# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the Maven project files
COPY blogapi/pom.xml .
COPY blogapi/src ./src

# Build the application
RUN mvn clean install -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "target/blogapi-0.0.1-SNAPSHOT.jar"]
