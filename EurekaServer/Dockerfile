FROM openjdk:17-alpine
ADD ./target/eurekaServer.jar /opt/app/eurekaServer.jar
WORKDIR /opt/app
ENV PATH = "${PATH}:${JAVA_HOME}/bin"
ENTRYPOINT ["java","-jar","eurekaServer.jar"]