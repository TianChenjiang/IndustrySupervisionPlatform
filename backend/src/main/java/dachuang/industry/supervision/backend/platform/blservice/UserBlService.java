package dachuang.industry.supervision.backend.platform.blservice;

import dachuang.industry.supervision.backend.platform.parameter.user.InsertUserParameter;
import dachuang.industry.supervision.backend.platform.parameter.user.UpdateUserByIdParameter;
import dachuang.industry.supervision.backend.platform.response.user.GetUserByIdResponse;
import dachuang.industry.supervision.backend.platform.response.user.InsertUserResponse;
import dachuang.industry.supervision.backend.platform.response.user.UpdateUserByIdResponse;
import dachuang.industry.supervision.backend.platform.response.user.UserLoginResponse;
import dachuang.industry.supervision.backend.platform.exception.WrongUsernameOrPasswordException;

public interface UserBlService {
    GetUserByIdResponse getUserById(int id);
    UpdateUserByIdResponse updateUserById(UpdateUserByIdParameter parameter);
    InsertUserResponse insertUser(InsertUserParameter parameter);
    UserLoginResponse login(String username, String password) throws WrongUsernameOrPasswordException;


}
