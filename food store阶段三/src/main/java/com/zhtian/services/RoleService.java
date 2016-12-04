package com.zhtian.services;


import com.zhtian.entities.Role;

public interface RoleService {


    public Role createRole(Role role);
    public void deleteRole(Long roleId);

}
