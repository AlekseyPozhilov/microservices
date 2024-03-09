package com.belhard.msvc_pozhilov;

import org.springframework.cloud.client.ServiceInstance;

public interface EurekaClient {
    void registerService(ServiceInstance serviceInstance);
    void unregisterService(ServiceInstance serviceInstance);
}
