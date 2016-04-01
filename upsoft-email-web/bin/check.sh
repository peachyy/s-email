#!/bin/sh
tpid=`cat tpid | awk '{print $1}'`
tpid=`ps -aef | grep $tpid | awk '{print $2}' |grep $tpid`
if [ ${tpid} ]; then
        echo emailServer App is running.
else
        echo emailServer App is NOT running.
fi