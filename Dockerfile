FROM amuguelove/adoptopenjdk:11-jre-alpine-apm-agent-1-25

COPY build/libs/*-SNAPSHOT.jar /opt/app.jar

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "/opt/app.jar"]