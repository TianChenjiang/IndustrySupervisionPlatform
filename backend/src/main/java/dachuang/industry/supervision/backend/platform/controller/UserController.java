package dachuang.industry.supervision.backend.platform.controller;

import dachuang.industry.supervision.backend.platform.parameter.user.InsertUserParameter;
import dachuang.industry.supervision.backend.platform.parameter.user.UpdateUserByIdParameter;
import dachuang.industry.supervision.backend.platform.response.Response;
import dachuang.industry.supervision.backend.platform.response.user.GetUserByIdResponse;
import dachuang.industry.supervision.backend.platform.response.user.InsertUserResponse;
import dachuang.industry.supervision.backend.platform.response.user.UpdateUserByIdResponse;
import dachuang.industry.supervision.backend.platform.response.user.UserLoginResponse;
import dachuang.industry.supervision.backend.platform.blservice.UserBlService;
import dachuang.industry.supervision.backend.platform.exception.WrongUsernameOrPasswordException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserBlService userBlService;

    @Autowired
    public UserController(UserBlService userBlService){
        this.userBlService = userBlService;
    }

    @RequestMapping(value = "Login", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Response> login
            (@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            UserLoginResponse userLoginResponse = userBlService.login(username, password);
            return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
        }
        catch (WrongUsernameOrPasswordException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getResponse(), HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "GetUserById", method = RequestMethod.GET)
    public GetUserByIdResponse getUserById(@RequestParam(name = "id", defaultValue = "0") int id){
        return userBlService.getUserById(id);
    }

    @RequestMapping(value = "InsertUser", method = RequestMethod.POST)
    public InsertUserResponse insertUser(@RequestBody InsertUserParameter parameter){
        return userBlService.insertUser(parameter);
    }

    @RequestMapping(value = "UpdateUserById", method = RequestMethod.POST)
    public UpdateUserByIdResponse updateUserById(@RequestBody UpdateUserByIdParameter parameter){
        return userBlService.updateUserById(parameter);
    }
}
