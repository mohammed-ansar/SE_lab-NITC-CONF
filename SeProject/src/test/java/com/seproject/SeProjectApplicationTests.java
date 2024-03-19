package com.seproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.seproject.entity.Paper;
import com.seproject.repository.PaperRepo;
import com.seproject.service.PaperService;

@SpringBootTest
class SeProjectApplicationTests {

    @Autowired
    private PaperService paperService;

    @MockBean
    private PaperRepo paperRepo;

    @Test
    void testGetAllPapers() {
        // Mock data
        List<Paper> mockPapers = Stream.of(
            new Paper(1, "submission1", "Department1", "state1", "reviewer1", "review_state1", "review1", "decision_state1", "Decision1"),
            new Paper(2, "submission2", "Department2", "state2", "reviewer2", "review_state2", "review2", "decision_state2", "Decision2")
        ).collect(Collectors.toList());

        // Mocking repository
        when(paperRepo.findAll()).thenReturn(mockPapers);

        // Call the service method
        List<Paper> result = paperService.getAllPapers();

        // Assertions
        assertEquals(2, result.size()); // Check the size
        assertEquals(mockPapers.get(0), result.get(0)); // Check if the first paper is correct
        assertEquals(mockPapers.get(1), result.get(1)); // Check if the second paper is correct
    }
    
    @Test
    void testGetPaperDetailsById() {
        // Mock data
        Paper mockPaper = new Paper(1, "submission1", "Department1", "state1", "reviewer1", "review_state1", "review1", "decision_state1", "Decision1");

        // Mocking repository
        when(paperRepo.findById(1)).thenReturn(java.util.Optional.of(mockPaper));

        // Call the service method
        Paper result = paperService.getPaperDetailsById(1);

        // Assertions
        assertEquals(mockPaper, result); // Check if the fetched paper is correct
    }
}
