FROM alpine:latest
RUN apk update && apk upgrade && \
    apk add openjdk11
MAINTAINER "Mauro Labruna"
COPY target/*.jar /consumer/consumer.jar
WORKDIR /consumer
ENTRYPOINT ["java","-jar","consumer.jar"]
