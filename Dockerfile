# Use uma imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR do projeto
COPY target/softskills-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta usada pela aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]