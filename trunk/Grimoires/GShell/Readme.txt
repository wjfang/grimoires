Grimoires Shell Readme
============================================================
This file is OBSOLETE. Please refer to Grimiores documentation
for the latest information about GShell.
============================================================

1. Introduction 
2. How to compile and run 
3. User guide 
4. A use scenario
5  Run commands in a batch mode

============================================================
1. Introduction
============================================================

The Grimoires shell (the shell in this readme) is a simple command
line client for the Grimoires registry (the registry in this
readme). The shell provides a group of utilities for users to
publish/inquire business/service/wsdl/metadata.

============================================================ 
2. How to compile and run
============================================================

Use "GShell" as the current directory.

To compile, type on the command line: 
ant

If GShell is to be used as a secure client, type
ant secure

To run on Windows, type on the command line: 
run

To run on Unix/Linux, type on the command line: 
chmod +x run.sh
./run.sh

The default registry's URL is set to
http://fantasio.ecs.soton.ac.uk:8080/grimoires.
 
If you have deployed the registry on, e.g.,
http://hostname:8080/grimoires, you need to start the shell by 
"run http://hostname:8080/grimoires"

NOTE: Although there is an ant target "run", please use "run.bat" or
"run.sh" for better usability.

============================================================ 
3. User guide 
============================================================

After the shell is started, you will see a prompt sign ">".

Type "help", you will see a help message.

Type "ls", you will see all available commands. A command is a 
utility that performs a single task on the registry.

Type "run command_name" to run a command.

Type "exit" to exit the shell.

You will see [$n] (n is an integer) in the output. It means the
printed variable is recorded in the shell and you may reuse them by
typing "$n".

============================================================
4. A use scenario
============================================================

In this scenario, we demonstrate how to publish/inquire a gcode
service owned by Univ. of Southampton, and how to annotate its input
message with some semantic type.

- run PublishBusiness 

Publish a business called "Univ. of Southampton". A business is the
UDDI's terminology for an organization. You will get a business
key. On the screen, you will see:

>run PublishBusiness
 ~~~~~~~~~~~~~~~~~~~
==== Publish a business ====
Input the business name:
Univ. of Southampton
~~~~~~~~~~~~~~~~~~~~
Input the business description:
University
~~~~~~~~~~
Business key[$1]: ca5bdb5b-cf1c-4054-8626-65862727b9ff

NOTE:
A. the lines underscored with "~~~~" are typed by users.
B. $1 in "Business key[$1]" refers to a recorded variable. Later, $1
can be used to refer to the key "ca5bdb5b-cf1c-4054-8626-65862727b9ff".

- run InquireBusiness

Inquire a business by name. On the screen, you will see:

>run InquireBusiness
 ~~~~~~~~~~~~~~~~~~~
==== Inquire a business ====
Input the business name:
Univ. of Southampton
~~~~~~~~~~~~~~~~~~~~
Business key[$2]: ca5bdb5b-cf1c-4054-8626-65862727b9ff

- run PublishService 

Publish a service called "gcode". On the screen, you will see:

>run PublishService
 ~~~~~~~~~~~~~~~~~~
==== Publish a service ====
Input the service name:
gcode
~~~~~
Input the service description:
group encoding
~~~~~~~~~~~~~~
Input the business key:
$1
~~
Input the service access point:
http://www.ecs.soton.ac.uk/gcode
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Input the service WSDL URL:
http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/gcode.wsdl
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Service key[$3]: 09017faa-0d2e-4bdd-aea3-6e76084504cf

NOTE:
A. The service access point is where the service is located.
B. The WSDL URL will be recorded in UDDI tModel, but a standard UDDI
registry will not register this WSDL file.

- run InquireService

Inquire a service by name. On the screen, you will see:

>run InquireService
 ~~~~~~~~~~~~~~~~~~
==== List all services ====
Input the service name:
gcode
~~~~~
Service name: gcode
Service key: dc64b224-02cf-44cd-92aa-0037a44d4da1
Business key: 9f6d4816-dfa4-46df-b330-c4108b361d94
Access point in binding template: http://www.ecs.soton.ac.uk/gcode
tModel: http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/gcode.wsdl

- run PublishWSDL

Publish a WSDL file, whose URL is
http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/gcode.wsdl
On the screen, you will see:

>run PublishWSDL
 ~~~~~~~~~~~~~~~
==== Publish a WSDL file ====
Input the WSDL URL:
http://www.ecs.soton.ac.uk/~wf/grimoires/wsdl/gcode.wsdl
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
WSDL key[$4]: 35708376-4092-464c-b364-80459d81400f

NOTE: this is a Grimoires' extension to the UDDI specification.

- run InquireWSDL 

Inquire a WSDL by its registered key. On the screen, you will see:

>run InquireWSDL
 ~~~~~~~~~~~~~~~
==== Inquire a WSDL file ====
Input the WSDL Key:
$4
~~
<?xml version="1.0" encoding="UTF-8"?>
<definitions targetNamespace="http://test/gcode" xmlns:tns="http://test/gcode" x
mlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://schemas.xmlsoap.org/ws
dl/">
  <message name="response">
    <part name="recoded" type="xsd:string"/>
  </message>
  <message name="request">
    <part name="sample" type="xsd:string"/>
    <part name="groups" type="xsd:string"/>
  </message>
  <portType name="DefaultPort">
    <operation name="DefaultOperation">
      <input message="tns:request"/>
      <output message="tns:response"/>
    </operation>
  </portType>
</definitions>

- run PublishMetadata

Publish a piece of metadata to a message part of the gcode service to
describe its semantic type. On the screen, you will see:

>run PublishMetadata
 ~~~~~~~~~~~~~~~~~~~
==== Publish a metadata to a message part ====
Input the message namespace:
http://test/gcode
~~~~~~~~~~~~~~~~~
Input the message name:
request
~~~~~~~
Input the message part name:
sample
~~~~~~
The metadata type by default: http://www.grimoires.org/SemanticType
Input the metadata to describe the semantic type of the message part:
nucleotide_sequence
~~~~~~~~~~~~~~~~~~~
Metadata key[$5]: 32529811-d841-45c5-bf5b-892e2815966c

- run InquireMetadata

Inquire an entity that has the specified annotation. On the screen,
you will see:

>run InquireMetadata
 ~~~~~~~~~~~~~~~~~~~
==== Inquire a metadata ====
Input the metadata:
nucleotide_sequence
~~~~~~~~~~~~~~~~~~~
Found a message part with this metedata:
(http://www.grimoires.org/SemanticType, nucleotide_sequence)
Message namespace[$6]: http://test/gcode
Message name[$7]: request
Message part name[$8]: sample

============================================================
5  Run commands in a batch mode
============================================================

All commands can be run in a batch mode. 

E.g., after setting up the proper classpath,
"java InquireBusinessCommand Grimoirse_URL business_name"
will inquire a business.

And "java InquireBusinessCommand" will show the usage of the command.