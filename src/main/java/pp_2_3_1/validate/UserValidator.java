package pp_2_3_1.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pp_2_3_1.dao.UserDao;
import pp_2_3_1.model.User;

@Component
public class UserValidator implements Validator {

    private final UserDao userDao;

    @Autowired
    public UserValidator(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        User foundedUser = userDao.readByName(user.getName());
        // Валидация гарантии уникальности имени
        if (foundedUser != null && foundedUser.getName().equals(user.getName())) {
            errors.rejectValue
                    (
                            "name",
                            "",
                            "Создать или обновить пользователя с таким именем невозможно. " +
                                    "\nПользователь с таким именем уже зарегистрирован в базе данных!"
                    );
        }
    }
}
