
package edu.javacourse.student_order.validator.register;

import edu.javacourse.student_order.config.Config;
import edu.javacourse.student_order.domain.Person;
import edu.javacourse.student_order.domain.register.CityRegisterRequest;
import edu.javacourse.student_order.domain.register.CityRegisterResponse;
import edu.javacourse.student_order.exception.CityRegisterException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;


public class RealCityRegisterChecker implements CityRegisterChecker{
    @Override
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException{
        
        CityRegisterRequest request = new CityRegisterRequest(person);
        
        Client client = ClientBuilder.newClient();
        CityRegisterResponse response = client.target(Config.getProperty(Config.CR_URL))
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                .readEntity(CityRegisterResponse.class);
    return response;
    }
}
