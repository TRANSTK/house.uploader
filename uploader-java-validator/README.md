Java XSD Validator
=====


Compile & Run
-----

Upload from  http://crm.ttk.ru/schema/uploader/ttk-uploader-1.2.xsd last version of xsd

```sh
>mvn clean package

>java -jar target/uploader-java-validator-1.0-SNAPSHOT-jar-with-dependencies.jar /PATH-TO-XSD-FILE/fileName.xsd /PATH-TO-XML-FILE/fileName.xml

10:50:54,062 - INFO [main] XmlValidator:main:54 - XSD file:target/test-classes/ttk-uploader-1.2.xsd
10:50:54,063 - INFO [main] XmlValidator:main:55 - XML file:target/test-classes/ttk-uploader-sample-1.2.xml
10:50:54,064 - INFO [main] XmlValidator:validate:83 - Going to validate xml file:target/test-classes/ttk-uploader-sample-1.2.xml via schema target/test-classes/ttk-uploader-1.2.xsd
10:50:54,142 - INFO [main] XmlValidator:main:61 - -----------------------------------------------------------------
10:50:54,142 - INFO [main] XmlValidator:main:62 -
10:50:54,142 - INFO [main] XmlValidator:main:65 - file is VALID
10:50:54,142 - INFO [main] XmlValidator:main:66 - Message:XML file: target/test-classes/ttk-uploader-sample-1.2.xml is valid
10:50:54,142 - INFO [main] XmlValidator:main:72 -
10:50:54,144 - INFO [main] XmlValidator:main:73 - -----------------------------------------------------------------

```

Test cases
----

Just to check yourself

../resources
ttk-uploader-1.2.xsd
ttk-uploader-sample-1.2.xml
ttk-uploader-sample-bad-1.2.xml


