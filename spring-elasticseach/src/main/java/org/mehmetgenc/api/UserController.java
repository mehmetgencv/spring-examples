package org.mehmetgenc.api;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.mehmetgenc.entity.User;
import org.mehmetgenc.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    @PostConstruct
    public void init(){
        User user = new User();
        user.setName("Mehmet");
        user.setSurname("Genc");
        user.setAddress("Hatay");
        user.setBirthDate(Calendar.getInstance().getTime());
        user.setId("MG001");
        userRepository.save(user);
    }
    @GetMapping("/{search}")
    public ResponseEntity<List <User>>getUser(@PathVariable String search){
        List<User> users = userRepository.getByCustomQuery(search);
        return ResponseEntity.ok(users);
    }
}
