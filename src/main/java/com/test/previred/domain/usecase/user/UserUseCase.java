package com.test.previred.domain.usecase.user;

import com.test.previred.domain.model.user.User;
import com.test.previred.domain.model.user.gateway.UserRepository;
import com.test.previred.infrastructure.adapter.consumer.client.ClientResponse;
import com.test.previred.infrastructure.adapter.consumer.client.CustomerRestConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@Component
@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;

    @Autowired
    private  final CustomerRestConsumer customerRestConsumer;
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    public ClientResponse updateUser(User user) throws MalformedURLException, URISyntaxException {
        return customerRestConsumer.sendDataToEndpoint("Leo_desarrollo",
                "111111",
                "35",
                "\"0\":\"1\",\"83\":\"10\"}");
    }

    public User findAll() {
        return customerRestConsumer.sendDataToEndpoint("Leo_desarrollo",
                "111111",
                "35",
                "\"0\":\"1\",\"83\":\"10\"}");
    }
}
