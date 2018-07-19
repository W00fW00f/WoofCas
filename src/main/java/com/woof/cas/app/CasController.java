package com.woof.cas.app;

import com.woof.cas.model.Rule;
import com.woof.cas.model.Vehicle;
import com.woof.cas.model.VehicleData;
import org.springframework.web.bind.annotation.*;

@RestController
public class CasController {

    @RequestMapping(value = "/vehicle",
                    method = RequestMethod.POST,
                    consumes = "application/json")
    @ResponseBody
    public String newVehicle(@RequestBody Vehicle vehicle) {
        System.out.println(vehicle.toString());
        return "200";
    }

    @RequestMapping(value = "/vehicle/{vin}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    @ResponseBody
    public Vehicle getVehicle(@PathVariable String vin) {
        return new Vehicle(vin, "127.0.0.1:9999/");
    }

    @RequestMapping(value = "/vehicle/{vin}",
                    method = RequestMethod.POST,
                    consumes = "application/json")
    @ResponseBody
    public String newVehicleData(@PathVariable String vin,
                                 @RequestBody VehicleData vehicleData) {
        System.out.println("VIN: " + vin + " data: " + vehicleData.toString());
        return "200";
    }

    @RequestMapping(value = "/infrastructure/{intersectionId}",
                    method = RequestMethod.POST,
                    consumes = "application/json")
    @ResponseBody
    public String changeCurrentRule(@PathVariable String intersectionId,
                                    @RequestBody Rule newRule) {
        System.out.println("Intersection: " + intersectionId + " rule: " + newRule);
        return "200";
    }
}
