package com.example.demo.feign;

import com.example.demo.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "user-service",configuration = CustomerRetryClientConfig.class,fallbackFactory = HystrixFallBackFactory.class)
@FeignClient(name = "user-service")
public interface UserFeign {
    @GetMapping("/users/{userId}")
    ResponseEntity<UserDto> getUserById(@PathVariable("userId") String userId);
}
