package com.app.studenthub.service;

import com.app.studenthub.model.Connection;
import com.app.studenthub.repository.ConnectionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ConnectionServiceTest {

    @MockBean
    private ConnectionRepository connectionRepository;

    @Autowired
    private ConnectionService connectionService;

    @Test
    void testGetAllConnections() {
        // Given
        Connection connection1 = new Connection();
        Connection connection2 = new Connection();
        List<Connection> connections = new ArrayList<>(Arrays.asList(connection1, connection2));
        when(connectionRepository.findAll()).thenReturn(connections);

        // When
        List<Connection> result = connectionService.getAllConnections();

        // Then
        assertEquals(2, result.size());
        verify(connectionRepository, times(1)).findAll();
    }

    @Test
    void testGetConnectionById() {
        // Given
        Connection connection = new Connection();
        Long id = 1L;
        when(connectionRepository.findById(id)).thenReturn(Optional.of(connection));

        // When
        Optional<Connection> result = connectionService.getConnectionById(id);

        // Then
        assertTrue(result.isPresent());
        assertEquals(connection, result.get());
        verify(connectionRepository, times(1)).findById(id);
    }

    @Test
    void testCreateConnection() {
        // Given
        Connection connection = new Connection();
        when(connectionRepository.save(connection)).thenReturn(connection);

        // When
        Connection createdConnection = connectionService.createConnection(connection);

        // Then
        assertNotNull(createdConnection);
        verify(connectionRepository, times(1)).save(connection);
        assertNotNull(createdConnection.getCreatedAt());
    }

    @Test
    void testDeleteConnection() {
        // Given
        Long id = 1L;

        // When
        connectionService.deleteConnection(id);

        // Then
        verify(connectionRepository, times(1)).deleteById(id);
    }
}
