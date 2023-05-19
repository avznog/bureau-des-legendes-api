# Use an official OpenJDK runtime as the base image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Maven executable to the container
COPY mvnw .
COPY .mvn .mvn
COPY target/*.jar /app/api.jar


# Copy the project files to the container
COPY pom.xml .
COPY src src

# Build the application with Maven
RUN chmod +x ./mvnw
RUN ./mvnw install -DskipTests

# Set the entry point for the container
ENTRYPOINT ["java", "-jar", "api.jar"]
