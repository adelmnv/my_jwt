package kz.itstep.jwtsecurity;

import kz.itstep.jwtsecurity.model.Book;
import kz.itstep.jwtsecurity.model.User;
import kz.itstep.jwtsecurity.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import kz.itstep.jwtsecurity.repository.BookRepository;

@SpringBootApplication
public class JwtSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtSecurityApplication.class, args);
    }
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository, BookRepository bookRepository, PasswordEncoder passwordEncoder){
        return args -> {
            userRepository.save(new User("dias", "ospanov", "dias", passwordEncoder.encode("dias"), "LIBRARIAN"));
            userRepository.save(new User("alena", "smirnova", "alena", passwordEncoder.encode("qwerty"), "ADMIN"));

            userRepository.save(new User("nikita", "sidorov", "nikich", passwordEncoder.encode("qwerty"), "USER"));
            userRepository.save(new User("alexandra", "kim", "alien", passwordEncoder.encode("qwerty"), "USER"));
            userRepository.save(new User("vika", "novoselova", "vik1", passwordEncoder.encode("qwerty"), "USER"));

            bookRepository.save(new Book("Dune", "Frank Gerbert"));
            bookRepository.save(new Book("Throne of Glass", "Sara JMass"));
            bookRepository.save(new Book("Red Queen", "Viktoria Aveyard"));
        };
    }

}
