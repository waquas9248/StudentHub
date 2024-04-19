package com.app.studenthub.service;

import com.app.studenthub.model.Connection;
import com.app.studenthub.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public ArrayList<Connection> getAllConnections() {
        return new ArrayList<Connection>(connectionRepository.findAll());
    }

    public Optional<Connection> getConnectionById(Long id) {
        return connectionRepository.findById(id);
    }

    public Connection createConnection(Connection connection) {
        connection.setCreatedAt(LocalDateTime.now());
        return connectionRepository.save(connection);
    }

    public void deleteConnection(Long id) {
        connectionRepository.deleteById(id);
    }
}
