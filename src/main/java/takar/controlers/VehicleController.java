package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.IBicycleManagement;
import takar.dataManagementServices.ICarManagement;
import takar.dataManagementServices.ITrailerManagement;
import takar.dataManagementServices.IVehicleManagement;
import takar.model.Vehicle;

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

    @RequestMapping("rent")
    public String addvehicle(@RequestParam(value="brand", required=true) String brand,
                             @RequestParam(value="model", required=true) String model,
                             @RequestParam(value="placeNumber", required=true) String placeNumber,
                             @RequestParam(value="description", required=true) String description,
                             @RequestParam(value="price", required=true) String price,
                             @RequestParam(value="infoForClient", required=true) String infoForClient,

                             @RequestParam(value="voiture") Boolean voiture,
                             @RequestParam(value="year", required=false) String year,
                             @RequestParam(value="motorization", required=false) String motorization,
                             @RequestParam(value="power", required=false) String power,
                             @RequestParam(value="licensePlate", required=false) String licensePlate,
                             @RequestParam(value="trunkVolume", required=false) String trunkVolume,

                             @RequestParam(value="moto") Boolean moto,
                             @RequestParam(value="type", required=false) String type,
                             @RequestParam(value="size", required=false) String size,
                             @RequestParam(value="isElectrical", required=false) Boolean isElectrical,

                             @RequestParam(value="remorque") Boolean remorque,
                             @RequestParam(value="capacity", required=false) String capacity,
                             @RequestParam(value="weight", required=false) String weight,
                             @RequestParam(value="length", required=false) String length,

                             Model modell)
    {
        /*TODO : Choisir si c'est une voiture une remorque ou une moto Donc ajouter les classes correspondantes et une case dans le html*/

        if(brand != null && model != null && placeNumber != null && description != null && price != null && infoForClient != null) {
            if(voiture)
                carManager.addCar(brand, model,Integer.parseInt(placeNumber), Double.parseDouble(price), infoForClient,description, year,motorization,power,licensePlate,Double.parseDouble(trunkVolume));
            if(remorque)
                trailerManager.addTrailer(brand, model,Integer.parseInt(placeNumber), Double.parseDouble(price), infoForClient,description, Double.parseDouble(capacity), Double.parseDouble(weight), Double.parseDouble(length),licensePlate);
            if(moto)
                bicycleManager.addBicycle(brand, model,Integer.parseInt(placeNumber), Double.parseDouble(price), infoForClient,description, type, size, isElectrical);
        }

        //(String brand, String model, Integer placeNumber, String description, double price, String infoForClient, int note)
        //Iterable<Vehicle> allVehicle = vehicleManager.getAllVehicle();
        //modell.addAttribute("vehicle", allVehicle);
        return "addVehicle";
    }

    @RequestMapping("search")
    public String look4vehicle(Model modell)
    {
        //(String brand, String model, Integer placeNumber, String description, double price, String infoForClient, int note)
        Iterable<Vehicle> allVehicle = vehicleManager.getAllVehicle();
        modell.addAttribute("vehicle", allVehicle);
        return "searchVehicle";
    }

}
