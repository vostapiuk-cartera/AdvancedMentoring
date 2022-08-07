FROM openjdk:8
ADD target/taf-jenkins-docker.jar taf-jenkins-docker.jar
ENTRYPOINT ["java", "-jar","taf-jenkins-docker.jar"]
EXPOSE 8050