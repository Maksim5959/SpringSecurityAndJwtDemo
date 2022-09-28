package com.example.security.model;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum AppUserRole {
    USER(Sets.newHashSet(AppUserPermission.STUDENT_READ)),
    ADMIN(Sets.newHashSet(AppUserPermission.STUDENT_WRITE, AppUserPermission.STUDENT_READ)),
    STUDENT(Sets.newHashSet());

    private final Set<AppUserPermission> appUserPermissionSet;

    AppUserRole(Set<AppUserPermission> appUserPermissionSet) {
        this.appUserPermissionSet = appUserPermissionSet;
    }

    public Set<AppUserPermission> getPermissions() {
        return appUserPermissionSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
