package org.training.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by anderson on 17-11-3.
 */
public class SAXDemo
{
    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new File("videos.xml"), new DefaultHandler() {
            String tag;
            @Override
            public void startDocument()
                    throws SAXException
            {
                System.out.println("开始解析...");
                super.startDocument();
            }

            @Override
            public void endDocument()
                    throws SAXException
            {
                super.endDocument();
                System.out.println("结束解析");
            }

            @Override
            public void characters(char[] ch, int start, int length)
                    throws SAXException
            {
                if ("title".equals(tag)) {
                    String s = new String(ch, start, length);
                    System.out.println(s);
                }
                tag = null;
//                super.characters(ch, start, length);
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException
            {
//                super.startElement(uri, localName, qName, attributes);
                if ("title".equals(qName)) {
                    tag = "title";
                }
                if ("anderson:video".equals(qName)) {
                    System.out.println(attributes.getValue("id"));
                }
            }
        });
    }
}
