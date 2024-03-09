package com.belhard.msvc_pozhilov.service.impl;

import com.belhard.msvc_pozhilov.EurekaClient;
import com.belhard.msvc_pozhilov.service.DiscoveryService;
//import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;

@RequiredArgsConstructor
public class DiscoveryServiceImpl implements DiscoveryService {
    private EurekaClient eurekaClient;
    @Override
    public void registerService(ServiceInstance serviceInstance) {
        eurekaClient.registerService(serviceInstance);
    }

    @Override
    public void unregisterService(ServiceInstance serviceInstance) {
        eurekaClient.unregisterService(serviceInstance);
    }
}
