package web.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import web.model.User;

@Service
public class UserService {
       private String uri = "http://91.241.64.178:7081/api/users";
    private RestTemplate restTemplate = new RestTemplate();

    public String getUsers() {
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        return result.getHeaders().get("Set-Cookie").get(0);
    }

    public String add(User user, String sessionId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cookie", sessionId);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, request, String.class);
        return responseEntity.getBody();
    }

    public String put(User user, String sessionId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cookie", sessionId);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);
        return responseEntity.getBody();
    }
    public String delete(User user, String sessionId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Cookie", sessionId);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://91.241.64.178:7081/api/users/3", HttpMethod.DELETE, request, String.class);
        return responseEntity.getBody();
    }
}
