package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.ICarManagement;
import takar.dataManagementServices.IVehicleManagement;
import takar.model.Vehicle;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
    @Autowired
    private ICarManagement carManager;
    @Autowired
    private IVehicleManagement vehicleManager;

    @RequestMapping("rent")
    public String addvehicle(@RequestParam(value="brand", required=false) String brand, @RequestParam(value="model", required=false) String model, @RequestParam(value="placeNumber", required=false) String placeNumber, @RequestParam(value="description", required=false) String description, @RequestParam(value="price", required=false) String price, @RequestParam(value="infoForClient", required=false) String infoForClient,@RequestParam(value="year", required=false) String year,@RequestParam(value="motorization", required=false) String motorization,@RequestParam(value="power", required=false) String power,@RequestParam(value="licensePlate", required=false) String licensePlate,@RequestParam(value="trunkVolume", required=false) String trunkVolume, Model modell)
    {
        System.out.println(brand+model+motorization+year+power+placeNumber+trunkVolume+price+licensePlate+description+infoForClient);
        if(brand != null && model != null && placeNumber != null && description != null && price != null && infoForClient != null) {
            carManager.addCar(brand, model,Integer.parseInt(placeNumber), Double.parseDouble(price), infoForClient,description, year,motorization,power,licensePlate,Double.parseDouble(trunkVolume));
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
