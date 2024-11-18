package com.example.Pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationService {
    private final PaginationRepository paginationRepository;

    public PaginationService(PaginationRepository paginationRepository) {
        this.paginationRepository = paginationRepository;
    }


    public Client addClient(Client client) {
        if (client !=null){
            Client client1= new Client();
            client1.setName(client.getName());
            client1.setAge(client.getAge());
            client1.setLocation(client.getLocation());
            paginationRepository.save(client1);
            return client1;
        }
        return null;

    }

    public List<Client> getAllClient() {
        return paginationRepository.findAll();
    }

    public Page<Client> getClients(int pageNo, int pageSize){
        Pageable pageable= PageRequest.of(pageNo,pageSize);
        return paginationRepository.findAll(pageable);
    }
}
