package org.training.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

/**
 * Created by anderson on 17-11-3.
 */
public class DOMdemo
{
    public static void main(String[] args)
            throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 验证是不是有效的xml
//        factory.setValidating(true);
        // 是否获取命名空间
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception)
                    throws SAXException
            {
            }

            @Override
            public void error(SAXParseException exception)
                    throws SAXException
            {
                System.out.println(exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception)
                    throws SAXException
            {
            }
        });
        Document doc = builder.parse("videos.xml");
        System.out.println(doc.getChildNodes().getLength());

        Element root = doc.getDocumentElement();
        System.out.println(root.getNamespaceURI());
        System.out.println(root.getChildNodes().getLength());

        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            // 换行和空格属于文本
            if (node instanceof Element) {
                System.out.println(node.getNodeName() + ", id: " + ((Element) node).getAttribute("id"));
                NamedNodeMap map = node.getAttributes();
                for (int j = 0; j < map.getLength(); j++) {
                    System.out.println(map.item(j).getNodeName() + ":" + map.item(j).getNodeValue());
                }
            }
        }

        NodeList titles = doc.getElementsByTagName("title");
        for (int i = 0; i < titles.getLength(); i++) {
            Node node = titles.item(i);
            System.out.println(node.getFirstChild().getTextContent());
        }
    }
}
