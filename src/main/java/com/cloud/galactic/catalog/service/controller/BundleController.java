package com.cloud.galactic.catalog.service.controller;

import com.cloud.galactic.openapi.api.ApiUtil;
import com.cloud.galactic.openapi.api.BookApi;
import com.cloud.galactic.openapi.api.BundleApi;
import com.cloud.galactic.openapi.model.Book;
import com.cloud.galactic.openapi.model.BundleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BundleController implements BundleApi {

    @Override
    public ResponseEntity<String> addBundle(
           BundleDto book
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    @Override
    public ResponseEntity<List<BundleDto>> getAllBundle(
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"name\" : \"Chả lụa\", \"id\" : \"B0001\", \"nameGroup\" : \"Chả\", \"status\" : true }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }
}
