# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built .jar file into the container
COPY target/city-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app will run on
EXPOSE 8080

# Run the .jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
