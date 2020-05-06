package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/test")
public class RestController {
    @Autowired
    private  PlayerRepository playerRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewPlayer (@RequestParam String name){
        Player n = new Player();
        n.setName(name);
        playerRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @PutMapping(path="/rename")
    public @ResponseBody String renamePlayer(@RequestParam String name,@RequestParam Integer id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            Player n = new Player();
            n.setName(name);
            playerRepository.save(n);
            return "Modified";
        }
        return "No player with specified ID.";
    }

    @DeleteMapping(path="/all")
    public @ResponseBody String getAllPlayers(@RequestParam Integer id) {
        if(playerRepository.existsById(id)){
            playerRepository.deleteById(id);
            return "Deleted.";
        }
        return "No player with specified ID.";
    }
}
