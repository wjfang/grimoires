#!/bin/bash

GRIMOIRES_URL="http://localhost:8080/grimoires"

echo Publishing a business ...
echo Usage: java PubishBusinessCommand Grimoires_URL business_name business_description
echo Example: java uk.ac.soton.ecs.grimoires.shell.PublishBusinessCommand $GRIMOIRES_URL MCS "MCS, ANL"
BUSINESS_KEY=`java uk.ac.soton.ecs.grimoires.shell.PublishBusinessCommand $GRIMOIRES_URL MCS "MCS, ANL"`
echo Published a business with key $BUSINESS_KEY
echo

echo Publishing a service ...
echo Usage: java PublishServiceCommand Grimoires_URL name description business_key access_point WSDL_URL
echo Example: java uk.ac.soton.ecs.grimoires.shell.PublishServiceCommand $GRIMOIRES_URL reslice2 "reslice2 transformation" $BUSINESS_KEY "http://vds.org/services/reslice2" "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/reslice2.wsdl"
SERVICE_KEY=`java uk.ac.soton.ecs.grimoires.shell.PublishServiceCommand $GRIMOIRES_URL reslice2 "reslice2 transformation" $BUSINESS_KEY "http://vds.org/services/reslice2" "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/reslice2.wsdl"`
echo Published a service with key $SERVICE_KEY
echo

echo Publishing a WSDL ...
echo Usage: java PublishWSDLCommand Grimoires_URL WSDL_URL
echo Example: java uk.ac.soton.ecs.grimoires.shell.PublishWSDLCommand $GRIMOIRES_URL "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/reslice2.wsdl"
WSDL_KEY=`java uk.ac.soton.ecs.grimoires.shell.PublishWSDLCommand $GRIMOIRES_URL "http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/reslice2.wsdl"`
echo Published a WSDL with key $WSDL_KEY
echo

echo Publishing a metadata ...
echo Usage: java PublishMetadataCommand Grimoires_URL -m message_namespace message_name message_part_name metadata_type metadata_value
echo Example: java uk.ac.soton.ecs.grimoires.shell.PublishMetadataCommand $GRIMOIRES_URL -m "http://www.example.org/reslice2/" reslice2Input airimg "http://vds.org/types/dataType" "http://vds.org/values/subject_image"
METADATA_KEY=`java uk.ac.soton.ecs.grimoires.shell.PublishMetadataCommand $GRIMOIRES_URL -m "http://www.example.org/reslice2/" reslice2Input airimg "http://vds.org/types/dataType" "http://vds.org/values/subject_image"`
echo Published a metadata with key $METADATA_KEY
echo

echo Discovering a message part attached with the metadata ...
echo Usage: java InquireMetadataCommand Grimoires_URL metadataType metadataValue
echo Example: java uk.ac.soton.ecs.grimoires.shell.InquireMetadataCommand $GRIMOIRES_URL "http://vds.org/types/dataType" "http://vds.org/values/subject_image"
java uk.ac.soton.ecs.grimoires.shell.InquireMetadataCommand $GRIMOIRES_URL "http://vds.org/types/dataType" "http://vds.org/values/subject_image"
