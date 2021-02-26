package barter;

import barter.access.BarterAccessor;
import barter.common.Barter;
import barter.model.Role;
import barter.model.User;
import barter.repository.CategoryRepo;
import barter.repository.RoleRepo;
import barter.repository.UserRepo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import barter.common.Constants;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import xyz.strongperched.Parakeet;



@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {


	private static final Logger log = Logger.getLogger(Bootstrap.class);

	@Autowired
	BarterAccessor accessor;

	@Autowired
	UserRepo userRepo;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	Environment env;

	public void onApplicationEvent(ContextRefreshedEvent contextRefreshEvent) {
		Parakeet.perch(accessor);

		Role adminRole = roleRepo.find(Constants.ADMIN_ROLE);
		Role userRole = roleRepo.find(Constants.USER_ROLE);

		if(adminRole == null){
			adminRole = new Role();
			adminRole.setName(Constants.ADMIN_ROLE);
			roleRepo.save(adminRole);
		}

		if(userRole == null){
			userRole = new Role();
			userRole.setName(Constants.USER_ROLE);
			roleRepo.save(userRole);
		}

		User existing = userRepo.getByUsername(Constants.ADMIN_USERNAME);
		String password = Parakeet.dirty(Constants.PASSWORD);

		if(existing == null){
			User admin = new User();
			admin.setUsername(Constants.ADMIN_USERNAME);
			admin.setPassword(password);
			userRepo.saveAdministrator(admin);
		}

		User existingGuest = userRepo.getByUsername(Constants.GUEST_USERNAME);
		String guestPassword = Parakeet.dirty(Constants.GUEST_PASSWORD);

		if(existingGuest == null){
			User user = new User();
			user.setUsername(Constants.GUEST_USERNAME);
			user.setPassword(guestPassword);
			userRepo.save(user);
		}

		log.info("Roles : " + roleRepo.count());
		log.info("Users : " + userRepo.getCount());

		if(Barter.isDevEnv(env)){
			createMocks();
		}
	}

	private boolean createMocks(){
		return true;
	}

}