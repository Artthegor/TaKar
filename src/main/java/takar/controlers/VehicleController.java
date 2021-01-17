package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import takar.alert.AlertMail;
import takar.dataManagementServices.*;
import takar.model.*;
import takar.repositories.CarRepository;
import takar.repositories.ClientRepository;
import takar.repositories.UserRepository;
import takar.repositories.VehicleRepository;

import java.util.Date;


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
    @Autowired
    private ClientManagement clientManager;
    @Autowired
    private LocationManagement locaManager;
    @Autowired
    private VehicleRepository vehicleRepo;


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
                ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:spring/application-config.xml");
                AlertMail am = (AlertMail) context.getBean("alertMail");
                Client cli = clientManager.findByid(user.getUserID());
                am.sendRent(cli.getMail(), username);
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
        if(allVehicle.iterator().hasNext()) {
            modell.addAttribute("vehicle", allVehicle);
        }
        else {
            modell.addAttribute("noresult", "Pas de résultat pour votre recherche.");
        }
        return "searchVehicle";
    }

    @RequestMapping(value = "filtre", method = RequestMethod.GET)
    public String filtre(@RequestParam(value = "type", required = false) String type,@RequestParam(value = "prix", required = false) Double prix,@RequestParam(value = "note", required = false) Integer note, Model modell){
        Double prixMax = Double.MAX_VALUE;
        int minNote = note;
        boolean isFiltrePrix = (prix ==null);
        if(!isFiltrePrix){
            prixMax = prix;
        }
        switch (type) {
            case "car": {

                Iterable<Long> allIdsCar = carManager.getAllIds();
                Iterable<Vehicle> allCar = vehicleManager.getVehicleFilter(allIdsCar,prixMax,minNote);
                if(allCar.iterator().hasNext()) {
                    modell.addAttribute("vehicle", allCar);
                }
                else {
                    modell.addAttribute("noresult", "Pas de résultat pour votre recherche.");
                }

            }
            break;
            case "trailer": {

                Iterable<Long> allIdsTrailer = trailerManager.getAllIds();
                Iterable<Vehicle> allTrailer = vehicleManager.getVehicleFilter(allIdsTrailer,prixMax,minNote);
                if(allTrailer.iterator().hasNext()) {
                    modell.addAttribute("vehicle", allTrailer);
                }
                else {
                    System.out.println("VIDE");
                    String noresult ="Pas de résultat pour votre recherche.";
                    modell.addAttribute("noresult",noresult );                }

            }
            break;
            case "bicycle": {

                Iterable<Long> allIdsBicycle = bicycleManager.getAllIds();
                Iterable<Vehicle> allBicycle = vehicleManager.getVehicleFilter(allIdsBicycle,prixMax,minNote);
                if(allBicycle != null) {
                    modell.addAttribute("vehicle", allBicycle);
                }
                else {
                    modell.addAttribute("noresult", "Pas de résultat pour votre recherche.");
                }

            }
            break;
            case "all":{
                Iterable<Vehicle> allVehicle;
                allVehicle = vehicleManager.getVehicleFilter(vehicleManager.getAllIds(),prixMax,minNote);
                if(allVehicle.iterator().hasNext()) {
                    modell.addAttribute("vehicle", allVehicle);
                }
                else {
                    String noresult ="Pas de résultat pour votre recherche.";
                    modell.addAttribute("noresult",noresult );
                }
            }
        }
        return "searchVehicle";
    }

    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String PrintCar(@RequestParam(value = "idVehicle", required = false) String  id, Model modell)
    {
        Car car = carManager.getByid(Long.parseLong(id));
        if(car != null) {
            modell.addAttribute("car", car);
            modell.addAttribute("vehicle", car.getVehicle());
            return "car";
        }
        else{
            Bicycle bicycle = bicycleManager.getByid(Long.parseLong(id));
            if(bicycle != null){
                modell.addAttribute("bicycle", bicycle);
                modell.addAttribute("vehicle", bicycle.getVehicle());
                return "bicycle";
            }
            else{
                Trailer trailer = trailerManager.getByid(Long.parseLong(id));
                modell.addAttribute("trailer", trailer);
                modell.addAttribute("vehicle", trailer.getVehicle());
                return "trailer";
            }
        }
    }

    @RequestMapping(value ="myOffer", method = RequestMethod.GET)
    public String getMyOffer(Model modell){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepo.findByUsername(username);
        Iterable<Vehicle> myVehicle = vehicleManager.getMyLocation(user);
        modell.addAttribute("vehicle", myVehicle);
        return "searchVehicle";
    }


    @RequestMapping(value = "location", method = RequestMethod.GET)
    public String RentVehicle(@RequestParam(value = "idVehicle", required = false) Long idVehicle, @RequestParam(value = "startDate", required = false) Date startDate, @RequestParam(value = "enDate", required = false) Date endDate, Model modell){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepo.findByUsername(username);

        Vehicle vehicle = vehicleRepo.findByIdVehicle(idVehicle);

        locaManager.addLocation(vehicle, startDate, endDate, user);

        return "searchVehicle";
    }
}
