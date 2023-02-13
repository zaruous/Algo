import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlFormatter {

    public static void main(String[] args) {

        String xml = "aasdsadsadadasdassa<Root><Sub name='kim'/></Root>";
        String ret = formatXml(xml);
        System.out.println(ret);

    }



    public static String formatXml(String inputString) {
        try {
            String[] parts = inputString.split("(?=<)");
            StringBuilder formatted = new StringBuilder();

            for (String part : parts) {
                if (part.startsWith("<?xml")) {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    factory.setValidating(false);
                    factory.setIgnoringElementContentWhitespace(true);
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(new InputSource(new StringReader(part)));
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    StreamResult result = new StreamResult(new StringWriter());
                    DOMSource source = new DOMSource(document);
                    transformer.transform(source, result);
                    formatted.append(result.getWriter().toString());
                } else {
                    formatted.append(part);
                }
            }

            return formatted.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return inputString;
        }
    }
}
