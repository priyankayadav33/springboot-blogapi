# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy pom.xml and src folder together
COPY blogapi/pom.xml .
COPY blogapi/src ./src

# Now build the project
RUN mvn clean install -DskipTests

# Expose port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/blogapi-0.0.1-SNAPSHOT.jar"]
