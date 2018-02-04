# This Dockerfile builds the container for the registry web service

#														#
# Author: Manuel Bernal Llinares <mbdebian@gmail.com>	#
#														#
FROM identifiersorg/linux-java8
LABEL maintainer="Manuel Bernal Llinares <mbdebian@gmail.com>"

# Prepare the application folder
RUN mkdir -p /home/app
