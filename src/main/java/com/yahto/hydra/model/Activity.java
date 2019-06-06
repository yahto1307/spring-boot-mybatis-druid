package com.yahto.hydra.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by yahto on 2019-05-27 17:01
 *
 * @author yahto
 */
@Data
@Builder
@EqualsAndHashCode
public class Activity {
    private Long id;

    private String name;

    private Date createAt;

    private Date updateAt;

}