
FROM maven:3.8.5-jdk-11-slim AS build

# Build Stage
WORKDIR /opt/app
COPY ./ /opt/app
RUN mvn clean install -DskipTests

# Docker Build Stage
FROM openjdk:11
COPY --from=build /opt/app/target/*.jar app.jar
ENV PORT 8090
EXPOSE $PORT
ENTRYPOINT ["java","-jar","-Dserver.port=${PORT}","app.jar"]
