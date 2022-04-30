


FROM maven:3-jdk-8-alpine AS build

# Build Stage
WORKDIR /opt/app
COPY src /opt/app
RUN mvn clean install -DskipTests

# Docker Build Stage
FROM openjdk:11-jdk-alpine
COPY --from=build /opt/app/target/*.jar app.jar
ENV PORT 8090
EXPOSE $PORT
ENTRYPOINT ["java","-jar",-Dserver.port=${PORT}","app.jar"]
