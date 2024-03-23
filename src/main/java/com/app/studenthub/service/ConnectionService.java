package com.app.studenthub.service;

import com.app.studenthub.model.Connection;
import com.app.studenthub.repository.ConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    @Autowired
    public ConnectionService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public Set<Connection> getAllConnections() {
        return new HashSet<>(connectionRepository.findAll());
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
