package models;

import lombok.Data;
import util.Const;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iid ;

    private String title;
    private String info;

    @Enumerated(EnumType.STRING)
    private Const.Status status;
}
