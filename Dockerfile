# Stage 1: Build the JAR file
FROM openjdk:17-jdk-slim AS build
WORKDIR /app

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Copy the project files
COPY pom.xml .
COPY src ./src

# Build the JAR file
RUN mvn clean install -DskipTests

# Stage 2: Run the JAR file
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/alita-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]