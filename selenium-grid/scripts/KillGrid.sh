#!/usr/bin/env bash
 nohup ps aux | grep 'appium' | grep -v grep | awk '{print $2}' | xargs -r kill -9 &
 nohup ps aux | grep 'selenium' | grep -v grep | awk '{print $2}' | xargs -r kill -9 &