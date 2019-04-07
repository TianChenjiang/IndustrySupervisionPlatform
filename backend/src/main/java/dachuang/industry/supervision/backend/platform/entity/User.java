package dachuang.industry.supervision.backend.platform.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "wx_id")
    private String wx_id;

    @Column(name = "phone")
    private String phone;

    public User(){
    }
    public User(int id, String wx_id, String phone){
        this.id = id;
        this.wx_id = wx_id;
        this.phone = phone;
    }
}

