FROM openjdk:8
ADD target/consumer.jar consumer.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "consumer.jar"]