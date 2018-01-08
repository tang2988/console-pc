#BASE hsdgold-console-pc Dockerfile
FROM hub.tang2988.com/base/tomcat/centos7-oracle8jre-tomcat8-confenv

#MAINTAINER info
MAINTAINER Ford.CHEN <fangri.chen@tang2988.com>

# COPY APP files
ADD target/hsdgold-console-pc/  /opt/webapp/

# Environment prepare
RUN chown -R tomcat:tomcat /opt/tomcat/ \
    && chown -R tomcat:tomcat /opt/webapp/ \
    && chmod 755 /opt/tomcat/bin/entrypoint.sh

# Starting
USER tomcat
CMD ["/opt/tomcat/bin/entrypoint.sh"]