package ch.zli.m223.ksh19a.mj.CRM.controller.Player;

import java.util.List;
import java.util.stream.Collectors;

import ch.zli.m223.ksh19a.mj.CRM.controller.Role.RoleDto;
import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.zli.m223.ksh19a.mj.CRM.controller.Role.RoleDto;
import ch.zli.m223.ksh19a.mj.CRM.controller.Player.PlayerDto;
import ch.zli.m223.ksh19a.mj.CRM.controller.Player.PlayerInputDto;



@RestController
@RequestMapping("/api/v1")
public class PlayerRestController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<PlayerDto> getAllPlayers() {
        return playerService.getAllPlayers().stream()
                .map(player -> new PlayerDto(player))
                .collect(Collectors.toList());
    }

    @GetMapping("/players/{id}")
    public PlayerDto getPlayer(@PathVariable("id") Long id) {
        return new PlayerDto(playerService.getPlayer(id));
    }

    @PostMapping("/players")
    public PlayerDto insertPlayer(@RequestBody PlayerInputDto playerData) {
        return new PlayerDto(playerService.insertPlayer(playerData.email, playerData.password));
    }

    @DeleteMapping("/players/{email}")
    public Long deleteUser(@PathVariable("email") String email) {
        return playerService.deletePlayer(email);
    }


    @GetMapping("/players/{id}/roles")
    public List<RoleDto> getRolesFromPlayer(@PathVariable("id") Long id) {
        Player player = playerService.getPlayer(id);
        return player.getRoles().stream()
                .map(role -> new RoleDto(role))
                .collect(Collectors.toList());
    }


}
