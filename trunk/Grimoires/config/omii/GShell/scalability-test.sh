#!/bin/sh

export OMII_CLIENT_HOME=@OMIICLIENT_HOME@
export GRIMOIRES_CLIENT_HOME=${OMII_CLIENT_HOME}/grimoires

export MY_CLASSPATH=.:${OMII_CLIENT_HOME}/lib:${OMII_CLIENT_HOME}/conf:
export ENDORSED=-Djava.endorsed.dirs="${OMII_CLIENT_HOME}/endorsed"
for j in `ls "${OMII_CLIENT_HOME}"/lib/*.jar`; do
    MY_CLASSPATH=${MY_CLASSPATH}:${j}
done
for j in `ls "${GRIMOIRES_CLIENT_HOME}"/lib/*.jar`; do
    MY_CLASSPATH=${MY_CLASSPATH}:${j}
done

java "$ENDORSED" -classpath "$MY_CLASSPATH" uk.ac.soton.ecs.grimoires.test.scalability.ScalabilityTest
