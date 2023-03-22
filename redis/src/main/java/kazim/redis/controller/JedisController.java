package kazim.redis.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.Map;

@RestController
public class JedisController {
    @Autowired
    private Jedis jedis;

    @GetMapping(path = "/jedis/")
    public Object jedisGet(@RequestParam Map<String, String> param) {
        try {
            return new ResponseEntity<>(jedis.get(param.get("id")), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/jedis/")
    public Object jedisSet(@RequestBody String body) {
        try {
            JsonObject jsonObject = JsonParser.parseString(body).getAsJsonObject();
            return new ResponseEntity<>(jedis.set(jsonObject.get("id").toString(), jsonObject.toString()), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping (path = "/jedis/")
    public Object jedisDel(@RequestParam Map<String, String> param) {
        try {
            jedis.del(param.get("id"));
            return new ResponseEntity<>("{\"Message\":\"Delete id" + param.get("id") + "\"}", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
