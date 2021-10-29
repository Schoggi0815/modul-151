package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlParse {
    public static void ParseAdressen() {
        try {
            DocumentBuilderFactory dcb = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dcb.newDocumentBuilder();
            Document document = documentBuilder.parse("adressen.xml");
            Node rootNode = document.getDocumentElement();
            NodeList nodeList = rootNode.getChildNodes();

            parse(nodeList, 2);

            System.out.println("\n-----------------------------------------------------------------------------\n");

            parse(nodeList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void parse(NodeList nodeList, int depth){
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println(node.getNodeName());
            if (depth > 1){
                parse(node.getChildNodes(), depth - 1);
            }
        }
    }

    private static void parse(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println(node.getNodeName());
            parse(node.getChildNodes());
        }
    }
}
