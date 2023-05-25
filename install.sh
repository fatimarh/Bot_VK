#!/bin/bash

sudo apt update && sudo apt upgrade
sudo apt install curl
curl -s "https://get.sdkman.io" | bash
sdk install gradle 8.1.1