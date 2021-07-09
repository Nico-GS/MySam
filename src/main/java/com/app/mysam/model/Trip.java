package com.app.mysam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "trip")
public class Trip {

    @Id
    private String id;

    @Field(value = "driverId")
    private String driverId;

    @Field("customerLastName")
    @NotBlank(message = "Customer LastName can't be blank")
    private String customerLastName;

    @Field("customerFirstName")
    @NotBlank(message = "Customer FirstName can't be blank")
    private String customerFirstName;

    @Field("customerPhone")
    @NotBlank(message = "Customer Phone can't be blank")
    private String customerPhone;

    @Field(value = "tripState")
    private TripState state;

    @Field(value = "price")
    private Double price;

    @Field(value = "debitCustomer")
    private Double debitCustomer;

    @Field(value = "creditDriver")
    private Double creditDriver;

    @Field(value = "creditMySam")
    private Double creditMySam;

    @Field(value = "startTrip")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime startTrip;

    @Field(value = "endTrip")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime endTrip;


}
