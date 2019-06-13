package com.bit.web.service;

import java.util.List;

import com.bit.web.domain.ShipperDTO;

import org.springframework.stereotype.Component;

/**
 * ShipperService
 */
@Component
public interface ShipperService {
    public void addShipper(ShipperDTO shipper);    
    public List<ShipperDTO> findShippers();
    public List<ShipperDTO> findShippersByOption(ShipperDTO option);
    public ShipperDTO findShipperByShipperId(String shipperId);
    public void updateShipper(ShipperDTO shipper);
    public void deleteShipper(ShipperDTO shipper);
    
}