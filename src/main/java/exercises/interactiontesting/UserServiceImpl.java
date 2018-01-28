package exercises.interactiontesting;

public class UserServiceImpl {

    private UserDAO userDAO;
    private SecurityService securityService;

    public UserServiceImpl(UserDAO userDAO, SecurityService securityService) {
        this.userDAO = userDAO;
        this.securityService = securityService;
    }

    public void assignPassword(User user) throws Exception {
        if (user == null) {
            throw new IllegalArgumentException("User is null");
        }
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }
}
