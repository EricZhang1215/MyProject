
package com.dxc.converter.model;

import com.dxc.converter.model.ERROR;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="MORE_IND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *             &lt;element name="PREMIUM">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;sequence>
 *                       &lt;element name="ERRCODE">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;maxLength value="4"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="PDESC">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;maxLength value="60"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="ZNBAKFLD">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;maxLength value="20"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="CNTBRANCH">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;maxLength value="2"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="TTMPRCNO">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;maxLength value="15"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="TOTAL">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                             &lt;totalDigits value="18"/>
 *                             &lt;fractionDigits value="2"/>
 *                             &lt;minInclusive value="0"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="OCCDATE">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                             &lt;totalDigits value="8"/>
 *                             &lt;minInclusive value="0"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="OWNRSKAMNT" maxOccurs="99" minOccurs="0">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                               &lt;sequence>
 *                                 &lt;element name="ZNRSKCD">
 *                                   &lt;simpleType>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                       &lt;maxLength value="4"/>
 *                                     &lt;/restriction>
 *                                   &lt;/simpleType>
 *                                 &lt;/element>
 *                                 &lt;element name="SUMINS">
 *                                   &lt;simpleType>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                                       &lt;totalDigits value="15"/>
 *                                       &lt;minInclusive value="0"/>
 *                                     &lt;/restriction>
 *                                   &lt;/simpleType>
 *                                 &lt;/element>
 *                               &lt;/sequence>
 *                             &lt;/restriction>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                       &lt;element name="INSUREDLIST">
 *                         &lt;complexType>
 *                           &lt;complexContent>
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                               &lt;sequence>
 *                                 &lt;element name="INSURED" maxOccurs="2" minOccurs="0">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="LIFE">
 *                                             &lt;simpleType>
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                 &lt;maxLength value="2"/>
 *                                               &lt;/restriction>
 *                                             &lt;/simpleType>
 *                                           &lt;/element>
 *                                           &lt;element name="INSRSKAMNT" maxOccurs="99" minOccurs="0">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="ZNRSKCD02">
 *                                                       &lt;simpleType>
 *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                           &lt;maxLength value="4"/>
 *                                                         &lt;/restriction>
 *                                                       &lt;/simpleType>
 *                                                     &lt;/element>
 *                                                     &lt;element name="SUMINS02">
 *                                                       &lt;simpleType>
 *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                                                           &lt;totalDigits value="15"/>
 *                                                           &lt;minInclusive value="0"/>
 *                                                         &lt;/restriction>
 *                                                       &lt;/simpleType>
 *                                                     &lt;/element>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="COVERAGELIST">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="COVERAGEINFO" maxOccurs="9" minOccurs="0">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                             &lt;sequence>
 *                                                               &lt;element name="COVERAGE">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="2"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="RIDER">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="2"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="ZNPRDCODE">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="10"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="RCESSAGE">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="3"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="RCESSTRM">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="3"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="PCESSAGE">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="3"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="PCESSTRM">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="3"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="BCESSAGE">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="3"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="BCESSTRM">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="3"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="SUMIN">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                                                                     &lt;totalDigits value="15"/>
 *                                                                     &lt;minInclusive value="0"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="INSTPRM">
 *                                                                 &lt;simpleType>
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                     &lt;maxLength value="18"/>
 *                                                                   &lt;/restriction>
 *                                                                 &lt;/simpleType>
 *                                                               &lt;/element>
 *                                                               &lt;element name="CASHVALUELIST">
 *                                                                 &lt;complexType>
 *                                                                   &lt;complexContent>
 *                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                       &lt;sequence>
 *                                                                         &lt;element name="CVYEAR" maxOccurs="107" minOccurs="0">
 *                                                                           &lt;complexType>
 *                                                                             &lt;complexContent>
 *                                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                                                 &lt;sequence>
 *                                                                                   &lt;element name="YEAR">
 *                                                                                     &lt;simpleType>
 *                                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                                                                                         &lt;totalDigits value="4"/>
 *                                                                                         &lt;minInclusive value="0"/>
 *                                                                                       &lt;/restriction>
 *                                                                                     &lt;/simpleType>
 *                                                                                   &lt;/element>
 *                                                                                   &lt;element name="ZDCSHVA">
 *                                                                                     &lt;simpleType>
 *                                                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                                                         &lt;maxLength value="11"/>
 *                                                                                       &lt;/restriction>
 *                                                                                     &lt;/simpleType>
 *                                                                                   &lt;/element>
 *                                                                                 &lt;/sequence>
 *                                                                               &lt;/restriction>
 *                                                                             &lt;/complexContent>
 *                                                                           &lt;/complexType>
 *                                                                         &lt;/element>
 *                                                                       &lt;/sequence>
 *                                                                     &lt;/restriction>
 *                                                                   &lt;/complexContent>
 *                                                                 &lt;/complexType>
 *                                                               &lt;/element>
 *                                                             &lt;/sequence>
 *                                                           &lt;/restriction>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                         &lt;/sequence>
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/sequence>
 *                             &lt;/restriction>
 *                           &lt;/complexContent>
 *                         &lt;/complexType>
 *                       &lt;/element>
 *                     &lt;/sequence>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *           &lt;/sequence>
 *           &lt;element ref="{http://www.csc.smart/bo/schemas/Error}ERROR"/>
 *         &lt;/choice>
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
    "moreind",
    "premium",
    "error"
})
@XmlRootElement(name = "PRMCALO_REC", namespace = "http://www.csc.smart/bo/schemas/PRMCALO")
public class PRMCALOREC {

    @XmlElement(name = "STATUS")
    protected String status;
    @XmlElement(name = "MORE_IND")
    protected String moreind;
    @XmlElement(name = "PREMIUM")
    protected PRMCALOREC.PREMIUM premium;
    @XmlElement(name = "ERROR", namespace = "http://www.csc.smart/bo/schemas/Error")
    protected ERROR error;

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
     * 获取moreind属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMOREIND() {
        return moreind;
    }

    /**
     * 设置moreind属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMOREIND(String value) {
        this.moreind = value;
    }

    /**
     * 获取premium属性的值。
     *
     * @return
     *     possible object is
     *     {@link PRMCALOREC.PREMIUM }
     *
     */
    public PRMCALOREC.PREMIUM getPREMIUM() {
        return premium;
    }

    /**
     * 设置premium属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link PRMCALOREC.PREMIUM }
     *
     */
    public void setPREMIUM(PRMCALOREC.PREMIUM value) {
        this.premium = value;
    }

    /**
     * 获取error属性的值。
     *
     * @return
     *     possible object is
     *     {@link ERROR }
     *
     */
    public ERROR getERROR() {
        return error;
    }

    /**
     * 设置error属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link ERROR }
     *
     */
    public void setERROR(ERROR value) {
        this.error = value;
    }


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
     *         &lt;element name="ERRCODE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PDESC">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ZNBAKFLD">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CNTBRANCH">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TTMPRCNO">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TOTAL">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;totalDigits value="18"/>
     *               &lt;fractionDigits value="2"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OCCDATE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *               &lt;totalDigits value="8"/>
     *               &lt;minInclusive value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OWNRSKAMNT" maxOccurs="99" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ZNRSKCD">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="4"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="SUMINS">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *                         &lt;totalDigits value="15"/>
     *                         &lt;minInclusive value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="INSUREDLIST">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="INSURED" maxOccurs="2" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="LIFE">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;maxLength value="2"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="INSRSKAMNT" maxOccurs="99" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="ZNRSKCD02">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                             &lt;maxLength value="4"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                       &lt;element name="SUMINS02">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *                                             &lt;totalDigits value="15"/>
     *                                             &lt;minInclusive value="0"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="COVERAGELIST">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="COVERAGEINFO" maxOccurs="9" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="COVERAGE">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="2"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="RIDER">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="2"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="ZNPRDCODE">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="10"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="RCESSAGE">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="3"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="RCESSTRM">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="3"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="PCESSAGE">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="3"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="PCESSTRM">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="3"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="BCESSAGE">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="3"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="BCESSTRM">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="3"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="SUMIN">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *                                                       &lt;totalDigits value="15"/>
     *                                                       &lt;minInclusive value="0"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="INSTPRM">
     *                                                   &lt;simpleType>
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                       &lt;maxLength value="18"/>
     *                                                     &lt;/restriction>
     *                                                   &lt;/simpleType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="CASHVALUELIST">
     *                                                   &lt;complexType>
     *                                                     &lt;complexContent>
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                         &lt;sequence>
     *                                                           &lt;element name="CVYEAR" maxOccurs="107" minOccurs="0">
     *                                                             &lt;complexType>
     *                                                               &lt;complexContent>
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                                                   &lt;sequence>
     *                                                                     &lt;element name="YEAR">
     *                                                                       &lt;simpleType>
     *                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *                                                                           &lt;totalDigits value="4"/>
     *                                                                           &lt;minInclusive value="0"/>
     *                                                                         &lt;/restriction>
     *                                                                       &lt;/simpleType>
     *                                                                     &lt;/element>
     *                                                                     &lt;element name="ZDCSHVA">
     *                                                                       &lt;simpleType>
     *                                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                                                           &lt;maxLength value="11"/>
     *                                                                         &lt;/restriction>
     *                                                                       &lt;/simpleType>
     *                                                                     &lt;/element>
     *                                                                   &lt;/sequence>
     *                                                                 &lt;/restriction>
     *                                                               &lt;/complexContent>
     *                                                             &lt;/complexType>
     *                                                           &lt;/element>
     *                                                         &lt;/sequence>
     *                                                       &lt;/restriction>
     *                                                     &lt;/complexContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                               &lt;/sequence>
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "errcode",
        "pdesc",
        "znbakfld",
        "cntbranch",
        "ttmprcno",
        "total",
        "occdate",
        "ownrskamnt",
        "insuredlist"
    })
    public static class PREMIUM {

        @XmlElement(name = "ERRCODE", required = true)
        protected String errcode;
        @XmlElement(name = "PDESC", required = true)
        protected String pdesc;
        @XmlElement(name = "ZNBAKFLD", required = true)
        protected String znbakfld;
        @XmlElement(name = "CNTBRANCH", required = true)
        protected String cntbranch;
        @XmlElement(name = "TTMPRCNO", required = true)
        protected String ttmprcno;
        @XmlElement(name = "TOTAL", required = true)
        protected BigDecimal total;
        @XmlElement(name = "OCCDATE", required = true)
        protected BigInteger occdate;
        @XmlElement(name = "OWNRSKAMNT")
        protected List<PRMCALOREC.PREMIUM.OWNRSKAMNT> ownrskamnt;
        @XmlElement(name = "INSUREDLIST", required = true)
        protected PRMCALOREC.PREMIUM.INSUREDLIST insuredlist;

        /**
         * 获取errcode属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getERRCODE() {
            return errcode;
        }

        /**
         * 设置errcode属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setERRCODE(String value) {
            this.errcode = value;
        }

        /**
         * 获取pdesc属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPDESC() {
            return pdesc;
        }

        /**
         * 设置pdesc属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPDESC(String value) {
            this.pdesc = value;
        }

        /**
         * 获取znbakfld属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getZNBAKFLD() {
            return znbakfld;
        }

        /**
         * 设置znbakfld属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setZNBAKFLD(String value) {
            this.znbakfld = value;
        }

        /**
         * 获取cntbranch属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCNTBRANCH() {
            return cntbranch;
        }

        /**
         * 设置cntbranch属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCNTBRANCH(String value) {
            this.cntbranch = value;
        }

        /**
         * 获取ttmprcno属性的值。
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTTMPRCNO() {
            return ttmprcno;
        }

        /**
         * 设置ttmprcno属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTTMPRCNO(String value) {
            this.ttmprcno = value;
        }

        /**
         * 获取total属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTOTAL() {
            return total;
        }

        /**
         * 设置total属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTOTAL(BigDecimal value) {
            this.total = value;
        }

        /**
         * 获取occdate属性的值。
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getOCCDATE() {
            return occdate;
        }

        /**
         * 设置occdate属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setOCCDATE(BigInteger value) {
            this.occdate = value;
        }

        /**
         * Gets the value of the ownrskamnt property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ownrskamnt property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOWNRSKAMNT().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PRMCALOREC.PREMIUM.OWNRSKAMNT }
         *
         *
         */
        public List<PRMCALOREC.PREMIUM.OWNRSKAMNT> getOWNRSKAMNT() {
            if (ownrskamnt == null) {
                ownrskamnt = new ArrayList<PRMCALOREC.PREMIUM.OWNRSKAMNT>();
            }
            return this.ownrskamnt;
        }

        /**
         * 获取insuredlist属性的值。
         *
         * @return
         *     possible object is
         *     {@link PRMCALOREC.PREMIUM.INSUREDLIST }
         *
         */
        public PRMCALOREC.PREMIUM.INSUREDLIST getINSUREDLIST() {
            return insuredlist;
        }

        /**
         * 设置insuredlist属性的值。
         *
         * @param value
         *     allowed object is
         *     {@link PRMCALOREC.PREMIUM.INSUREDLIST }
         *
         */
        public void setINSUREDLIST(PRMCALOREC.PREMIUM.INSUREDLIST value) {
            this.insuredlist = value;
        }


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
         *         &lt;element name="INSURED" maxOccurs="2" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="LIFE">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;maxLength value="2"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="INSRSKAMNT" maxOccurs="99" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ZNRSKCD02">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                   &lt;maxLength value="4"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="SUMINS02">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
         *                                   &lt;totalDigits value="15"/>
         *                                   &lt;minInclusive value="0"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="COVERAGELIST">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="COVERAGEINFO" maxOccurs="9" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="COVERAGE">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="2"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="RIDER">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="2"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="ZNPRDCODE">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="10"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="RCESSAGE">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="3"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="RCESSTRM">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="3"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="PCESSAGE">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="3"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="PCESSTRM">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="3"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="BCESSAGE">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="3"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="BCESSTRM">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="3"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="SUMIN">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
         *                                             &lt;totalDigits value="15"/>
         *                                             &lt;minInclusive value="0"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="INSTPRM">
         *                                         &lt;simpleType>
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                             &lt;maxLength value="18"/>
         *                                           &lt;/restriction>
         *                                         &lt;/simpleType>
         *                                       &lt;/element>
         *                                       &lt;element name="CASHVALUELIST">
         *                                         &lt;complexType>
         *                                           &lt;complexContent>
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                               &lt;sequence>
         *                                                 &lt;element name="CVYEAR" maxOccurs="107" minOccurs="0">
         *                                                   &lt;complexType>
         *                                                     &lt;complexContent>
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                                         &lt;sequence>
         *                                                           &lt;element name="YEAR">
         *                                                             &lt;simpleType>
         *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
         *                                                                 &lt;totalDigits value="4"/>
         *                                                                 &lt;minInclusive value="0"/>
         *                                                               &lt;/restriction>
         *                                                             &lt;/simpleType>
         *                                                           &lt;/element>
         *                                                           &lt;element name="ZDCSHVA">
         *                                                             &lt;simpleType>
         *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                                                 &lt;maxLength value="11"/>
         *                                                               &lt;/restriction>
         *                                                             &lt;/simpleType>
         *                                                           &lt;/element>
         *                                                         &lt;/sequence>
         *                                                       &lt;/restriction>
         *                                                     &lt;/complexContent>
         *                                                   &lt;/complexType>
         *                                                 &lt;/element>
         *                                               &lt;/sequence>
         *                                             &lt;/restriction>
         *                                           &lt;/complexContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                     &lt;/sequence>
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "insured"
        })
        public static class INSUREDLIST {

            @XmlElement(name = "INSURED")
            protected List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED> insured;

            /**
             * Gets the value of the insured property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the insured property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getINSURED().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED }
             *
             *
             */
            public List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED> getINSURED() {
                if (insured == null) {
                    insured = new ArrayList<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED>();
                }
                return this.insured;
            }


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
             *         &lt;element name="LIFE">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;maxLength value="2"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="INSRSKAMNT" maxOccurs="99" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ZNRSKCD02">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;maxLength value="4"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="SUMINS02">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
             *                         &lt;totalDigits value="15"/>
             *                         &lt;minInclusive value="0"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="COVERAGELIST">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="COVERAGEINFO" maxOccurs="9" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="COVERAGE">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="2"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="RIDER">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="2"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="ZNPRDCODE">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="10"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="RCESSAGE">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="3"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="RCESSTRM">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="3"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="PCESSAGE">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="3"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="PCESSTRM">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="3"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="BCESSAGE">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="3"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="BCESSTRM">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="3"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="SUMIN">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
             *                                   &lt;totalDigits value="15"/>
             *                                   &lt;minInclusive value="0"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="INSTPRM">
             *                               &lt;simpleType>
             *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                   &lt;maxLength value="18"/>
             *                                 &lt;/restriction>
             *                               &lt;/simpleType>
             *                             &lt;/element>
             *                             &lt;element name="CASHVALUELIST">
             *                               &lt;complexType>
             *                                 &lt;complexContent>
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                     &lt;sequence>
             *                                       &lt;element name="CVYEAR" maxOccurs="107" minOccurs="0">
             *                                         &lt;complexType>
             *                                           &lt;complexContent>
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                                               &lt;sequence>
             *                                                 &lt;element name="YEAR">
             *                                                   &lt;simpleType>
             *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
             *                                                       &lt;totalDigits value="4"/>
             *                                                       &lt;minInclusive value="0"/>
             *                                                     &lt;/restriction>
             *                                                   &lt;/simpleType>
             *                                                 &lt;/element>
             *                                                 &lt;element name="ZDCSHVA">
             *                                                   &lt;simpleType>
             *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                                                       &lt;maxLength value="11"/>
             *                                                     &lt;/restriction>
             *                                                   &lt;/simpleType>
             *                                                 &lt;/element>
             *                                               &lt;/sequence>
             *                                             &lt;/restriction>
             *                                           &lt;/complexContent>
             *                                         &lt;/complexType>
             *                                       &lt;/element>
             *                                     &lt;/sequence>
             *                                   &lt;/restriction>
             *                                 &lt;/complexContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "life",
                "insrskamnt",
                "coveragelist"
            })
            public static class INSURED {

                @XmlElement(name = "LIFE", required = true)
                protected String life;
                @XmlElement(name = "INSRSKAMNT")
                protected List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.INSRSKAMNT> insrskamnt;
                @XmlElement(name = "COVERAGELIST", required = true)
                protected PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST coveragelist;

                /**
                 * 获取life属性的值。
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getLIFE() {
                    return life;
                }

                /**
                 * 设置life属性的值。
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setLIFE(String value) {
                    this.life = value;
                }

                /**
                 * Gets the value of the insrskamnt property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the insrskamnt property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getINSRSKAMNT().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.INSRSKAMNT }
                 *
                 *
                 */
                public List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.INSRSKAMNT> getINSRSKAMNT() {
                    if (insrskamnt == null) {
                        insrskamnt = new ArrayList<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.INSRSKAMNT>();
                    }
                    return this.insrskamnt;
                }

                /**
                 * 获取coveragelist属性的值。
                 *
                 * @return
                 *     possible object is
                 *     {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST }
                 *
                 */
                public PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST getCOVERAGELIST() {
                    return coveragelist;
                }

                /**
                 * 设置coveragelist属性的值。
                 *
                 * @param value
                 *     allowed object is
                 *     {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST }
                 *
                 */
                public void setCOVERAGELIST(PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST value) {
                    this.coveragelist = value;
                }


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
                 *         &lt;element name="COVERAGEINFO" maxOccurs="9" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="COVERAGE">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="2"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="RIDER">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="2"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="ZNPRDCODE">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="10"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="RCESSAGE">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="3"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="RCESSTRM">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="3"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="PCESSAGE">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="3"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="PCESSTRM">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="3"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="BCESSAGE">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="3"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="BCESSTRM">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="3"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="SUMIN">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
                 *                         &lt;totalDigits value="15"/>
                 *                         &lt;minInclusive value="0"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="INSTPRM">
                 *                     &lt;simpleType>
                 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                         &lt;maxLength value="18"/>
                 *                       &lt;/restriction>
                 *                     &lt;/simpleType>
                 *                   &lt;/element>
                 *                   &lt;element name="CASHVALUELIST">
                 *                     &lt;complexType>
                 *                       &lt;complexContent>
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                           &lt;sequence>
                 *                             &lt;element name="CVYEAR" maxOccurs="107" minOccurs="0">
                 *                               &lt;complexType>
                 *                                 &lt;complexContent>
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                                     &lt;sequence>
                 *                                       &lt;element name="YEAR">
                 *                                         &lt;simpleType>
                 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
                 *                                             &lt;totalDigits value="4"/>
                 *                                             &lt;minInclusive value="0"/>
                 *                                           &lt;/restriction>
                 *                                         &lt;/simpleType>
                 *                                       &lt;/element>
                 *                                       &lt;element name="ZDCSHVA">
                 *                                         &lt;simpleType>
                 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *                                             &lt;maxLength value="11"/>
                 *                                           &lt;/restriction>
                 *                                         &lt;/simpleType>
                 *                                       &lt;/element>
                 *                                     &lt;/sequence>
                 *                                   &lt;/restriction>
                 *                                 &lt;/complexContent>
                 *                               &lt;/complexType>
                 *                             &lt;/element>
                 *                           &lt;/sequence>
                 *                         &lt;/restriction>
                 *                       &lt;/complexContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
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
                    "coverageinfo"
                })
                public static class COVERAGELIST {

                    @XmlElement(name = "COVERAGEINFO")
                    protected List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO> coverageinfo;

                    /**
                     * Gets the value of the coverageinfo property.
                     *
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the coverageinfo property.
                     *
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getCOVERAGEINFO().add(newItem);
                     * </pre>
                     *
                     *
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO }
                     *
                     *
                     */
                    public List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO> getCOVERAGEINFO() {
                        if (coverageinfo == null) {
                            coverageinfo = new ArrayList<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO>();
                        }
                        return this.coverageinfo;
                    }


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
                     *         &lt;element name="COVERAGE">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="2"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="RIDER">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="2"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="ZNPRDCODE">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="10"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="RCESSAGE">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="3"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="RCESSTRM">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="3"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="PCESSAGE">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="3"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="PCESSTRM">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="3"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="BCESSAGE">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="3"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="BCESSTRM">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="3"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="SUMIN">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
                     *               &lt;totalDigits value="15"/>
                     *               &lt;minInclusive value="0"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="INSTPRM">
                     *           &lt;simpleType>
                     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *               &lt;maxLength value="18"/>
                     *             &lt;/restriction>
                     *           &lt;/simpleType>
                     *         &lt;/element>
                     *         &lt;element name="CASHVALUELIST">
                     *           &lt;complexType>
                     *             &lt;complexContent>
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                 &lt;sequence>
                     *                   &lt;element name="CVYEAR" maxOccurs="107" minOccurs="0">
                     *                     &lt;complexType>
                     *                       &lt;complexContent>
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *                           &lt;sequence>
                     *                             &lt;element name="YEAR">
                     *                               &lt;simpleType>
                     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
                     *                                   &lt;totalDigits value="4"/>
                     *                                   &lt;minInclusive value="0"/>
                     *                                 &lt;/restriction>
                     *                               &lt;/simpleType>
                     *                             &lt;/element>
                     *                             &lt;element name="ZDCSHVA">
                     *                               &lt;simpleType>
                     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                     *                                   &lt;maxLength value="11"/>
                     *                                 &lt;/restriction>
                     *                               &lt;/simpleType>
                     *                             &lt;/element>
                     *                           &lt;/sequence>
                     *                         &lt;/restriction>
                     *                       &lt;/complexContent>
                     *                     &lt;/complexType>
                     *                   &lt;/element>
                     *                 &lt;/sequence>
                     *               &lt;/restriction>
                     *             &lt;/complexContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
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
                        "coverage",
                        "rider",
                        "znprdcode",
                        "rcessage",
                        "rcesstrm",
                        "pcessage",
                        "pcesstrm",
                        "bcessage",
                        "bcesstrm",
                        "sumin",
                        "instprm",
                        "cashvaluelist"
                    })
                    public static class COVERAGEINFO {

                        @XmlElement(name = "COVERAGE", required = true)
                        protected String coverage;
                        @XmlElement(name = "RIDER", required = true)
                        protected String rider;
                        @XmlElement(name = "ZNPRDCODE", required = true)
                        protected String znprdcode;
                        @XmlElement(name = "RCESSAGE", required = true)
                        protected String rcessage;
                        @XmlElement(name = "RCESSTRM", required = true)
                        protected String rcesstrm;
                        @XmlElement(name = "PCESSAGE", required = true)
                        protected String pcessage;
                        @XmlElement(name = "PCESSTRM", required = true)
                        protected String pcesstrm;
                        @XmlElement(name = "BCESSAGE", required = true)
                        protected String bcessage;
                        @XmlElement(name = "BCESSTRM", required = true)
                        protected String bcesstrm;
                        @XmlElement(name = "SUMIN", required = true)
                        protected BigInteger sumin;
                        @XmlElement(name = "INSTPRM", required = true)
                        protected String instprm;
                        @XmlElement(name = "CASHVALUELIST", required = true)
                        protected PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST cashvaluelist;

                        /**
                         * 获取coverage属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getCOVERAGE() {
                            return coverage;
                        }

                        /**
                         * 设置coverage属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setCOVERAGE(String value) {
                            this.coverage = value;
                        }

                        /**
                         * 获取rider属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getRIDER() {
                            return rider;
                        }

                        /**
                         * 设置rider属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setRIDER(String value) {
                            this.rider = value;
                        }

                        /**
                         * 获取znprdcode属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getZNPRDCODE() {
                            return znprdcode;
                        }

                        /**
                         * 设置znprdcode属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setZNPRDCODE(String value) {
                            this.znprdcode = value;
                        }

                        /**
                         * 获取rcessage属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getRCESSAGE() {
                            return rcessage;
                        }

                        /**
                         * 设置rcessage属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setRCESSAGE(String value) {
                            this.rcessage = value;
                        }

                        /**
                         * 获取rcesstrm属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getRCESSTRM() {
                            return rcesstrm;
                        }

                        /**
                         * 设置rcesstrm属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setRCESSTRM(String value) {
                            this.rcesstrm = value;
                        }

                        /**
                         * 获取pcessage属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getPCESSAGE() {
                            return pcessage;
                        }

                        /**
                         * 设置pcessage属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setPCESSAGE(String value) {
                            this.pcessage = value;
                        }

                        /**
                         * 获取pcesstrm属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getPCESSTRM() {
                            return pcesstrm;
                        }

                        /**
                         * 设置pcesstrm属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setPCESSTRM(String value) {
                            this.pcesstrm = value;
                        }

                        /**
                         * 获取bcessage属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getBCESSAGE() {
                            return bcessage;
                        }

                        /**
                         * 设置bcessage属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setBCESSAGE(String value) {
                            this.bcessage = value;
                        }

                        /**
                         * 获取bcesstrm属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getBCESSTRM() {
                            return bcesstrm;
                        }

                        /**
                         * 设置bcesstrm属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setBCESSTRM(String value) {
                            this.bcesstrm = value;
                        }

                        /**
                         * 获取sumin属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link BigInteger }
                         *
                         */
                        public BigInteger getSUMIN() {
                            return sumin;
                        }

                        /**
                         * 设置sumin属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link BigInteger }
                         *
                         */
                        public void setSUMIN(BigInteger value) {
                            this.sumin = value;
                        }

                        /**
                         * 获取instprm属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getINSTPRM() {
                            return instprm;
                        }

                        /**
                         * 设置instprm属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setINSTPRM(String value) {
                            this.instprm = value;
                        }

                        /**
                         * 获取cashvaluelist属性的值。
                         *
                         * @return
                         *     possible object is
                         *     {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST }
                         *
                         */
                        public PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST getCASHVALUELIST() {
                            return cashvaluelist;
                        }

                        /**
                         * 设置cashvaluelist属性的值。
                         *
                         * @param value
                         *     allowed object is
                         *     {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST }
                         *
                         */
                        public void setCASHVALUELIST(PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST value) {
                            this.cashvaluelist = value;
                        }


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
                         *         &lt;element name="CVYEAR" maxOccurs="107" minOccurs="0">
                         *           &lt;complexType>
                         *             &lt;complexContent>
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                         *                 &lt;sequence>
                         *                   &lt;element name="YEAR">
                         *                     &lt;simpleType>
                         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
                         *                         &lt;totalDigits value="4"/>
                         *                         &lt;minInclusive value="0"/>
                         *                       &lt;/restriction>
                         *                     &lt;/simpleType>
                         *                   &lt;/element>
                         *                   &lt;element name="ZDCSHVA">
                         *                     &lt;simpleType>
                         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                         *                         &lt;maxLength value="11"/>
                         *                       &lt;/restriction>
                         *                     &lt;/simpleType>
                         *                   &lt;/element>
                         *                 &lt;/sequence>
                         *               &lt;/restriction>
                         *             &lt;/complexContent>
                         *           &lt;/complexType>
                         *         &lt;/element>
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
                            "cvyear"
                        })
                        public static class CASHVALUELIST {

                            @XmlElement(name = "CVYEAR")
                            protected List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST.CVYEAR> cvyear;

                            /**
                             * Gets the value of the cvyear property.
                             *
                             * <p>
                             * This accessor method returns a reference to the live list,
                             * not a snapshot. Therefore any modification you make to the
                             * returned list will be present inside the JAXB object.
                             * This is why there is not a <CODE>set</CODE> method for the cvyear property.
                             *
                             * <p>
                             * For example, to add a new item, do as follows:
                             * <pre>
                             *    getCVYEAR().add(newItem);
                             * </pre>
                             *
                             *
                             * <p>
                             * Objects of the following type(s) are allowed in the list
                             * {@link PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST.CVYEAR }
                             *
                             *
                             */
                            public List<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST.CVYEAR> getCVYEAR() {
                                if (cvyear == null) {
                                    cvyear = new ArrayList<PRMCALOREC.PREMIUM.INSUREDLIST.INSURED.COVERAGELIST.COVERAGEINFO.CASHVALUELIST.CVYEAR>();
                                }
                                return this.cvyear;
                            }


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
                             *         &lt;element name="YEAR">
                             *           &lt;simpleType>
                             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
                             *               &lt;totalDigits value="4"/>
                             *               &lt;minInclusive value="0"/>
                             *             &lt;/restriction>
                             *           &lt;/simpleType>
                             *         &lt;/element>
                             *         &lt;element name="ZDCSHVA">
                             *           &lt;simpleType>
                             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                             *               &lt;maxLength value="11"/>
                             *             &lt;/restriction>
                             *           &lt;/simpleType>
                             *         &lt;/element>
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
                                "year",
                                "zdcshva"
                            })
                            public static class CVYEAR {

                                @XmlElement(name = "YEAR", required = true)
                                protected BigInteger year;
                                @XmlElement(name = "ZDCSHVA", required = true)
                                protected String zdcshva;

                                /**
                                 * 获取year属性的值。
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link BigInteger }
                                 *     
                                 */
                                public BigInteger getYEAR() {
                                    return year;
                                }

                                /**
                                 * 设置year属性的值。
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link BigInteger }
                                 *     
                                 */
                                public void setYEAR(BigInteger value) {
                                    this.year = value;
                                }

                                /**
                                 * 获取zdcshva属性的值。
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link String }
                                 *     
                                 */
                                public String getZDCSHVA() {
                                    return zdcshva;
                                }

                                /**
                                 * 设置zdcshva属性的值。
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link String }
                                 *     
                                 */
                                public void setZDCSHVA(String value) {
                                    this.zdcshva = value;
                                }

                            }

                        }

                    }

                }


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
                 *         &lt;element name="ZNRSKCD02">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;maxLength value="4"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="SUMINS02">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
                 *               &lt;totalDigits value="15"/>
                 *               &lt;minInclusive value="0"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
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
                    "znrskcd02",
                    "sumins02"
                })
                public static class INSRSKAMNT {

                    @XmlElement(name = "ZNRSKCD02", required = true)
                    protected String znrskcd02;
                    @XmlElement(name = "SUMINS02", required = true)
                    protected BigInteger sumins02;

                    /**
                     * 获取znrskcd02属性的值。
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getZNRSKCD02() {
                        return znrskcd02;
                    }

                    /**
                     * 设置znrskcd02属性的值。
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setZNRSKCD02(String value) {
                        this.znrskcd02 = value;
                    }

                    /**
                     * 获取sumins02属性的值。
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getSUMINS02() {
                        return sumins02;
                    }

                    /**
                     * 设置sumins02属性的值。
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setSUMINS02(BigInteger value) {
                        this.sumins02 = value;
                    }

                }

            }

        }


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
         *         &lt;element name="ZNRSKCD">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="4"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="SUMINS">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
         *               &lt;totalDigits value="15"/>
         *               &lt;minInclusive value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
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
            "znrskcd",
            "sumins"
        })
        public static class OWNRSKAMNT {

            @XmlElement(name = "ZNRSKCD", required = true)
            protected String znrskcd;
            @XmlElement(name = "SUMINS", required = true)
            protected BigInteger sumins;

            /**
             * 获取znrskcd属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZNRSKCD() {
                return znrskcd;
            }

            /**
             * 设置znrskcd属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZNRSKCD(String value) {
                this.znrskcd = value;
            }

            /**
             * 获取sumins属性的值。
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getSUMINS() {
                return sumins;
            }

            /**
             * 设置sumins属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setSUMINS(BigInteger value) {
                this.sumins = value;
            }

        }

    }

}
