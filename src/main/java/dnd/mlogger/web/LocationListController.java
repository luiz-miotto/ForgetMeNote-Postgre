package dnd.mlogger.web;

import dnd.mlogger.domain.Location;
import dnd.mlogger.repositories.LocationRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/locationlist")
public class LocationListController {

    private final LocationRepository locationRepository;

    public LocationListController(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @GetMapping
    public String locationList(){
        return "locationlist";
    }

    @ModelAttribute(name="location")
    public List<Location> addLocationToModel(Model model){
        List<Location> locationList = new ArrayList<>();
        locationRepository.findAll().forEach(location -> {
            locationList.add(location);
        });
        return locationList;
    }
}
