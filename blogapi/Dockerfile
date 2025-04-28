# Use official OpenJDK 21 slim image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy Maven files first
COPY blogapi/pom.xml .

# Download Maven dependencies
RUN mvn dependency:go-offline

# Copy full source code
COPY blogapi/src ./src

# Package the application (skip tests to speed up)
RUN mvn clean package -DskipTests

# Move final jar to a simple name app.jar
RUN cp target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "app.jar"]
