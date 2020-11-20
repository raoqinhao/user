package com.hh.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements Serializable {
    public static final Long serialVersionUID=3L;
    private String permissionId;
    private String permissionString;
}
