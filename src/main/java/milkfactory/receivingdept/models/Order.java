package milkfactory.receivingdept.models;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "order")
public @Data
class Order {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "provider_id")
    private Long providerId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date_time")
    private Date orderDateTime;

    @Column(name = "milk_class")
    private MilkClass milkClass;

    @Column(name = "milk_volume")
    private Long milkVolume;

    enum MilkClass {
        FirstClass,
        SecondClass,
        ThirdClass
    }
}
