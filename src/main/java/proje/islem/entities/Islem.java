package proje.islem.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@AllArgsConstructor
@Data
@Entity
@Table(name = "islem")
public class Islem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private long islemYapanId;

    @NotNull
    private Date islemTarihi;

    @NotNull
    private float tutar;

}
