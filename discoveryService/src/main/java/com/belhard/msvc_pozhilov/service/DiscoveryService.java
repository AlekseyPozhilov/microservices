package com.belhard.msvc_pozhilov.service;

import org.springframework.cloud.client.ServiceInstance;

public interface DiscoveryService {
    public void registerService(ServiceInstance serviceInstance);
    public void unregisterService(ServiceInstance serviceInstance);
}
