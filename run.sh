#!/bin/bash

clear
rm app.log
mvn clean compile exec:java
