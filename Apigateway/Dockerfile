FROM openjdk:17-alpine
ADD ./target/apiGateway.jar /opt/app/apiGateway.jar
WORKDIR /opt/app
ENV PATH = "${PATH}:${JAVA_HOME}/bin"
ENTRYPOINT ["java","-jar","apiGateway.jar"]