FROM openjdk:11-ea-17-jre-slim

WORKDIR /app

COPY target/DockerDemoProject-1.0.jar /app/hello-world-app.jar

EXPOSE 8080

CMD ["java", "jar", "hello-world-app.jar"]