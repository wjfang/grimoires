# The GRIMOIRES Registry #

### What is GRIMOIRES? ###

GRIMOIRES is a [UDDI](http://uddi.xml.org/)-compatible web service registry with added capabilities including attaching metadata to UDDI entities and discovering entities based on metadata.

GRIMOIRES allows registering the technical interface of web service, which is usually in the form of WSDL. Registered WSDL can be annotated with metadata that conveys the semantic information about WSDL elements such as operations and messages. By doing so, GRIMOIRES supports discovering services by their semantic technical signature.

In GRIMOIRES, all information is represented in RDF triples, which forms a foundation for semantic discovery and ontology reasoning.

Recently, an XMLView interface is added to support domain-specific service descriptions. Examples of domain-specific service descriptions include [GLUE](http://glueschema.forge.cnaf.infn.it/), that is used in grid computing community to describe computing or storage resources, and FETA, that is defined by the [myGrid](http://www.mygrid.org.uk) project to describe bioinformatic services. With XMLView, GRIMOIRES supports publishing and discovering a domain-specific description, while presenting the published descriptions in a UDDI-compatible view. Thus XMLView bridges the gap between widely-understood UDDI descriptions and various descriptions popular inside a specific domain.

### Where can I find more information about GRIMORIES? ###

Started in 2003, GRIMOIRES has a long history. You can find more information at its [homepage](http://www.grimoires.org).

As a commissioned software project of [OMII-UK](http://www.omii.ac.uk), GRIMOIRES is hosted at OMII-UK's [repository](http://www.omii.ac.uk/repository/project.jhtml?pid=43). You can download GRIMOIRES releases for OMII-UK there.

### Then what is this site for? ###

OMII-UK develops its own web application container, which is based on [Tomcat](http://tomcat.apache.org/). Thus the GRIMOIRES releases that can be found at OMII-UK are specially implemented for the OMII-UK container. More precisely, they use OMII-UK's security setting based on WSS4J, and is customised in a way that can be easily deployed into the OMII-UK container.

Different from the OMII-UK repository, this site hosts source and releases targeted at the original Tomcat. In other word, the source and releases from this site should be easily deployed into the original Tomcat. Currently, GRIMOIRES is tested against Tomcat 5.

### More questions and answers can be found at [FAQ](FAQ.md). ###