package com.cp.microservice.mobileapi.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface UserRegistrationSource {

    @Output("userRegistrationChannel")
    MessageChannel userRegistration();
}
