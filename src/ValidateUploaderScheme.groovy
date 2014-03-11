package ru.ttk.baloo.address.groovy.uploader.finalversion__1_2

import org.xml.sax.SAXException

import javax.xml.XMLConstants
import javax.xml.transform.Source
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory
import javax.xml.validation.Validator

/**
 *
 */
public class ValidateUploaderScheme {

    public static void main(String... args) {


        System.exit(0)

        System.setProperty("http.proxyHost", "10.105.0.217");
        System.setProperty("http.proxyPort", "3128");

        final String path = "/opt/dev/Pathces/ADDRESS/BRANCH-1.2/ru.ttk.baloo.address/extra-groovy/src/ru/ttk/baloo/address/groovy/uploader/finalversion__1_2";

        final String xsdFileName = "ttk-uploader-1.2.xsd";
        final String xmlFileName = "ttk-uploader-sample-1.2.xml";
        final String notValidXmlFileName = "ttk-uploader-sample-bad-1.2.xml";

        System.out.println("File:" + xmlFileName + " ->\n" +
                isXmlFileValid(path + File.separator + xsdFileName, path + File.separator + xmlFileName) + "\n\n");

        System.out.println("File:" + notValidXmlFileName + " ->\n" +
                isXmlFileValid(path + File.separator + xsdFileName, path + File.separator + notValidXmlFileName) + "\n\n");

    }

    /**
     * @param fullFileNamePathXsdSchema
     * @param fullFileNamePath
     * @return
     */
    public static String isXmlFileValid(String fullFileNamePathXsdSchema, String fullFileNamePath) {
        Source xmlFile = new StreamSource(new File(fullFileNamePath));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {

            schema = schemaFactory.newSchema(new StreamSource(new FileReader(fullFileNamePathXsdSchema)));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);

            return "XML file is VALID";
        } catch (SAXException e) {
            System.out.println("xml is not valid: " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Could not get file to validate :" + fullFileNamePath + " " + e);
        }

        return "!!! WARNING !!! XML file is NOT valid!!!";
    }

}
