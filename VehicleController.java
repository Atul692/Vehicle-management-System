package com.example.vehicleMngt.Controller;

import com.example.vehicleMngt.Model.VehicleModel;
import com.example.vehicleMngt.Repo.VehicleRepo;
import com.example.vehicleMngt.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @Autowired
    VehicleRepo vehicleRepo;

    @GetMapping("/vehicles")
    private List<VehicleModel> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/vehicles/create")
    private VehicleModel createVehicle(@RequestBody VehicleModel vehicleModel){
        return vehicleService.createVehicle(vehicleModel);
    }

    @DeleteMapping("/vehicles/delete/{id}")
    private String deleteVehicle(@PathVariable("id") int id){
        try {
            vehicleService.delete(id);
            return "Vehicle record deleted!!!";
        }catch (Exception e){
            return "Vehicle with this ID doesn't exists!!!";
        }
    }

    @PutMapping("/vehicles/update")
    private String updateVehicle(@PathVariable("id") int id, @RequestBody VehicleModel vehicleModel){
        try {
            return vehicleService.updateVehicle(id,vehicleModel);
        }catch (Exception e){
            return "Book with this ID doesn't exists!!!";
        }
    }
}
