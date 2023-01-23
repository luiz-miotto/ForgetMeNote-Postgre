package dnd.mlogger.web;

import dnd.mlogger.domain.Location;
import dnd.mlogger.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addlocation")
public class LocationAdderController {

    public LocationAdderDto locationAdderDto;

    @Autowired
     LocationRepository locationRepository;


    @PostMapping
    public String processLocation(LocationAdderDto locationAdderDto){
        Location location = new Location(locationAdderDto.getName());
        location.setSubLocations(locationAdderDto.getSubLocation());
        locationRepository.save(location);
        return "redirect:/locationlist";

    }

    @GetMapping
    public String locationAdder(){
        return "addlocation";
    }

    @ModelAttribute("locationAdderDto")
    public LocationAdderDto location(){
        return new LocationAdderDto();
    }
}
