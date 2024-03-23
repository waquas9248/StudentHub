package com.app.studenthub.controller;

import com.app.studenthub.model.Connection;
import com.app.studenthub.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {

    private final ConnectionService connectionService;

    @Autowired
    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    // Get all connections
    @GetMapping
    public ResponseEntity<Set<Connection>> getAllConnections() {
        return ResponseEntity.ok(connectionService.getAllConnections());
    }

    // Get a single connection by ID
    @GetMapping("/{id}")
    public ResponseEntity<Connection> getConnectionById(@PathVariable Long id) {
        return connectionService.getConnectionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new connection
    @PostMapping
    public ResponseEntity<Connection> createConnection(@RequestBody Connection connection) {
        Connection newConnection = connectionService.createConnection(connection);
        return ResponseEntity.ok(newConnection);
    }

    // Update a connection - Assuming you have a method in your service class
    // @PutMapping("/{id}")
    // public ResponseEntity<Connection> updateConnection(@PathVariable Long id, @RequestBody Connection connection) {
    //     // Implement your update logic here
    //     // Return the updated connection
    // }

    // Delete a connection
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConnection(@PathVariable Long id) {
        connectionService.deleteConnection(id);
        return ResponseEntity.ok().build();
    }
}
