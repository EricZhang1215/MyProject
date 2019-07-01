
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
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}ERROR_DESC"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}ERROR_EROR" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/bo/schemas/Error}FIELD" maxOccurs="25" minOccurs="0"/>
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
    "errordesc",
    "erroreror",
    "field"
})
@XmlRootElement(name = "REASON")
public class REASON {

    @XmlElement(name = "ERROR_DESC", namespace = "http://www.csc.smart/bo/schemas/Error", required = true)
    protected String errordesc;
    @XmlElement(name = "ERROR_EROR", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected String erroreror;
    @XmlElement(name = "FIELD", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected List<FIELD> field;

    /**
     * 获取errordesc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORDESC() {
        return errordesc;
    }

    /**
     * 设置errordesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORDESC(String value) {
        this.errordesc = value;
    }

    /**
     * 获取erroreror属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERROREROR() {
        return erroreror;
    }

    /**
     * 设置erroreror属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERROREROR(String value) {
        this.erroreror = value;
    }

    /**
     * Gets the value of the field property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the field property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFIELD().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FIELD }
     * 
     * 
     */
    public List<FIELD> getFIELD() {
        if (field == null) {
            field = new ArrayList<FIELD>();
        }
        return this.field;
    }

}
