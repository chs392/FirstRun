FROM ubuntu:latest
RUN apt-get update
RUN apt-get install -y openjdk-11-jdk
RUN apt install -y maven
RUN mkdir -p /initial/mylearn/
COPY ./src /initial/mylearn/src/
COPY ./pom.xml /initial/mylearn/
RUN cd /initial/mylearn/;mvn clean install
CMD ["java","-Dservice.identifier=${service_identifier}","-jar","/initial/mylearn/target/initial.jar"]