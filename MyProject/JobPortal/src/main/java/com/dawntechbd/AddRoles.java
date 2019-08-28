//package com.dawntechbd;
//
//import com.dawntechbd.entity.Role;
//import com.dawntechbd.repo.RoleRepo;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
////@SpringBootApplication
////public class AddRoles {
////    public static void main(String[] args) {
////        SpringApplication.run(AddRoles.class, args);
////    }
////
////    @Bean
////    CommandLineRunner init (RoleRepo roleRepo) {
////        return args -> {
////            List<String> roleNames = Arrays.asList("ADMIN", "APPLICANT", "EMPLOYER", "DEVELOPER", "MANAGER");
////            roleNames.forEach(roleName -> roleRepo.save(new Role(roleName)));
////        };
////    }
//
//@Component
//public class AddRoles implements ApplicationListener<ApplicationReadyEvent> {
//    private RoleRepo roleRepo;
//
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        Role role1 = new Role("ADMIN");
//        Role role2 = new Role("APPLICANT");
//        Role role3 = new Role("EMPLOYER");
//        Role role4 = new Role("DEVELOPER");
//        Role role5 = new Role("MANAGER");
//
//        this.roleRepo.save(role1);
//        this.roleRepo.save(role2);
//        this.roleRepo.save(role3);
//        this.roleRepo.save(role4);
//        this.roleRepo.save(role5);
//
//        return;
//    }
//}
