package com.hh.userservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    public static final Long serialVersionUID=2L;
    private String roleId;
    private String name;
    private String permissionId;
    private Set<Permission> permissions;
}
