package com.coding.challenge.controller;

import com.coding.challenge.entity.Organization;
import com.coding.challenge.entity.User;
import com.coding.challenge.payload.OrganizationRequest;
import com.coding.challenge.service.OrganizationService;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("api/v1")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    private static final Logger logger = getLogger(OrganizationController.class);

    @GetMapping(value="/hello", produces={"application/json"})
    public ResponseEntity<String> HelloAPI() {

        return new ResponseEntity<String>("Hello API!", HttpStatus.OK);

    }

    @GetMapping(value="/organizations", produces={"application/json"})
    public ResponseEntity<List<Organization>> getAllOrganizations() {

        List<Organization> organizations = organizationService.getAllOrganizations();

        logger.trace("Organization count: " + organizations.size());

        return new ResponseEntity<>(organizations, HttpStatus.OK);

    }

    @GetMapping(value="/organization/user/{userID}", produces={"application/json"})
    public ResponseEntity<List<Organization>> getOrganizationsByUser( @PathVariable("userID") int userID ) {

        List<Organization> organizations = organizationService.getOrganizationsByUser(userID);

        logger.trace("Organization by user (id=" + userID + ") count: " + organizations.size());

        return new ResponseEntity<>(organizations, HttpStatus.OK);

    }

    @PostMapping("/organization")
    public ResponseEntity<?> createOrganization( @RequestBody OrganizationRequest organizationRequest ) {

        Organization organization = new Organization( organizationRequest );

        logger.trace("Organization to be created: " + organization.toString());

        organizationService.addOrganization(organization);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}
