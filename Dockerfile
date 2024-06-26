FROM openjdk:21-slim
MAINTAINER ruslan
WORKDIR /app
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]