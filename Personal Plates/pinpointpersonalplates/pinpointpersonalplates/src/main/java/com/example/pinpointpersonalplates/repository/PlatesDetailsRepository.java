package com.example.pinpointpersonalplates.repository;

import com.example.pinpointpersonalplates.model.PlatesDTO;
import com.example.pinpointpersonalplates.services.PlatesDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class PlatesDetailsRepository
{
    @Autowired
    private PlatesDTOService platesDTOService;

    @GetMapping("/platesdetails")
    public List<PlatesDTO> getAllPlatesDetails()
    {
        return platesDTOService.getAllPlatesDTO();
    }

    @GetMapping("/platesdetails/{id}")
    public PlatesDTO getPlatesById(@PathVariable("id") int plateId)
    {
        PlatesDTO platesDTO = platesDTOService.getPlatesDTOById(plateId);

        if(platesDTO != null)
        {
            return platesDTO;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plate ID not found");
    }
}
