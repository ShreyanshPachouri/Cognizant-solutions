import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public interface ExternalApi {
    String getData();
}


public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }
}

class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Arrange: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Stub: Specify behavior
        when(mockApi.getData()).thenReturn("Mock Data");

        // Act: Use service with mock
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert: Verify result
        assertEquals("Mock Data", result);

        // Optional: Verify interaction
        verify(mockApi).getData();
    }
}
