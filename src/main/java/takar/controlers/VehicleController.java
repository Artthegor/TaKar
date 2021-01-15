package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.IVehicleManagement;
import takar.model.Vehicle;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
    @Autowired
    private IVehicleManagement vehicleManager;

    @RequestMapping("rent")
    public String addvehicle(@RequestParam(value="brand", required=false) String brand, @RequestParam(value="model", required=false) String model, @RequestParam(value="placeNumber", required=false) Integer placeNumber, @RequestParam(value="description", required=false) String description, @RequestParam(value="price", required=false) Double price, @RequestParam(value="infoForClient", required=false) String infoForClient, @RequestParam(value="note", required=false) Integer note, Model modell)
    {
        if(brand != null && model != null && placeNumber > 0 && description != null && price > 0 && infoForClient != null) {
            vehicleManager.addVehicle(brand, model, placeNumber, description, price, infoForClient, note);
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
