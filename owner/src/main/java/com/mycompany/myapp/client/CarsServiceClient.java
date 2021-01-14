package com.mycompany.myapp.client;

import com.mycompany.myapp.client.remoteentities.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@AuthorizedFeignClient (name = "car")
public interface CarsServiceClient {
    @RequestMapping (method = RequestMethod.GET,value = "/api/cars")
    List<Car> getAllCars();
}
