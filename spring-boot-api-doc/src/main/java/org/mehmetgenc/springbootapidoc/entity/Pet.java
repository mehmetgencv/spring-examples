package org.mehmetgenc.springbootapidoc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet Entity", description = "Pet")
public class Pet {
    @ApiModelProperty(value = "Pet`s ID space")
    private int id;
    @ApiModelProperty(value = "Pet`s Name space")
    private String name;
    @ApiModelProperty(value = "Pet`s date space")
    private Date date;
}
