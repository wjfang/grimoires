+++++++++++++++++++++
+  Grimoires 1.7.0  +
+++++++++++++++++++++

==========================================================
Introduction
==========================================================
A Grimoire is a magician's manual for invoking demons (Oxford English 
Dictionary). Likewise, the Grimoires registry hosts descriptions of services 
and workflows, which a scientist can use for forming their complex scientific
experiments. However, service and workflow interfaces are sometimes 
underspecified and therefore difficult to use in an automated manner; hence, 
the Grimoires registry augments their interfaces with metadata such as 
functionality, semantic information about their inputs and outputs, or 
various metrics (e.g. perceived quality of service, trust).

==========================================================
Official homepage
==========================================================
http://www.grimoires.org
	
==========================================================
What are included in this package
==========================================================
src/: source code
    grimoires.properties: set up runtime options, e.g., which RDF triple store to use.
lib/: where Grimoires server jar is generated, and all third party jars required by Grimoires
docs/: documentation
    api/: javadoc
wsdl/: wsdl files and xsd schemas for all Grimoires services
config/: configuration files for various containers
    axis/: configuration files for standard Apache Tomcat
    gt4/: configuration files for GT4 container
    omii/: configuration files for OMII without signed SOAP message support
    omii-sec/: configuration files for OMII with signed SOAP message support
dist/: where binary release files (war file or gar file) for various containers are generated
    client/: Grimoires client
    server/: Grimoires server
wstester/: junit test suite
GShell/: Grimoires shell, Grimoires' command line client tool
licenses/: third party licenses
mygrid/: xmlview configuration for mygrid feta service descriptions
init.properties: set up the compilation and deployment options for Grimiores. Users need to edit this before compilation and deployment.
build.xml: Ant build file containing all ant targets to compile and deploy Grimoires. Users do not need to edit this file to compile and deploy Grimoires.
LICENCE: the licence statement.
ReleaseNotes.txt: this file.

==========================================================
Documentation and how to get started
==========================================================
The Grimoires documentation is accessible at docs/index.html.
You may want to read it to get started to use Grimoires.
