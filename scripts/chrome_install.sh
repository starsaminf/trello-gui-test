#!/bin/bash

wget --no-verbose -O /tmp/chrome.deb https://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_87.0.4280.88-1_amd64.deb \
  && sudo dpkg -i /tmp/chrome.deb \
  && sudo apt install -f \
  && rm /tmp/chrome.deb
