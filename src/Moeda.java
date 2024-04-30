import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public record Moeda(@SerializedName("base_code") String moeda) {

}
