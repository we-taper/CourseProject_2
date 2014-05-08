package taper.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.databinding.ADBBean;

public class Utility {
	public static String XML2Str(ADBBean adbBean) {
		String xml = null;
		try {
			XMLStreamReader reader = adbBean.getPullParser(null);
			OMElement omElement = new StAXOMBuilder(reader)
					.getDocumentElement();
			xml = omElement.toStringWithConsume();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}
}
