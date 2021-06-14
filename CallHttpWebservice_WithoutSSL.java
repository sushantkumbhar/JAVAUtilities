package test2;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class test {

public static void main(String[] args) {
// TODO Auto-generated method stub
try {
String respo=getWeather(2,2);
System.out.println(respo);
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
public static String getWeather(int x, int y) throws Exception
{
 
//Code to make a webservice HTTP request
String responseString = "";
String outputString = "";
String wsURL = "http://{host}:{[port}/SOAPService/WSDL-service0.serviceagent/PortTypeEndpoint0";
URL url = new URL(wsURL);
URLConnection connection = url.openConnection();
HttpURLConnection httpConn = (HttpURLConnection)connection;
ByteArrayOutputStream bout = new ByteArrayOutputStream();
// String xmlInput =
// " <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://litwinconsulting.com/webservices/\">\n" +
// " <soapenv:Header/>\n" +
// " <soapenv:Body>\n" +
// " <web:GetWeather>\n" +
// " <!--Optional:-->\n" +
// " <web:City>" + city + "</web:City>\n" +
// " </web:GetWeather>\n" +
// " </soapenv:Body>\n" +
// " </soapenv:Envelope>";
String xmlInput=
"<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ns=\"http://xmlns.example.com/1494024143556\">\n"+
   "<soapenv:Header/>\n"+
   "<soapenv:Body>\n"+
      "<ns:sum>\n"+
         "<a>2</a>\n"+
         "<b>2</b>\n"+
      "</ns:sum>\n"+
   "</soapenv:Body>\n"+
"</soapenv:Envelope>\n";
 
byte[] buffer = new byte[xmlInput.length()];
buffer = xmlInput.getBytes();
bout.write(buffer);
byte[] b = bout.toByteArray();
String SOAPAction ="/SOAPService/WSDL-service0.serviceagent/PortTypeEndpoint0/sum";
// Set the appropriate HTTP parameters.
httpConn.setRequestProperty("Content-Length",String.valueOf(b.length));
httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
httpConn.setRequestProperty("SOAPAction", SOAPAction);
httpConn.setRequestMethod("POST");
httpConn.setDoOutput(true);
httpConn.setDoInput(true);
OutputStream out = httpConn.getOutputStream();
//Write the content of the request to the outputstream of the HTTP Connection.
out.write(b);
out.close();
//Ready with sending the request.
 
//Read the response.
InputStreamReader isr =new InputStreamReader(httpConn.getInputStream());
BufferedReader in = new BufferedReader(isr);
 
//Write the SOAP message response to a String.
while ((responseString = in.readLine()) != null) {
outputString = outputString + responseString;
}
//Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
//Document document = parseXmlFile(outputString);
//NodeList nodeLst = document.getElementsByTagName("GetWeatherResult");
//String weatherResult = nodeLst.item(0).getTextContent();
//System.out.println("Weather: " + weatherResult);
 
//Write the SOAP message formatted to the console.
//String formattedSOAPResponse = formatXML(outputString);
//System.out.println(formattedSOAPResponse);
//return weatherResult;
return outputString;
}

}

