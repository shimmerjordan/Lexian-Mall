package lexian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int ID;
    private Timestamp date;
    private String description;
    private int comment;
    private int total;
    private int status;
    private int isDelete;
}
