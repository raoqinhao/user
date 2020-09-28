package com.hh.userservice.pojo;

import lombok.Data;
import java.io.Serializable;

@Data
public class Permission implements Serializable {
    public static final Long serialVersionUID=3L;
    private String permissionId;
    private String permissionString;
}
