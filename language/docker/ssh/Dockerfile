FROM centos:centos7

RUN yum -y update && yum clean all
RUN yum install -y which
RUN yum install -y wget
RUN yum install -y tar
RUN yum install -y vim
RUN yum install -y git
RUN yum -y install openssh-server openssh-clients

RUN mkdir  ~/.ssh \
    touch  ~/.ssh/authorized_keys \
    chmod 600  ~/.ssh/authorized_keys


CMD /bin/bash
