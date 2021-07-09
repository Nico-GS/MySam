package com.app.mysam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "driver")
public class Driver {

    @Id
    private String id;

    @Field(value = "lastName")
    @NotBlank(message = "LastName can't be blank")
    private String lastName;

    @Field(value = "firstName")
    private String firstName;

    @Field(value = "tripId")
    private String tripId;

}
