package com.ea.project2.controller;

import com.ea.project2.entity.ShippingAddress;
import com.ea.project2.repository.ShippingAddressRepository;
import com.ea.project2.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class ShippingAdressController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping("/{id}")
    public ShippingAddress getAddressById(@PathVariable("id") Long id) {
        return shippingService.getAddressById(id);
    }

    @PostMapping("/")
    public ShippingAddress addAddress(@RequestBody ShippingAddress shippingAddress) {
        return shippingService.addAddress(shippingAddress);
    }

    @PatchMapping("/{id}")
    public ShippingAddress updateAddress(@PathVariable("id") Long id, @RequestBody ShippingAddress shippingAddress) throws Exception {
        return shippingService.updateAddress(shippingAddress, id);
    }

    @DeleteMapping("/{id}")
    public ShippingAddress deleteAddress(@PathVariable("id") Long id) throws Exception {
        return shippingService.deleteAddress(id);
    }

}
