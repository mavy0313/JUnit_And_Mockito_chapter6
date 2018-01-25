package exercises.interactiontesting;

public class UserServiceImpl {
    private UserDAO userDAO;
    private SecurityService securityService;
    public void assignPassword(User user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }
}
