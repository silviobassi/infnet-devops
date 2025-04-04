FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho no contêiner
WORKDIR /app

COPY files /app/files

# Copiar o JAR gerado no estágio de build
COPY target/*.jar /app/app-course.jar

# Expor a porta que a aplicação vai rodar
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app-course.jar"]
