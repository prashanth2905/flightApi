import com.hcl.hackathon.flightApi.model.FlightInfo
import com.hcl.hackathon.flightApi.services.FlightService
import spock.lang.Specification

import javax.xml.bind.JAXBContext
import javax.xml.bind.Unmarshaller


class FlightServicesTest extends Specification {


    def "marshal Vendor Not found  xml to obj"() {
        def expectedXml = '''<?xml version="1.0" encoding="UTF-8"?>
							<Request>
							   <Body>
							      <Action>
							         <FlightInfo>
										 <SourceLocation>ORD</SourceLocation>
							     		<DestinationLocation>CLT</DestinationLocation>
							         </FlightInfo>
							      </Action>
							   </Body>
							   <Header>
							      <Log>
							         <Level>INFO</Level>
							      </Log>
							      <EntityID>a</EntityID>
							   </Header>
							</Request>
							
							''';


        JAXBContext jaxbContext = JAXBContext.newInstance(FlightInfo.class);
        Unmarshaller um = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(addressXml);
        FlightInfo response = (FlightInfo) um.unmarshal(reader);

        expect :
        response.getDestinationLocation() != null;

    }





}