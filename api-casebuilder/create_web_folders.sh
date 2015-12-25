#!/usr/bin/env bash

echo "project name: $1"
path="src/main/java/io/hedwig/wings/$1"
echo "the project folder: $path"

mkdir -p $path/config
mkdir -p $path/domain
mkdir -p $path/repository
mkdir -p $path/service
mkdir -p $path/rest/controller
mkdir -p $path/rest/dto
mkdir -p $path/rest/exception
mkdir -p $path/exception