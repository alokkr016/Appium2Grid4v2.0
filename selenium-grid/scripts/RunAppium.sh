#!/usr/bin/env bash
echo Hello
pkill  -9 -f appium
FILE_PATH=$PWD/selenium-grid
appium --config $FILE_PATH/configuration/appium1.yml &
appium --config $FILE_PATH/configuration/appium2.yml  &
sleep 3
java -jar "$FILE_PATH"/selenium-server-4.21.0.jar node --config "$FILE_PATH"/configuration/configAndroid.toml &
java -jar "$FILE_PATH"/selenium-server-4.21.0.jar node --config "$FILE_PATH"/configuration/configIos.toml &
sleep 5

