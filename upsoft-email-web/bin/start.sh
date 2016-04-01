#!/bin/sh
rm -f tpid
nohup java -jar  /opt/emailSVR/upsoft-email.jar  > /opt/emailSVR/log/$(date +%Y%m%d)_emailsvr.log 2>&1 &
echo $! > tpid