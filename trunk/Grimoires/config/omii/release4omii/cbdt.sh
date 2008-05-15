#!/bin/bash

#
# cbdt: checkout, build, deploy, and test.
#
# This is a script to automate Grimoires release for OMII.
# Configuration.
# 1. Clean up previous Grimoires source and locally deployed Grimoires.
# 2. Get to-be-released Grimoires source from CVS.
# 3. Use OMII's managed_programme_build to build server binary and 
#    client binary from Grimoires source.
# 4. Deploy Grimoires server binary.
# 5. Deploy Grimoires client binary.
# 6. Test.
# 7. Upload the Grimoires release. THIS IS MOVED INTO RELEASE.SH.

#
# Grimoires release configuration
#
GRIMOIRES_VERSION=1.6.1
GRIMOIRES_CVS_TAG=Release-1_6_1

#
# Directory configuration
#
GRIMOIRES_DIR=$HOME/grimoires
OMII_SERVER=$HOME/OMII
OMII_CLIENT=$HOME/OMIICLIENT
OMII_SERVER_SOURCE=$HOME/omii/omii-server-3.4.0
OMII_CLIENT_SOURCE=$HOME/omii/omii-client-3.4.0
MANAGED_PROGRAMME_BUILD=$HOME/omii/managed_programme_build
RELEASE_SCRIPT_HOME=$HOME/release4omii

#
# Variables
#
GRIMOIRES_RELEASE_NAME=grimoires-${GRIMOIRES_VERSION}
GRIMOIRES_RELEASE_DIR=$GRIMOIRES_DIR/$GRIMOIRES_RELEASE_NAME
#echo $GRIMOIRES_RELEASE_DIR
GRIMOIRES_RELEASE_FILE=$GRIMOIRES_DIR/${GRIMOIRES_RELEASE_NAME}-src.tar.gz
#echo $GRIMOIRES_RELEASE_FILE
GRIMOIRES_SERVER_BINARY_FILE=$MANAGED_PROGRAMME_BUILD/binary/${GRIMOIRES_RELEASE_NAME}-bin-server.tgz
GRIMOIRES_CLIENT_BINARY_FILE=$MANAGED_PROGRAMME_BUILD/binary/${GRIMOIRES_RELEASE_NAME}-bin-client.zip

if [ -n $OMII_HOME ]; then
    export OMII_HOME=$OMII_SERVER
fi

export JAVA_OPTS=-Xmx256m

#
# 1. Clean up previous Grimoires source and locally deployed Grimoires.
#
echo "======== Clearn up Grimoires source ========"
if [ -e ${GRIMOIRES_DIR}/grimoires-*-src.tar.gz ]; then
    mv ${GRIMOIRES_DIR}/grimoires-*-src.tar.gz ${GRIMOIRES_DIR}/old
    echo mv ${GRIMOIRES_DIR}/grimoires-*-src.tar.gz ${GRIMOIRES_DIR}/old 
fi

if [ -e ${GRIMOIRES_DIR}/grimoires-* ]; then
    rm -rf ${GRIMOIRES_DIR}/grimoires-*
    echo rm -rf ${GRIMOIRES_DIR}/grimoires-*
fi

echo "======== Undeploy Grimoires server ========"
cd $OMII_SERVER_SOURCE
./OMIIstackUninstall.pl < $RELEASE_SCRIPT_HOME/undeploy_server.input
cd

echo "======== Undeploy Grimores client ========"
if [ -e ${OMII_CLIENT}/grimoires ]; then
    rm -rf ${OMII_CLIENT}/grimoires
fi  

rm $MANAGED_PROGRAMME_BUILD/projects/*.gz
rm $MANAGED_PROGRAMME_BUILD/binary/*.tgz
rm $MANAGED_PROGRAMME_BUILD/binary/*.zip
rm $OMII_SERVER_SOURCE/managed_programme/*.tgz
rm $OMII_CLIENT_SOURCE/managed_programme/*.zip

#
# 2. Get to-be-released Grimoires source from CVS.
#
echo "======== Get Grimoires from CVS ========"
cd $GRIMOIRES_DIR
cvs export -r $GRIMOIRES_CVS_TAG Grimoires/Product
mv Grimoires/Product $GRIMOIRES_RELEASE_DIR
rm -r Grimoires
tar czvf $GRIMOIRES_RELEASE_FILE $GRIMOIRES_RELEASE_NAME
cd

#
# 3. Use OMII's managed_programme_build to build server binary and 
#    client binary from Grimoires source.
#
echo "======== Build server and client binaries ========"
cp $GRIMOIRES_RELEASE_FILE $MANAGED_PROGRAMME_BUILD/projects
cd $MANAGED_PROGRAMME_BUILD
ls
./OMIImanagedProgrammeBuild.sh < $RELEASE_SCRIPT_HOME/build.input
rm -rf projects/$GRIMOIRES_RELEASE_NAME
cd

#
# 4. Deploy Grimoires server binary.
#
echo "======== Deploy Grimoires server binary ========"
mv $GRIMOIRES_SERVER_BINARY_FILE $OMII_SERVER_SOURCE/managed_programme/
cd $OMII_SERVER_SOURCE
./OMIIstackInstall.pl < $RELEASE_SCRIPT_HOME/deploy_server.input
cd

#
# 5. Deploy Grimoires client binary.
#
echo "======== Deploy Grimoires client binary ========"
mv $GRIMOIRES_CLIENT_BINARY_FILE $OMII_CLIENT_SOURCE/managed_programme/
cd $OMII_CLIENT_SOURCE/managed_programme
./OMIImanagedProgrammeClientInstall.sh < $RELEASE_SCRIPT_HOME/deploy_client.input
cd

#
# 6. Test.
#
echo "======== Test ========"
cd $OMII_CLIENT/grimoires/bin

echo "Running gshell test ..."
./run.sh https://localhost:18443/grimoires/services < ../input.txt &> gshell-output.txt

echo "Running junit test ..."
./junit.sh &> junit-output.txt

less gshell-output.txt
less junit-output.txt
cd

