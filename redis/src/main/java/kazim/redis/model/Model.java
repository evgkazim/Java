package kazim.redis.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("model")
public class Model implements Serializable {
    private String id;
    private String name;
    private int x;
    private int y;
    private int z;

    public Model(String id, String name, int x, int y, int z) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
