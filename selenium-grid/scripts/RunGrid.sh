#!/usr/bin/env bash
echo Hello
pkill  -9 -f selenium &
sleep 1
FILE_PATH=$PWD/selenium-grid
#ls $FILE_PATH
#java -jar $FILE_PATH/selenium-server-4.20.0.jar hub --host 127.0.0.1 --port 4444 &
java -jar "$FILE_PATH"/selenium-server-4.21.0.jar hub &
#java -jar "$FILE_PATH"/selenium-server-4.20.0.jar hub &
sleep 3
