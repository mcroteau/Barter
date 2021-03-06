package barter.access;

import org.springframework.beans.factory.annotation.Autowired;
import barter.model.User;
import barter.repository.UserRepo;
import xyz.strongperched.resources.access.Accessor;

import java.util.Set;

public class BarterAccessor implements Accessor {

    @Autowired
    private UserRepo userRepo;

    public String getPassword(String user){
        String password = userRepo.getUserPassword(user);
        return password;
    }

    public Set<String> getRoles(String user){
        User person = userRepo.getByUsername(user);
        Set<String> roles = userRepo.getUserRoles(person.getId());
        return roles;
    }

    public Set<String> getPermissions(String user){
        User person = userRepo.getByUsername(user);
        Set<String> permissions = userRepo.getUserPermissions(person.getId());
        return permissions;
    }

}
