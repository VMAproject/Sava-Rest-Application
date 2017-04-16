package com.sava.controller;

import com.sava.model.BlackBook;
import com.sava.service.interfaces.BlackBookService;
import com.sava.util.CustomErrorType;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by verlamov on 16.04.17.
 */

@RestController
@RequestMapping("/api")
@Api(name = "Black Book API ", description = "Crud operations and methods for the table ", stage = ApiStage.RC)
public class BlackBookController {

    public static final Logger logger = LoggerFactory.getLogger(BlackBookController.class);

    //Service which will do all data retrieval/manipulation work
    private BlackBookService blackBookService;

    @Autowired
    public void setBlackBookService(BlackBookService blackBookService) {
        this.blackBookService = blackBookService;
    }


    // ----------------------------------Retrieve All BlackBook ---------------------------------------------

    @RequestMapping(value = "/blackBook/", method = RequestMethod.GET)
    @ApiMethod(description = "Retrieve All Black Book")
    public ResponseEntity<List<BlackBook>> listAllBlackBook() {
        List<BlackBook> blackBooks = blackBookService.findAllBlackBooks();
        if (blackBooks.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<BlackBook>>(blackBooks, HttpStatus.OK);
    }


    // -----------------------------------Retrieve Single BlackBook Notice ------------------------------------------

    @RequestMapping(value = "blackBook/{id}", method = RequestMethod.GET)
    @ApiMethod(description = "Retrieve Single Black Book client")
    public ResponseEntity<?> getBlackBookNotice(@PathVariable("id") Long id) {
        logger.info("Fetching Black Book Notice with id {}", id);

        BlackBook blackBook = blackBookService.findById(id);
        if (blackBook == null) {
            logger.error("Black Book Client with id {} not found.", id);
            return new ResponseEntity<Object>(new CustomErrorType("Black Book Client with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BlackBook>(blackBook, HttpStatus.OK);
    }

    // -----------------------------------------Create a BlackBook Notice -------------------------------------------
    @RequestMapping(value = "/blackBook/", method = RequestMethod.POST)
    @ApiMethod(description = "Create a BlackBook Notice")
    public ResponseEntity<?> createBlackBookNotice(@RequestBody BlackBook blackBook, UriComponentsBuilder uriComponentsBuilder) {
        logger.info("Creating Black Book :{}", blackBook);

        if (blackBookService.isBlackBookExist(blackBook)) {
            logger.error("Unable to Black Book. A blackBook with name {} already exist", blackBook.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Black Book with name " + blackBook.getName() + "already exist."), HttpStatus.CONFLICT);
        }
        blackBookService.saveBlackBook(blackBook);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/api/blackBook/{id}").buildAndExpand(blackBook.getId()).toUri());
        return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
    }

    // ---------------------------------------- Update a BlackBook Notice ------------------------------------------------

    @RequestMapping(value = "/blackBook/{id}", method = RequestMethod.PUT)
    @ApiMethod(description = "Update a BlackBook Notice")
    public ResponseEntity<?> updateBlackBookNotice(@PathVariable("id") Long id, @RequestBody BlackBook blackBook) {
        logger.info("Updating BlackBook Notice with id {}", id);

        BlackBook currentBlackBook = blackBookService.findById(id);

        if (currentBlackBook == null) {
            logger.error("Unable to update. BlackBook Notice with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. BlackBook Notice with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentBlackBook.setClientMac(blackBook.getClientMac());
        currentBlackBook.setName(blackBook.getName());

        blackBookService.updateBlackBook(currentBlackBook);
        return new ResponseEntity<BlackBook>(currentBlackBook, HttpStatus.OK);
    }

    // --------------------------------------------- Delete a BlackBook Notice -----------------------------------------

    @RequestMapping(value = "/blackBook/{id}", method = RequestMethod.DELETE)
    @ApiMethod(description = "Delete a BlackBook Notice")
    public ResponseEntity<?> deleteBlackBookNotice(@PathVariable("id") Long id) {
        logger.info("Fetching & Deleting BlackBook Notice with id {}", id);

        BlackBook blackBook = blackBookService.findById(id);
        if (blackBook == null) {
            logger.error("Unable to delete. BlackBook Notice with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. BlackBook Notice with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        blackBookService.deleteBlackBookById(id);
        return new ResponseEntity<BlackBook>(HttpStatus.NO_CONTENT);
    }

    // ------------------------------------------- Delete All BlackBook Notice-----------------------------
    @RequestMapping(value = "/blackBook/", method = RequestMethod.DELETE)
    @ApiMethod(description = "Delete All BlackBook Notices")
    public ResponseEntity<BlackBook> deleteAllBlackBookNotice() {
        logger.info("Deleting All BlackBook Notices");

        blackBookService.deleteAllBlackBooks();
        return new ResponseEntity<BlackBook>(HttpStatus.NO_CONTENT);
    }

}
