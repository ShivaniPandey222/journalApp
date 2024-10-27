package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @ParameterizedTest
//    @ValueSource(strings = {
//            "ram",
//            "shivani",
//            "xyzw"
//    })
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testFindByUserName(User user){
//        assertNotNull( userRepository.findByUserName("ram"));
//        User user= userRepository.findByUserName("ram");
//        assertTrue(!user.getJournalEntries().isEmpty());

        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,8",
            "3,3,9"
    })
    public void test(int a,int b, int expected){
        assertEquals(expected,a+b);
    }
}
