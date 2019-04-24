package dachuang.industry.supervision.backend.platform.bl;

import dachuang.industry.supervision.backend.platform.parameter.user.InsertUserParameter;
import dachuang.industry.supervision.backend.platform.parameter.user.UpdateUserByIdParameter;
import dachuang.industry.supervision.backend.platform.response.user.GetUserByIdResponse;
import dachuang.industry.supervision.backend.platform.response.user.InsertUserResponse;
import dachuang.industry.supervision.backend.platform.response.user.UpdateUserByIdResponse;
import dachuang.industry.supervision.backend.platform.response.user.UserLoginResponse;
import dachuang.industry.supervision.backend.platform.blservice.UserBlService;
import dachuang.industry.supervision.backend.platform.dataservice.UserDataAccessService;
import dachuang.industry.supervision.backend.platform.entity.User;
import dachuang.industry.supervision.backend.platform.exception.WrongUsernameOrPasswordException;
import dachuang.industry.supervision.backend.platform.security.jwt.JwtService;
import dachuang.industry.supervision.backend.platform.security.jwt.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBlServiceImpl implements UserBlService {
    private final UserDataAccessService userDataAccessService;

    private final static String USER_DEFAULT_PASSWORD = "user";

    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtService jwtService;


    @Autowired
    public UserBlServiceImpl(UserDataAccessService userDataAccessService){
        this.userDataAccessService = userDataAccessService;
    }
    @Override
    public GetUserByIdResponse getUserById(int id) {
        User res = userDataAccessService.GetUserById(id);
        return new GetUserByIdResponse(res);
    }

    @Override
    public UpdateUserByIdResponse updateUserById(UpdateUserByIdParameter parameter) {
        User res = userDataAccessService.UpdateUserById(parameter.getId(), parameter.getPhone(), parameter.getWx_id(),parameter.getUsername(), parameter.getPassword());
        return new UpdateUserByIdResponse(res.getId(), res.getPhone(), res.getWx_id());
    }

    @Override
    public InsertUserResponse insertUser(InsertUserParameter parameter) {
        User res = userDataAccessService.InsertUser(parameter.getId(), parameter.getWx_id(), parameter.getPhone(),parameter.getUsername(), parameter.getPassword());
        return new InsertUserResponse(res) ;
    }

    @Override
    public UserLoginResponse login(String username, String password) throws WrongUsernameOrPasswordException {
        if (username.length() == 0) {
//            throw new CannotRegisterException();
        }
        if (password.equals(USER_DEFAULT_PASSWORD)) {

            JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(username);
            String token = jwtService.generateToken(jwtUser, EXPIRATION);
            return new UserLoginResponse(token);
        } else {
            if (userDataAccessService.confirmPassword(username, password)) {
                JwtUser jwtUser = (JwtUser) jwtUserDetailsService.loadUserByUsername(username);
                String token = jwtService.generateToken(jwtUser, EXPIRATION);
                return new UserLoginResponse(token);
            } else {
                throw new WrongUsernameOrPasswordException();
            }
        }
        return null;
    }
}
