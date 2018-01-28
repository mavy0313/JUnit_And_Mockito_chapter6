package exercises.interactiontesting;

import exercises.interactiontesting.SecurityService;
import exercises.interactiontesting.User;
import exercises.interactiontesting.UserDAO;
import exercises.interactiontesting.UserServiceImpl;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private static final String PASSWORD = "password";
    private static final String PASSWORD_MD5 = "password_md5";

    @Test
    public void shouldAssignPassword() throws Exception {
        User user = mock(User.class);
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);

        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);

        when(user.getPassword()).thenReturn(PASSWORD);
        when(securityService.md5(PASSWORD)).thenReturn(PASSWORD_MD5);

        sut.assignPassword(user);

        verify(user).setPassword(PASSWORD_MD5);
        verify(userDAO).updateUser(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullUser() throws Exception {
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);

        UserServiceImpl sut = new UserServiceImpl(userDAO, securityService);

        sut.assignPassword(null);
    }
}
