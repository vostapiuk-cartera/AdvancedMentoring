FROM openjdk:11
ADD target/taf-jenkins-docker-jar-with-dependencies.jar taf-jenkins-docker-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar","taf-jenkins-docker-jar-with-dependencies.jar"]
EXPOSE 8050
RUN java -jar taf-jenkins-docker-jar-with-dependencies.jar