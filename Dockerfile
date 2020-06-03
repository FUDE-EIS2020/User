FROM openjdk:8-jdk-alpine
MAINTAINER chuyuxuan
EXPOSE 8080
COPY ./target/fude-user-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar", "--spring.profiles.active=production"]