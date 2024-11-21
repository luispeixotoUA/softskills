# Etapa 1: Construir o JAR
FROM maven:3.9.4-eclipse-temurin-21 as builder

# Diretório de trabalho para o Maven
WORKDIR /app

# Copiar o projeto inteiro para o container
COPY . .

# Executar o Maven para construir o JAR
RUN mvn clean package -DskipTests

# Etapa 2: Executar a aplicação
FROM openjdk:21-jdk-slim

# Diretório de trabalho para o runtime
WORKDIR /app

# Copiar o JAR gerado da etapa anterior
COPY --from=builder /app/target/softskills-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta para o Render
EXPOSE 8080

# Passar a variável PORT para o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]