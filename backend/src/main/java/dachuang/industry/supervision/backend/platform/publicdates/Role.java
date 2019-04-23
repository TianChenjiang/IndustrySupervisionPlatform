package dachuang.industry.supervision.backend.platform.publicdates;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

@Embeddable
public class Role {
    public final static String USER_NAME = "ROLE_USER";
    public final static String RESTAURANT_NAME = "ROLE_RESTAURANT";
    public final static String ADMIN_NAME = "ROLE_ADMIN";
    public final static Role USER = new Role(USER_NAME);
    public final static Role ADMIN = new Role(ADMIN_NAME);

    private String name;

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
