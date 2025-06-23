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

import com.essalud.sispoi.dto.FormulationSupportFileDTO;
import com.essalud.sispoi.exception.ModelNotFoundException;
import com.essalud.sispoi.model.FormulationSupportFile;
import com.essalud.sispoi.service.IFormulationSupportFileService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/formulation-support-file")
public class FormulationSupportFileController {

	@Autowired
    private ModelMapper mapper;

    @Autowired
    private IFormulationSupportFileService service;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> saveFormulationSupportFile(@RequestParam("file") MultipartFile file) throws Exception{

		int rpta = 0;

		FormulationSupportFile ar = new FormulationSupportFile();
		ar.setFileExtension(file.getContentType());
		ar.setName(file.getOriginalFilename());
		ar.setFile(file.getBytes());
        ar.setActive(true);

		rpta = service.saveFile(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@GetMapping("/{idFormulationSupportFile}")
    public ResponseEntity<FormulationSupportFileDTO> findById(@PathVariable Integer idFormulationSupportFile) {
        FormulationSupportFileDTO dtoResponse;
        FormulationSupportFile obj = service.findById(idFormulationSupportFile);

        if (obj == null) {
            throw new ModelNotFoundException("ID DOES NOT EXIST: " + idFormulationSupportFile);
        } else {
            dtoResponse = mapper.map(obj, FormulationSupportFileDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

	@GetMapping(value = "/{idFormulationSupportFile}/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> getFormulationSupportFile(@PathVariable("idFormulationSupportFile") Integer idFormulationSupportFile) throws IOException {

		byte[] arr = service.getFile(idFormulationSupportFile);

		return new ResponseEntity<>(arr, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        FormulationSupportFile obj = service.findById(id);

        if (obj == null) {
            throw new ModelNotFoundException("ID DOES NOT EXIST: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}