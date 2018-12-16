FROM openjdk:8-jdk-alpine
ADD target/finalConsumer.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]