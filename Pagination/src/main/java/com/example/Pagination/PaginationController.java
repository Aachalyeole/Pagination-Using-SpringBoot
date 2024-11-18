package com.example.Pagination;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class PaginationController {

    private final PaginationService paginationService;

    public PaginationController(PaginationService paginationService) {
        this.paginationService = paginationService;
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        return ResponseEntity.ok(paginationService.addClient(client));

    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClient(){
        return ResponseEntity.ok(paginationService.getAllClient());
    }

    @GetMapping
    public ResponseEntity<Page<Client>> getClients(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        Page<Client> clients= paginationService.getClients(pageNo, pageSize);
        return ResponseEntity.ok(clients);
    }
}
