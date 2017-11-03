package org.training.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by anderson on 17-11-3.
 */
public class CreateXMLdemo
{
    public static void main(String[] args)
            throws ParserConfigurationException, TransformerException, FileNotFoundException, SAXException, XMLStreamException
    {
//        createByDOM();
//        createBySAX();
        createByStAX();
    }

    private static void createByDOM()
            throws ParserConfigurationException, TransformerException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("emps");
        Element emp = document.createElement("emp");
        Text name = document.createTextNode("张三");

        document.appendChild(root);
        root.appendChild(emp);
        emp.appendChild(name);

        emp.setAttribute("id", "e001");

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.transform(new DOMSource(document), new StreamResult(new File("emps.xml")));
    }

    private static void createBySAX()
            throws FileNotFoundException, SAXException, TransformerConfigurationException
    {
        Result xml = new StreamResult(new FileOutputStream("emps2.xml"));
        SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler = factory.newTransformerHandler();
        handler.setResult(xml);

        Transformer transformer = handler.getTransformer();
        handler.startDocument();
        AttributesImpl attrs = new AttributesImpl();
        attrs.addAttribute("", "", "id", "", "e001");
        handler.startElement("", "", "person", null);
        handler.startElement("", "", "emp", attrs);
        handler.characters("张三".toCharArray(), 0, "张三".length());
        handler.endElement("", "", "emp");
        handler.endElement("", "", "person");

        handler.endDocument();
    }

    private static void createByStAX()
            throws FileNotFoundException, XMLStreamException
    {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("emps3.xml"));
        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("users");
        writer.writeStartElement("user");
        writer.writeAttribute("id", "u001");
        writer.writeCharacters("Tom");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();
    }

    private static void createByXSLT()
            throws ParserConfigurationException, IOException, SAXException, TransformerException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("myusers.xml");
        File file = new File("myusers.xsl");
        StreamSource ss = new StreamSource(file);
        Transformer t = TransformerFactory.newInstance().newTransformer(ss);
        t.transform(new DOMSource(document), new StreamResult(new File("emps4.html")));
    }
}