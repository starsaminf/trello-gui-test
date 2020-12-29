#!/bin/bash

sudo apt update && sudo apt install wget
wget --no-verbose -O /tmp/chrome.deb wget https://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_83.0.4103.116-1_amd64.deb \
  && apt install -y /tmp/chrome.deb \
  && rm /tmp/chrome.deb
