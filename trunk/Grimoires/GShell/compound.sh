#!/bin/bash

GRIMOIRES_URL="http://localhost:8080/grimoires"

echo Publishing transformation A ...
SERVICE_KEY_A=`java uk.ac.soton.ecs.grimoires.shell.PublishServiceCommand $GRIMOIRES_URL A "transformation A" "business_key" "http://vds.org/services/A" "http://vds.org/interfaces/A.wsdl"`
echo Published a transformation with key $SERVICE_KEY_A
echo

echo Publishing transformation B ...
SERVICE_KEY_B=`java uk.ac.soton.ecs.grimoires.shell.PublishServiceCommand $GRIMOIRES_URL B "transformation B" "business_key" "http://vds.org/services/B" "http://vds.org/interfaces/B.wsdl"`
echo Published a transformation with key $SERVICE_KEY_B
echo

echo Publishing a metadata that says A will call B ...
METADATA_KEY_C=`java uk.ac.soton.ecs.grimoires.shell.PublishMetadataCommand $GRIMOIRES_URL -k service $SERVICE_KEY_A "http://vds.org/types/call" $SERVICE_KEY_B`
echo Published a metadata with key $METADATA_KEY_C
echo

echo Publishing a data link metadata ...
METADATA_KEY_L=`java uk.ac.soton.ecs.grimoires.shell.PublishMetadataCommand $GRIMOIRES_URL -k service $SERVICE_KEY_A "http://vds.org/types/hasLink" link1`
echo Published a metadata with key $METADATA_KEY_L
echo

echo Publishing a metadata that says the source of the link is A:input:raw ...
METADATA_KEY_S=`java uk.ac.soton.ecs.grimoires.shell.PublishMetadataCommand $GRIMOIRES_URL -k metadata $METADATA_KEY_L "http://vds.org/types/hasSource" "A:input:raw"`
echo Published a metadata with key $METADATA_KEY_S
echo

echo Publishing a metadata that says the destination of the link is B:input:raw ...
METADATA_KEY_D=`java uk.ac.soton.ecs.grimoires.shell.PublishMetadataCommand $GRIMOIRES_URL -k metadata $METADATA_KEY_L "http://vds.org/types/hasDestination" "B:input:raw"`
echo Published a metadata with key $METADATA_KEY_D
echo
