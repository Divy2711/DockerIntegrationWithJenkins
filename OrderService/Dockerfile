FROM openjdk:17-alpine
ADD ./target/orderService.jar /opt/app/orderService.jar
WORKDIR /opt/app
ENV PATH = "${PATH}:${JAVA_HOME}/bin"
ENTRYPOINT ["java","-jar","orderService.jar"]