package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.model.Player.Player;
import ch.zli.m223.ksh19a.mj.CRM.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserWebController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/playerlist")
    String getPlayerList(Model model) {
        List<Player> userList = playerService.getAllPlayers();
        model.addAttribute("players", userList);

        return "playerList";
    }

    @GetMapping("/admin")
    String getToAdminPage() {
        return "admin_page";
    }

    @GetMapping("/user")
    String getToUserPage() {
        return "user_page";
    }


    @GetMapping("/login")
    String getToLoginPage() {
        return "login_page";
    }





}
