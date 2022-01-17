FROM openjdk:8-jdk-slim
VOLUME "./target/AdministracionDeEdificiosApi-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 9999
ENTRYPOINT ["java","-jar","app.jar"]