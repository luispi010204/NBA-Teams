package ch.zli.m223.ksh19a.mj.CRM.controller.Role;


import ch.zli.m223.ksh19a.mj.CRM.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    List<RoleDto> getAllRoles() {
        return roleService.getAllRoles().stream().map(role -> new RoleDto(role)).collect(Collectors.toList());
    }

    @GetMapping("/roles/{id}")
    RoleDto getRole(@PathVariable("id") Long id) {
        return new RoleDto(roleService.getRole(id));
    }

    @PostMapping("/roles")
    RoleDto insertRole(@RequestBody RoleInputDto roleData) {
        return new RoleDto(roleService.insertRole(roleData.name));
    }

    @DeleteMapping("/roles/{id}")
    void deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRoleById(id);
    }


}
