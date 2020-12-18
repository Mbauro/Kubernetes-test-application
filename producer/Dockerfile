FROM alpine:latest
RUN apk update && apk upgrade && \
    apk add openjdk11
MAINTAINER "Mauro Labruna"
COPY target/*.jar /producer/producer.jar
WORKDIR /producer
ENTRYPOINT ["java","-jar","producer.jar"]
