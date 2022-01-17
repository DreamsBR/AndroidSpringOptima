FROM openjdk:8-jdk-slim
COPY "./target/AdministracionDeEdificiosApi-0.0.1-SNAPSHOT.jar" "optimamobil.app"
EXPOSE 9999
ENTRYPOINT ["java","-jar","optimamobil.app"]
