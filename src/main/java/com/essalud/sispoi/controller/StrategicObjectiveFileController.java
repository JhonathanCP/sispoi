package com.essalud.sispoi.controller;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.essalud.sispoi.dto.StrategicObjectiveFileDTO;
import com.essalud.sispoi.exception.ModelNotFoundException;
import com.essalud.sispoi.model.StrategicObjectiveFile;
import com.essalud.sispoi.service.IStrategicObjectiveFileService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/strategic-objective-file")
public class StrategicObjectiveFileController {

	@Autowired
    private ModelMapper mapper;

    @Autowired
    private IStrategicObjectiveFileService service;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> saveStrategicObjectiveFile(@RequestParam("file") MultipartFile file, @RequestParam("idFileType") Integer idFileType) throws Exception{

		int rpta = 0;

		StrategicObjectiveFile ar = new StrategicObjectiveFile();
		ar.setFileExtension(file.getContentType());
		ar.setName(file.getOriginalFilename());
		ar.setFile(file.getBytes());
        ar.setActive(true);

		rpta = service.saveFile(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@GetMapping("/{idForumationSupportFile}")
    public ResponseEntity<StrategicObjectiveFileDTO> findById(@PathVariable Integer idForumationSupportFile) {
        StrategicObjectiveFileDTO dtoResponse;
        StrategicObjectiveFile obj = service.findById(idForumationSupportFile);

        if (obj == null) {
            throw new ModelNotFoundException("ID DOES NOT EXIST: " + idForumationSupportFile);
        } else {
            dtoResponse = mapper.map(obj, StrategicObjectiveFileDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

	@GetMapping(value = "/{idForumationSupportFile}/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> getStrategicObjectiveFile(@PathVariable("idForumationSupportFile") Integer idForumationSupportFile) throws IOException {

		byte[] arr = service.getFile(idForumationSupportFile);

		return new ResponseEntity<>(arr, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        StrategicObjectiveFile obj = service.findById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID DOES NOT EXIST: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}