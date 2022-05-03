#!/bin/bash
export KAFKA_HOST="10.2.102.170:9092"
export KAFKA_TOPIC="PRODUTOS"

export CLASSPATH=target/desafio-0.0.1-SNAPSHOT.jar
export className=DesafioApplication
echo "## Running $className..."
shift
mvn exec:java -Dexec.mainClass="br.com.ilabgrupo2.desafio.$className"