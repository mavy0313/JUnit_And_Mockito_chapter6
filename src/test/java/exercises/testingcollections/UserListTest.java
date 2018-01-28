package exercises.testingcollections;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class UserListTest {

    @Test
    public void shouldReturnEmptyList() {
        UserList userList = new UserList();

        assertEquals(0, userList.getUsers().size());
        assertThat(userList.getUsers()).isEmpty();
    }

    @Test
    public void shouldReturnOneUser() {
        User user = new User();
        UserList userList = new UserList();

        userList.addUser(user);

        assertEquals(1, userList.getUsers().size());
        assertThat(userList.getUsers()).isNotEmpty().containsOnly(user);
    }

    @Test
    public void shouldReturnTwoUsers() {
        User user1 = new User();
        User user2 = new User();
        UserList userList = new UserList();

        userList.addUser(user1);
        userList.addUser(user2);

        assertEquals(2, userList.getUsers().size());
        assertThat(userList.getUsers()).isNotNull().isNotEmpty().containsOnly(user1, user2);
    }
}
