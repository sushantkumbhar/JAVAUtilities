package xmltest;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

import org.w3c.dom.Node;

import org.w3c.dom.Element;

import java.io.File;

public class test {


public static void main(String[] args)  {

try

{

StringBuffer buf = new StringBuffer();


DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory .newInstance();

DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

Document document = docBuilder.parse(new File("/Users/sushantkumbhar/JavaWorkSpaces/xmltest/test.xml"));

//doSomething(document.getDocumentElement());


NodeList nl = document.getElementsByTagName("*");

    for (int i = 0; i < nl.getLength(); i++)

    {

      System.out.println("name is : "+nl.item(i).getNodeName());

      buf.append(nl.item(i).getNodeName()+",");

      System.out.println("Child Length : "+nl.item(i).getChildNodes().getLength());

      if(nl.item(i).getChildNodes().getLength()==1)

      {

      buf.append(nl.item(i).getTextContent()+",");

      System.out.println("value is : "+nl.item(i).getTextContent());

      }

    }

    System.out.println(buf.toString());

 

}

catch (Exception e)

{

e.printStackTrace();

}

}


public static void doSomething(Node node) {


System.out.println("CurrentNode: "+node.getNodeName());


NodeList nodeList = node.getChildNodes();

System.out.println("Number of childnodes of Current Node: "+nodeList.getLength()+" under "+node.getNodeName());


for (int i = 0; i < nodeList.getLength(); i++) {

Node currentNode = nodeList.item(i);

System.out.println("CurrentNodeInside: "+currentNode.getNodeName());

System.out.println(currentNode.getNodeType() == Node.ELEMENT_NODE);


if (currentNode.getNodeType() == Node.ELEMENT_NODE)

{

System.out.println("Its Element Node");

System.out.println("Node:"+currentNode.getNodeName());


//System.out.println("Length:"+currentNode.);


System.out.println("Value:"+currentNode.getTextContent());


doSomething(currentNode);

}

else

{

//System.out.println("Its Not Element Node");

}

}

}

}