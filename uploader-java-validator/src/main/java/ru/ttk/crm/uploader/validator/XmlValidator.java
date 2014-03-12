package ru.ttk.crm.uploader.validator;

import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Copyright (c) 2013-2014 TTK
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class XmlValidator {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(XmlValidator.class);

    /**
     * Start point
     *
     * <p />first argument is a /PATH-TO-XSD-FILE/xsd_schema.xsd
     * <p />second argument should be /PATH-TO-XML-FILE/file_to_validate.xml
     *
     * @param args
     */
    public static void main(String... args){

        if(args == null){
            printMessage();
            return;
        }

        if(args.length >= 2){
            final String xsdFile = args[0];
            final String xmlFile = args[1];

            LOG.info("XSD file:" + xsdFile);
            LOG.info("XML file:" + xmlFile);


            XmlValidator xmlValidator = new XmlValidator();
            XmlValidator.Response response = xmlValidator.validate(xsdFile, xmlFile);

            LOG.info("-----------------------------------------------------------------");
            LOG.info("");

            if(response.getStatus().equals(XmlValidator.Status.OK)){
                LOG.info("file is VALID");
                LOG.info("Message:" + response.getMessage());
            }else{
                LOG.error("file is NOT VALID");
                LOG.error("Message:" + response.getMessage());
            }

            LOG.info("");
            LOG.info("-----------------------------------------------------------------");
        }else{
            printMessage();
        }

    }

    public Response validate(String xsdFileName, String xmlFileName) {
        Response _response = new Response(Status.INVALID, "XML file: " + xmlFileName + " is not valid");

        LOG.info("Going to validate xml file:" + xmlFileName + " via schema " + xsdFileName);

        Source xmlFile = new StreamSource(new File(xmlFileName));
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;

        try {
            schema = schemaFactory.newSchema(new StreamSource(new FileReader(xsdFileName)));
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);

            return new Response(Status.OK, "XML file: " + xmlFileName + " is valid");
        } catch (SAXException e) {
            _response = new Response(Status.INVALID, "XML file: " + xmlFileName + " is not valid 'cause:" + e.getLocalizedMessage());
        } catch (IOException e) {
            _response = new Response(Status.INVALID, "Could not get file to validate :" + xmlFileName + " 'cause:" + e.getLocalizedMessage());
        }

        return _response;
    }

    public static void printMessage(){
        System.out.println("" +
                "" +
                "First run:" +
                ">mvn clean package" +
                "" +
                "in ../target find a file uploader-java-validator-1.0-SNAPSHOT.jar" +
                "" +
                "Validate a XML-file run:" +
                ">java -jar uploader-java-validator-1.0-SNAPSHOT.jar /PATH-TO-XSD-FILE/xsd_schema.xsd /PATH-TO-XML-FILE/file_to_validate.xml" +
                "" +
                "");
    }

    public class Response{

        private Status status;
        private String message;

        Response(Status status, String message) {
            this.status = status;
            this.message = message;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public enum Status{
        OK, INVALID
    }

}
