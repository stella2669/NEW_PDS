/**
 *
 */

var strategySchema = '<?xml version="1.0" encoding="UTF-8"?>'+
					 ' 	<schema targetNamespace="http://www.avaya.com/ContactStrategy" xmlns="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://www.avaya.com/ContactStrategy">'+
					 '   <element name="AvayaPIMContactStrategy">'+
					 '   	<complexType>'+
					 '   		<sequence>'+
					 '               <element name="NotificationText" type="tns:NotificationTextType" minOccurs="0" maxOccurs="unbounded"></element>'+
					 '               <element name="Handler" minOccurs="1"'+
					 '   				maxOccurs="unbounded">'+
					 '   				<complexType>'+
					 '                       <choice>'+
					 '                       	<element name="action" minOccurs="1"'+
					 '                       		maxOccurs="unbounded">'+
					 '                       		<complexType>'+
					 '                       			<sequence>'+
					 '                       				<element name="restrictions"'+
					 '                       					minOccurs="0" maxOccurs="1">'+
					 '                       					<complexType>'+
					 '                       						<sequence>'+
					 '                       							<element'+
					 '                         								name="override" minOccurs="0"'+
					 '                       								maxOccurs="unbounded">'+
					 '                       								<complexType>'+
					 '                       									<sequence>'+
					 '                       										<element'+
					 '                       											name="exception"'+
					 '                       											type="tns:exceptionComplexType"'+
					 '                       											minOccurs="0"'+
					 '                       											maxOccurs="unbounded">'+
					 '                       										</element>'+
					 '                       									</sequence>'+
					 '                       									<attribute'+
					 '                       										name="name" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="global_id" type="string"'+
					 '                       										use="required">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="description" type="string"'+
					 '                       										use="optional">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="foundError" type="boolean">'+
					 '                       									</attribute>'+
					 '                       								</complexType>'+
					 '                       							</element>'+
					 '                       							<element'+
					 '                       								name="restrict" minOccurs="0"'+
					 '                       								maxOccurs="unbounded">'+
					 '                       								<complexType>'+
					 '                       									<sequence'+
					 '                       										minOccurs="1" maxOccurs="1">'+

					 '                       										<choice'+
					 '                       											minOccurs="1" maxOccurs="1">'+
					 '                       											<element'+
					 '                       												name="value" minOccurs="0"'+
					 '                       												maxOccurs="1" type="string">'+
					 '                       											</element>'+
					 '                       											<sequence'+
					 '                       												minOccurs="1" maxOccurs="1">'+
					 '                       												<element'+
					 '                       													name="minValue" type="string"'+
					 '                       													minOccurs="1" maxOccurs="1">'+
					 '                       												</element>'+
					 '                       												<element'+
					 '                       													name="maxValue" minOccurs="0"'+
					 '                       													maxOccurs="1" type="string">'+
					 '                       												</element>'+
					 '                       											</sequence>'+
					 '                       											<element'+
					 '                       												name="maxValue" type="string"'+
					 '                       												minOccurs="1" maxOccurs="1">'+
					 '                       											</element>'+
					 '                       										</choice>'+
					 '                       										<element'+
					 '                       											name="exception" minOccurs="0"'+
					 '                       											maxOccurs="unbounded"'+
					 '                       											type="tns:exceptionComplexType">'+
					 '                       										</element>'+
					 '                       									</sequence>'+


					 '                       									<attribute'+
					 '                       										name="name" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="attribute" type="string"'+
					 '                       										use="required">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="type" use="required">'+
					 '                       										<simpleType>'+
					 '                       											<restriction'+
					 '                       												base="string">'+
					 '                       												<enumeration'+
					 '                       													value="permanent">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="temporary">'+
					 '                       												</enumeration>'+
					 '                       											</restriction>'+
					 '                       										</simpleType>'+
					 '                       									</attribute>'+
					 ' 															<attribute'+
					 '                       										name="recheckInterval" type="int">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="attributeType" use="optional">'+
					 '                       										<simpleType>'+
					 '                       											<restriction'+
					 '                       												base="string">'+
					 '                       												<enumeration'+
					 '                       													value="contact">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="system">'+
					 '                       												</enumeration>'+
					 '                       											</restriction>'+
					 '                       										</simpleType>'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="id" type="string"'+
					 '                       										use="optional">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="description" type="string"'+
					 '                       										use="optional">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="operator"'+
					 '                       										type="tns:operatorType">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="foundError" type="boolean">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="customClass" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="externalClass" type="boolean">'+
					 '                       									</attribute>'+
					 '                       								</complexType>'+
					 '                       							</element>'+
					 '                       						</sequence>'+
					 '                       						<attribute name="name"'+
					 '                       							type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="foundError" type="boolean">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="description" type="string">'+
					 '                       						</attribute>'+
					 '                       					</complexType>'+
					 '                       				</element>'+
					 '                       				<element name="address"'+
					 '                       					type="tns:AddressType" minOccurs="1"'+
					 '                       					maxOccurs="unbounded">'+
					 '                       				</element>'+
					 '                       				<element name="MonitorVdn"'+
					 '                       					minOccurs="0" maxOccurs="unbounded">'+
					 '                       					<complexType>'+
					 '                       						<attribute name="number"'+
					 '                       							type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="foundError" type="boolean">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="description" type="string">'+
					 '                       						</attribute>'+
					 '                       					</complexType>'+
					 '                       				</element>'+
					 '                       				<element name="ani"'+
					 '                       					minOccurs="0" maxOccurs="1">'+
					 '                       					<complexType>'+
					 '                       						<sequence>'+
					 '                       							<element'+
					 '                       								name="condition" minOccurs="0"'+
					 '                       								maxOccurs="unbounded">'+
					 '                       								<complexType>'+
					 '                       									<simpleContent>'+
					 '                       										<extension'+
					 '                       											base="string">'+
					 '                       											<attribute'+
					 '                       												name="name" type="string"'+
					 '                       												use="optional">'+
					 '                       											</attribute>'+
					 '                                                                   <attribute name="operator" type="string">'+
					 '                       											</attribute>'+
					 '                                                                   <attribute'+
					 '                       												name="value" type="string">'+
					 '                       											</attribute>'+

					 '                                                                   <attribute name="minValue" type="string">'+
					 '                       											</attribute>'+
					 '                                                                   <attribute'+
					 '                       												name="maxValue" type="string">'+
					 '                       											</attribute>'+
					 '                       											<attribute'+
					 '                       												name="dispName" type="string"'+
					 '                       												use="optional">'+
					 '                       											</attribute>'+
					 '                       											<attribute'+
					 '                       												name="foundError" type="boolean">'+
					 '                       											</attribute>'+
					 '                       											<attribute'+
					 '                       												name="description" type="string">'+
					 '                       											</attribute>'+
					 '                       										</extension>'+
					 '                       									</simpleContent>'+
					 '                       								</complexType>'+
					 '                       							</element>'+
					 '                       						</sequence>'+
					 '                       						<attribute name="name"'+
					 '                       							type="string" use="optional">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="attribute" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="senderAddressAttribute" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="description" type="string"'+
					 '                       							use="optional">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="foundError" type="boolean">'+
					 '                       						</attribute>'+
					 '                       					</complexType>'+
					 '                       				</element>'+
					 '                       				<element name="attachment"'+
					 '                       					minOccurs="0" maxOccurs="10">'+
					 '                       					<complexType mixed="true">'+
					 '                       						<sequence>'+
					 '                       							<element name="url"'+
					 '                       								minOccurs="1" maxOccurs="1"'+
					 '                       								type="string">'+
					 '                       							</element>'+
					 '                       						</sequence>'+
					 '                       						<attribute name="name"'+
					 '                       							type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="description" type="string"'+
					 '                       							use="optional">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="foundError" type="boolean">'+
					 '                       						</attribute>'+
					 '                       					</complexType>'+
					 '                       				</element>'+
					 '                       				<element name="Application"'+
					 '                       					type="tns:ApplicationType" minOccurs="0"'+
					 '                       					maxOccurs="1">'+
					 '                       				</element>'+
					 '                       				<element name="resultprocessors"'+
					 '                       					minOccurs="1" maxOccurs="1">'+
					 '                       					<complexType>'+
					 '                       						<sequence>'+
					 '                       							<element'+
					 '                       								name="result" type="tns:resultType"'+
					 '                       								minOccurs="0" maxOccurs="unbounded">'+
					 '                       							</element>'+
					 '                       						</sequence>'+
					 '                       						<attribute name="name"'+
					 '                       							type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="nextState" type="string"'+
					 '                       							use="optional">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="foundError" type="boolean">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="description" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="customClass" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="customProcessor" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="waitTimeout" type="int">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="waitTimeoutCC" type="string">'+
					 '                       						</attribute>'+
					 '                       					</complexType>'+
					 '                       				</element>'+
					 '                       			</sequence>'+
					 '                       			<attribute name="name"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="type"'+
					 '                       				use="required">'+
					 '                       				<simpleType>'+
					 '                       					<restriction'+
					 '                       						base="string">'+
					 '                       						<enumeration'+
					 '                       							value="call">'+
					 '                       						</enumeration>'+
					 '                       						<enumeration'+
					 '                       							value="sms">'+
					 '                       						</enumeration>'+
					 '                       						<enumeration'+
					 '                       							value="mail">'+
					 '                       						</enumeration>'+
					 '                       						<enumeration'+
					 '                       							value="custom">'+
					 '                       						</enumeration>'+
					 '                       					</restriction>'+
					 '                       				</simpleType>'+
					 '                       			</attribute>'+
					 '                       			<attribute name="fromDisplayName"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="fromAddress"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="timeout"'+
					 '                       				type="string" use="optional">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="guardTime"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="minContactTime"'+
					 '                       				type="time" use="optional">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="maxContactTime"'+
					 '                       				type="time" use="optional">'+
					 '                       			</attribute>'+
					 ' 									<attribute name="recheckInterval"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="EnhancedCCA"'+
					 '                       				use="optional">'+
					 '                       				<simpleType>'+
					 '                       					<restriction'+
					 '                       						base="string">'+
					 '                       						<enumeration'+
					 '                       							value="ON">'+
					 '                       						</enumeration>'+
					 '                       						<enumeration'+
					 '                       							value="OFF">'+
					 '                       						</enumeration>'+
					 '                       					</restriction>'+
					 '                       				</simpleType>'+
					 '                       			</attribute>'+
					 '                       			<attribute'+
					 '                       				name="OnMediaServerFailure">'+
					 '                       				<simpleType>'+
					 '                       					<restriction'+
					 '                       						base="string">'+
					 '                       						<enumeration'+
					 '                       							value="retry">'+
					 '                       						</enumeration>'+
					 '                       						<enumeration'+
					 '                       							value="no_retry">'+
					 '                       						</enumeration>'+
					 '                       					</restriction>'+
					 '                       				</simpleType>'+
					 '                       			</attribute>'+

					 '                       			<attribute name="DriverApp"'+
					 '                       				type="string" use="optional">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="description"'+
					 '                       				type="string" use="optional">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="foundError"'+
					 '                       				type="boolean">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="CallPacingType"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="ECRSetting"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+

					 '                       			<attribute name="initialHitRate"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="minimumHitRate"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute'+
					 '                       				name="desiredServiceLevel" type="float">'+
					 '                       			</attribute>'+

					 '                       			<attribute name="value"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="smsPace"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="mailPace"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="timeUnit"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+

					 '                       			<attribute name="outboundSkill"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+


					 '                       			<attribute name="outboundSkillName"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="NuisanceApp"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="HoldApp"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="callPace"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="overDialRatio"'+
					 '                       				type="float">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="isTimedPreview"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="agentBlending"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="priority"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="allocationType"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="minAgents"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="maxAgents"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="defaultCompCode"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="numOfACWExtns"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="acwTime"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="minPorts"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="maxPorts"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="replyTo"'+
					 '                       				type="string" use="optional">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="skillToMonitorName"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="algorithmParameter"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+

					 '   						<attribute name="ewtLevels"'+
					 '   						       type="string">'+
					 '   						 </attribute>'+
					 '                       			<attribute name="desiredValue"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="initialPace"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="paceInterval"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="incrementStep"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="maxPace"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="SMSPacingType"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="MailPacingType"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="NailerApp"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="skillToMonitor"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="canCancelPreview"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="SMSApplication"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="MailApplication"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="minPace"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="calcType"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="BackgroundAMD"'+
					 '                       				use="optional">'+
					 '                       				<simpleType>'+
					 '                       					<restriction'+
					 '                       						base="string">'+
					 '                       						<enumeration'+
					 '                       							value="ON">'+
					 '                       						</enumeration>'+
					 '                       						<enumeration'+
					 '                       							value="OFF">'+
					 '                       						</enumeration>'+
					 '                       					</restriction>'+
					 '                       				</simpleType>'+
					 '                       			</attribute>'+
					 '                       			<attribute name="AMDAction"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="SilentCallDetection"'+
					 '                       				use="optional">'+
					 '                       				<simpleType>'+
					 '                       					<restriction'+
					 '                       						base="string">'+
					 '                       						<enumeration'+
					 '                       							value="ON">'+
					 '                       						</enumeration>'+
					 '                       						<enumeration'+
					 '                       							value="OFF">'+
					 '                       						</enumeration>'+
					 '                       					</restriction>'+
					 '                       				</simpleType>'+
					 '                       			</attribute>'+
					 '                       		</complexType>'+
					 '                       	</element>'+
					 '                       	<element name="selector" minOccurs="1" maxOccurs="1">'+
					 '                       		<complexType>'+
					 '                       			<sequence>'+
					 '                       				<element name="conditions"'+
					 '                       					maxOccurs="unbounded" minOccurs="1">'+
					 '                       					<complexType>'+
					 '                       						<sequence>'+
					 '                       							<element name="case"'+
					 '                       								maxOccurs="unbounded" minOccurs="1">'+
					 '                       								<complexType>'+
					 '                       									<attribute'+
					 '                       										name="operator">'+
					 '                       										<simpleType>'+
					 '                       											<restriction'+
					 '                       												base="string">'+
					 '                       												<enumeration'+
					 '                       													value="Equals">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Greater Than">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Less Than">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Between">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Starts With">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Contains">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Is Null">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Is Not Null">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="One Of">'+
					 '                       												</enumeration>'+
					 '                       												<enumeration'+
					 '                       													value="Not Equal">'+
					 '                       												</enumeration>'+
					 '                       											</restriction>'+
					 '                       										</simpleType>'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="name" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="description" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="value" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="minValue" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="maxValue" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="nextState" type="string">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="foundError" type="boolean">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="waitTimeout" type="int">'+
					 '                       									</attribute>'+
					 '                       									<attribute'+
					 '                       										name="waitTimeoutCC" type="string">'+
					 '                       									</attribute>'+
					 '                       								</complexType>'+
					 '                       							</element>'+
					 '                       						</sequence>'+
					 '                       						<attribute'+
					 '                       							name="type">'+
					 '                       							<simpleType>'+
					 '                       								<restriction'+
					 '                       									base="string">'+
					 '                       									<enumeration'+
					 '                       										value="System">'+
					 '                       									</enumeration>'+
					 '                       									<enumeration'+
					 '                       										value="Contact">'+
					 '                       									</enumeration>'+
					 '                       									<enumeration'+
					 '                       										value="Custom">'+
					 '                       									</enumeration>'+
					 '                       								</restriction>'+
					 '                       							</simpleType>'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="attribute" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="description" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute name="name"'+
					 '                       							type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="className" type="string">'+
					 '                       						</attribute>'+
					 '                       						<attribute'+
					 '                       							name="foundError" type="boolean">'+
					 '                       						</attribute>'+
					 '                       					</complexType>'+
					 '                       				</element>'+
					 '                       			</sequence>'+
					 '                       			<attribute name="name"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="description"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="defaultNextState"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="foundError"'+
					 '                       				type="boolean">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="waitTimeout"'+
					 '                       				type="int">'+
					 '                       			</attribute>'+
					 '                       			<attribute name="waitTimeoutCC"'+
					 '                       				type="string">'+
					 '                       			</attribute>'+
					 '                       		</complexType></element>'+
					 '                       </choice>'+

					 '   					<attribute name="name" type="string"></attribute>'+
					 '   					<attribute name="state" type="string"'+
					 '   						use="required">'+
					 '   					</attribute>'+
					 '   					<attribute name="description" type="string"'+
					 '   						use="optional">'+
					 '   					</attribute>'+
					 '   					<attribute name="foundError" type="boolean"></attribute>'+
					 '   				</complexType>'+
					 '               </element>'+
					 '   		</sequence>'+
					 '   	</complexType>'+
					 '   </element>'+

					 '   <complexType name="AddressType">'+
					 '   	<sequence>'+
					 '   		<element name="ContactAttribute" type="string" minOccurs="1"'+
					 '   			maxOccurs="1">'+
					 '   		</element>'+

					 '   	</sequence>'+
					 '   	<attribute name="name" type="string"></attribute>'+
					 '   	<attribute name="minContactTime" type="time"></attribute>'+
					 '   	<attribute name="maxContactTime" type="time"></attribute>'+
					 '   	<attribute name="weekDaysOnly" type="boolean"></attribute>'+
					 '   	<attribute name="isBranch" type="boolean" use="optional"></attribute>'+
					 '   	<attribute name="description" type="string" use="optional"></attribute>'+
					 '   	<attribute name="foundError" type="boolean"></attribute>'+
					 '   </complexType>'+

					 '   <complexType name="resultType">'+
					 '   	<choice minOccurs="1" maxOccurs="1">'+
					 '   		<element name="Application" type="tns:ApplicationType"'+
					 '   			minOccurs="0" maxOccurs="1">'+
					 '   		</element>'+
					 '   		<element name="retry" minOccurs="0" maxOccurs="1">'+
					 '   			<complexType>'+
					 '   				<sequence>'+
					 '   					<element name="address" type="tns:AddressType"'+
					 '   						minOccurs="0" maxOccurs="unbounded">'+
					 '   					</element>'+
					 '   				</sequence>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="addressLooping" type="string"></attribute>'+
					 '   				<attribute name="count" type="int" use="required"></attribute>'+
					 '   				<attribute name="interval" type="string"'+
					 '   					use="required">'+
					 '   				</attribute>'+
					 '   				<attribute name="failstate" type="string"'+
					 '   					use="required">'+
					 '   				</attribute>'+
					 '   				<attribute name="description" type="string"'+
					 '   					use="optional">'+
					 '   				</attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+
					 '   				<attribute name="waitTimeout" type="int"></attribute>'+
					 '   				<attribute name="waitTimeoutCC" type="string"></attribute>'+
					 '   			</complexType>'+
					 '   		</element>'+
					 '   		<element name="Agent" type="tns:AgentType" maxOccurs="1"'+
					 '   			minOccurs="0">'+
					 '   		</element>'+
					 '   	</choice>'+
					 '   	<attribute name="name" type="string"></attribute>'+
					 '       <attribute name="allOtherResults" type="boolean"></attribute>'+
					 '       <attribute name="value" type="string" use="required"></attribute>'+
					 '   	<attribute name="nextState" type="string" use="required"></attribute>'+
					 '   	<attribute name="nextStateAfter" type="string"></attribute>'+
					 '   	<attribute name="description" type="string" use="optional"></attribute>'+
					 '   	<attribute name="foundError" type="boolean"></attribute>'+
					 '   	<attribute name="waitTimeout" type="int"></attribute>'+
					 '   	<attribute name="waitTimeoutCC" type="string"></attribute>'+
					 '   </complexType>'+

					 '   <complexType name="ApplicationType">'+
					 '   	<choice minOccurs="1" maxOccurs="1">'+
					 '   		<element name="AvayaNotify">'+
					 '   			<complexType>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="textId" type="string"'+
					 '   					use="required">'+
					 '   				</attribute>'+
					 '   				<attribute name="description" type="string"'+
					 '   					use="optional">'+
					 '   				</attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+
					 '   			</complexType>'+
					 '   		</element>'+
					 '   		<element name="AvayaAgent">'+
					 '   			<complexType>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="VDN" type="string"'+
					 '   					use="optional">'+
					 '   				</attribute>'+
					 '   				<attribute name="textId" type="string"></attribute>'+
					 '   				<attribute name="description" type="string"'+
					 '   					use="optional">'+
					 '   				</attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+

					 '   				<attribute name="agentScript" type="string"></attribute>'+
					 '   				<attribute name="agentScriptName" type="string"></attribute>'+
					 '   				<attribute name="prefAgentCallback" type="string"></attribute>'+
					 '   				<attribute name="strictAgentCallback" type="string"></attribute>'+
					 '   				<attribute name="campaignCallBack" type="string"></attribute>'+
					 '   				<attribute name="generalCallBack" type="string"></attribute>'+
					 '   				<attribute name="canCancelCallback" type="string"></attribute>'+
					 '   			</complexType>'+
					 '   		</element>'+
					 '   		<element name="Custom">'+
					 '   			<complexType>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="application" type="string"'+
					 '   					use="required">'+
					 '   				</attribute>'+
					 '   				<attribute name="VDN" type="string"></attribute>'+
					 '   				<attribute name="externalClass" type="boolean"></attribute>'+
					 '   				<attribute name="description" type="string"'+
					 '   					use="optional">'+
					 '   				</attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+

					 '   				<attribute name="agentScript" type="string"></attribute>'+
					 '   				<attribute name="agentScriptName" type="string"></attribute>'+
					 '   				<attribute name="prefAgentCallback" type="string"></attribute>'+
					 '   				<attribute name="strictAgentCallback" type="string"></attribute>'+
					 '   				<attribute name="campaignCallBack" type="string"></attribute>'+
					 '   				<attribute name="generalCallBack" type="string"></attribute>'+
					 '   				<attribute name="canCancelCallback" type="string"></attribute>'+
					 '   			</complexType>'+
					 '   		</element>'+
					 '   		<element name="url">'+
					 '   			<complexType mixed="true">'+
					 '   				<sequence>'+
					 '   					<element name="ContactAttribute" type="string"'+
					 '   						minOccurs="0" maxOccurs="unbounded">'+
					 '   					</element>'+
					 '   				</sequence>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+
					 '   				<attribute name="description" type="string"></attribute>'+
					 '   			</complexType>'+
					 '   		</element>'+
					 '   		<element name="CustomSMS">'+
					 '   			<complexType>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="description" type="string"></attribute>'+
					 '   				<attribute name="application" type="string"></attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+
					 '   			</complexType>'+
					 '   		</element>'+
					 '   		<element name="CustomMail">'+
					 '   			<complexType>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="description" type="string"></attribute>'+
					 '   				<attribute name="application" type="string"></attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+
					 '   			</complexType></element>'+
					 '   	</choice>'+
					 '   	<attribute name="name" type="string"></attribute>'+
					 '   	<attribute name="foundError" type="boolean"></attribute>'+

					 '   	<attribute name="description" type="string"></attribute>'+
					 '   </complexType>'+

					 '   <complexType name="NotificationTextType">'+
					 '   	<sequence>'+

					 '   		<element name="textItem" minOccurs="1"'+
					 '   			maxOccurs="unbounded">'+
					 '   			<complexType>'+
					 '   				<sequence>'+
					 '   					<element name="text" type="string"></element>'+

					 '   				</sequence>'+
					 '   				<attribute name="name" type="string"></attribute>'+
					 '   				<attribute name="language" type="string"'+
					 '   					use="required">'+
					 '   				</attribute>'+
					 '   				<attribute name="subject" type="string"></attribute>'+
					 '   				<attribute name="isBranch" type="string"></attribute>'+

					 '   				<attribute name="description" type="string"'+
					 '   					use="optional">'+
					 '   				</attribute>'+
					 '   				<attribute name="foundError" type="boolean"></attribute>'+
					 '   			</complexType>'+
					 '   		</element>'+

					 '   	</sequence>'+
					 '   	<attribute name="name" type="string"></attribute>'+
					 '   	<attribute name="id" type="string" use="required"></attribute>'+

					 '   	<attribute name="defaultlang" type="string" use="required"></attribute>'+
					 '   	<attribute name="description" type="string" use="optional"></attribute>'+
					 '   	<attribute name="foundError" type="boolean"></attribute>'+
					 '   </complexType>'+


					 '   <complexType name="exceptionComplexType">'+
					 '   	<choice minOccurs="1" maxOccurs="1">'+
					 '   		<element minOccurs="1" maxOccurs="1" name="value"'+
					 '   			type="string">'+
					 '   		</element>'+
					 '   		<sequence minOccurs="1" maxOccurs="1">'+
					 '   			<element minOccurs="1" maxOccurs="1" name="minValue"'+
					 '   				type="string">'+
					 '   			</element>'+
					 '   			<element minOccurs="0" maxOccurs="1" name="maxValue"'+
					 '   				type="string">'+
					 '   			</element>'+
					 '   		</sequence>'+
					 '   		<element name="maxValue" type="string" minOccurs="1"'+
					 '   			maxOccurs="1">'+
					 '   		</element>'+
					 '   	</choice>'+
					 '   	<attribute name="name" type="string"></attribute>'+
					 '   	<attribute name="attribute" type="string" use="required"></attribute>'+
					 '   	<attribute use="optional" name="attributeType">'+
					 '   		<simpleType>'+
					 '   			<restriction base="string">'+
					 '   				<enumeration value="contact"></enumeration>'+
					 '   				<enumeration value="system"></enumeration>'+
					 '   			</restriction>'+
					 '   		</simpleType>'+
					 '   	</attribute>'+
					 '   	<attribute name="isBranch" type="boolean"></attribute>'+
					 '   	<attribute name="description" type="string" use="optional"></attribute>'+
					 '       <attribute name="operator" type="tns:operatorType"></attribute>'+
					 '       <attribute name="foundError" type="boolean"></attribute>'+
					 '   </complexType>'+

					 '   <simpleType name="NewSimpleType">'+
					 '   	<restriction base="string"></restriction>'+
					 '   </simpleType>'+

					 '   <simpleType name="operatorType">'+
					 '   	<restriction base="string">'+
					 '   		<enumeration value="Equals"></enumeration>'+
					 '   		<enumeration value="Contains"></enumeration>'+
					 '   		<enumeration value="IsNull"></enumeration>'+
					 '   		<enumeration value="IsNotNull"></enumeration>'+
					 '   		<enumeration value="NotEqual"></enumeration>'+
					 '   	</restriction>'+
					 '   </simpleType>'+

					 '   <complexType name="AgentType">'+
					 '   	<attribute name="name" type="string"></attribute>'+
					 '   	<attribute name="description" type="string"></attribute>'+
					 '   	<attribute name="agentScriptName" type="string"></attribute>'+
					 '   	<attribute name="agentScript" type="string"></attribute>'+
					 '   	<attribute name="callBackExpiryTime" type="string"></attribute>'+
					 '   	<attribute name="prefAgentCallback" type="string"></attribute>'+
					 '   	<attribute name="strictAgentCallback" type="string"></attribute>'+
					 '   	<attribute name="campaignCallBack" type="string"></attribute>'+
					 '   	<attribute name="generalCallBack" type="string"></attribute>'+
					 '   	<attribute name="canCancelCallback" type="string"></attribute>'+
					 '   	<attribute name="nailingNoAnswerTime" type="int"></attribute>'+
					 '   	<attribute name="foundError" type="boolean"></attribute>'+
					 '   </complexType>'+
					 '   <complexType name="CustomMailType">'+
					 '   	<attribute name="name" type="string"></attribute>'+
					 '   	<attribute name="description" type="string"></attribute>'+
					 '   	<attribute name="application" type="string"></attribute>'+
					 '   	<attribute name="foundError" type="string"></attribute>'+
					 '   </complexType>'+
					 '</schema>';
