package kazim.redis.controller;

import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kazim.redis.model.Model;
import kazim.redis.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RedisController {
    @Autowired
    private ModelRepository repository;

    @GetMapping(path = "/redis", produces = "application/json")
    public Object redisGet(@RequestParam Map<String, String> param) {
        try {
            return new ResponseEntity<>(new Gson().toJson(repository.findById(param.get("id")).get()), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/redis", produces = "application/json")
    public Object redisSet(@RequestBody String body) {
        try {
            JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();
            Model model = new Gson().fromJson(body, Model.class);
            repository.save(model);
            return new ResponseEntity<>(new Gson().toJson(model), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/redis", produces = "application/json")
    public Object redisDel(@RequestParam Map<String, String> param) {
        try {
            repository.deleteById(param.get("id"));
            return new ResponseEntity<>("{\"Message\":\"Delete id" + param.get("id") + "\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
