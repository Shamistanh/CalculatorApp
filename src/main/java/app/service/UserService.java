package app.service;

import app.entity.Calculation;
import app.entity.XUser;
import app.repo.CalcRepo;
import app.repo.XUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private CalcRepo calcRepo;

    @Autowired
    private XUserRepo xUserRepo;

    public XUser logged_user() {
        XUser xUser = new XUser();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        String password = ((UserDetails) principal).getPassword();
        xUser.setUsername(username);
        xUser.setPassword(password);
        xUser.setId(1);
        xUserRepo.save(xUser);
        return xUser;
    }

    public void  saveToDB(String operation, Double res) {
        String username = logged_user().getUsername();
        Calculation calculation = new Calculation();
        calculation.setOperation(operation);
        calculation.setRes(res);
        calculation.setUsername(username);
        calculation.setXUser(logged_user());
        calcRepo.save(calculation);
    }
}
