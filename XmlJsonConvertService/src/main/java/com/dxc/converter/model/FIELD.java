
package com.dxc.converter.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}ERROR_FIELD"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}ERROR_OCCUR" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "errorfield",
    "erroroccur"
})
@XmlRootElement(name = "FIELD")
public class FIELD {

    @XmlElement(name = "ERROR_FIELD", namespace = "http://www.csc.smart/bo/schemas/Error", required = true)
    protected String errorfield;
    @XmlElement(name = "ERROR_OCCUR", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected String erroroccur;

    /**
     * 获取errorfield属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORFIELD() {
        return errorfield;
    }

    /**
     * 设置errorfield属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORFIELD(String value) {
        this.errorfield = value;
    }

    /**
     * 获取erroroccur属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERROROCCUR() {
        return erroroccur;
    }

    /**
     * 设置erroroccur属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERROROCCUR(String value) {
        this.erroroccur = value;
    }

}
