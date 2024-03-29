package tbpapi.thebestprototypeapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tbpapi.thebestprototypeapi.Exceptions.NoUserFoundException;
import tbpapi.thebestprototypeapi.Models.User;
import tbpapi.thebestprototypeapi.Repositories.UserRepository;

@Service
public class UpdateService {

    @Autowired
    UserRepository userRepository;
    public User updateData(User user) throws NoUserFoundException {
        User userfromdb = userRepository.findByEmail(user.getEmail()  );
        if(!(userfromdb == null) && user.getLatitude() != 0
                && user.getLongtitude() != 0
                && user.getSignalpower() != 0
                && !user.getNetworkOperatorName().isEmpty()
                && user.getNetworkOperatorCode() != 0)
        {
            userfromdb.setLatitude(user.getLatitude());
            userfromdb.setLongtitude(user.getLongtitude());
            userfromdb.setSignalpower(user.getSignalpower());
            userfromdb.setNetworkOperatorName(user.getNetworkOperatorName());
            userfromdb.setNetworkOperatorCode(user.getNetworkOperatorCode());
            return userRepository.save(userfromdb);
        }
        throw new NoUserFoundException("Пользователь с таким email + " + user.getEmail() + " либо не найден!\nЛибо вы неправильно указали изменённые данные!");
    }
}
