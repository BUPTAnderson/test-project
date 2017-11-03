package org.training.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by anderson on 17-11-3.
 */
public class StAXDemo
{
    public static void main(String[] args)
            throws FileNotFoundException, XMLStreamException
    {
        XMLInputFactory factory = XMLInputFactory.newFactory();
        InputStream is = new FileInputStream("videos.xml");
        XMLStreamReader reader = factory.createXMLStreamReader(is);

        int e = reader.getEventType();
        while (true) {
//            int e = reader.next();
            if (e == XMLStreamConstants.START_DOCUMENT) {
                System.out.println("开始解析");
            } else if (e == XMLStreamConstants.START_ELEMENT) {
                if (reader.getLocalName().equals("title")) {
                    System.out.println(reader.getElementText());
                }
                if (reader.getLocalName().equals("video")) {
                    System.out.println(reader.getAttributeValue(null, "id"));
                }
            }

            if (!reader.hasNext()) {
                break;
            }
            e = reader.next();
        }
    }
}
