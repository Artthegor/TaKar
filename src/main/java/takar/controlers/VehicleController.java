package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.IBicycleManagement;
import takar.dataManagementServices.ICarManagement;
import takar.dataManagementServices.ITrailerManagement;
import takar.dataManagementServices.IVehicleManagement;
import takar.model.*;
import takar.repositories.UserRepository;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
    @Autowired
    private ICarManagement carManager;
    @Autowired
    private ITrailerManagement trailerManager;
    @Autowired
    private IBicycleManagement bicycleManager;
    @Autowired
    private IVehicleManagement vehicleManager;
    @Autowired
    private UserRepository userRepo;

    @RequestMapping("rent")
    public String addvehicle(@RequestParam(value="brand", required=false) String brand,
                             @RequestParam(value="model", required=false) String model,
                             @RequestParam(value="description", required=false) String description,
                             @RequestParam(value="price", required=false) String price,
                             @RequestParam(value="infoForClient", required=false) String infoForClient,

                             //voiture
                             @RequestParam(value="year", required=false) String year,
                             @RequestParam(value="motorization", required=false) String motorization,
                             @RequestParam(value="power", required=false) String power,
                             @RequestParam(value="licensePlate", required=false) String licensePlate,
                             @RequestParam(value="trunkVolume", required=false) String trunkVolume,
                             @RequestParam(value="placeNumber", required=false) String placeNumber,

                             //velo
                             @RequestParam(value="type", required=false) String type,
                             @RequestParam(value="size", required=false) String size,
                             @RequestParam(value="isElectrical", required=false) Boolean isElectrical,

                             //remorque
                             @RequestParam(value="capacity", required=false) String capacity,
                             @RequestParam(value="weight", required=false) String weight,
                             @RequestParam(value="length", required=false) String length,

                             Model modell)
    {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepo.findByUsername(username);
        System.out.println("controleur vehicle username : " + username);
        /*TODO : Choisir si c'est une voiture une remorque ou une moto Donc ajouter les classes correspondantes et une case dans le html*/
        try {
            if (brand != null &&
                    model != null &&
                    description != null &&
                    price != null &&
                    infoForClient != null &&
                    !brand.trim().isEmpty() &&
                    !model.trim().isEmpty() &&
                    !description.trim().isEmpty() &&
                    Double.parseDouble(price) > 0 &&
                    !infoForClient.trim().isEmpty()) {
                if (year != null &&
                        placeNumber != null &&
                        motorization != null &&
                        power != null &&
                        licensePlate != null &&
                        trunkVolume != null &&
                        Integer.parseInt(placeNumber) > 0 &&
                        !motorization.trim().isEmpty() &&
                        !power.trim().isEmpty() &&
                        !licensePlate.trim().isEmpty() &&
                        Double.parseDouble(trunkVolume) > 0 &&
                        Integer.parseInt(year) > 1800 &&
                        Integer.parseInt(year) < 2022) {
                    carManager.addCar(brand, model, Integer.parseInt(placeNumber), Double.parseDouble(price), infoForClient, description, year, motorization, power, licensePlate, Double.parseDouble(trunkVolume),user);
                } else {
                    if (type != null &&
                            size != null &&
                            isElectrical != null &&
                            !type.trim().isEmpty() &&
                            !size.trim().isEmpty()) {
                        bicycleManager.addBicycle(brand, model, Double.parseDouble(price), infoForClient, description, type, size, isElectrical,user);
                    } else {
                        if (capacity != null &&
                                weight != null &&
                                length != null &&
                                licensePlate != null &&
                                Double.parseDouble(capacity) > 0 &&
                                Double.parseDouble(weight) > 0 &&
                                Double.parseDouble(length) > 0 &&
                                !licensePlate.trim().isEmpty()) {
                            trailerManager.addTrailer(brand, model, Double.parseDouble(price), infoForClient, description, Double.parseDouble(capacity), Double.parseDouble(weight), Double.parseDouble(length), licensePlate,user);
                        } else {
                            System.out.println("Selection non valide");
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Selection non valide");
        }
        return "addVehicle";
    }

    @RequestMapping("search")
    public String look4vehicle(Model modell)
    {
        Iterable<Vehicle> allVehicle = vehicleManager.getAllVehicle();
        modell.addAttribute("vehicle", allVehicle);
        return "searchVehicle";
    }

    @RequestMapping("car")
    public String PrintCar(Car car, Model modell)
    {
        modell.addAttribute("car", car);
        modell.addAttribute("vehicle", car.getVehicle());
        return "car";
    }
    @RequestMapping("bicycle")
    public String PrintBicycle(Bicycle bicycle, Model modell)
    {
        modell.addAttribute("bicycle", bicycle);
        modell.addAttribute("vehicle", bicycle.getVehicle());
        return "bicycle";
    }
    @RequestMapping("trailer")
    public String PrintTrailer(Trailer trailer, Model modell)
    {
        modell.addAttribute("trailer", trailer);
        modell.addAttribute("vehicle", trailer.getVehicle());
        return "trailer";
    }

}
