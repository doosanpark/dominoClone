package unic.domino.pizza.clone.server.join.controller;

import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unic.domino.pizza.clone.server.join.entity.User;
import unic.domino.pizza.clone.server.join.repository.JoinRepository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/join")
public class JoinController {
    private JoinRepository joinRepository;

    @Autowired
    public void setJoinRepository(JoinRepository joinRepository) {
        this.joinRepository = joinRepository;
    }

    @PostMapping("/list")
    public ResponseEntity<List<User>> getUserList(){
        return ResponseEntity.ok(joinRepository.findAll());
    }

    @PostMapping("/item")
    public ResponseEntity<User> getUser(@RequestBody HashMap<String, String> userMap){
        return ResponseEntity.ok(joinRepository.selectUser(userMap.get("userId")));
    }

    @PostMapping("/insert")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        String password = user.getUserPassword();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUserPassword(passwordEncoder.encode(password));
        user.setRegDtm(Instant.now());
        User saveData = joinRepository.saveAndFlush(user);
        return ResponseEntity.ok(saveData);
    }
}
