FROM openjdk:11
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list
RUN apt-get update && apt-get -y install google-chrome-stable
ADD target/taf-jenkins-docker-jar-with-dependencies.jar taf-jenkins-docker-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar","taf-jenkins-docker-jar-with-dependencies.jar"]
EXPOSE 8080