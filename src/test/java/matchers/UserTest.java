package matchers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void shouldReturnUserWithAnyInt() {
        UserDAO userDAO = mock(UserDAO.class);
        User user = new User();

        when(userDAO.getUser(anyInt())).thenReturn(user);

        assertEquals(user, userDAO.getUser(1));
        assertEquals(user, userDAO.getUser(2));
        assertEquals(user, userDAO.getUser(3));
        verify(userDAO, times(3)).getUser(anyInt());
    }
}
