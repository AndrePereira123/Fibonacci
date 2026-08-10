FROM maven:3.8.8 AS build
WORKDIR /workspace

# Copy only the files needed for dependency resolution first to leverage Docker cache
COPY pom.xml mvnw .mvn/ ./
COPY mvnw .
RUN mvn -v || true

# Copy the full project and build
COPY . .
RUN ./mvnw -B -DskipTests package -DskipDocker

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
