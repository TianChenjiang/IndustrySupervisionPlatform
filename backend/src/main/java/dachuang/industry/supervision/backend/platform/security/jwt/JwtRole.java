package dachuang.industry.supervision.backend.platform.security.jwt;

import dachuang.industry.supervision.backend.platform.publicdates.Role;
import org.springframework.security.core.GrantedAuthority;
import net.sf.json.JSONObject;


public class JwtRole implements GrantedAuthority {
    public static final JwtRole USER = new JwtRole(Role.USER.getName());
    public static final JwtRole ADMIN = new JwtRole(Role.ADMIN.getName());

    private String roleName;

    private JwtRole(String roleName) {
        this.roleName = roleName;
    }

    public JwtRole(JSONObject jsonObject) {
        this.roleName = (String) jsonObject.get("name");
    }

    public JwtRole(Role role) {
        this.roleName = role.getName();
    }
    @Override
    public String getAuthority() {
        return roleName;
    }
}
