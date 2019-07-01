
package com.dxc.converter.model;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}STATUS"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}OBJECT_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}VERB_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}PROGRAM" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}ENTITY" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}ENTITY_ID" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}REASON" maxOccurs="25"/>
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
    "status",
    "objectid",
    "verbid",
    "program",
    "entity",
    "entityid",
    "reason"
})
@XmlRootElement(name = "ERROR")
public class ERROR {

    @XmlElement(name = "STATUS", namespace = "http://www.csc.smart/bo/schemas/Error", required = true)
    protected String status;
    @XmlElement(name = "OBJECT_ID", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected String objectid;
    @XmlElement(name = "VERB_ID", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected String verbid;
    @XmlElement(name = "PROGRAM", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected String program;
    @XmlElement(name = "ENTITY", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected String entity;
    @XmlElement(name = "ENTITY_ID", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected String entityid;
    @XmlElement(name = "REASON", namespace = "http://www.csc.smart/bo/schemas/Error", required = true)
    protected List<REASON> reason;

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUS() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUS(String value) {
        this.status = value;
    }

    /**
     * 获取objectid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJECTID() {
        return objectid;
    }

    /**
     * 设置objectid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJECTID(String value) {
        this.objectid = value;
    }

    /**
     * 获取verbid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERBID() {
        return verbid;
    }

    /**
     * 设置verbid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERBID(String value) {
        this.verbid = value;
    }

    /**
     * 获取program属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROGRAM() {
        return program;
    }

    /**
     * 设置program属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROGRAM(String value) {
        this.program = value;
    }

    /**
     * 获取entity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITY() {
        return entity;
    }

    /**
     * 设置entity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITY(String value) {
        this.entity = value;
    }

    /**
     * 获取entityid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITYID() {
        return entityid;
    }

    /**
     * 设置entityid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITYID(String value) {
        this.entityid = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getREASON().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link REASON }
     * 
     * 
     */
    public List<REASON> getREASON() {
        if (reason == null) {
            reason = new ArrayList<REASON>();
        }
        return this.reason;
    }

}
