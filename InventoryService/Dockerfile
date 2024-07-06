FROM openjdk:17-alpine
ADD ./target/inventoryService.jar /opt/app/inventoryService.jar
WORKDIR /opt/app
ENV PATH = "${PATH}:${JAVA_HOME}/bin"
ENTRYPOINT ["java","-jar","inventoryService.jar"]