//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.8-b130911.1802 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2021.07.26 시간 11:08:13 AM KST 
//


package com.llynx.cmn.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>resultType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="resultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Application" type="{http://www.avaya.com/ContactStrategy}ApplicationType" minOccurs="0"/>
 *         &lt;element name="retry" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="address" type="{http://www.avaya.com/ContactStrategy}AddressType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="addressLooping" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="interval" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="failstate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                 &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Agent" type="{http://www.avaya.com/ContactStrategy}AgentType" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="allOtherResults" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nextState" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nextStateAfter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultType", propOrder = {
    "application",
    "retry",
    "agent"
})
public class ResultType {

    @XmlElement(name = "Application")
    protected ApplicationType application;
    protected ResultType.Retry retry;
    @XmlElement(name = "Agent")
    protected AgentType agent;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "allOtherResults")
    protected Boolean allOtherResults;
    @XmlAttribute(name = "value", required = true)
    protected String value;
    @XmlAttribute(name = "nextState", required = true)
    protected String nextState;
    @XmlAttribute(name = "nextStateAfter")
    protected String nextStateAfter;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "foundError")
    protected Boolean foundError;
    @XmlAttribute(name = "waitTimeout")
    protected Integer waitTimeout;
    @XmlAttribute(name = "waitTimeoutCC")
    protected String waitTimeoutCC;

    /**
     * application 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationType }
     *     
     */
    public ApplicationType getApplication() {
        return application;
    }

    /**
     * application 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationType }
     *     
     */
    public void setApplication(ApplicationType value) {
        this.application = value;
    }

    /**
     * retry 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ResultType.Retry }
     *     
     */
    public ResultType.Retry getRetry() {
        return retry;
    }

    /**
     * retry 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType.Retry }
     *     
     */
    public void setRetry(ResultType.Retry value) {
        this.retry = value;
    }

    /**
     * agent 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AgentType }
     *     
     */
    public AgentType getAgent() {
        return agent;
    }

    /**
     * agent 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AgentType }
     *     
     */
    public void setAgent(AgentType value) {
        this.agent = value;
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
     * allOtherResults 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllOtherResults() {
        return allOtherResults;
    }

    /**
     * allOtherResults 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllOtherResults(Boolean value) {
        this.allOtherResults = value;
    }

    /**
     * value 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * value 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * nextState 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextState() {
        return nextState;
    }

    /**
     * nextState 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextState(String value) {
        this.nextState = value;
    }

    /**
     * nextStateAfter 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextStateAfter() {
        return nextStateAfter;
    }

    /**
     * nextStateAfter 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextStateAfter(String value) {
        this.nextStateAfter = value;
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
     * waitTimeout 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWaitTimeout() {
        return waitTimeout;
    }

    /**
     * waitTimeout 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWaitTimeout(Integer value) {
        this.waitTimeout = value;
    }

    /**
     * waitTimeoutCC 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitTimeoutCC() {
        return waitTimeoutCC;
    }

    /**
     * waitTimeoutCC 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitTimeoutCC(String value) {
        this.waitTimeoutCC = value;
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
     *         &lt;element name="address" type="{http://www.avaya.com/ContactStrategy}AddressType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="addressLooping" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="count" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="interval" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="failstate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *       &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "address"
    })
    public static class Retry {

        protected List<AddressType> address;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "addressLooping")
        protected String addressLooping;
        @XmlAttribute(name = "count", required = true)
        protected int count;
        @XmlAttribute(name = "interval", required = true)
        protected String interval;
        @XmlAttribute(name = "failstate", required = true)
        protected String failstate;
        @XmlAttribute(name = "description")
        protected String description;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;
        @XmlAttribute(name = "waitTimeout")
        protected Integer waitTimeout;
        @XmlAttribute(name = "waitTimeoutCC")
        protected String waitTimeoutCC;

        /**
         * Gets the value of the address property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the address property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AddressType }
         * 
         * 
         */
        public List<AddressType> getAddress() {
            if (address == null) {
                address = new ArrayList<AddressType>();
            }
            return this.address;
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
         * addressLooping 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddressLooping() {
            return addressLooping;
        }

        /**
         * addressLooping 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddressLooping(String value) {
            this.addressLooping = value;
        }

        /**
         * count 속성의 값을 가져옵니다.
         * 
         */
        public int getCount() {
            return count;
        }

        /**
         * count 속성의 값을 설정합니다.
         * 
         */
        public void setCount(int value) {
            this.count = value;
        }

        /**
         * interval 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInterval() {
            return interval;
        }

        /**
         * interval 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInterval(String value) {
            this.interval = value;
        }

        /**
         * failstate 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFailstate() {
            return failstate;
        }

        /**
         * failstate 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFailstate(String value) {
            this.failstate = value;
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
         * waitTimeout 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getWaitTimeout() {
            return waitTimeout;
        }

        /**
         * waitTimeout 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setWaitTimeout(Integer value) {
            this.waitTimeout = value;
        }

        /**
         * waitTimeoutCC 속성의 값을 가져옵니다.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getWaitTimeoutCC() {
            return waitTimeoutCC;
        }

        /**
         * waitTimeoutCC 속성의 값을 설정합니다.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setWaitTimeoutCC(String value) {
            this.waitTimeoutCC = value;
        }

    }

}
