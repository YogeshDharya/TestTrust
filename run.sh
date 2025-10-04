#!/bin/bash

mvn clean install -DskipTests assembly:single -q
java -jar target/geektrust.jar "$@"
