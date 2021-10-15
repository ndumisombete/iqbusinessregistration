package za.com.iqbusiness.service;

import za.com.iqbusiness.model.ActionStatusType;
import za.com.iqbusiness.model.PersonModel;

import java.io.IOException;
import java.util.List;

public interface PersonService {

    ActionStatusType registerPerson(PersonModel personModel) throws IOException;

    PersonModel getPerson(Integer personId);

    List<PersonModel> getPersons();

    ActionStatusType delete(Integer personId);
}
