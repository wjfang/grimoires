#!/bin/sh

export AXIS_LIB=../lib/omii3
export MY_CLASSPATH=.:../lib

for j in `ls ./lib/*.jar`; do
    MY_CLASSPATH=${MY_CLASSPATH}:${j}
done
for j in `ls ${AXIS_LIB}/*.jar`; do
    MY_CLASSPATH=${MY_CLASSPATH}:${j}
done

java $ENDORSED -classpath $MY_CLASSPATH uk.ac.soton.ecs.grimoires.shell.Shell $1
