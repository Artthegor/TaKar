package takar.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import takar.dataManagementServices.IUserManagment;
import takar.dataManagementServices.UserManagment;
import takar.model.User;
import takar.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

@Component("customAuthenticationSuccessHandler")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);

    @Autowired
    private IUserManagment userRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.debug(userRepo.getAllUsers().toString());
        /*System.out.println("LAAAAAAAAAAAAAAAAAAAAAA" + authentication.getPrincipal());
        UserDetails user = (UserDetails) authentication.getPrincipal();
        System.out.println(user.getUsername());*/
        //System.out.println(request.getCookies().toString());
        //System.out.println(request.getSession().toString());
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("../");
    }
}