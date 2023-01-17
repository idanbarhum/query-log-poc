package isb.querylogpoc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Entity
public class TestEntity {

    @GeneratedValue
    @Id
    private Long Id;
    private String string;
    private int integer;

}
