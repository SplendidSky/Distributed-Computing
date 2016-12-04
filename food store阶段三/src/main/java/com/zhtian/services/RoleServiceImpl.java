package com.zhtian.services;

import com.zhtian.dao.RoleDao;
import com.zhtian.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
    private RoleDao roleDao;

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

}
