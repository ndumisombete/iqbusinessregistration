package za.com.iqbusiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.com.iqbusiness.entity.PersonEntity;
import za.com.iqbusiness.model.ActionStatusType;
import za.com.iqbusiness.model.PersonModel;
import za.com.iqbusiness.repository.PersonRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public ActionStatusType registerPerson(PersonModel personModel) throws IOException {
        if(personModel.getFullName() == null || personModel.getFullName().isEmpty()
              || personModel.getIdNumber().equals(0) || personModel.getTelephoneNumber() == null
                || personModel.getTelephoneNumber().isEmpty()
            ){
            return new ActionStatusType(Boolean.valueOf(true), "mandatory.fields.cannot.be.empty");
        } else {
            PersonEntity personEntity = new PersonEntity();

            personEntity.setFullName(personModel.getFullName());

            personEntity.setIdNumber(personModel.getIdNumber());

            personEntity.setTelephoneNumber(personModel.getTelephoneNumber());

            personRepository.save(personEntity);

            return new ActionStatusType(Boolean.valueOf(true), "person.registered.successful");

        }
    }

    @Override
    public PersonModel getPerson(Integer personId) {
        return null;
    }

    @Override
    public List<PersonModel> getPersons() {

        List<PersonEntity> personEntities = personRepository.findAll();
        List<PersonModel> personModels = new ArrayList<>();

        for (PersonEntity personEntity : personEntities){
             PersonModel personModel = new PersonModel();
             personModel.setFullName(personEntity.getFullName());
             personModel.setPersonId(personEntity.getPersonId());
             personModel.setIdNumber(personEntity.getIdNumber());
             personModel.setTelephoneNumber(personEntity.getTelephoneNumber());
             personModels.add(personModel);
        }

        return personModels;
    }

    @Override
    public ActionStatusType delete(Integer personId) {
        return null;
    }
}
