tpid=`cat tpid | awk '{print $1}'`
tpid=`ps -aef | grep $tpid | awk '{print $2}' |grep $tpid`
if [ ${tpid} ]; then
         kill -9 $tpid
        echo è¿›ç¨‹$topid å·²å…³é—­
fi