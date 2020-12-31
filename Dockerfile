FROM maven:3.6.3-jdk-15.0.1

RUN useradd -m -u 1000 -s /bin/bash jenkins

RUN yum install -y openssh-clients
