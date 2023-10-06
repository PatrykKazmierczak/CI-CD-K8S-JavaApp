FROM openjdk:17-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD target/sapp-0.0.1-SNAPSHOT.war sapp.war
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/sapp.war"]

