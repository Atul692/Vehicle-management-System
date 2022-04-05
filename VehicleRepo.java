package com.example.vehicleMngt.Repo;

import com.example.vehicleMngt.Model.VehicleModel;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<VehicleModel,Integer> {
}
