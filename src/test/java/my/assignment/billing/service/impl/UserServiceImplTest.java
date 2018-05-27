package my.assignment.billing.service.impl;

import my.assignment.billing.dao.UserDao;
import my.assignment.billing.data.dto.UserDto;
import my.assignment.billing.util.PrepareDataHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * Created by bkothari on 26/05/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDao userDao;

    @Test
    public void testGetProductsByOrder_Success() {

        when(userDao.findByUsername(Mockito.anyString())).thenReturn(PrepareDataHelper.populateUserEntity());

        UserDto userDto = userService.getUserByUsername("bhavik");
        Assert.assertNotNull(userDto);
    }

    @Test
    public void testGetProductsByOrder_NotFound() {

        when(userDao.findByUsername(Mockito.anyString())).thenReturn(null);

        UserDto userDto = userService.getUserByUsername("bhavik");
        Assert.assertNull(userDto);
    }

}
