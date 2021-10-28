//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2021.07.26 시간 11:08:13 AM KST 
//


package com.llynx.cmn.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ApplicationType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="ApplicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="AvayaNotify">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="textId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AvayaAgent">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="VDN" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="textId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="agentScript" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="agentScriptName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="prefAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="strictAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="campaignCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="generalCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="canCancelCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Custom">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="application" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="VDN" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="externalClass" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="agentScript" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="agentScriptName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="prefAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="strictAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="campaignCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="generalCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="canCancelCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="url">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ContactAttribute" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CustomSMS">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="application" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CustomMail">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="application" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationType", propOrder = {
    "avayaNotify",
    "avayaAgent",
    "custom",
    "url",
    "customSMS",
    "customMail"
})
public class ApplicationType {

    @XmlElement(name = "AvayaNotify")
    protected ApplicationType.AvayaNotify avayaNotify;
    @XmlElement(name = "AvayaAgent")
    protected ApplicationType.AvayaAgent avayaAgent;
    @XmlElement(name = "Custom")
    protected ApplicationType.Custom custom;
    protected ApplicationType.Url url;
    @XmlElement(name = "CustomSMS")
    protected ApplicationType.CustomSMS customSMS;
    @XmlElement(name = "CustomMail")
    protected ApplicationType.CustomMail customMail;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "foundError")
    protected Boolean foundError;
    @XmlAttribute(name = "description")
    protected String description;

    /**
     * avayaNotify 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType.AvayaNotify }
     *     
     */
    public ApplicationType.AvayaNotify getAvayaNotify() {
        return avayaNotify;
    }

    /**
     * avayaNotify 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType.AvayaNotify }
     *     
     */
    public void setAvayaNotify(ApplicationType.AvayaNotify value) {
        this.avayaNotify = value;
    }

    /**
     * avayaAgent 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType.AvayaAgent }
     *     
     */
    public ApplicationType.AvayaAgent getAvayaAgent() {
        return avayaAgent;
    }

    /**
     * avayaAgent 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType.AvayaAgent }
     *     
     */
    public void setAvayaAgent(ApplicationType.AvayaAgent value) {
        this.avayaAgent = value;
    }

    /**
     * custom 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType.Custom }
     *     
     */
    public ApplicationType.Custom getCustom() {
        return custom;
    }

    /**
     * custom 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType.Custom }
     *     
     */
    public void setCustom(ApplicationType.Custom value) {
        this.custom = value;
    }

    /**
     * url 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType.Url }
     *     
     */
    public ApplicationType.Url getUrl() {
        return url;
    }

    /**
     * url 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType.Url }
     *     
     */
    public void setUrl(ApplicationType.Url value) {
        this.url = value;
    }

    /**
     * customSMS 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType.CustomSMS }
     *     
     */
    public ApplicationType.CustomSMS getCustomSMS() {
        return customSMS;
    }

    /**
     * customSMS 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType.CustomSMS }
     *     
     */
    public void setCustomSMS(ApplicationType.CustomSMS value) {
        this.customSMS = value;
    }

    /**
     * customMail 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType.CustomMail }
     *     
     */
    public ApplicationType.CustomMail getCustomMail() {
        return customMail;
    }

    /**
     * customMail 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType.CustomMail }
     *     
     */
    public void setCustomMail(ApplicationType.CustomMail value) {
        this.customMail = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * foundError 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFoundError() {
        return foundError;
    }

    /**
     * foundError 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFoundError(Boolean value) {
        this.foundError = value;
    }

    /**
     * description 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * description 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="VDN" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="textId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="agentScript" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="agentScriptName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="prefAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="strictAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="campaignCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="generalCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="canCancelCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AvayaAgent {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "VDN")
        protected String vdn;
        @XmlAttribute(name = "textId")
        protected String textId;
        @XmlAttribute(name = "description")
        protected String description;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;
        @XmlAttribute(name = "agentScript")
        protected String agentScript;
        @XmlAttribute(name = "agentScriptName")
        protected String agentScriptName;
        @XmlAttribute(name = "prefAgentCallback")
        protected String prefAgentCallback;
        @XmlAttribute(name = "strictAgentCallback")
        protected String strictAgentCallback;
        @XmlAttribute(name = "campaignCallBack")
        protected String campaignCallBack;
        @XmlAttribute(name = "generalCallBack")
        protected String generalCallBack;
        @XmlAttribute(name = "canCancelCallback")
        protected String canCancelCallback;

        /**
         * name 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * name 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * vdn 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVDN() {
            return vdn;
        }

        /**
         * vdn 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVDN(String value) {
            this.vdn = value;
        }

        /**
         * textId 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTextId() {
            return textId;
        }

        /**
         * textId 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTextId(String value) {
            this.textId = value;
        }

        /**
         * description 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * description 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * foundError 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFoundError() {
            return foundError;
        }

        /**
         * foundError 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFoundError(Boolean value) {
            this.foundError = value;
        }

        /**
         * agentScript 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgentScript() {
            return agentScript;
        }

        /**
         * agentScript 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgentScript(String value) {
            this.agentScript = value;
        }

        /**
         * agentScriptName 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgentScriptName() {
            return agentScriptName;
        }

        /**
         * agentScriptName 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgentScriptName(String value) {
            this.agentScriptName = value;
        }

        /**
         * prefAgentCallback 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrefAgentCallback() {
            return prefAgentCallback;
        }

        /**
         * prefAgentCallback 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrefAgentCallback(String value) {
            this.prefAgentCallback = value;
        }

        /**
         * strictAgentCallback 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrictAgentCallback() {
            return strictAgentCallback;
        }

        /**
         * strictAgentCallback 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrictAgentCallback(String value) {
            this.strictAgentCallback = value;
        }

        /**
         * campaignCallBack 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCampaignCallBack() {
            return campaignCallBack;
        }

        /**
         * campaignCallBack 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCampaignCallBack(String value) {
            this.campaignCallBack = value;
        }

        /**
         * generalCallBack 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGeneralCallBack() {
            return generalCallBack;
        }

        /**
         * generalCallBack 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGeneralCallBack(String value) {
            this.generalCallBack = value;
        }

        /**
         * canCancelCallback 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCanCancelCallback() {
            return canCancelCallback;
        }

        /**
         * canCancelCallback 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCanCancelCallback(String value) {
            this.canCancelCallback = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="textId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AvayaNotify {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "textId", required = true)
        protected String textId;
        @XmlAttribute(name = "description")
        protected String description;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;

        /**
         * name 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * name 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * textId 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTextId() {
            return textId;
        }

        /**
         * textId 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTextId(String value) {
            this.textId = value;
        }

        /**
         * description 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * description 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * foundError 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFoundError() {
            return foundError;
        }

        /**
         * foundError 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFoundError(Boolean value) {
            this.foundError = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="application" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="VDN" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="externalClass" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="agentScript" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="agentScriptName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="prefAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="strictAgentCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="campaignCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="generalCallBack" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="canCancelCallback" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Custom {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "application", required = true)
        protected String application;
        @XmlAttribute(name = "VDN")
        protected String vdn;
        @XmlAttribute(name = "externalClass")
        protected Boolean externalClass;
        @XmlAttribute(name = "description")
        protected String description;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;
        @XmlAttribute(name = "agentScript")
        protected String agentScript;
        @XmlAttribute(name = "agentScriptName")
        protected String agentScriptName;
        @XmlAttribute(name = "prefAgentCallback")
        protected String prefAgentCallback;
        @XmlAttribute(name = "strictAgentCallback")
        protected String strictAgentCallback;
        @XmlAttribute(name = "campaignCallBack")
        protected String campaignCallBack;
        @XmlAttribute(name = "generalCallBack")
        protected String generalCallBack;
        @XmlAttribute(name = "canCancelCallback")
        protected String canCancelCallback;

        /**
         * name 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * name 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * application 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplication() {
            return application;
        }

        /**
         * application 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplication(String value) {
            this.application = value;
        }

        /**
         * vdn 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVDN() {
            return vdn;
        }

        /**
         * vdn 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVDN(String value) {
            this.vdn = value;
        }

        /**
         * externalClass 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isExternalClass() {
            return externalClass;
        }

        /**
         * externalClass 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setExternalClass(Boolean value) {
            this.externalClass = value;
        }

        /**
         * description 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * description 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * foundError 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFoundError() {
            return foundError;
        }

        /**
         * foundError 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFoundError(Boolean value) {
            this.foundError = value;
        }

        /**
         * agentScript 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgentScript() {
            return agentScript;
        }

        /**
         * agentScript 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgentScript(String value) {
            this.agentScript = value;
        }

        /**
         * agentScriptName 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAgentScriptName() {
            return agentScriptName;
        }

        /**
         * agentScriptName 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAgentScriptName(String value) {
            this.agentScriptName = value;
        }

        /**
         * prefAgentCallback 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrefAgentCallback() {
            return prefAgentCallback;
        }

        /**
         * prefAgentCallback 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrefAgentCallback(String value) {
            this.prefAgentCallback = value;
        }

        /**
         * strictAgentCallback 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStrictAgentCallback() {
            return strictAgentCallback;
        }

        /**
         * strictAgentCallback 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStrictAgentCallback(String value) {
            this.strictAgentCallback = value;
        }

        /**
         * campaignCallBack 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCampaignCallBack() {
            return campaignCallBack;
        }

        /**
         * campaignCallBack 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCampaignCallBack(String value) {
            this.campaignCallBack = value;
        }

        /**
         * generalCallBack 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGeneralCallBack() {
            return generalCallBack;
        }

        /**
         * generalCallBack 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGeneralCallBack(String value) {
            this.generalCallBack = value;
        }

        /**
         * canCancelCallback 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCanCancelCallback() {
            return canCancelCallback;
        }

        /**
         * canCancelCallback 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCanCancelCallback(String value) {
            this.canCancelCallback = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="application" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CustomMail {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "description")
        protected String description;
        @XmlAttribute(name = "application")
        protected String application;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;

        /**
         * name 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * name 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * description 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * description 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * application 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplication() {
            return application;
        }

        /**
         * application 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplication(String value) {
            this.application = value;
        }

        /**
         * foundError 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFoundError() {
            return foundError;
        }

        /**
         * foundError 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFoundError(Boolean value) {
            this.foundError = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="application" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CustomSMS {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "description")
        protected String description;
        @XmlAttribute(name = "application")
        protected String application;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;

        /**
         * name 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * name 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * description 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * description 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * application 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getApplication() {
            return application;
        }

        /**
         * application 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setApplication(String value) {
            this.application = value;
        }

        /**
         * foundError 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFoundError() {
            return foundError;
        }

        /**
         * foundError 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFoundError(Boolean value) {
            this.foundError = value;
        }

    }


    /**
     * <p>anonymous complex type에 대한 Java 클래스입니다.
     * 
     * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ContactAttribute" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class Url {

        @XmlElementRef(name = "ContactAttribute", type = JAXBElement.class, required = false)
        @XmlMixed
        protected List<Serializable> content;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;
        @XmlAttribute(name = "description")
        protected String description;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * {@link String }
         * 
         * 
         */
        public List<Serializable> getContent() {
            if (content == null) {
                content = new ArrayList<Serializable>();
            }
            return this.content;
        }

        /**
         * name 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * name 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * foundError 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isFoundError() {
            return foundError;
        }

        /**
         * foundError 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setFoundError(Boolean value) {
            this.foundError = value;
        }

        /**
         * description 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * description 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

    }

}
