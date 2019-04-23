package dachuang.industry.supervision.backend.platform.response.user;

import dachuang.industry.supervision.backend.platform.response.Response;
import lombok.Data;

@Data
public class UserLoginResponse extends Response {
    private String username;
    private String password;
    public UserLoginResponse(String username, String password){
        this.username = username;
        this.password = password;
    }
}
