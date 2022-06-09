#!/bin/bash

clear
rm *.log
mvn clean compile exec:java 2> err.log
