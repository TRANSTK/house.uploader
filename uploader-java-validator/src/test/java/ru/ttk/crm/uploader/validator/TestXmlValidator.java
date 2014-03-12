package ru.ttk.crm.uploader.validator;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.File;

import static junit.framework.Assert.*;

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
public class TestXmlValidator {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(TestXmlValidator.class);

    private static String ABSOLUTE_PATH;

    private static final String XSD_SCHEMA_FILE_NAME = "ttk-uploader-1.2.xsd";
    private static final String CORRECT_XML_FILE_NAME = "ttk-uploader-sample-1.2.xml";
    private static final String INVALID_XML_FILE_NAME = "ttk-uploader-sample-bad-1.2.xml";

    @Before
    public void init(){
        ABSOLUTE_PATH = TestXmlValidator.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }

    @Test
    public void testValidateCorrectXMLFile(){
        XmlValidator xmlValidator = new XmlValidator();

        XmlValidator.Response response = xmlValidator.validate(ABSOLUTE_PATH + XSD_SCHEMA_FILE_NAME, ABSOLUTE_PATH + CORRECT_XML_FILE_NAME);
        LOG.info("Message:" + response.getMessage());
        assertEquals(response.getStatus(), XmlValidator.Status.OK);
    }

    @Test
    public void testValidateInvalidXMLFile(){
        XmlValidator xmlValidator = new XmlValidator();

        XmlValidator.Response response = xmlValidator.validate(ABSOLUTE_PATH + XSD_SCHEMA_FILE_NAME, ABSOLUTE_PATH + INVALID_XML_FILE_NAME);
        LOG.info("Message:" + response.getMessage());
        assertEquals(response.getStatus(), XmlValidator.Status.INVALID);
    }

}
