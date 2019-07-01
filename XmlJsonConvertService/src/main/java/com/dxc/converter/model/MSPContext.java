
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
 *         &lt;element ref="{http://www.csc.smart/msp/schemas/MSPContext}UserId" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/msp/schemas/MSPContext}UserPassword" minOccurs="0"/>
 *         &lt;element ref="{http://www.csc.smart/msp/schemas/MSPContext}RequestParameters" minOccurs="0"/>
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
    "userId",
    "userPassword",
    "requestParameters"
})
@XmlRootElement(name = "MSPContext", namespace = "http://www.csc.smart/msp/schemas/MSPContext")
public class MSPContext {

    @XmlElement(name = "UserId", namespace = "http://www.csc.smart/msp/schemas/MSPContext")
    protected String userId;
    @XmlElement(name = "UserPassword", namespace = "http://www.csc.smart/msp/schemas/MSPContext")
    protected String userPassword;
    @XmlElement(name = "RequestParameters", namespace = "http://www.csc.smart/msp/schemas/MSPContext")
    protected RequestParameters requestParameters;

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * 获取userPassword属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置userPassword属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * 获取requestParameters属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RequestParameters }
     *     
     */
    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    /**
     * 设置requestParameters属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RequestParameters }
     *     
     */
    public void setRequestParameters(RequestParameters value) {
        this.requestParameters = value;
    }

}
