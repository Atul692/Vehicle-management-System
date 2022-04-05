package com.example.vehicleMngt.Service;

import com.example.vehicleMngt.Model.VehicleModel;
import com.example.vehicleMngt.Repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    VehicleRepo vehicleRepo;


    public List<VehicleModel> getAllVehicles() {
        List<VehicleModel> vehicles = new ArrayList<VehicleModel>();
        vehicleRepo.findAll().forEach(vehicle -> vehicles.add(vehicle));
        return vehicles;
    }

    public VehicleModel createVehicle(VehicleModel vehicleModel) {

        try {
            return vehicleRepo.save(vehicleModel);
        }catch (Exception e){
            throw  new NoVehicleFoundException();
        }
    }

    public void delete(int id) {
        vehicleRepo.deleteById(id);
    }

    public String updateVehicle(int id, VehicleModel vehicleModel) {
        VehicleModel vm = vehicleRepo.findById(id).get();
        System.out.println(vm.getId());
        vm.setName(vehicleModel.getName());
        vm.setType(vehicleModel.getType());
        vm.setCompany(vehicleModel.getCompany());
        final VehicleModel updatedVehicle =vehicleRepo.save(vm);
        return "Vehicle with ID: "+updatedVehicle.getId()+" has been updated";

    }
}
