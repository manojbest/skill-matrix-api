FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY target/skill-matrix-api-0.0.1-SNAPSHOT.jar skill-matrix-api.jar

ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/skill-matrix-api.jar","-web" ,"-webAllowOthers", "-tcp" ,"-tcpAllowOthers", "-browser"]