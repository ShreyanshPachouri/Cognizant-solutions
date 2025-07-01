import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public interface ExternalApi {
    String getData();
    String getDataById(int id);
}

package com.example;

public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(int id) {
        return externalApi.getDataById(id);
    }
}

class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // Arrange: Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub (optional)
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act
        MyService service = new MyService(mockApi);
        service.fetchData();

        // Assert: Verify interaction
        verify(mockApi).getData();
    }

    @Test
    public void testVerifyInteractionWithArguments() {
        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getDataById(42)).thenReturn("Mock Data By ID");

        // Act
        MyService service = new MyService(mockApi);
        String result = service.fetchDataById(42);

        // Assert value
        assertEquals("Mock Data By ID", result);

        // Verify that getDataById was called with argument 42
        verify(mockApi).getDataById(42);

        // You can also verify it was called exactly once
        verify(mockApi, times(1)).getDataById(42);

        // Or verify that getData (which wasn't called) never ran:
        verify(mockApi, never()).getData();
    }
}
