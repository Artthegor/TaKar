package takar.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import takar.dataManagementServices.IVehicleManagement;
import takar.model.Vehicle;

@Controller
@RequestMapping("locate")
public class VehiculeController {
    @Autowired
    private IVehicleManagement vehicleManager;

    @RequestMapping("vehicle")
    public String addvehicle(@RequestParam(value="brand", required=false) String brand, @RequestParam(value="model", required=false) String model, @RequestParam(value="placeNumber", required=false) Integer placeNumber, Model modell)
    {
        if(brand != null && model != null && placeNumber > 0) {
            vehicleManager.addVehicle(brand, model, placeNumber, description);
        }

        //(String brand, String model, Integer placeNumber, String description, double price, String infoForClient, int note)
        Iterable<Vehicle> allVehicle = vehicleManager.getAllVehicle();
        modell.addAttribute("vehicle",allVehicle);
        return "addVehicule";
    }

}
