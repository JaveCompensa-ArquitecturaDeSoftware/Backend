FROM ringcentral/jdk:latest

WORKDIR /app

COPY target/servicioadmin-0.0.1-SNAPSHOT.jar app.jar
COPY wait.sh /

ENTRYPOINT ["/wait.sh"]