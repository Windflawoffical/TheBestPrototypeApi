package tbpapi.thebestprototypeapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbpapi.thebestprototypeapi.Exceptions.NoUserFoundException;
import tbpapi.thebestprototypeapi.Exceptions.RegistrationErrorException;
import tbpapi.thebestprototypeapi.Models.User;
import tbpapi.thebestprototypeapi.Repositories.UserRepository;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;


    public User signUp(User user) throws RegistrationErrorException {
        if(!userRepository.existsByEmail(user.getEmail())) {
            return userRepository.save(user);
        } else if (!user.getEmail().isEmpty() || !user.getFullname().isEmpty() || !user.getPassword().isEmpty()){
            throw new RegistrationErrorException("Регистрация провалена!\nПользователь либо уже существует, либо регистрация пройдена некорректно.");
        } throw new RegistrationErrorException("Регистрация провалена!\nПользователь либо уже существует, либо регистрация пройдена некорректно.");
    }

    public User signIn (User user) throws NoUserFoundException {
        User userfromdb = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(userfromdb != null) {
            return userfromdb;
        }
        throw new NoUserFoundException("Пользователь с таким email и password не существует!\nПроверьте данные и повторите снова!");
    }
}
