package com.example.pinpointpersonalplates.services;
import com.example.pinpointpersonalplates.model.Plates;
import com.example.pinpointpersonalplates.model.PlatesDTO;
import com.example.pinpointpersonalplates.repository.PlatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatesDTOService
{
    @Autowired
    private PlatesRepository platesRepository;

    private PlatesDTO convertToPlatesDTO(Plates plates)
    {
        PlatesDTO platesDTO = new PlatesDTO();
        platesDTO.setPlateid(plates.getPlateid());
        platesDTO.setRegistrationplate(plates.getRegistrationplate());
        platesDTO.setCost(plates.getPayment().getCost());
        platesDTO.setFirstname(plates.getCustomer().getFirstname());
        platesDTO.setSecondname(plates.getCustomer().getSecondname());

        return platesDTO;
    }

    @Cacheable("plateDTOs")
    public List<PlatesDTO> getAllPlatesDTO()
    {
        //Calls findAll to get all plate entities from the platesrepo, converts them into a list of PLateDTO
        return ((List<Plates>)platesRepository.findAll()).stream().map(this::convertToPlatesDTO).collect(Collectors.toList());
    }

    @Cacheable("plateDTO")
    public PlatesDTO getPlatesDTOById(int id)
    {
        List<PlatesDTO> platesDTOList =getAllPlatesDTO();

        for(PlatesDTO platesDTO : platesDTOList)
        {
            if(platesDTO.getPlateid() ==id)
            {
                return platesDTO;
            }
        }
        return null;
    }
}
