package dachuang.industry.supervision.backend.platform.response.user;

import dachuang.industry.supervision.backend.platform.entity.User;
import lombok.Data;

@Data
public class GetUserByIdResponse {
    private User user;
    public GetUserByIdResponse(User user){
        this.user = user;
    }
}
