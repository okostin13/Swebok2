import javax.annotation.security.RunAs;
import javax.ejb.SessionContext;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named
@RequestScoped
@RunAs("admin")
public class AuthorizationController {

    @Inject
    UserDAO userDAO;

    @Inject
    AdminController adminController;

    public AuthorizationController() {
    }

    @NotNull
    private String login;

    @NotNull
    private String password;


    public String signIn() {

        if (userDAO.CheckUser(login, password)) {

          return  adminController.getAdminPage();
        }
        else return "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}