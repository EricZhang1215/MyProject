/**
 * 4/4/2019
 *
 * @author qzhang52
 * @version 1.0
 */
@XmlSchema(
        xmlns={
                @XmlNs(prefix= "b", namespaceURI="http://www.csc.smart/bo/schemas/PRMCALO"),
                @XmlNs(prefix= "a", namespaceURI="http://www.csc.smart/bo/schemas/PRMCALI"),
                @XmlNs(prefix= "c", namespaceURI="http://www.csc.smart/msp/schemas/MSPContext"),
                @XmlNs(prefix= "d", namespaceURI="http://www.csc.smart/bo/schemas/Error")
        }
)
package com.dxc.converter.model;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;