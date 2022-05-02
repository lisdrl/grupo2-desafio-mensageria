#!/bin/bash
export KAFKA_HOST="44.200.60.230:9092"
export KAFKA_TOPIC="TOPICO_1"

export CLASSPATH=target/kafka_producer-1.0-SNAPSHOT.jar
export className=DesafioApplication
echo "## Running $className..."
shift
mvn exec:java -Dexec.mainClass="br.com.ilabgrupo2.desafio.$className"