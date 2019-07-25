FROM openjdk:8-jdk-alpine

# Metadata
LABEL module.name="h3-rest"	

ADD *.jar app.jar

# Timezone 
#RUN apk add --no-cache tzdata

# Installing the bare build requirements
RUN apk add cmake make gcc libtool musl-dev

# logs folder
RUN mkdir -p /var/log/platform-logs && \
	mkdir ./target
	
# create onesait user/group
RUN addgroup -S onesait -g 433 && adduser -u 431 -S -g onesait -h /usr/local -s /sbin/nologin onesait 

RUN chown -R onesait:onesait /usr/local && \
    chown -R onesait:onesait /var/log/platform-logs && \
    chown -R onesait:onesait ./target && \
    chown onesait:onesait app.jar && \
    chmod -R 777 ./target && \
    chmod -R 777 /var/log && \
    chmod -R 777 /usr/local

VOLUME ["/tmp", "/var/log"]
    
USER onesait
    
# ports
EXPOSE 30010

ENV JAVA_OPTS="$JAVA_OPTS -Xms1G -Xmx3G" \
    SERVER_NAME=localhost

ENTRYPOINT java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -jar /app.jar