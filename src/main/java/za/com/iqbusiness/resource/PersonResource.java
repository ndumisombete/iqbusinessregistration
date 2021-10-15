package za.com.iqbusiness.resource;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.com.iqbusiness.model.ActionStatusType;
import za.com.iqbusiness.model.PersonModel;
import za.com.iqbusiness.model.exception.ExceptionResponseType;
import za.com.iqbusiness.service.PersonService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping({"/v1"})
@CrossOrigin
@Slf4j
public class PersonResource {
    @Autowired
    PersonService personService;
    @RequestMapping(value = {"/person"}, method = {RequestMethod.POST}, consumes = {"application/json"}, produces = {"application/json"})
    @ApiOperation(value = "Create Person", response = ActionStatusType.class)
    @ApiResponses({@ApiResponse(code = 200, message = "Successful creation of Person", response = ActionStatusType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public ActionStatusType addPerson(@ApiParam(name = "PersonModel", value = "PersonEntity payload", required = true) @Valid @RequestBody PersonModel personModel) throws IOException {
        return this.personService.registerPerson(personModel);
    }

    @RequestMapping(value = {"/persons"}, method = {RequestMethod.GET}, produces = {"application/json"})
    @ApiOperation(value = "Get Persons", response = PersonModel.class, responseContainer = "List")
    @ApiResponses({@ApiResponse(code = 200, message = "Successful get form submissions", response = PersonModel.class, responseContainer = "List"), @ApiResponse(code = 404, message = "form submission does not found", response = ExceptionResponseType.class), @ApiResponse(code = 500, message = "Internal server error", response = ExceptionResponseType.class)})
    public List<PersonModel> getPersons() throws Exception {
        return this.personService.getPersons();
    }
}
