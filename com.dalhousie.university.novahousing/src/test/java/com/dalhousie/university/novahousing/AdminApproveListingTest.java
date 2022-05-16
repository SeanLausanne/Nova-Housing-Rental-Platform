package com.dalhousie.university.novahousing;

// Author- Anita Kumari (B00884141)
import com.dalhousie.university.novahousing.exception.AdminException;
import com.dalhousie.university.novahousing.repository.adminPostAction.AdminPostActionRepositoryImpl;
import com.dalhousie.university.novahousing.services.adminPostAction.AdminPostActionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AdminApproveListingTest {


    @MockBean
    AdminPostActionRepositoryImpl adminApprovePostRepositoryMock;

    @Autowired
    AdminPostActionServiceImpl adminPostActionService;

    String id;
    String approveStatus;

    @BeforeEach
    public void init() {
        id="2876";
        approveStatus="Yes";
    }


    @Test
    public void testNullApproveStatusInput(){
        approveStatus=null;
        Mockito.when(adminApprovePostRepositoryMock.approvePost(id,approveStatus)).thenReturn(true);
        AdminException exception = assertThrows(AdminException.class, () -> adminPostActionService.approvePost(id,approveStatus));
        assertEquals("Please approve or reject to continue", exception.getMessage());
    }

    @Test
    public void testEmptyApproveStatusInput(){
        Mockito.when(adminApprovePostRepositoryMock.approvePost(id,approveStatus)).thenReturn(true);
        approveStatus="";
        AdminException exception = assertThrows(AdminException.class, () -> adminPostActionService.approvePost(id,approveStatus));
        assertEquals("Please approve or reject to continue", exception.getMessage());
    }

    @Test
    public void testNullPostIdInput(){
        id=null;
        Mockito.when(adminApprovePostRepositoryMock.approvePost(id,approveStatus)).thenReturn(true);
        AdminException exception = assertThrows(AdminException.class, () -> adminPostActionService.approvePost(id,approveStatus));
        assertEquals("Post id not provided", exception.getMessage());
    }

    @Test
    public void testEmptyPostIdInput(){
        id="";
        Mockito.when(adminApprovePostRepositoryMock.approvePost(id,approveStatus)).thenReturn(true);
        AdminException exception = assertThrows(AdminException.class, () -> adminPostActionService.approvePost(id,approveStatus));
        assertEquals("Post id not provided", exception.getMessage());
    }

    @Test
    public void testPostitiveStatusApproveInput() throws AdminException {
        Mockito.when(adminApprovePostRepositoryMock.approvePost(id,approveStatus)).thenReturn(true);
        assertTrue(adminPostActionService.approvePost(id,approveStatus));
    }

    @Test
    public void testPostitivePostIdInput() throws AdminException {
        Mockito.when(adminApprovePostRepositoryMock.approvePost(id,approveStatus)).thenReturn(true);
        assertTrue(adminPostActionService.approvePost(id,approveStatus));
    }


}
