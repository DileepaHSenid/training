# Use an official OpenJDK runtime as a parent image
FROM openjdk:21

# Copy the JAR file from the target directory to the container
COPY . /app

# Set the working directory in the container
WORKDIR /app

# Run the JAR file
ENTRYPOINT ["java", "-cp", "target/Docker-1.0-SNAPSHOT.jar", "org.example.Main"]
