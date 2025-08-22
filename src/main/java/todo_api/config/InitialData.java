package todo_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import todo_api.model.UserEntity;
import todo_api.repository.UserRepository;

@Component
public class InitialData implements CommandLineRunner {

    // classe para inicar a aplicação com 2 usuários para teste

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PasswordEncoder  passwordEncoder;

        @Override
        public void run(String... args) {
            if (userRepository.count() == 0) {
                userRepository.save(new UserEntity("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN"));
                userRepository.save(new UserEntity("user", passwordEncoder.encode("user123"), "ROLE_USER"));
            }
        }
    }

