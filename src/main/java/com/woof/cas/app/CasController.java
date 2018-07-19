package com.woof.cas.app;

import com.woof.cas.algorithm.DetectionAlgorithm;
import com.woof.cas.model.Rule;
import com.woof.cas.model.Vehicle;
import com.woof.cas.model.VehicleData;
import com.woof.cas.storage.RuleStorage;
import com.woof.cas.storage.VehicleStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CasController {

    private VehicleStorage vehicleStorage;
    private RuleStorage ruleStorage;
    private DetectionAlgorithm detectionAlgorithm;

    @Autowired
    public CasController() {
        vehicleStorage = new VehicleStorage();
        ruleStorage = new RuleStorage();
        detectionAlgorithm = new DetectionAlgorithm(
                vehicleStorage,
                ruleStorage);
    }

    @RequestMapping(value = "/vehicle",
                    method = RequestMethod.POST,
                    consumes = "application/json")
    @ResponseBody
    public String newVehicle(@RequestBody Vehicle vehicle) {
        System.out.println(vehicle.toString());

        vehicleStorage.addVehicle(vehicle);

        return "200";
    }

    @RequestMapping(value = "/vehicle/{vin}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Vehicle getVehicle(@PathVariable String vin) {
        Vehicle vehicle = vehicleStorage.findVehicleByVin(vin);

        if (vehicle != null) {
            System.out.println(vehicle.toString());
        }

        return vehicle;
    }

    @RequestMapping(value = "/vehicle/{vin}",
                    method = RequestMethod.POST,
                    consumes = "application/json")
    @ResponseBody
    public String newVehicleData(@PathVariable String vin,
                                 @RequestBody VehicleData vehicleData) {
        System.out.println("VIN: " + vin + " data: " + vehicleData.toString());

        // run the algorithm
        detectionAlgorithm.onNewVehicleData(vin, vehicleData);

        return "200";
    }

    @RequestMapping(value = "/infrastructure/{intersectionId}",
                    method = RequestMethod.POST,
                    consumes = "application/json")
    @ResponseBody
    public String changeCurrentRule(@PathVariable Integer intersectionId,
                                    @RequestBody Rule newRule) {
        System.out.println("Intersection: " + intersectionId + " rule: " + newRule);

        ruleStorage.updateRuleFor(intersectionId, newRule);

        return "200";
    }
}
