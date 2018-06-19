FROM java:duiba
RUN rm -rf /root/duiba-deploy
ADD ./activity-center-deploy/build/libs/tuia-activity-center-0.1.0.jar /root/duiba-deploy/tuia-activity-center.jar