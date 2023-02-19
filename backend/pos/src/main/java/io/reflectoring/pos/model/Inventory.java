package io.reflectoring.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Inventory {

    @Id
    private String inventoryId;
    private String inventoryName;
    private String inventoryCategory;


}
