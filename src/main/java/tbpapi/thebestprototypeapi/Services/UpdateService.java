package tbpapi.thebestprototypeapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbpapi.thebestprototypeapi.Exceptions.NoUserFoundException;
import tbpapi.thebestprototypeapi.Models.User;
import tbpapi.thebestprototypeapi.Repositories.UserRepository;

import java.util.Objects;

@Service
public class UpdateService {

    @Autowired
    UserRepository userRepository;
    public User updateLocation(User user) throws NoUserFoundException {
        User userfromdb = userRepository.findByEmail(user.getEmail()  );
        if(!(userfromdb == null) && user.getLatitude() != 0 && user.getLongtitude() != 0) {
            userfromdb.setLatitude(user.getLatitude());
            userfromdb.setLongtitude(user.getLongtitude());
            return userRepository.save(userfromdb);
        }
        throw new NoUserFoundException("Пользователь с таким email + " + user.getEmail() + " либо не найден!\nЛибо вы указали latitude = 0/null или longtitude = 0/null!");
    }
}
