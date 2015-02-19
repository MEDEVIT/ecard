@XmlSchema(namespace = "http://soap.abs.client.chipkarte.at",
  xmlns = { @javax.xml.bind.annotation.XmlNs(namespaceURI = "http://soap.base.client.chipkarte.at", prefix = "base"),
            @javax.xml.bind.annotation.XmlNs(namespaceURI= "http://exceptions.soap.base.client.chipkarte.at", prefix = "baseexc"),
            @javax.xml.bind.annotation.XmlNs(namespaceURI= "http://exceptions.soap.abs.client.chipkarte.at", prefix = "absexc"),
            @javax.xml.bind.annotation.XmlNs(namespaceURI= "http://www.w3.org/2005/05/xmlmime", prefix = "xmime")
  }
)
package at.chipkarte.client.abs.soap;

import javax.xml.bind.annotation.XmlSchema;