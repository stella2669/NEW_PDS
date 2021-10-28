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
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="NotificationText" type="{http://www.avaya.com/ContactStrategy}NotificationTextType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Handler" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="action" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="restrictions" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="override" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="global_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="restrict" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;choice>
 *                                                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                   &lt;sequence>
 *                                                     &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                     &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                   &lt;/sequence>
 *                                                   &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;/choice>
 *                                                 &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="attribute" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="type" use="required">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;enumeration value="permanent"/>
 *                                                     &lt;enumeration value="temporary"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                               &lt;attribute name="attributeType">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;enumeration value="contact"/>
 *                                                     &lt;enumeration value="system"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="operator" type="{http://www.avaya.com/ContactStrategy}operatorType" />
 *                                               &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                               &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="externalClass" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="address" type="{http://www.avaya.com/ContactStrategy}AddressType" maxOccurs="unbounded"/>
 *                             &lt;element name="MonitorVdn" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ani" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="condition" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="operator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="val" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="dispName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                               &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="senderAddressAttribute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="attachment" maxOccurs="10" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Application" type="{http://www.avaya.com/ContactStrategy}ApplicationType" minOccurs="0"/>
 *                             &lt;element name="resultprocessors">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="result" type="{http://www.avaya.com/ContactStrategy}resultType" maxOccurs="unbounded" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="customProcessor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                     &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="type" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="call"/>
 *                                 &lt;enumeration value="sms"/>
 *                                 &lt;enumeration value="mail"/>
 *                                 &lt;enumeration value="custom"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="fromDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="fromAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="timeout" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="guardTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="minContactTime" type="{http://www.w3.org/2001/XMLSchema}time" />
 *                           &lt;attribute name="maxContactTime" type="{http://www.w3.org/2001/XMLSchema}time" />
 *                           &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="EnhancedCCA">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="ON"/>
 *                                 &lt;enumeration value="OFF"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="OnMediaServerFailure">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="retry"/>
 *                                 &lt;enumeration value="no_retry"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="DriverApp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="CallPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ECRSetting" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="initialHitRate" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="minimumHitRate" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="desiredServiceLevel" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                           &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="smsPace" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="mailPace" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="timeUnit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="outboundSkill" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="outboundSkillName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="NuisanceApp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="HoldApp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="callPace" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="overDialRatio" type="{http://www.w3.org/2001/XMLSchema}float" />
 *                           &lt;attribute name="isTimedPreview" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="agentBlending" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="allocationType" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="minAgents" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="maxAgents" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="defaultCompCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="numOfACWExtns" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="acwTime" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="minPorts" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="maxPorts" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="replyTo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="skillToMonitorName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="algorithmParameter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ewtLevels" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="desiredValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="initialPace" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="paceInterval" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="incrementStep" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="maxPace" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="SMSPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="MailPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="NailerApp" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="skillToMonitor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="canCancelPreview" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="SMSApplication" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="MailApplication" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="minPace" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="calcType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="BackgroundAMD">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="ON"/>
 *                                 &lt;enumeration value="OFF"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="AMDAction" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="SilentCallDetection">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;enumeration value="ON"/>
 *                                 &lt;enumeration value="OFF"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="selector">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="conditions" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="case" maxOccurs="unbounded">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="operator">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;enumeration value="Equals"/>
 *                                                     &lt;enumeration value="Greater Than"/>
 *                                                     &lt;enumeration value="Less Than"/>
 *                                                     &lt;enumeration value="Between"/>
 *                                                     &lt;enumeration value="Starts With"/>
 *                                                     &lt;enumeration value="Contains"/>
 *                                                     &lt;enumeration value="Is Null"/>
 *                                                     &lt;enumeration value="Is Not Null"/>
 *                                                     &lt;enumeration value="One Of"/>
 *                                                     &lt;enumeration value="Not Equal"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                               &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                               &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="type">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;enumeration value="System"/>
 *                                           &lt;enumeration value="Contact"/>
 *                                           &lt;enumeration value="Custom"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="className" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="defaultNextState" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="state" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
    "notificationText",
    "handler"
})
@XmlRootElement(name = "AvayaPIMContactStrategy")
public class AvayaPIMContactStrategy {

    @XmlElement(name = "NotificationText")
    protected List<NotificationTextType> notificationText;
    @XmlElement(name = "Handler", required = true)
    protected List<AvayaPIMContactStrategy.Handler> handler;

    /**
     * Gets the value of the notificationText property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationText property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationText().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationTextType }
     *
     *
     */
    public List<NotificationTextType> getNotificationText() {
        if (notificationText == null) {
            notificationText = new ArrayList<NotificationTextType>();
        }
        return this.notificationText;
    }

    /**
     * Gets the value of the handler property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the handler property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHandler().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AvayaPIMContactStrategy.Handler }
     *
     *
     */
    public List<AvayaPIMContactStrategy.Handler> getHandler() {
        if (handler == null) {
            handler = new ArrayList<AvayaPIMContactStrategy.Handler>();
        }
        return this.handler;
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
     *       &lt;choice>
     *         &lt;element name="action" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="restrictions" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="override" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="global_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="restrict" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;choice>
     *                                         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                         &lt;sequence>
     *                                           &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                           &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                         &lt;/sequence>
     *                                         &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;/choice>
     *                                       &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="attribute" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="type" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;enumeration value="permanent"/>
     *                                           &lt;enumeration value="temporary"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                                     &lt;attribute name="attributeType">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;enumeration value="contact"/>
     *                                           &lt;enumeration value="system"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="operator" type="{http://www.avaya.com/ContactStrategy}operatorType" />
     *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                                     &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="externalClass" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="address" type="{http://www.avaya.com/ContactStrategy}AddressType" maxOccurs="unbounded"/>
     *                   &lt;element name="MonitorVdn" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ani" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="condition" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="operator" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="val" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="dispName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="senderAddressAttribute" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="attachment" maxOccurs="10" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Application" type="{http://www.avaya.com/ContactStrategy}ApplicationType" minOccurs="0"/>
     *                   &lt;element name="resultprocessors">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="result" type="{http://www.avaya.com/ContactStrategy}resultType" maxOccurs="unbounded" minOccurs="0"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="customProcessor" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                           &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="type" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="call"/>
     *                       &lt;enumeration value="sms"/>
     *                       &lt;enumeration value="mail"/>
     *                       &lt;enumeration value="custom"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="fromDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="fromAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="timeout" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="guardTime" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="minContactTime" type="{http://www.w3.org/2001/XMLSchema}time" />
     *                 &lt;attribute name="maxContactTime" type="{http://www.w3.org/2001/XMLSchema}time" />
     *                 &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="EnhancedCCA">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="ON"/>
     *                       &lt;enumeration value="OFF"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="OnMediaServerFailure">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="retry"/>
     *                       &lt;enumeration value="no_retry"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="DriverApp" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="CallPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ECRSetting" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="initialHitRate" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="minimumHitRate" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="desiredServiceLevel" type="{http://www.w3.org/2001/XMLSchema}float" />
     *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="smsPace" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="mailPace" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="timeUnit" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="outboundSkill" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="outboundSkillName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="NuisanceApp" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="HoldApp" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="callPace" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="overDialRatio" type="{http://www.w3.org/2001/XMLSchema}float" />
     *                 &lt;attribute name="isTimedPreview" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="agentBlending" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="allocationType" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="minAgents" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="maxAgents" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="defaultCompCode" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="numOfACWExtns" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="acwTime" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="minPorts" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="maxPorts" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="replyTo" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="skillToMonitorName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="algorithmParameter" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ewtLevels" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="desiredValue" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="initialPace" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="paceInterval" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="incrementStep" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="maxPace" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="SMSPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="MailPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="NailerApp" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="skillToMonitor" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="canCancelPreview" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="SMSApplication" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="MailApplication" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="minPace" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="calcType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="BackgroundAMD">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="ON"/>
     *                       &lt;enumeration value="OFF"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="AMDAction" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="SilentCallDetection">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;enumeration value="ON"/>
     *                       &lt;enumeration value="OFF"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="selector">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="conditions" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="case" maxOccurs="unbounded">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="operator">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;enumeration value="Equals"/>
     *                                           &lt;enumeration value="Greater Than"/>
     *                                           &lt;enumeration value="Less Than"/>
     *                                           &lt;enumeration value="Between"/>
     *                                           &lt;enumeration value="Starts With"/>
     *                                           &lt;enumeration value="Contains"/>
     *                                           &lt;enumeration value="Is Null"/>
     *                                           &lt;enumeration value="Is Not Null"/>
     *                                           &lt;enumeration value="One Of"/>
     *                                           &lt;enumeration value="Not Equal"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                                     &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                                     &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="type">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;enumeration value="System"/>
     *                                 &lt;enumeration value="Contact"/>
     *                                 &lt;enumeration value="Custom"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="className" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="defaultNextState" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="state" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    @XmlType(name = "", propOrder = {
        "action",
        "selector"
    })
    public static class Handler {

        protected List<AvayaPIMContactStrategy.Handler.Action> action;
        protected AvayaPIMContactStrategy.Handler.Selector selector;
        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "state", required = true)
        protected String state;
        @XmlAttribute(name = "description")
        protected String description;
        @XmlAttribute(name = "foundError")
        protected Boolean foundError;

        /**
         * Gets the value of the action property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the action property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAction().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AvayaPIMContactStrategy.Handler.Action }
         *
         *
         */
        public List<AvayaPIMContactStrategy.Handler.Action> getAction() {
            if (action == null) {
                action = new ArrayList<AvayaPIMContactStrategy.Handler.Action>();
            }
            return this.action;
        }

        /**
         * selector 속성의 값을 가져옵니다.
         *
         * @return
         *     possible object is
         *     {@link AvayaPIMContactStrategy.Handler.Selector }
         *
         */
        public AvayaPIMContactStrategy.Handler.Selector getSelector() {
            return selector;
        }

        /**
         * selector 속성의 값을 설정합니다.
         *
         * @param value
         *     allowed object is
         *     {@link AvayaPIMContactStrategy.Handler.Selector }
         *
         */
        public void setSelector(AvayaPIMContactStrategy.Handler.Selector value) {
            this.selector = value;
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
         * state 속성의 값을 가져옵니다.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getState() {
            return state;
        }

        /**
         * state 속성의 값을 설정합니다.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setState(String value) {
            this.state = value;
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
         * <p>anonymous complex type에 대한 Java 클래스입니다.
         *
         * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="restrictions" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="override" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
         *                           &lt;/sequence>
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="global_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="restrict" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;choice>
         *                               &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                               &lt;sequence>
         *                                 &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                 &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                               &lt;/sequence>
         *                               &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;/choice>
         *                             &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
         *                           &lt;/sequence>
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="attribute" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="type" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;enumeration value="permanent"/>
         *                                 &lt;enumeration value="temporary"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                           &lt;attribute name="attributeType">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;enumeration value="contact"/>
         *                                 &lt;enumeration value="system"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="operator" type="{http://www.avaya.com/ContactStrategy}operatorType" />
         *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                           &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="externalClass" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="address" type="{http://www.avaya.com/ContactStrategy}AddressType" maxOccurs="unbounded"/>
         *         &lt;element name="MonitorVdn" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ani" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="condition" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="operator" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="val" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="dispName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="senderAddressAttribute" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="attachment" maxOccurs="10" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Application" type="{http://www.avaya.com/ContactStrategy}ApplicationType" minOccurs="0"/>
         *         &lt;element name="resultprocessors">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="result" type="{http://www.avaya.com/ContactStrategy}resultType" maxOccurs="unbounded" minOccurs="0"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="customProcessor" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                 &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="type" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="call"/>
         *             &lt;enumeration value="sms"/>
         *             &lt;enumeration value="mail"/>
         *             &lt;enumeration value="custom"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="fromDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="fromAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="timeout" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="guardTime" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="minContactTime" type="{http://www.w3.org/2001/XMLSchema}time" />
         *       &lt;attribute name="maxContactTime" type="{http://www.w3.org/2001/XMLSchema}time" />
         *       &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="EnhancedCCA">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="ON"/>
         *             &lt;enumeration value="OFF"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="OnMediaServerFailure">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="retry"/>
         *             &lt;enumeration value="no_retry"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="DriverApp" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="CallPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ECRSetting" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="initialHitRate" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="minimumHitRate" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="desiredServiceLevel" type="{http://www.w3.org/2001/XMLSchema}float" />
         *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="smsPace" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="mailPace" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="timeUnit" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="outboundSkill" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="outboundSkillName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="NuisanceApp" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="HoldApp" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="callPace" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="overDialRatio" type="{http://www.w3.org/2001/XMLSchema}float" />
         *       &lt;attribute name="isTimedPreview" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="agentBlending" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="allocationType" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="minAgents" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="maxAgents" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="defaultCompCode" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="numOfACWExtns" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="acwTime" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="minPorts" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="maxPorts" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="replyTo" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="skillToMonitorName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="algorithmParameter" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ewtLevels" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="desiredValue" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="initialPace" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="paceInterval" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="incrementStep" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="maxPace" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="SMSPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="MailPacingType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="NailerApp" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="skillToMonitor" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="canCancelPreview" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="SMSApplication" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="MailApplication" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="minPace" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="calcType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="BackgroundAMD">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="ON"/>
         *             &lt;enumeration value="OFF"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="AMDAction" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="SilentCallDetection">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="ON"/>
         *             &lt;enumeration value="OFF"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "restrictions",
            "address",
            "monitorVdn",
            "ani",
            "attachment",
            "application",
            "resultprocessors"
        })
        public static class Action {

            protected AvayaPIMContactStrategy.Handler.Action.Restrictions restrictions;
            @XmlElement(required = true)
            protected List<AddressType> address;
            @XmlElement(name = "MonitorVdn")
            protected List<AvayaPIMContactStrategy.Handler.Action.MonitorVdn> monitorVdn;
            protected AvayaPIMContactStrategy.Handler.Action.Ani ani;
            protected List<AvayaPIMContactStrategy.Handler.Action.Attachment> attachment;
            @XmlElement(name = "Application")
            protected ApplicationType application;
            @XmlElement(required = true)
            protected AvayaPIMContactStrategy.Handler.Action.Resultprocessors resultprocessors;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "type", required = true)
            protected String type;
            @XmlAttribute(name = "fromDisplayName")
            protected String fromDisplayName;
            @XmlAttribute(name = "fromAddress")
            protected String fromAddress;
            @XmlAttribute(name = "timeout")
            protected String timeout;
            @XmlAttribute(name = "guardTime")
            protected String guardTime;
            @XmlAttribute(name = "minContactTime")
            @XmlSchemaType(name = "time")
            protected XMLGregorianCalendar minContactTime;
            @XmlAttribute(name = "maxContactTime")
            @XmlSchemaType(name = "time")
            protected XMLGregorianCalendar maxContactTime;
            @XmlAttribute(name = "recheckInterval")
            protected Integer recheckInterval;
            @XmlAttribute(name = "EnhancedCCA")
            protected String enhancedCCA;
            @XmlAttribute(name = "OnMediaServerFailure")
            protected String onMediaServerFailure;
            @XmlAttribute(name = "DriverApp")
            protected String driverApp;
            @XmlAttribute(name = "description")
            protected String description;
            @XmlAttribute(name = "foundError")
            protected Boolean foundError;
            @XmlAttribute(name = "CallPacingType")
            protected String callPacingType;
            @XmlAttribute(name = "ECRSetting")
            protected String ecrSetting;
            @XmlAttribute(name = "initialHitRate")
            protected Integer initialHitRate;
            @XmlAttribute(name = "minimumHitRate")
            protected Integer minimumHitRate;
            @XmlAttribute(name = "desiredServiceLevel")
            protected Float desiredServiceLevel;
            @XmlAttribute(name = "value")
            protected Integer value;
            @XmlAttribute(name = "smsPace")
            protected Integer smsPace;
            @XmlAttribute(name = "mailPace")
            protected Integer mailPace;
            @XmlAttribute(name = "timeUnit")
            protected String timeUnit;
            @XmlAttribute(name = "outboundSkill")
            protected String outboundSkill;
            @XmlAttribute(name = "outboundSkillName")
            protected String outboundSkillName;
            @XmlAttribute(name = "NuisanceApp")
            protected String nuisanceApp;
            @XmlAttribute(name = "HoldApp")
            protected String holdApp;
            @XmlAttribute(name = "callPace")
            protected Integer callPace;
            @XmlAttribute(name = "overDialRatio")
            protected Float overDialRatio;
            @XmlAttribute(name = "isTimedPreview")
            protected String isTimedPreview;
            @XmlAttribute(name = "agentBlending")
            protected String agentBlending;
            @XmlAttribute(name = "priority")
            protected Integer priority;
            @XmlAttribute(name = "allocationType")
            protected Integer allocationType;
            @XmlAttribute(name = "minAgents")
            protected Integer minAgents;
            @XmlAttribute(name = "maxAgents")
            protected Integer maxAgents;
            @XmlAttribute(name = "defaultCompCode")
            protected String defaultCompCode;
            @XmlAttribute(name = "numOfACWExtns")
            protected Integer numOfACWExtns;
            @XmlAttribute(name = "acwTime")
            protected Integer acwTime;
            @XmlAttribute(name = "minPorts")
            protected Integer minPorts;
            @XmlAttribute(name = "maxPorts")
            protected Integer maxPorts;
            @XmlAttribute(name = "replyTo")
            protected String replyTo;
            @XmlAttribute(name = "skillToMonitorName")
            protected String skillToMonitorName;
            @XmlAttribute(name = "algorithmParameter")
            protected String algorithmParameter;
            @XmlAttribute(name = "ewtLevels")
            protected String ewtLevels;
            @XmlAttribute(name = "desiredValue")
            protected String desiredValue;
            @XmlAttribute(name = "initialPace")
            protected String initialPace;
            @XmlAttribute(name = "paceInterval")
            protected String paceInterval;
            @XmlAttribute(name = "incrementStep")
            protected String incrementStep;
            @XmlAttribute(name = "maxPace")
            protected String maxPace;
            @XmlAttribute(name = "SMSPacingType")
            protected String smsPacingType;
            @XmlAttribute(name = "MailPacingType")
            protected String mailPacingType;
            @XmlAttribute(name = "NailerApp")
            protected String nailerApp;
            @XmlAttribute(name = "skillToMonitor")
            protected String skillToMonitor;
            @XmlAttribute(name = "canCancelPreview")
            protected String canCancelPreview;
            @XmlAttribute(name = "SMSApplication")
            protected String smsApplication;
            @XmlAttribute(name = "MailApplication")
            protected String mailApplication;
            @XmlAttribute(name = "minPace")
            protected String minPace;
            @XmlAttribute(name = "calcType")
            protected String calcType;
            @XmlAttribute(name = "BackgroundAMD")
            protected String backgroundAMD;
            @XmlAttribute(name = "AMDAction")
            protected Integer amdAction;
            @XmlAttribute(name = "SilentCallDetection")
            protected String silentCallDetection;

            /**
             * restrictions 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link AvayaPIMContactStrategy.Handler.Action.Restrictions }
             *
             */
            public AvayaPIMContactStrategy.Handler.Action.Restrictions getRestrictions() {
                return restrictions;
            }

            /**
             * restrictions 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link AvayaPIMContactStrategy.Handler.Action.Restrictions }
             *
             */
            public void setRestrictions(AvayaPIMContactStrategy.Handler.Action.Restrictions value) {
                this.restrictions = value;
            }

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
             * Gets the value of the monitorVdn property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the monitorVdn property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMonitorVdn().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AvayaPIMContactStrategy.Handler.Action.MonitorVdn }
             *
             *
             */
            public List<AvayaPIMContactStrategy.Handler.Action.MonitorVdn> getMonitorVdn() {
                if (monitorVdn == null) {
                    monitorVdn = new ArrayList<AvayaPIMContactStrategy.Handler.Action.MonitorVdn>();
                }
                return this.monitorVdn;
            }

            /**
             * ani 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link AvayaPIMContactStrategy.Handler.Action.Ani }
             *
             */
            public AvayaPIMContactStrategy.Handler.Action.Ani getAni() {
                return ani;
            }

            /**
             * ani 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link AvayaPIMContactStrategy.Handler.Action.Ani }
             *
             */
            public void setAni(AvayaPIMContactStrategy.Handler.Action.Ani value) {
                this.ani = value;
            }

            /**
             * Gets the value of the attachment property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the attachment property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAttachment().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AvayaPIMContactStrategy.Handler.Action.Attachment }
             *
             *
             */
            public List<AvayaPIMContactStrategy.Handler.Action.Attachment> getAttachment() {
                if (attachment == null) {
                    attachment = new ArrayList<AvayaPIMContactStrategy.Handler.Action.Attachment>();
                }
                return this.attachment;
            }

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
             * resultprocessors 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link AvayaPIMContactStrategy.Handler.Action.Resultprocessors }
             *
             */
            public AvayaPIMContactStrategy.Handler.Action.Resultprocessors getResultprocessors() {
                return resultprocessors;
            }

            /**
             * resultprocessors 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link AvayaPIMContactStrategy.Handler.Action.Resultprocessors }
             *
             */
            public void setResultprocessors(AvayaPIMContactStrategy.Handler.Action.Resultprocessors value) {
                this.resultprocessors = value;
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
             * type 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getType() {
                return type;
            }

            /**
             * type 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setType(String value) {
                this.type = value;
            }

            /**
             * fromDisplayName 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getFromDisplayName() {
                return fromDisplayName;
            }

            /**
             * fromDisplayName 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setFromDisplayName(String value) {
                this.fromDisplayName = value;
            }

            /**
             * fromAddress 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getFromAddress() {
                return fromAddress;
            }

            /**
             * fromAddress 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setFromAddress(String value) {
                this.fromAddress = value;
            }

            /**
             * timeout 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getTimeout() {
                return timeout;
            }

            /**
             * timeout 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setTimeout(String value) {
                this.timeout = value;
            }

            /**
             * guardTime 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getGuardTime() {
                return guardTime;
            }

            /**
             * guardTime 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setGuardTime(String value) {
                this.guardTime = value;
            }

            /**
             * minContactTime 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getMinContactTime() {
                return minContactTime;
            }

            /**
             * minContactTime 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setMinContactTime(XMLGregorianCalendar value) {
                this.minContactTime = value;
            }

            /**
             * maxContactTime 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getMaxContactTime() {
                return maxContactTime;
            }

            /**
             * maxContactTime 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setMaxContactTime(XMLGregorianCalendar value) {
                this.maxContactTime = value;
            }

            /**
             * recheckInterval 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getRecheckInterval() {
                return recheckInterval;
            }

            /**
             * recheckInterval 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setRecheckInterval(Integer value) {
                this.recheckInterval = value;
            }

            /**
             * enhancedCCA 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getEnhancedCCA() {
                return enhancedCCA;
            }

            /**
             * enhancedCCA 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setEnhancedCCA(String value) {
                this.enhancedCCA = value;
            }

            /**
             * onMediaServerFailure 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getOnMediaServerFailure() {
                return onMediaServerFailure;
            }

            /**
             * onMediaServerFailure 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setOnMediaServerFailure(String value) {
                this.onMediaServerFailure = value;
            }

            /**
             * driverApp 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getDriverApp() {
                return driverApp;
            }

            /**
             * driverApp 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setDriverApp(String value) {
                this.driverApp = value;
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
             * callPacingType 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCallPacingType() {
                return callPacingType;
            }

            /**
             * callPacingType 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCallPacingType(String value) {
                this.callPacingType = value;
            }

            /**
             * ecrSetting 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getECRSetting() {
                return ecrSetting;
            }

            /**
             * ecrSetting 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setECRSetting(String value) {
                this.ecrSetting = value;
            }

            /**
             * initialHitRate 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getInitialHitRate() {
                return initialHitRate;
            }

            /**
             * initialHitRate 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setInitialHitRate(Integer value) {
                this.initialHitRate = value;
            }

            /**
             * minimumHitRate 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getMinimumHitRate() {
                return minimumHitRate;
            }

            /**
             * minimumHitRate 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setMinimumHitRate(Integer value) {
                this.minimumHitRate = value;
            }

            /**
             * desiredServiceLevel 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Float }
             *
             */
            public Float getDesiredServiceLevel() {
                return desiredServiceLevel;
            }

            /**
             * desiredServiceLevel 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Float }
             *
             */
            public void setDesiredServiceLevel(Float value) {
                this.desiredServiceLevel = value;
            }

            /**
             * value 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getValue() {
                return value;
            }

            /**
             * value 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setValue(Integer value) {
                this.value = value;
            }

            /**
             * smsPace 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getSmsPace() {
                return smsPace;
            }

            /**
             * smsPace 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setSmsPace(Integer value) {
                this.smsPace = value;
            }

            /**
             * mailPace 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getMailPace() {
                return mailPace;
            }

            /**
             * mailPace 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setMailPace(Integer value) {
                this.mailPace = value;
            }

            /**
             * timeUnit 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getTimeUnit() {
                return timeUnit;
            }

            /**
             * timeUnit 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setTimeUnit(String value) {
                this.timeUnit = value;
            }

            /**
             * outboundSkill 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getOutboundSkill() {
                return outboundSkill;
            }

            /**
             * outboundSkill 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setOutboundSkill(String value) {
                this.outboundSkill = value;
            }

            /**
             * outboundSkillName 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getOutboundSkillName() {
                return outboundSkillName;
            }

            /**
             * outboundSkillName 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setOutboundSkillName(String value) {
                this.outboundSkillName = value;
            }

            /**
             * nuisanceApp 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getNuisanceApp() {
                return nuisanceApp;
            }

            /**
             * nuisanceApp 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setNuisanceApp(String value) {
                this.nuisanceApp = value;
            }

            /**
             * holdApp 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getHoldApp() {
                return holdApp;
            }

            /**
             * holdApp 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setHoldApp(String value) {
                this.holdApp = value;
            }

            /**
             * callPace 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getCallPace() {
                return callPace;
            }

            /**
             * callPace 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setCallPace(Integer value) {
                this.callPace = value;
            }

            /**
             * overDialRatio 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Float }
             *
             */
            public Float getOverDialRatio() {
                return overDialRatio;
            }

            /**
             * overDialRatio 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Float }
             *
             */
            public void setOverDialRatio(Float value) {
                this.overDialRatio = value;
            }

            /**
             * isTimedPreview 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getIsTimedPreview() {
                return isTimedPreview;
            }

            /**
             * isTimedPreview 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setIsTimedPreview(String value) {
                this.isTimedPreview = value;
            }

            /**
             * agentBlending 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getAgentBlending() {
                return agentBlending;
            }

            /**
             * agentBlending 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setAgentBlending(String value) {
                this.agentBlending = value;
            }

            /**
             * priority 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getPriority() {
                return priority;
            }

            /**
             * priority 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setPriority(Integer value) {
                this.priority = value;
            }

            /**
             * allocationType 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getAllocationType() {
                return allocationType;
            }

            /**
             * allocationType 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setAllocationType(Integer value) {
                this.allocationType = value;
            }

            /**
             * minAgents 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getMinAgents() {
                return minAgents;
            }

            /**
             * minAgents 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setMinAgents(Integer value) {
                this.minAgents = value;
            }

            /**
             * maxAgents 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getMaxAgents() {
                return maxAgents;
            }

            /**
             * maxAgents 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setMaxAgents(Integer value) {
                this.maxAgents = value;
            }

            /**
             * defaultCompCode 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getDefaultCompCode() {
                return defaultCompCode;
            }

            /**
             * defaultCompCode 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setDefaultCompCode(String value) {
                this.defaultCompCode = value;
            }

            /**
             * numOfACWExtns 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getNumOfACWExtns() {
                return numOfACWExtns;
            }

            /**
             * numOfACWExtns 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setNumOfACWExtns(Integer value) {
                this.numOfACWExtns = value;
            }

            /**
             * acwTime 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getAcwTime() {
                return acwTime;
            }

            /**
             * acwTime 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setAcwTime(Integer value) {
                this.acwTime = value;
            }

            /**
             * minPorts 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getMinPorts() {
                return minPorts;
            }

            /**
             * minPorts 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setMinPorts(Integer value) {
                this.minPorts = value;
            }

            /**
             * maxPorts 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getMaxPorts() {
                return maxPorts;
            }

            /**
             * maxPorts 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setMaxPorts(Integer value) {
                this.maxPorts = value;
            }

            /**
             * replyTo 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getReplyTo() {
                return replyTo;
            }

            /**
             * replyTo 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setReplyTo(String value) {
                this.replyTo = value;
            }

            /**
             * skillToMonitorName 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSkillToMonitorName() {
                return skillToMonitorName;
            }

            /**
             * skillToMonitorName 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSkillToMonitorName(String value) {
                this.skillToMonitorName = value;
            }

            /**
             * algorithmParameter 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getAlgorithmParameter() {
                return algorithmParameter;
            }

            /**
             * algorithmParameter 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setAlgorithmParameter(String value) {
                this.algorithmParameter = value;
            }

            /**
             * ewtLevels 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getEwtLevels() {
                return ewtLevels;
            }

            /**
             * ewtLevels 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setEwtLevels(String value) {
                this.ewtLevels = value;
            }

            /**
             * desiredValue 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getDesiredValue() {
                return desiredValue;
            }

            /**
             * desiredValue 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setDesiredValue(String value) {
                this.desiredValue = value;
            }

            /**
             * initialPace 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getInitialPace() {
                return initialPace;
            }

            /**
             * initialPace 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setInitialPace(String value) {
                this.initialPace = value;
            }

            /**
             * paceInterval 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getPaceInterval() {
                return paceInterval;
            }

            /**
             * paceInterval 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setPaceInterval(String value) {
                this.paceInterval = value;
            }

            /**
             * incrementStep 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getIncrementStep() {
                return incrementStep;
            }

            /**
             * incrementStep 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setIncrementStep(String value) {
                this.incrementStep = value;
            }

            /**
             * maxPace 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getMaxPace() {
                return maxPace;
            }

            /**
             * maxPace 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setMaxPace(String value) {
                this.maxPace = value;
            }

            /**
             * smsPacingType 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSMSPacingType() {
                return smsPacingType;
            }

            /**
             * smsPacingType 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSMSPacingType(String value) {
                this.smsPacingType = value;
            }

            /**
             * mailPacingType 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getMailPacingType() {
                return mailPacingType;
            }

            /**
             * mailPacingType 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setMailPacingType(String value) {
                this.mailPacingType = value;
            }

            /**
             * nailerApp 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getNailerApp() {
                return nailerApp;
            }

            /**
             * nailerApp 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setNailerApp(String value) {
                this.nailerApp = value;
            }

            /**
             * skillToMonitor 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSkillToMonitor() {
                return skillToMonitor;
            }

            /**
             * skillToMonitor 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSkillToMonitor(String value) {
                this.skillToMonitor = value;
            }

            /**
             * canCancelPreview 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCanCancelPreview() {
                return canCancelPreview;
            }

            /**
             * canCancelPreview 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCanCancelPreview(String value) {
                this.canCancelPreview = value;
            }

            /**
             * smsApplication 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSMSApplication() {
                return smsApplication;
            }

            /**
             * smsApplication 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSMSApplication(String value) {
                this.smsApplication = value;
            }

            /**
             * mailApplication 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getMailApplication() {
                return mailApplication;
            }

            /**
             * mailApplication 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setMailApplication(String value) {
                this.mailApplication = value;
            }

            /**
             * minPace 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getMinPace() {
                return minPace;
            }

            /**
             * minPace 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setMinPace(String value) {
                this.minPace = value;
            }

            /**
             * calcType 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCalcType() {
                return calcType;
            }

            /**
             * calcType 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCalcType(String value) {
                this.calcType = value;
            }

            /**
             * backgroundAMD 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getBackgroundAMD() {
                return backgroundAMD;
            }

            /**
             * backgroundAMD 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setBackgroundAMD(String value) {
                this.backgroundAMD = value;
            }

            /**
             * amdAction 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link Integer }
             *
             */
            public Integer getAMDAction() {
                return amdAction;
            }

            /**
             * amdAction 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link Integer }
             *
             */
            public void setAMDAction(Integer value) {
                this.amdAction = value;
            }

            /**
             * silentCallDetection 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSilentCallDetection() {
                return silentCallDetection;
            }

            /**
             * silentCallDetection 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSilentCallDetection(String value) {
                this.silentCallDetection = value;
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
             *         &lt;element name="condition" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="operator" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="val" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="dispName" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="senderAddressAttribute" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            @XmlType(name = "", propOrder = {
                "condition"
            })
            public static class Ani {

                protected List<AvayaPIMContactStrategy.Handler.Action.Ani.Condition> condition;
                @XmlAttribute(name = "name")
                protected String name;
                @XmlAttribute(name = "attribute")
                protected String attribute;
                @XmlAttribute(name = "senderAddressAttribute")
                protected String senderAddressAttribute;
                @XmlAttribute(name = "description")
                protected String description;
                @XmlAttribute(name = "foundError")
                protected Boolean foundError;

                /**
                 * Gets the value of the condition property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the condition property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getCondition().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link AvayaPIMContactStrategy.Handler.Action.Ani.Condition }
                 *
                 *
                 */
                public List<AvayaPIMContactStrategy.Handler.Action.Ani.Condition> getCondition() {
                    if (condition == null) {
                        condition = new ArrayList<AvayaPIMContactStrategy.Handler.Action.Ani.Condition>();
                    }
                    return this.condition;
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
                 * attribute 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getAttribute() {
                    return attribute;
                }

                /**
                 * attribute 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setAttribute(String value) {
                    this.attribute = value;
                }

                /**
                 * senderAddressAttribute 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getSenderAddressAttribute() {
                    return senderAddressAttribute;
                }

                /**
                 * senderAddressAttribute 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setSenderAddressAttribute(String value) {
                    this.senderAddressAttribute = value;
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
                 * <p>anonymous complex type에 대한 Java 클래스입니다.
                 *
                 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="operator" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="val" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="dispName" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
                 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Condition {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "operator")
                    protected String operator;
                    @XmlAttribute(name = "value")
                    protected String val;
                    @XmlAttribute(name = "minValue")
                    protected String minValue;
                    @XmlAttribute(name = "maxValue")
                    protected String maxValue;
                    @XmlAttribute(name = "dispName")
                    protected String dispName;
                    @XmlAttribute(name = "foundError")
                    protected Boolean foundError;
                    @XmlAttribute(name = "description")
                    protected String description;

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
                     * operator 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getOperator() {
                        return operator;
                    }

                    /**
                     * operator 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setOperator(String value) {
                        this.operator = value;
                    }

                    /**
                     * val 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getVal() {
                        return val;
                    }

                    /**
                     * val 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setVal(String value) {
                        this.val = value;
                    }

                    /**
                     * minValue 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getMinValue() {
                        return minValue;
                    }

                    /**
                     * minValue 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setMinValue(String value) {
                        this.minValue = value;
                    }

                    /**
                     * maxValue 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getMaxValue() {
                        return maxValue;
                    }

                    /**
                     * maxValue 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setMaxValue(String value) {
                        this.maxValue = value;
                    }

                    /**
                     * dispName 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getDispName() {
                        return dispName;
                    }

                    /**
                     * dispName 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setDispName(String value) {
                        this.dispName = value;
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
             *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            @XmlType(name = "", propOrder = {
                "content"
            })
            public static class Attachment {

                @XmlElementRef(name = "url", type = JAXBElement.class)
                @XmlMixed
                protected List<Serializable> content;
                @XmlAttribute(name = "name")
                protected String name;
                @XmlAttribute(name = "description")
                protected String description;
                @XmlAttribute(name = "foundError")
                protected Boolean foundError;

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
                 * {@link String }
                 * {@link JAXBElement }{@code <}{@link String }{@code >}
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
             *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            @XmlType(name = "")
            public static class MonitorVdn {

                @XmlAttribute(name = "number")
                protected String number;
                @XmlAttribute(name = "foundError")
                protected Boolean foundError;
                @XmlAttribute(name = "description")
                protected String description;

                /**
                 * number 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getNumber() {
                    return number;
                }

                /**
                 * number 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setNumber(String value) {
                    this.number = value;
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
             *         &lt;element name="override" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
             *                 &lt;/sequence>
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="global_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="restrict" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;choice>
             *                     &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                     &lt;sequence>
             *                       &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                       &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                     &lt;/sequence>
             *                     &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;/choice>
             *                   &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
             *                 &lt;/sequence>
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="attribute" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="type" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;enumeration value="permanent"/>
             *                       &lt;enumeration value="temporary"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
             *                 &lt;attribute name="attributeType">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;enumeration value="contact"/>
             *                       &lt;enumeration value="system"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="operator" type="{http://www.avaya.com/ContactStrategy}operatorType" />
             *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *                 &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="externalClass" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "override",
                "restrict"
            })
            public static class Restrictions {

                protected List<AvayaPIMContactStrategy.Handler.Action.Restrictions.Override> override;
                protected List<AvayaPIMContactStrategy.Handler.Action.Restrictions.Restrict> restrict;
                @XmlAttribute(name = "name")
                protected String name;
                @XmlAttribute(name = "foundError")
                protected Boolean foundError;
                @XmlAttribute(name = "description")
                protected String description;

                /**
                 * Gets the value of the override property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the override property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getOverride().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link AvayaPIMContactStrategy.Handler.Action.Restrictions.Override }
                 *
                 *
                 */
                public List<AvayaPIMContactStrategy.Handler.Action.Restrictions.Override> getOverride() {
                    if (override == null) {
                        override = new ArrayList<AvayaPIMContactStrategy.Handler.Action.Restrictions.Override>();
                    }
                    return this.override;
                }

                /**
                 * Gets the value of the restrict property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the restrict property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getRestrict().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link AvayaPIMContactStrategy.Handler.Action.Restrictions.Restrict }
                 *
                 *
                 */
                public List<AvayaPIMContactStrategy.Handler.Action.Restrictions.Restrict> getRestrict() {
                    if (restrict == null) {
                        restrict = new ArrayList<AvayaPIMContactStrategy.Handler.Action.Restrictions.Restrict>();
                    }
                    return this.restrict;
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
                 *       &lt;sequence>
                 *         &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
                 *       &lt;/sequence>
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="global_id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                @XmlType(name = "", propOrder = {
                    "exception"
                })
                public static class Override {

                    protected List<ExceptionComplexType> exception;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "global_id", required = true)
                    protected String globalId;
                    @XmlAttribute(name = "description")
                    protected String description;
                    @XmlAttribute(name = "foundError")
                    protected Boolean foundError;

                    /**
                     * Gets the value of the exception property.
                     *
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the exception property.
                     *
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getException().add(newItem);
                     * </pre>
                     *
                     *
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ExceptionComplexType }
                     *
                     *
                     */
                    public List<ExceptionComplexType> getException() {
                        if (exception == null) {
                            exception = new ArrayList<ExceptionComplexType>();
                        }
                        return this.exception;
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
                     * globalId 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getGlobalId() {
                        return globalId;
                    }

                    /**
                     * globalId 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setGlobalId(String value) {
                        this.globalId = value;
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
                 *       &lt;sequence>
                 *         &lt;choice>
                 *           &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *           &lt;sequence>
                 *             &lt;element name="minValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *             &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *           &lt;/sequence>
                 *           &lt;element name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;/choice>
                 *         &lt;element name="exception" type="{http://www.avaya.com/ContactStrategy}exceptionComplexType" maxOccurs="unbounded" minOccurs="0"/>
                 *       &lt;/sequence>
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="attribute" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="type" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;enumeration value="permanent"/>
                 *             &lt;enumeration value="temporary"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="recheckInterval" type="{http://www.w3.org/2001/XMLSchema}int" />
                 *       &lt;attribute name="attributeType">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;enumeration value="contact"/>
                 *             &lt;enumeration value="system"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="operator" type="{http://www.avaya.com/ContactStrategy}operatorType" />
                 *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
                 *       &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="externalClass" type="{http://www.w3.org/2001/XMLSchema}boolean" />
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
                public static class Restrict {

                    @XmlElementRefs({
                        @XmlElementRef(name = "minValue", type = JAXBElement.class, required = false),
                        @XmlElementRef(name = "maxValue", type = JAXBElement.class, required = false),
                        @XmlElementRef(name = "exception", type = JAXBElement.class, required = false),
                        @XmlElementRef(name = "value", type = JAXBElement.class, required = false)
                    })
                    protected List<JAXBElement<?>> content;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "attribute", required = true)
                    protected String attribute;
                    @XmlAttribute(name = "type", required = true)
                    protected String type;
                    @XmlAttribute(name = "recheckInterval")
                    protected Integer recheckInterval;
                    @XmlAttribute(name = "attributeType")
                    protected String attributeType;
                    @XmlAttribute(name = "id")
                    protected String id;
                    @XmlAttribute(name = "description")
                    protected String description;
                    @XmlAttribute(name = "operator")
                    protected OperatorType operator;
                    @XmlAttribute(name = "foundError")
                    protected Boolean foundError;
                    @XmlAttribute(name = "customClass")
                    protected String customClass;
                    @XmlAttribute(name = "externalClass")
                    protected Boolean externalClass;

                    /**
                     * 나머지 콘텐츠 모델을 가져옵니다.
                     *
                     * <p>
                     * 다음 원인으로 인해 이 "catch-all" 속성을 가져오고 있습니다.
                     * 필드 이름 "MaxValue"이(가) 스키마의 다른 두 부분에 사용되었습니다. 참조:
                     * file:/C:/workspace/PDS_SYSTEM/ContactStrategy.xsd의 74행
                     * file:/C:/workspace/PDS_SYSTEM/ContactStrategy.xsd의 69행
                     * <p>
                     * 이 속성을 제거하려면 다음 선언 중 하나에
                     * 속성 사용자 정의를 적용하여 이름을 변경하십시오.
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
                     * {@link JAXBElement }{@code <}{@link String }{@code >}
                     * {@link JAXBElement }{@code <}{@link ExceptionComplexType }{@code >}
                     * {@link JAXBElement }{@code <}{@link String }{@code >}
                     *
                     *
                     */
                    public List<JAXBElement<?>> getContent() {
                        if (content == null) {
                            content = new ArrayList<JAXBElement<?>>();
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
                     * attribute 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getAttribute() {
                        return attribute;
                    }

                    /**
                     * attribute 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setAttribute(String value) {
                        this.attribute = value;
                    }

                    /**
                     * type 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getType() {
                        return type;
                    }

                    /**
                     * type 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setType(String value) {
                        this.type = value;
                    }

                    /**
                     * recheckInterval 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link Integer }
                     *
                     */
                    public Integer getRecheckInterval() {
                        return recheckInterval;
                    }

                    /**
                     * recheckInterval 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *
                     */
                    public void setRecheckInterval(Integer value) {
                        this.recheckInterval = value;
                    }

                    /**
                     * attributeType 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getAttributeType() {
                        return attributeType;
                    }

                    /**
                     * attributeType 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setAttributeType(String value) {
                        this.attributeType = value;
                    }

                    /**
                     * id 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getId() {
                        return id;
                    }

                    /**
                     * id 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setId(String value) {
                        this.id = value;
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
                     * operator 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link OperatorType }
                     *
                     */
                    public OperatorType getOperator() {
                        return operator;
                    }

                    /**
                     * operator 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link OperatorType }
                     *
                     */
                    public void setOperator(OperatorType value) {
                        this.operator = value;
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
                     * customClass 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getCustomClass() {
                        return customClass;
                    }

                    /**
                     * customClass 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setCustomClass(String value) {
                        this.customClass = value;
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
             *         &lt;element name="result" type="{http://www.avaya.com/ContactStrategy}resultType" maxOccurs="unbounded" minOccurs="0"/>
             *       &lt;/sequence>
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="customClass" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="customProcessor" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                "result"
            })
            public static class Resultprocessors {

                protected List<ResultType> result;
                @XmlAttribute(name = "name")
                protected String name;
                @XmlAttribute(name = "nextState")
                protected String nextState;
                @XmlAttribute(name = "foundError")
                protected Boolean foundError;
                @XmlAttribute(name = "description")
                protected String description;
                @XmlAttribute(name = "customClass")
                protected String customClass;
                @XmlAttribute(name = "customProcessor")
                protected String customProcessor;
                @XmlAttribute(name = "waitTimeout")
                protected Integer waitTimeout;
                @XmlAttribute(name = "waitTimeoutCC")
                protected String waitTimeoutCC;

                /**
                 * Gets the value of the result property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the result property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getResult().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ResultType }
                 *
                 *
                 */
                public List<ResultType> getResult() {
                    if (result == null) {
                        result = new ArrayList<ResultType>();
                    }
                    return this.result;
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
                 * customClass 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getCustomClass() {
                    return customClass;
                }

                /**
                 * customClass 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setCustomClass(String value) {
                    this.customClass = value;
                }

                /**
                 * customProcessor 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getCustomProcessor() {
                    return customProcessor;
                }

                /**
                 * customProcessor 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setCustomProcessor(String value) {
                    this.customProcessor = value;
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
         *         &lt;element name="conditions" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="case" maxOccurs="unbounded">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="operator">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;enumeration value="Equals"/>
         *                                 &lt;enumeration value="Greater Than"/>
         *                                 &lt;enumeration value="Less Than"/>
         *                                 &lt;enumeration value="Between"/>
         *                                 &lt;enumeration value="Starts With"/>
         *                                 &lt;enumeration value="Contains"/>
         *                                 &lt;enumeration value="Is Null"/>
         *                                 &lt;enumeration value="Is Not Null"/>
         *                                 &lt;enumeration value="One Of"/>
         *                                 &lt;enumeration value="Not Equal"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *                           &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                           &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="type">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;enumeration value="System"/>
         *                       &lt;enumeration value="Contact"/>
         *                       &lt;enumeration value="Custom"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="className" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="defaultNextState" type="{http://www.w3.org/2001/XMLSchema}string" />
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
            "conditions"
        })
        public static class Selector {

            @XmlElement(required = true)
            protected List<AvayaPIMContactStrategy.Handler.Selector.Conditions> conditions;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "description")
            protected String description;
            @XmlAttribute(name = "defaultNextState")
            protected String defaultNextState;
            @XmlAttribute(name = "foundError")
            protected Boolean foundError;
            @XmlAttribute(name = "waitTimeout")
            protected Integer waitTimeout;
            @XmlAttribute(name = "waitTimeoutCC")
            protected String waitTimeoutCC;

            /**
             * Gets the value of the conditions property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the conditions property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getConditions().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AvayaPIMContactStrategy.Handler.Selector.Conditions }
             *
             *
             */
            public List<AvayaPIMContactStrategy.Handler.Selector.Conditions> getConditions() {
                if (conditions == null) {
                    conditions = new ArrayList<AvayaPIMContactStrategy.Handler.Selector.Conditions>();
                }
                return this.conditions;
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
             * defaultNextState 속성의 값을 가져옵니다.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getDefaultNextState() {
                return defaultNextState;
            }

            /**
             * defaultNextState 속성의 값을 설정합니다.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setDefaultNextState(String value) {
                this.defaultNextState = value;
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
             *         &lt;element name="case" maxOccurs="unbounded">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="operator">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;enumeration value="Equals"/>
             *                       &lt;enumeration value="Greater Than"/>
             *                       &lt;enumeration value="Less Than"/>
             *                       &lt;enumeration value="Between"/>
             *                       &lt;enumeration value="Starts With"/>
             *                       &lt;enumeration value="Contains"/>
             *                       &lt;enumeration value="Is Null"/>
             *                       &lt;enumeration value="Is Not Null"/>
             *                       &lt;enumeration value="One Of"/>
             *                       &lt;enumeration value="Not Equal"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *                 &lt;attribute name="waitTimeout" type="{http://www.w3.org/2001/XMLSchema}int" />
             *                 &lt;attribute name="waitTimeoutCC" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="type">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;enumeration value="System"/>
             *             &lt;enumeration value="Contact"/>
             *             &lt;enumeration value="Custom"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="className" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="foundError" type="{http://www.w3.org/2001/XMLSchema}boolean" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "_case"
            })
            public static class Conditions {

                @XmlElement(name = "case", required = true)
                protected List<AvayaPIMContactStrategy.Handler.Selector.Conditions.Case> _case;
                @XmlAttribute(name = "type")
                protected String type;
                @XmlAttribute(name = "attribute")
                protected String attribute;
                @XmlAttribute(name = "description")
                protected String description;
                @XmlAttribute(name = "name")
                protected String name;
                @XmlAttribute(name = "className")
                protected String className;
                @XmlAttribute(name = "foundError")
                protected Boolean foundError;

                /**
                 * Gets the value of the case property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the case property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getCase().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link AvayaPIMContactStrategy.Handler.Selector.Conditions.Case }
                 *
                 *
                 */
                public List<AvayaPIMContactStrategy.Handler.Selector.Conditions.Case> getCase() {
                    if (_case == null) {
                        _case = new ArrayList<AvayaPIMContactStrategy.Handler.Selector.Conditions.Case>();
                    }
                    return this._case;
                }

                /**
                 * type 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getType() {
                    return type;
                }

                /**
                 * type 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setType(String value) {
                    this.type = value;
                }

                /**
                 * attribute 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getAttribute() {
                    return attribute;
                }

                /**
                 * attribute 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setAttribute(String value) {
                    this.attribute = value;
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
                 * className 속성의 값을 가져옵니다.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getClassName() {
                    return className;
                }

                /**
                 * className 속성의 값을 설정합니다.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setClassName(String value) {
                    this.className = value;
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
                 * <p>anonymous complex type에 대한 Java 클래스입니다.
                 *
                 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="operator">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;enumeration value="Equals"/>
                 *             &lt;enumeration value="Greater Than"/>
                 *             &lt;enumeration value="Less Than"/>
                 *             &lt;enumeration value="Between"/>
                 *             &lt;enumeration value="Starts With"/>
                 *             &lt;enumeration value="Contains"/>
                 *             &lt;enumeration value="Is Null"/>
                 *             &lt;enumeration value="Is Not Null"/>
                 *             &lt;enumeration value="One Of"/>
                 *             &lt;enumeration value="Not Equal"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="minValue" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="maxValue" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="nextState" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                @XmlType(name = "")
                public static class Case {

                    @XmlAttribute(name = "operator")
                    protected String operator;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "description")
                    protected String description;
                    @XmlAttribute(name = "value")
                    protected String value;
                    @XmlAttribute(name = "minValue")
                    protected String minValue;
                    @XmlAttribute(name = "maxValue")
                    protected String maxValue;
                    @XmlAttribute(name = "nextState")
                    protected String nextState;
                    @XmlAttribute(name = "foundError")
                    protected Boolean foundError;
                    @XmlAttribute(name = "waitTimeout")
                    protected Integer waitTimeout;
                    @XmlAttribute(name = "waitTimeoutCC")
                    protected String waitTimeoutCC;

                    /**
                     * operator 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getOperator() {
                        return operator;
                    }

                    /**
                     * operator 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setOperator(String value) {
                        this.operator = value;
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
                     * minValue 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getMinValue() {
                        return minValue;
                    }

                    /**
                     * minValue 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setMinValue(String value) {
                        this.minValue = value;
                    }

                    /**
                     * maxValue 속성의 값을 가져옵니다.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getMaxValue() {
                        return maxValue;
                    }

                    /**
                     * maxValue 속성의 값을 설정합니다.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setMaxValue(String value) {
                        this.maxValue = value;
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

        }

    }

}
