package com.zhtian.dao;


import com.zhtian.entities.Role;

public interface RoleDao {

    public Role createRole(Role role);
    public void deleteRole(Long roleId);

}
