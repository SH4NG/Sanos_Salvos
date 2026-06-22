# Etapa 1: Compilar la aplicación
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM eclipse-temurin:17-jre

WORKDIR /app

# Instalar wget
RUN apt-get update && apt-get install -y wget

# Descargar dockerize
RUN wget https://github.com/jwilder/dockerize/releases/download/v0.9.3/dockerize-linux-amd64-v0.9.3.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.9.3.tar.gz \
    && rm dockerize-linux-amd64-v0.9.3.tar.gz

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["dockerize","-wait","tcp://mysql-db:3306","-timeout","120s","java","-jar","app.jar"]