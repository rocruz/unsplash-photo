FROM fabric8/java-alpine-openjdk11-jdk
MAINTAINER Roberto de la Cruz "rocruz92@gmail.com"
EXPOSE 8080
ADD atam-0.0.1-SNAPSHOT.jar /opt/
CMD java -Djava.security.egd=file:/dev/./urandom -jar /opt/atam-0.0.1-SNAPSHOT.jar