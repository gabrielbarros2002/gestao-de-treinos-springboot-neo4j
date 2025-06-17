# Etapa 1: Compilar a aplicação
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Rodar a aplicação
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/gestao-de-treinos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
