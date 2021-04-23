#### SHARED DOCKER STAGES ##############

# The OS setup
FROM ubuntu as developer-os
MAINTAINER Riley Croucher
ENV DEBIAN_FRONTEND    noninteractive
RUN apt-get update --fix-missing && \
apt-get install -y software-properties-common && \
apt-get install -y --no-install-recommends apt-utils && \
apt-get install -y curl \
wget
RUN echo "export SERVER_IP_ADDRESS='0.0.0.0'" >> /etc/profile
RUN apt-get clean

# Setup for node.js
FROM developer-os as nodeenv
MAINTAINER Riley Croucher
# Create and change the working directory
WORKDIR /var/www/node
RUN curl -sL https://deb.nodesource.com/setup_13.x && \
apt-get install -y nodejs npm && \
npm install -g npm && \
npm install -g npx
RUN npm install -g package-json-merge && \
npm install -g nodemon
RUN apt-get clean

#### THE WEB SERVER ##############

FROM nodeenv as webserver
# Expose our webservers port number
# Change to the working directory
WORKDIR /var/www/node
# Execute the application
ENTRYPOINT ["node", "server.js"]

#### THE WEB SERVICE ##############

FROM nodeenv as webservice
# Expose our webservices port number
# Change to the working directory
WORKDIR /var
# Execute the application
ENTRYPOINT ["java","-jar", "pinpointpersonalplates.jar"]


